import java.awt.AWTException;
import java.awt.HeadlessException;
//import java.awt.MouseInfo;
//import java.awt.Point;
//import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class AlphaVersion {

	public static void main(String[] args) throws IOException {
		JFrame mainFrame = new JFrame();
		mainFrame.setAlwaysOnTop(true);
		Robot robot;
		Runtime rt=Runtime.getRuntime();
		final File idmanDir = new File("C:/PROGRA~2/INTERN~2/");
		String savedDir = null;
		JFileChooser chooseSavedDir = new JFileChooser();
		chooseSavedDir.setCurrentDirectory(new File("D:/"));
		chooseSavedDir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (chooseSavedDir.showSaveDialog(mainFrame) == JFileChooser.APPROVE_OPTION)
		{
			savedDir = chooseSavedDir.getSelectedFile().getAbsolutePath().toString().replace("\\", "/");
		}
		else
		{
			System.exit(0);
		}
//		final String savedDir = ;
		//System.out.println(savedDir);
		try {
			robot = new Robot();
//			{// This code is for an ease of finding mouse position
//				robot.mouseMove(0, 0);
//				robot.delay(3000);
//				robot.mouseMove(991, 415);				
//				robot.delay(4000);
//				System.out.println(MouseInfo.getPointerInfo().getLocation());
//				robot.mouseMove(0, 0);
//			}			
			do {
				if (JOptionPane.showConfirmDialog(mainFrame, "Continue For This Currently Playing Video?", "Add Video To IDM Queue", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)
				{
					break;					
				}
				robot.mouseMove(991, 415);	
				robot.delay(100);
				robot.mousePress(InputEvent.BUTTON3_MASK);
				robot.delay(100);
				robot.mouseRelease(InputEvent.BUTTON3_MASK);
				robot.delay(300);
				robot.mouseMove(1070, 533);
				robot.delay(100);
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.delay(100);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
				robot.delay(300);
				rt.exec("cmd /c idman /d \"" + Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString() 
						+ "\" /p \"" + savedDir + "\" /a",null,idmanDir);
			} while (true);			
		} catch (AWTException | HeadlessException | UnsupportedFlavorException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(mainFrame, e.toString() + "\n" + e.fillInStackTrace());			
		}
		System.exit(0);
	}

}
