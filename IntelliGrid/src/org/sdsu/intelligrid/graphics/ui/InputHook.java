package org.sdsu.intelligrid.graphics.ui;

import org.sdsu.intelligrid.Global;
import org.sdsu.intelligrid.R;
import org.sdsu.intelligrid.graphics.Sprite;
import org.sdsu.intelligrid.simulation.Simulation;
import org.sdsu.intelligrid.util.Color;
import org.sdsu.intelligrid.util.Vector2f;

import android.view.MotionEvent;

/**
 * A hook containing static methods that are called when input events happen.
 */
public class InputHook {

    public static Vector2f pixelsToCoords(final float x, final float y) {
        return new Vector2f((x / (float) Global.getRenderer().getScreenWidth()
                * 2f - 1f)
                * (float) Global.getRenderer().getScreenWidth()
                / (float) Global.getRenderer().getScreenHeight(), y
                / (float) Global.getRenderer().getScreenHeight() * 2f - 1f);
    }

    public static Vector2f sizeToCoords(final float x, final float y) {
        return new Vector2f(x / (float) Global.getRenderer().getScreenHeight(), y
                / (float) Global.getRenderer().getScreenHeight());
    }

	/**
	 * This function is called when a pointer goes down and touches the screen
	 * on a clickable object.
	 * <p>
	 * This function is called before
	 * {@link #reportDown(Vector2f, MotionEvent, int) reportDown}.
	 * 
	 * @param object
	 *            the clickable object that the event triggered on
	 * @param coords
	 *            the openGL coordinates of the MotionEvent (<tt>[0,0]</tt> is
	 *            the center of the screen)
	 * @param e
	 *            the MotionEvent that caused this function to be called
	 * @param id
	 *            the pointer identifier of the MotionEvent
	 */
	public static synchronized void reportDownOnObject(final Clickable object,
			final Vector2f coords, final MotionEvent e, final int id) {

        if(object.getId().equals("play")) {
        	LightAnimation.setPaused(false);
            Simulation.SimulationData.timeScale = 288;
            MainUI.Objects.playdown.setDepth(-1);
            MainUI.Objects.play2down.setDepth(11);
            MainUI.Objects.play3down.setDepth(11);
            MainUI.Objects.pausedown.setDepth(11);
        }
        if(object.getId().equals("play2")) {
        	LightAnimation.setPaused(false);
            Simulation.SimulationData.timeScale = 720;
            MainUI.Objects.playdown.setDepth(11);
            MainUI.Objects.play2down.setDepth(-1);
            MainUI.Objects.play3down.setDepth(11);
            MainUI.Objects.pausedown.setDepth(11);
        }
        if(object.getId().equals("play3")) {
        	LightAnimation.setPaused(false);
            Simulation.SimulationData.timeScale = 1920;
            MainUI.Objects.playdown.setDepth(11);
            MainUI.Objects.play2down.setDepth(11);
            MainUI.Objects.play3down.setDepth(-1);
            MainUI.Objects.pausedown.setDepth(11);
        }
        if(object.getId().equals("pause")) {
        	LightAnimation.setPaused(true);
            Simulation.SimulationData.timeScale = 0;
            MainUI.Objects.playdown.setDepth(11);
            MainUI.Objects.play2down.setDepth(11);
            MainUI.Objects.play3down.setDepth(11);
            MainUI.Objects.pausedown.setDepth(-1);
        }

//        if(object.getId().equals("background")) {
//            MainUI.ClickableObjects.graphspage.setDepth(11);
//            MainUI.ClickableObjects.exitgraphs.setDepth(11);
//            MainUI.ClickableObjects.infopage.setDepth(11);
//            MainUI.ClickableObjects.exitinfo.setDepth(11);
//            MainUI.ClickableObjects.faultspage.setDepth(11);
//            MainUI.ClickableObjects.exitfaults.setDepth(11);
//        }

        if(object.getId().equals("info")) {
            MainUI.ClickableObjects.infopage.setDepth(-1);
            MainUI.ClickableObjects.exitinfo.setDepth(-2);
            MainUI.ClickableObjects.load1stats.setDepth(11);
            MainUI.ClickableObjects.load1statsclick.setDepth(11);
            MainUI.UIInfo.Load1.setDepth(11);
            MainUI.ClickableObjects.load2stats.setDepth(11);
            MainUI.ClickableObjects.load2statsclick.setDepth(11);
            MainUI.UIInfo.Load2.setDepth(11);
            MainUI.ClickableObjects.load3stats.setDepth(11);
            MainUI.ClickableObjects.load3statsclick.setDepth(11);
            MainUI.UIInfo.Load3.setDepth(11);
            MainUI.ClickableObjects.load4stats.setDepth(11);
            MainUI.ClickableObjects.load4statsclick.setDepth(11);
            MainUI.UIInfo.Load4.setDepth(11);
            MainUI.ClickableObjects.load5stats.setDepth(11);
            MainUI.ClickableObjects.load5statsclick.setDepth(11);
            MainUI.UIInfo.Load5.setDepth(11);
            MainUI.ClickableObjects.load6stats.setDepth(11);
            MainUI.ClickableObjects.load6statsclick.setDepth(11);
            MainUI.UIInfo.Load6.setDepth(11);
        }
        if(object.getId().equals("infonight")) {
            MainUI.ClickableObjects.infopage.setDepth(-1);
            MainUI.ClickableObjects.exitinfo.setDepth(-2);
            MainUI.ClickableObjects.load1stats.setDepth(11);
            MainUI.ClickableObjects.load1statsclick.setDepth(11);
            MainUI.UIInfo.Load1.setDepth(11);
            MainUI.ClickableObjects.load2stats.setDepth(11);
            MainUI.ClickableObjects.load2statsclick.setDepth(11);
            MainUI.UIInfo.Load2.setDepth(11);
            MainUI.ClickableObjects.load3stats.setDepth(11);
            MainUI.ClickableObjects.load3statsclick.setDepth(11);
            MainUI.UIInfo.Load3.setDepth(11);
            MainUI.ClickableObjects.load4stats.setDepth(11);
            MainUI.ClickableObjects.load4statsclick.setDepth(11);
            MainUI.UIInfo.Load4.setDepth(11);
            MainUI.ClickableObjects.load5stats.setDepth(11);
            MainUI.ClickableObjects.load5statsclick.setDepth(11);
            MainUI.UIInfo.Load5.setDepth(11);
            MainUI.ClickableObjects.load6stats.setDepth(11);
            MainUI.ClickableObjects.load6statsclick.setDepth(11);
            MainUI.UIInfo.Load6.setDepth(11);
        }
        if(object.getId().equals("exitinfo")) {
            MainUI.ClickableObjects.infopage.setDepth(11);
            MainUI.ClickableObjects.exitinfo.setDepth(11);
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
        }

        if(object.getId().equals("graphs")) {
            MainUI.ClickableObjects.graphspage.setDepth(-1);
            MainUI.ClickableObjects.exitgraphs.setDepth(-2);
            MainUI.ClickableObjects.load1stats.setDepth(11);
            MainUI.ClickableObjects.load1statsclick.setDepth(11);
            MainUI.UIInfo.Load1.setDepth(11);
            MainUI.ClickableObjects.load2stats.setDepth(11);
            MainUI.ClickableObjects.load2statsclick.setDepth(11);
            MainUI.UIInfo.Load2.setDepth(11);
            MainUI.ClickableObjects.load3stats.setDepth(11);
            MainUI.ClickableObjects.load3statsclick.setDepth(11);
            MainUI.UIInfo.Load3.setDepth(11);
            MainUI.ClickableObjects.load4stats.setDepth(11);
            MainUI.ClickableObjects.load4statsclick.setDepth(11);
            MainUI.UIInfo.Load4.setDepth(11);
            MainUI.ClickableObjects.load5stats.setDepth(11);
            MainUI.ClickableObjects.load5statsclick.setDepth(11);
            MainUI.UIInfo.Load5.setDepth(11);
            MainUI.ClickableObjects.load6stats.setDepth(11);
            MainUI.ClickableObjects.load6statsclick.setDepth(11);
            MainUI.UIInfo.Load6.setDepth(11);
        }
        if(object.getId().equals("graphsnight")) {
            MainUI.ClickableObjects.graphspage.setDepth(-1);
            MainUI.ClickableObjects.exitgraphs.setDepth(-2);
            MainUI.ClickableObjects.load1stats.setDepth(11);
            MainUI.ClickableObjects.load1statsclick.setDepth(11);
            MainUI.UIInfo.Load1.setDepth(11);
            MainUI.ClickableObjects.load2stats.setDepth(11);
            MainUI.ClickableObjects.load2statsclick.setDepth(11);
            MainUI.UIInfo.Load2.setDepth(11);
            MainUI.ClickableObjects.load3stats.setDepth(11);
            MainUI.ClickableObjects.load3statsclick.setDepth(11);
            MainUI.UIInfo.Load3.setDepth(11);
            MainUI.ClickableObjects.load4stats.setDepth(11);
            MainUI.ClickableObjects.load4statsclick.setDepth(11);
            MainUI.UIInfo.Load4.setDepth(11);
            MainUI.ClickableObjects.load5stats.setDepth(11);
            MainUI.ClickableObjects.load5statsclick.setDepth(11);
            MainUI.UIInfo.Load5.setDepth(11);
            MainUI.ClickableObjects.load6stats.setDepth(11);
            MainUI.ClickableObjects.load6statsclick.setDepth(11);
            MainUI.UIInfo.Load6.setDepth(11);
        }
        if(object.getId().equals("exitgraphs")) {
            MainUI.ClickableObjects.graphspage.setDepth(11);
            MainUI.ClickableObjects.exitgraphs.setDepth(11);
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
        }

        if(object.getId().equals("faults")) {
            /*MainUI.ClickableObjects.faultspage.setDepth(-1);
            MainUI.ClickableObjects.exitfaults.setDepth(-2);
            MainUI.ClickableObjects.load1stats.setDepth(11);
            MainUI.ClickableObjects.load1statsclick.setDepth(11);
            MainUI.UIInfo.Load1.setDepth(11);
            MainUI.ClickableObjects.load2stats.setDepth(11);
            MainUI.ClickableObjects.load2statsclick.setDepth(11);
            MainUI.UIInfo.Load2.setDepth(11);
            MainUI.ClickableObjects.load3stats.setDepth(11);
            MainUI.ClickableObjects.load3statsclick.setDepth(11);
            MainUI.UIInfo.Load3.setDepth(11);
            MainUI.ClickableObjects.load4stats.setDepth(11);
            MainUI.ClickableObjects.load4statsclick.setDepth(11);
            MainUI.UIInfo.Load4.setDepth(11);
            MainUI.ClickableObjects.load5stats.setDepth(11);
            MainUI.ClickableObjects.load5statsclick.setDepth(11);
            MainUI.UIInfo.Load5.setDepth(11);
            MainUI.ClickableObjects.load6stats.setDepth(11);
            MainUI.ClickableObjects.load6statsclick.setDepth(11);
            MainUI.UIInfo.Load6.setDepth(11);*/
            		currentFault++;
		if (currentFault == 16) {
			currentFault = 0;
		}
		String fault;
		switch (currentFault) {
		case 1:
			fault = "A";
			break;
		case 2:
			fault = "B";
			break;
		case 3:
			fault = "C";
			break;
		case 4:
			fault = "D";
			break;
		case 5:
			fault = "E";
			break;
		case 6:
			fault = "F";
			break;
		case 7:
			fault = "H";
			break;
		case 8:
			fault = "I";
			break;
		case 9:
			fault = "J";
			break;
		case 10:
			fault = "K";
			break;
		case 11:
			fault = "L";
			break;
		case 12:
			fault = "M";
			break;
            case 13:
                fault = "DI";
                break;
            case 14:
                fault = "ACE";
                break;
            case 15:
                fault = "MKI";
                break;
		default:
			fault = "";
		}
		try {
			Global.getGlobalSimulation().data.fault = fault;
		} catch (Exception ex) {
			// do nothing
		}
        }
        if(object.getId().equals("exitfaults")) {
            MainUI.ClickableObjects.faultspage.setDepth(11);
            MainUI.ClickableObjects.exitfaults.setDepth(11);
            MainUI.ClickableObjects.load1statsclick.setDepth(0);
            MainUI.ClickableObjects.load2statsclick.setDepth(0);
            MainUI.ClickableObjects.load3statsclick.setDepth(0);
            MainUI.ClickableObjects.load4statsclick.setDepth(0);
            MainUI.ClickableObjects.load5statsclick.setDepth(0);
            MainUI.ClickableObjects.load6statsclick.setDepth(0);
        }

        if(object.getId().equals("load1statsclick")) {
            MainUI.ClickableObjects.load1stats.setDepth(-1);
            MainUI.UIInfo.Load1.setDepth(-2);
        }
        if(object.getId().equals("load1stats")) {
            MainUI.ClickableObjects.load1stats.setDepth(11);
            MainUI.UIInfo.Load1.setDepth(11);
        }
        if(object.getId().equals("house3a")) {
            MainUI.ClickableObjects.load1stats.setDepth(-1);
            MainUI.UIInfo.Load1.setDepth(-2);
        }
        if(object.getId().equals("house3b")) {
            MainUI.ClickableObjects.load1stats.setDepth(-1);
            MainUI.UIInfo.Load1.setDepth(-2);
        }
        if(object.getId().equals("house3c")) {
            MainUI.ClickableObjects.load1stats.setDepth(-1);
            MainUI.UIInfo.Load1.setDepth(-2);
        }

        if(object.getId().equals("load2statsclick")) {
            MainUI.ClickableObjects.load2stats.setDepth(-1);
            MainUI.UIInfo.Load2.setDepth(-2);
        }
        if(object.getId().equals("load2stats")) {
            MainUI.ClickableObjects.load2stats.setDepth(11);
            MainUI.UIInfo.Load2.setDepth(11);
        }
        if(object.getId().equals("house2solar1")) {
            MainUI.ClickableObjects.load2stats.setDepth(-1);
            MainUI.UIInfo.Load2.setDepth(-2);
        }
        if(object.getId().equals("house2solar2")) {
            MainUI.ClickableObjects.load2stats.setDepth(-1);
            MainUI.UIInfo.Load2.setDepth(-2);
        }
        if(object.getId().equals("house2solar3")) {
            MainUI.ClickableObjects.load2stats.setDepth(-1);
            MainUI.UIInfo.Load2.setDepth(-2);
        }

        if(object.getId().equals("load3statsclick")) {
            MainUI.ClickableObjects.load3stats.setDepth(-1);
            MainUI.UIInfo.Load3.setDepth(-2);
        }
        if(object.getId().equals("load3stats")) {
            MainUI.ClickableObjects.load3stats.setDepth(11);
            MainUI.UIInfo.Load3.setDepth(11);
        }
        if(object.getId().equals("house1solar1")) {
            MainUI.ClickableObjects.load3stats.setDepth(-1);
            MainUI.UIInfo.Load3.setDepth(-2);
        }
        if(object.getId().equals("house1solar2")) {
            MainUI.ClickableObjects.load3stats.setDepth(-1);
            MainUI.UIInfo.Load3.setDepth(-2);
        }
        if(object.getId().equals("house1solar3")) {
            MainUI.ClickableObjects.load3stats.setDepth(-1);
            MainUI.UIInfo.Load3.setDepth(-2);
        }

        if(object.getId().equals("load4statsclick")) {
            MainUI.ClickableObjects.load4stats.setDepth(-1);
            MainUI.UIInfo.Load4.setDepth(-2);
        }
        if(object.getId().equals("load4stats")) {
            MainUI.ClickableObjects.load4stats.setDepth(11);
            MainUI.UIInfo.Load4.setDepth(11);
        }
        if(object.getId().equals("business1")) {
            MainUI.ClickableObjects.load4stats.setDepth(-1);
            MainUI.UIInfo.Load4.setDepth(-2);
        }

        if(object.getId().equals("load5statsclick")) {
            MainUI.ClickableObjects.load5stats.setDepth(-1);
            MainUI.UIInfo.Load5.setDepth(-2);
        }
        if(object.getId().equals("load5stats")) {
            MainUI.ClickableObjects.load5stats.setDepth(11);
            MainUI.UIInfo.Load5.setDepth(11);
        }
        if(object.getId().equals("business2")) {
            MainUI.ClickableObjects.load4stats.setDepth(-1);
            MainUI.UIInfo.Load4.setDepth(-2);
        }
        if(object.getId().equals("business2copy")) {
            MainUI.ClickableObjects.load4stats.setDepth(-1);
            MainUI.UIInfo.Load4.setDepth(-2);
        }
        if(object.getId().equals("business2copy2")) {
            MainUI.ClickableObjects.load4stats.setDepth(-1);
            MainUI.UIInfo.Load4.setDepth(-2);
        }

        if(object.getId().equals("load6statsclick")) {
            MainUI.ClickableObjects.load6stats.setDepth(-1);
            MainUI.UIInfo.Load6.setDepth(-2);
        }
        if(object.getId().equals("load6stats")) {
            MainUI.ClickableObjects.load6stats.setDepth(11);
            MainUI.UIInfo.Load6.setDepth(11);
        }
        if(object.getId().equals("business1a")) {
            MainUI.ClickableObjects.load4stats.setDepth(-1);
            MainUI.UIInfo.Load4.setDepth(-2);
        }
    }

