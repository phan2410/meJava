// Use a BufferedReader to read characters from the console.
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
class BRRead4Mod {
public static void main(String args[]) throws IOException
	{
		try{
			Robot robot = new Robot();
	//		Runtime rt=Runtime.getRuntime();
	//		rt.exec("cmd /c D:\\Musik\\DoiMatMauXanh.mp3");
			robot.delay(7000);
			BufferedReader source=new BufferedReader(new FileReader("C:\\Users\\PhanBear\\Desktop\\order4alezaa.txt"));
			String temp="";
			String fullfail="";
			Runtime rt=Runtime.getRuntime();
			while(true) {
				if (fullfail.length()==0){
					if ((temp=source.readLine().trim()).length() == 0) {
						rt.gc();
						break;
					}
				}				
				String[] parseInfo=new String(temp+" justnothing").split(" ");
				if (!new File("C:/Users/PhanBear/Desktop/4alezaa/"+parseInfo[1]).mkdirs()){
	//				System.out.println(parseInfo[0]);
	//				System.out.println(parseInfo[1]+" is already there !!!");
					continue;
				}
				robot.mouseMove(333, 47);
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.delay(300);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				StringSelection link = new StringSelection(parseInfo[0]);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			    clipboard.setContents(link,link);
			    robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				robot.delay(27000);
				robot.mouseMove(333, 88);
				robot.delay(7000);
				robot.keyPress(KeyEvent.VK_ESCAPE);
				robot.keyRelease(KeyEvent.VK_ESCAPE);
				robot.keyPress(KeyEvent.VK_ESCAPE);
				robot.keyRelease(KeyEvent.VK_ESCAPE);				
				robot.delay(300);
				if (fullfail.length()==0){
					robot.mouseMove(1254,88);
					robot.delay(500);
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.delay(300);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
					robot.delay(7000);
				} else {
					robot.mouseMove(777,348);
					robot.delay(3000);
				}				
				long size1=1,size2=2,size3=3;
				Long[] checkloop = new Long[9999];
				int i=1,loop=0;
				while((size1 != size2) || (size2 != size3)){
					BufferedImage screencapture;
					BufferedImage screencapture2;
					if (fullfail.length() == 0){
						screencapture = robot.createScreenCapture(new Rectangle(93, 53,531, 671));
						screencapture2 = robot.createScreenCapture(new Rectangle(744, 53,533, 671));
					} else{
						screencapture = robot.createScreenCapture(new Rectangle(93, 104,531, 584));
						screencapture2 = robot.createScreenCapture(new Rectangle(744, 104,533, 584));
					}					
				    robot.delay(111);
					robot.mouseMove(1333, 384);
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.delay(300);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
					File tempf= new File("C:/Users/PhanBear/Desktop/4alezaa/"+parseInfo[1]+"/"+(i*2-1)+".png");
		            ImageIO.write(screencapture, "png", tempf);
		            ImageIO.write(screencapture2, "png", new File("C:/Users/PhanBear/Desktop/4alezaa/"+parseInfo[1]+"/"+(i*2)+".png"));
		            if (fullfail.length() == 0){
		            	robot.delay(1777);
		            } else {
		            	robot.delay(1366);
		            }		            
		            int tempi= i%3;
		            long sizef=tempf.length();
					if (tempi == 0) {
						size3=sizef;					
					} else if (tempi == 1) {
						size1=sizef;
					} else {
						size2=sizef;
					}
					
					int temp1=Arrays.asList(checkloop).indexOf(sizef);
					if ((temp1>=0) && (i>=6)) {
						int temp2=Arrays.asList(checkloop).indexOf(checkloop[i-1]);
						if ((temp2 == (temp1+1))||(temp2 == (temp1-1))) {
							if (loop++>2){								
		//						rt.exec("cmd /c D:\\Musik\\DoiMatMauXanh.mp3");
								if (fullfail.length() == 0){
									fullfail="failcmnr!";
									removeDirectory(new File("C:/Users/PhanBear/Desktop/4alezaa/"+parseInfo[1]+"/"));
									i=0;
									break;
								} else {
									rt.exec("cmd /c D:\\Musik\\DoiMatMauXanh.mp3");
								}
								robot.delay(300);
								System.exit(0);
							}							
						}
					}
					checkloop[i]=sizef;		
		//			robot.delay(2000);
					i++;
		        }
				robot.keyPress(KeyEvent.VK_ESCAPE);
				robot.keyRelease(KeyEvent.VK_ESCAPE);
				robot.keyPress(KeyEvent.VK_ESCAPE);
				robot.keyRelease(KeyEvent.VK_ESCAPE);
				if ((i==0) && (fullfail.length() >0)) {
					rt.gc();
					continue;
				}
				i--;
				new File("C:/Users/PhanBear/Desktop/4alezaa/"+parseInfo[1]+"/"+(i*2)+".png").delete();
				new File("C:/Users/PhanBear/Desktop/4alezaa/"+parseInfo[1]+"/"+(i*2-1)+".png").delete();
				i--;
				new File("C:/Users/PhanBear/Desktop/4alezaa/"+parseInfo[1]+"/"+(i*2)+".png").delete();
				new File("C:/Users/PhanBear/Desktop/4alezaa/"+parseInfo[1]+"/"+(i*2-1)+".png").delete();
				fullfail="";
				rt.gc();				
			}
			
			source.close(); 
			rt.exec("shutdown -s -t 7"); 
	/*		robot.mouseMove(815, 130);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
			Runtime rt=Runtime.getRuntime();
			rt.exec("cmd /c C:\\Users\\PhanTom\\Desktop\\lancoldicc\\dicct.docx");
			
			robot.delay(2000);
			robot.mouseMove(650, 570);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			robot.delay(500);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			robot.delay(500);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_CONTROL);	
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);	
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_CONTROL);	
			
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);	
			
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_ALT);
			/----------------------------------------------/
			robot.mouseMove(696, 180);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			robot.delay(100);
			robot.mouseMove(815, 130);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			robot.delay(100);
			robot.mouseMove(696, 180);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			robot.delay(100);
			robot.mouseMove(815, 130);
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
			robot.delay(2000);
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_X);
			robot.keyRelease(KeyEvent.VK_X);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
			robot.delay(5000);
			Runtime rt=Runtime.getRuntime();
			rt.exec("cmd /c C:\\Users\\PhanTom\\Desktop\\lancoldicc\\dicct.docx");
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
			robot.keyRelease(KeyEvent.VK_ENTER);*/
			
			//Runtime rt=Runtime.getRuntime();
			//rt.exec("cmd /c D:\\Musik\\existence.mp4");
			
	
			
		}catch (Exception ex){ex.printStackTrace();}

		System.exit(0);
		 
        // SET THE MOUSE X Y POSITION
        
/*	String c="";
	ArrayList<String> ka=new ArrayList<String>();
	ka.add(null);
	//String[] a=c.split(" ");
	if (c.isEmpty()) System.out.println(ka.get(0));

}

public static String xoakhoangtrang(String str)
{
	String abc=str;
	for (int i=0; i<abc.length();i++)
	{
		if (abc.charAt(i)==' ')
		{
			if (i==0)//khoang trang dau tien bo
			{
				abc=abc.substring(1);
				i=-1;
			}
			else if (i==abc.length()-1)//khoang trang cuoi cung bo
			{
				abc=abc.substring(0, i);
				i=i-2;
			}
			else if (abc.charAt(i+1)==' ')//2 khoang trang lien nhau thi xoa
			{			
				abc=abc.substring(0,i+1)+abc.substring(i+2);
				i=i-1;
			}
		}
	}
	return abc;
}*/
	}
public static void removeDirectory(File dir) {
    if (dir.isDirectory()) {
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File aFile : files) {
                removeDirectory(aFile);
            }
        }
        dir.delete();
    } else {
        dir.delete();
    }
}
}