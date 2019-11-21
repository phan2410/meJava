import java.awt.Rectangle;
//import java.net.DatagramPacket;
//import java.util.ArrayList;
//import java.util.Scanner;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyEvent;
//import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class lilac2gcVOTD {

	public static void main(String args[]) {
		try {			
			if (JOptionPane.showConfirmDialog (null
					, "Is Eternal Lands Window At Proper Position ?"
					,"Please Make Sure"
					,JOptionPane.YES_NO_OPTION) 
				== JOptionPane.YES_OPTION) {
				Robot robot = new Robot();
				Runtime rt = Runtime.getRuntime();
				BufferedImage screencapture;
				File tempf;
				robot.delay(4000);
				robot.mouseMove(543, 33);
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.delay(300);
				robot.mouseMove(1882, 15);
				robot.delay(300);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
				robot.delay(100);
				tempf= new File("D:/AnSelected/JavaMeCache/EternalLands/lilac2gcVOTD/NowELWindow.png");
				screencapture = robot.createScreenCapture(new Rectangle(1366, 0, 1024, 768));	
				robot.delay(1000);
	            ImageIO.write(screencapture, "png", tempf);
	            robot.delay(300);
	            System.out.println(tempf.length());
	            if (tempf.length() == new File("D:/AnSelected/JavaMeCache/EternalLands/lilac2gcVOTD/Ref/ProperELWindow.png").length())
	            	if (JOptionPane.showConfirmDialog (null
	    					, "1. Please Login\n"
	    					+ "2. a Go To VOTD\n"
	    					+ "    b Empty Your Bag\n"
	    					+ "    c Put Vegetable In Slot 1\n"
	    					+ "3. Press OK\n"
	    					,"Please Do As Follows"
	    					,JOptionPane.YES_NO_OPTION) 
	    				== JOptionPane.YES_OPTION) {
	            		robot.mouseMove(1882, 15);
	            		robot.mousePress(InputEvent.BUTTON1_MASK);
	            		robot.delay(300);
	            		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	            		robot.delay(100);
	            		robot.keyPress(KeyEvent.VK_TAB);
	            		robot.delay(100);
	            		robot.keyRelease(KeyEvent.VK_TAB);
	            		robot.delay(100);
	            		robot.mouseMove(1691, 87);	            		
	        			robot.mousePress(InputEvent.BUTTON1_MASK);
	            		robot.delay(300);
	            		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	            		robot.delay(100);
	            		screencapture = robot.createScreenCapture(new Rectangle(1682, 79, 22, 22));
	        			tempf= new File("D:/AnSelected/JavaMeCache/EternalLands/lilac2gcVOTD/NowGoLilac.png");
	    	            ImageIO.write(screencapture, "png", tempf);
	    	            robot.delay(300);
	            	}	            	
			}
		} catch (Exception ex){ex.printStackTrace();}
		ShowMessageThenExit("lilac2gcVOTD is stopped !!!");
	}
	
	public static void ShowMessageThenExit(String Msg) {
		JOptionPane.showMessageDialog(null, Msg);
		System.exit(0);
	}
	
}
