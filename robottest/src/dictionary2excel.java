import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class dictionary2excel {

	public static void main(String[] args) {
		try{
			Robot robot=new Robot();
			
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_ALT);
			
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_ALT);
			
			robot.mouseMove(700, 170);
			
			for(int k=1;k<6;k++){
				for(int j=0;j<10;j++){
					for(int i=0;i<1300;i++){
						robot.mousePress(InputEvent.BUTTON1_MASK);
						robot.mouseRelease(InputEvent.BUTTON1_MASK);
						robot.delay(44);
						robot.keyPress(KeyEvent.VK_DOWN);
						robot.keyRelease(KeyEvent.VK_DOWN);		
						robot.delay(44);
						robot.keyPress(KeyEvent.VK_ALT);
						robot.keyPress(KeyEvent.VK_TAB);
						robot.keyRelease(KeyEvent.VK_TAB);
						robot.keyRelease(KeyEvent.VK_ALT);
						robot.delay(11);
						robot.keyPress(KeyEvent.VK_0);
						robot.keyRelease(KeyEvent.VK_0);
						robot.keyPress(KeyEvent.VK_1);
						robot.keyRelease(KeyEvent.VK_1);
						robot.keyPress(KeyEvent.VK_2);
						robot.keyRelease(KeyEvent.VK_2);
						robot.keyPress(KeyEvent.VK_4);
						robot.keyRelease(KeyEvent.VK_4);
						robot.keyPress(KeyEvent.VK_7);
						robot.keyRelease(KeyEvent.VK_7);
						robot.keyPress(KeyEvent.VK_ENTER);
						robot.keyRelease(KeyEvent.VK_ENTER);
						robot.keyPress(KeyEvent.VK_CONTROL);
						robot.keyPress(KeyEvent.VK_V);
						robot.keyRelease(KeyEvent.VK_V);
						robot.keyRelease(KeyEvent.VK_CONTROL);	
						robot.delay(44);
					}
					
					robot.keyPress(KeyEvent.VK_ESCAPE);
					robot.keyRelease(KeyEvent.VK_ESCAPE);
					
					robot.delay(11);
					
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_A);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					
					robot.delay(3000);
					
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_X);
					robot.keyRelease(KeyEvent.VK_X);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					
					robot.delay(5000);
					Runtime rt=Runtime.getRuntime();
					rt.exec("cmd /c C:\\Users\\PhanTom\\Desktop\\lancoldicc\\col"+k+".docx");
					robot.delay(30000);
					
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					robot.delay(1000);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					robot.delay(1000);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					
					robot.delay(1000);
					
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_END);
					robot.keyRelease(KeyEvent.VK_END);
					robot.keyRelease(KeyEvent.VK_CONTROL);	
					
					robot.delay(11000);
					
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_CONTROL);	
					
					robot.delay(11000);
					
					robot.keyPress(KeyEvent.VK_ESCAPE);
					robot.keyRelease(KeyEvent.VK_ESCAPE);
					
					robot.delay(11);
					
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_S);
					robot.keyRelease(KeyEvent.VK_S);
					robot.keyRelease(KeyEvent.VK_CONTROL);	
					
					robot.delay(40000);
					
					robot.keyPress(KeyEvent.VK_ALT);
					robot.keyPress(KeyEvent.VK_F4);
					robot.keyRelease(KeyEvent.VK_F4);
					robot.keyRelease(KeyEvent.VK_ALT);	
					
					robot.delay(5000);
					
					robot.keyPress(KeyEvent.VK_ALT);
					robot.keyPress(KeyEvent.VK_F4);
					robot.keyRelease(KeyEvent.VK_F4);
					robot.keyRelease(KeyEvent.VK_ALT);
					
					robot.delay(3000);
					
					robot.keyPress(KeyEvent.VK_S);
					robot.keyRelease(KeyEvent.VK_S);
					
					robot.delay(8000);
					robot.keyPress(KeyEvent.VK_N);
					robot.keyRelease(KeyEvent.VK_N);
					
					robot.delay(11000);
					
					rt.exec("cmd /c C:\\Users\\PhanTom\\Desktop\\dicc.docx");
					robot.delay(4000);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					robot.delay(1000);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					robot.delay(1000);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					robot.delay(11);				
				}
			}
			
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);
			
			robot.delay(11);
			
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);
			
			Runtime rtt=Runtime.getRuntime();
			rtt.exec("cmd /c D:\\Musik\\existence.mp4");		
			
			robot.delay(1800000);
			
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);
			
			rtt.exec("cmd /c shutdown -t 0 -s -f");	
			
		}catch (Exception ex){ex.printStackTrace();}
	}

}
