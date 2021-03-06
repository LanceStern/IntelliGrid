// Copyright 2014 Harrison Snodgrass and San Diego Gas and Electric, all rights reserved

package org.sdsu.intelligrid.graphics;

import static android.opengl.GLES20.*;

import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.sdsu.intelligrid.Global;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.opengl.GLUtils;

class TextTextureManager {

	private static final Map<String, Texture> textureMap = new LinkedHashMap<>();

	private static final int MAX_BUFFERED_TEXTURES = 500;

	private static int getPowerOfTwo(final int in) {
		int x = 64;
		while (x <= 4096) {
			if (in <= x) {
				return x;
			}
			x *= 2;
		}
		return 4096;
	}

	private static Texture buildTexture(final String text, final int fontSize,
			final Typeface font, final float maxLineWidth) {
		final Paint textPaint = new Paint();
		textPaint.setTextSize(fontSize);
		textPaint.setAntiAlias(true);
		textPaint.setTypeface(font);
		textPaint.setTextAlign(Align.LEFT);
		textPaint.setARGB(0xff, 0xff, 0xff, 0xff);

		final float lineSpacing = textPaint.getFontSpacing();
		int iterations = 0;
		int currentStart = 0;
		Rect fullRect = null;
		final Map<Integer, Integer> charsMap = new HashMap<>();
		while (currentStart < text.length()) {
			iterations++;
			int chars = textPaint.breakText(text.substring(currentStart), true,
					maxLineWidth, null);
			charsMap.put(iterations, chars);
			int skip = 0;
			for (int i = currentStart; i < currentStart + chars; i++) {
				if (text.charAt(i) == '\n') {
					chars = i - currentStart;
					skip++;
					break;
				}
			}
			if (skip == 0 && text.length() > currentStart + chars
					&& text.charAt(currentStart + chars) != '\n'
					&& text.charAt(currentStart + chars) != ' ') {
				for (int i = currentStart + chars - 1; i >= currentStart; i--) {
					if (text.charAt(i) == ' ') {
						chars = i - currentStart;
						skip++;
						break;
					}
				}
			}
			Rect rect = new Rect();
			textPaint.getTextBounds(
					text.substring(currentStart, currentStart + chars), 0,
					chars, rect);
			if (fullRect == null) {
				fullRect = new Rect(rect);
			} else {
				rect.offset(0, (int) (lineSpacing * (float) iterations));
				fullRect.union(rect);
			}
			currentStart += chars + skip;
		}

		final Bitmap bitmap;
		if (fullRect != null) {
			bitmap = Bitmap.createBitmap(getPowerOfTwo(fullRect.width()),
					getPowerOfTwo(fullRect.height()), Bitmap.Config.ARGB_8888);
			final Canvas canvas = new Canvas(bitmap);
			bitmap.eraseColor(0);

			iterations = 0;
			currentStart = 0;
			while (currentStart < text.length()) {
				iterations++;
				int chars = charsMap.get(iterations);
				int skip = 0;
				for (int i = currentStart; i < currentStart + chars; i++) {
					if (text.charAt(i) == '\n') {
						chars = i - currentStart;
						skip++;
						break;
					}
				}
				if (skip == 0 && text.length() > currentStart + chars
						&& text.charAt(currentStart + chars) != '\n'
						&& text.charAt(currentStart + chars) != ' ') {
					for (int i = currentStart + chars - 1; i >= currentStart; i--) {
						if (text.charAt(i) == ' ') {
							chars = i - currentStart;
							skip++;
							break;
						}
					}
				}
				canvas.drawText(
						text.substring(currentStart, currentStart + chars), 0,
						(int) (lineSpacing * (float) iterations), textPaint);
				currentStart += chars + skip;
			}
		} else {
			bitmap = Bitmap.createBitmap(getPowerOfTwo(0), getPowerOfTwo(0),
					Bitmap.Config.ARGB_8888);
		}

		final IntBuffer buffer = IntBuffer.allocate(1);
		glGenTextures(1, buffer);
		final int texture = buffer.get();
		glBindTexture(GL_TEXTURE_2D, texture);

		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

		GLUtils.texImage2D(GL_TEXTURE_2D, 0, bitmap, 0);

		final Texture tex = new Texture(-1, texture, bitmap.getWidth(),
				bitmap.getHeight());

		bitmap.recycle();

		return tex;
	}

	private static int count = 0;

	static Texture getTexture(final String text, final int fontSize,
			final Typeface font, final float maxLineWidth) {
		final String mapString = text + "$" + fontSize + "$" + font.toString()
				+ "$" + (int) maxLineWidth + "$";

		if (!textureMap.containsKey(mapString)) {
			final Texture texture = buildTexture(text, fontSize, font,
					maxLineWidth);
			count++;
			if (count > MAX_BUFFERED_TEXTURES) {
				count = 0;
				flushUnusedTextTextures();
			}
			textureMap.put(mapString, texture);
			return texture;
		} else {
			return textureMap.get(mapString);
		}
	}

	private static void flushUnusedTextTextures() {
		final Set<Integer> stillUsedTextures = new HashSet<>();
		for (Drawable drawable : Global.getRenderer().drawableList) {
			if (drawable instanceof TextSprite) {
				TextSprite text = (TextSprite) drawable;
				stillUsedTextures.add(text.texture);
			}
		}

		final Set<Integer> unusedTextures = new LinkedHashSet<>();
		final Iterator<Map.Entry<String, Texture>> iter = textureMap.entrySet()
				.iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Texture> entry = iter.next();
			int texture = entry.getValue().getTexture();
			if (!stillUsedTextures.contains(texture)) {
				unusedTextures.add(texture);
				iter.remove();
			}
		}

		final int[] toRemove = new int[unusedTextures.size()];
		int count = 0;
		for (int i : unusedTextures) {
			toRemove[count] = i;
			count++;
		}

		// Logger.getGlobal().log(Level.SEVERE, "Removing " + count +
		// " textures");
		// Logger.getGlobal().log(Level.SEVERE, "Still has " + textureMap.size()
		// + " textures");
		glDeleteTextures(count, toRemove, 0);
	}
}