	/**
	 * This function is called when a pointer moves over a clickable object.
	 * <p>
	 * This function is called before
	 * {@link #reportMove(Vector2f, MotionEvent, int) reportMove}.
	 * 
	 * @param object
	 *            the clickable object that the event triggered on
	 * @param coords
	 *            the openGL coordinates of the MotionEvent (<tt>[0,0]</tt> is
	 *            the center of the screen)
	 * @param e
	 *            the MotionEvent that caused this function to be called
	 * @param id
	 *            the pointer identifier of the MotionEvent
	 */
	public static synchronized void reportMoveOverObject(
			final Clickable object, final Vector2f coords, final MotionEvent e,
			final int id) {
	}

	/**
	 * This function is called when a pointer comes up and leaves the screen
	 * from a clickable object.
	 * <p>
	 * This function is called before
	 * {@link #reportUp(Vector2f, MotionEvent, int) reportUp}.
	 * 
	 * @param object
	 *            the clickable object that the event triggered on
	 * @param coords
	 *            the openGL coordinates of the MotionEvent (<tt>[0,0]</tt> is
	 *            the center of the screen)
	 * @param e
	 *            the MotionEvent that caused this function to be called
	 * @param id
	 *            the pointer identifier of the MotionEvent
	 */
	public static synchronized void reportUpFromObject(final Clickable object,
			final Vector2f coords, final MotionEvent e, final int id) {
	}

