import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class swf2pdf {

	public static void main(String[] args) {
		try {
			Robot robot = new Robot();
			Runtime rt=Runtime.getRuntime();
	/*		rt.exec("cmd /c \"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe\" vgu.edu.vn");
			Thread.sleep(11111);
			for (int ind=0;ind<7;ind++){
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_F4);
				Thread.sleep(77);
				robot.keyRelease(KeyEvent.VK_F4);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(333);
			}*/
			rt.exec("cmd /c \"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe\" www.google.com.vn");
			Thread.sleep(7777);			
			try(Stream<Path> paths = Files.walk(Paths.get("C:/Users/PhanBear/Desktop/AJAVA/"))) {
				Thread.sleep(777);
			    paths.forEach(filePath -> {
			        if (Files.isRegularFile(filePath)) {
			        	String tempstr=filePath.toString();
			        	try {
							rt.exec("cmd /c \"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe\" file:///".concat(tempstr));
							//System.out.println(Thread.activeCount());
							Thread.sleep(555);			        	
				        	robot.mouseMove(587, 249);
				        	robot.mousePress(InputEvent.BUTTON3_MASK);
				        	Thread.sleep(333);
				        	robot.mouseRelease(InputEvent.BUTTON3_MASK);
				        	Thread.sleep(111);
				        	robot.mouseMove(644,362);
				        	robot.mousePress(InputEvent.BUTTON1_MASK);
				        	Thread.sleep(111);
				        	robot.mouseRelease(InputEvent.BUTTON1_MASK);
				        	Thread.sleep(999);
				        	robot.mouseMove(353, 353);
				        	robot.mousePress(InputEvent.BUTTON1_MASK);
				        	Thread.sleep(111);
				        	robot.mouseRelease(InputEvent.BUTTON1_MASK);
				        	Thread.sleep(3333);
				        	robot.keyPress(KeyEvent.VK_CONTROL);
							robot.keyPress(KeyEvent.VK_F4);
							Thread.sleep(111);
							robot.keyRelease(KeyEvent.VK_F4);
							robot.keyRelease(KeyEvent.VK_CONTROL);
							Thread.sleep(111);
				        	robot.mouseMove(418, 15);
				        	Thread.sleep(111);
				        	robot.mousePress(InputEvent.BUTTON1_MASK);
				        	Thread.sleep(111);
				        	robot.mouseRelease(InputEvent.BUTTON1_MASK);
				        	Thread.sleep(333);
				        	new File("C:/Users/PhanBear/Desktop/temp/Flash.pdf").renameTo(new File(tempstr.substring(0, tempstr.length()-4).concat(".pdf")));
							Thread.sleep(333);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}			        				        	
			        }        
			    });			    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

	}

}