	/**
	 * This function is called when the main pointer's event is cancelled in
	 * some way (on top of a clickable object). This behaves like
	 * reportUpFromObject, except it shouldn't activate any buttons or
	 * functionality.
	 * <p>
	 * This function is called before
	 * {@link #reportCancel(Vector2f, MotionEvent, int) reportCancel}.
	 * 
	 * @param object
	 *            the clickable object that the event triggered on
	 * @param coords
	 *            the openGL coordinates of the MotionEvent (<tt>[0,0]</tt> is
	 *            the center of the screen)
	 * @param e
	 *            the MotionEvent that caused this function to be called
	 * @param id
	 *            the pointer identifier of the MotionEvent (however, only the
	 *            main pointer can generate this event)
	 */
	public static synchronized void reportCancelFromObject(
			final Clickable object, final Vector2f coords, final MotionEvent e,
			final int id) {
	}

	static int currentFault = 0;

	/**
	 * This function is called when a pointer goes down and touches the screen.
	 * 
	 * @param coords
	 *            the openGL coordinates of the MotionEvent (<tt>[0,0]</tt> is
	 *            the center of the screen)
	 * @param e
	 *            the MotionEvent that caused this function to be called
	 * @param id
	 *            the pointer identifier of the MotionEvent
	 */
	public static synchronized void reportDown(final Vector2f coords,
			final MotionEvent e, final int id) {
//		currentFault++;
//		if (currentFault == 13) {
//			currentFault = 0;
//		}
//		String fault;
//		switch (currentFault) {
//		case 1:
//			fault = "A";
//			break;
//		case 2:
//			fault = "B";
//			break;
//		case 3:
//			fault = "C";
//			break;
//		case 4:
//			fault = "D";
//			break;
//		case 5:
//			fault = "E";
//			break;
//		case 6:
//			fault = "F";
//			break;
//		case 7:
//			fault = "H";
//			break;
//		case 8:
//			fault = "I";
//			break;
//		case 9:
//			fault = "J";
//			break;
//		case 10:
//			fault = "K";
//			break;
//		case 11:
//			fault = "L";
//			break;
//		case 12:
//			fault = "M";
//			break;
//		default:
//			fault = "";
//		}
//		try {
//			Global.getGlobalSimulation().data.fault = fault;
//		} catch (Exception ex) {
//			// do nothing
//		}

		// Test
		/*
		 * final TextSprite text = new TextSprite(
		 * "This is a test paragraph designed to demonstrate the multi-line capabilities of the text rendering system.\nThere are few word-processor features for this system; carriage returns and wrap does work, but that's about it. Please note that this system is slow to initialize new strings; do not change them too often. Do not vary font, size, or line width on strings that do change, such as power readouts."
		 * , new Vector2f(0f, 0f), 60, Typeface.DEFAULT, 1000f, 0, 0, new
		 * Vector2f(1f, 1f), new Color(255, 255, 255));
		 * Global.getRenderer().addDrawable(text);
		 */
	}

	/**
	 * This function is called when a pointer moves around the screen.
	 * 
	 * @param coords
	 *            the openGL coordinates of the MotionEvent (<tt>[0,0]</tt> is
	 *            the center of the screen)
	 * @param e
	 *            the MotionEvent that caused this function to be called
	 * @param id
	 *            the pointer identifier of the MotionEvent
	 */
	public static synchronized void reportMove(final Vector2f coords,
			final MotionEvent e, final int id) {
	}

	/**
	 * This function is called when a pointer comes up and leaves the screen.
	 * 
	 * @param coords
	 *            the openGL coordinates of the MotionEvent (<tt>[0,0]</tt> is
	 *            the center of the screen)
	 * @param e
	 *            the MotionEvent that caused this function to be called
	 * @param id
	 *            the pointer identifier of the MotionEvent
	 */
	public static synchronized void reportUp(final Vector2f coords,
			final MotionEvent e, final int id) {
	}

	/**
	 * This function is called when the main pointer's event is cancelled in
	 * some way. This behaves like reportUp, except it shouldn't activate any
	 * buttons or functionality.
	 * 
	 * @param coords
	 *            the openGL coordinates of the MotionEvent (<tt>[0,0]</tt> is
	 *            the center of the screen)
	 * @param e
	 *            the MotionEvent that caused this function to be called
	 * @param id
	 *            the pointer identifier of the MotionEvent (however, only the
	 *            main pointer can generate this event)
	 */
	public static synchronized void reportCancel(final Vector2f coords,
			final MotionEvent e, final int id) {
	}
}
