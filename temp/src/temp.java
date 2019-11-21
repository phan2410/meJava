import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

public class temp {

	public static void main(String[] args) {
		Robot robot;
		Runtime rt=Runtime.getRuntime();
		try {
			robot = new Robot();
//			BufferedImage screencapture;
//			File tempf;
//			String tempstr =System.getProperty("user.home").concat("\\Desktop\\BWTracker.xlsx");
//			System.out.print(tempstr);
//			robot.mouseMove(1691, 87);
//			robot.mousePress(InputEvent.BUTTON1_MASK);
//			robot.delay(300);
//			robot.mouseRelease(InputEvent.BUTTON1_MASK);
	//		robot.delay(7000);
	/*		robot.keyPress(KeyEvent.VK_SPACE);
			for (int i=0; i<2000; i++){
				robot.keyPress(KeyEvent.VK_Z);
				robot.delay(111);
				robot.keyRelease(KeyEvent.VK_Z);
				robot.delay(77);
			}
			robot.keyRelease(KeyEvent.VK_SPACE); */
	/*		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			double width = screenSize.getWidth();
			double height = screenSize.getHeight();
			System.out.print(width+" hoho "+ height);*/
			
//			robot.delay(1000);
//			screencapture = robot.createScreenCapture(new Rectangle(1682, 79, 22, 22));
//			tempf= new File("D:/AnSelected/JavaMeCache/EternalLands/lilac2gcVOTD/NowGoLilac.png");
//            ImageIO.write(screencapture, "png", tempf);
			
			
			{// This code is for an ease of finding mouse position
				robot.mouseMove(0, 0);			
				robot.delay(4000);
				System.out.println(MouseInfo.getPointerInfo().getLocation());
				robot.mouseMove(0, 0);
			}
			
			
//			robot.mouseMove(744, 104);
	//		robot.mouseMove(1802,967);
	//		rt.exec("cmd /c \"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe\" vgu.edu.vn");
	/*		try(Stream<Path> paths = Files.walk(Paths.get("D:/Archives/Phat_Phap/AJAVA/"))) {
			    paths.forEach(filePath -> {
			        if (Files.isDirectory(filePath)) {
			            System.out.println(filePath);
			            try {
							rt.exec("cmd /c start "+filePath.toString());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
			    });
			}  catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}								
	*/
	/*	
			
			InputStream asd= new FileInputStream("C:\\Users\\PhanBear\\Desktop\\Temp\\settings (2).ybd");
			Reader reader = new InputStreamReader(asd, Charset.defaultCharset());
            // buffer for efficiency
            Reader buffer = new BufferedReader(reader);
            List<Integer> src2 = new ArrayList<Integer>();
            int r;
            while ((r = buffer.read()) != -1) {
            	src2.add(r);
            }
            asd= new FileInputStream("C:\\Users\\PhanBear\\Desktop\\Temp\\settings (3).ybd");
			reader = new InputStreamReader(asd, Charset.defaultCharset());
            // buffer for efficiency
            buffer = new BufferedReader(reader);
            List<Integer> src3 = new ArrayList<Integer>();
            while ((r = buffer.read()) != -1) {
            	src3.add(r);
            }
            asd= new FileInputStream("C:\\Users\\PhanBear\\Desktop\\Temp\\settings (4).ybd");
			reader = new InputStreamReader(asd, Charset.defaultCharset());
            // buffer for efficiency
            buffer = new BufferedReader(reader);
            List<Integer> src4 = new ArrayList<Integer>();
            while ((r = buffer.read()) != -1) {
            	src4.add(r);
            }
			asd.close();
			reader.close();
			buffer.close();
			r=0;
			for (r=0; r < src2.size(); r++) {
				for (int i=0; i < src3.size(); i++){
					if (src2.get(r)==src3.get(i)){
						if(src2.get(++r)==src3.get(++i)){
							if (src4.contains(src2.get(r)) && src4.contains(src2.get(r-1))){
								System.out.print((char) src2.get(r-1).intValue());
								System.out.println((char) src2.get(r).intValue());
							}
						}
					}
				}
			}
			
			*/
/*			try {
				BufferedReader src2=new BufferedReader(new FileReader("C:\\Users\\PhanBear\\Desktop\\Temp\\settings (2).ybd"));
				String tmp2="";
				BufferedReader src3=new BufferedReader(new FileReader("C:\\Users\\PhanBear\\Desktop\\Temp\\settings (3).ybd"));
				String tmp3="";
				BufferedReader src4=new BufferedReader(new FileReader("C:\\Users\\PhanBear\\Desktop\\Temp\\settings (4).ybd"));
				String tmp4="";				
				String tmp="";
				while (true){
					tmp= src2.readLine();
					try{
						if ((tmp == null) || (tmp == "")) {
							break;
						}
					} catch (NullPointerException e) {};
					tmp2=tmp2+tmp;				
//					System.out.println(tmp);
				}
				src2.close();
				tmp="";
				while (true){
					tmp= src3.readLine();
					try{
						if ((tmp == null) || (tmp == "")) {
							break;
						}
					} catch (NullPointerException e) {};
					tmp3=tmp3+tmp;				
				}
				src3.close();
				tmp="";
				while (true){
					tmp= src4.readLine();
					try{
						if ((tmp == null) || (tmp == "")) {
							break;
						}
					} catch (NullPointerException e) {};
					tmp4=tmp4+tmp;				
				}
				src4.close();
				tmp="";
	//			System.out.println(tmp2);
				for (int i = 0 ; i < tmp2.length(); i++){
					for (int j = 0 ; j < tmp3.length(); j++){
						if (tmp2.charAt(i) == tmp3.charAt(j)){
							if (tmp2.charAt(++i) == tmp3.charAt(++j)){
								CharSequence tmpo =tmp2.subSequence(i-1, i+1);
								if (tmp4.contains(tmpo)){
									System.out.println(tmpo.toString()+" YEY "+i);									
								}
							}
						}
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
*/			
			
			
	/*		robot.mouseMove(1300, 686);
			robot.mouseMove(67, 99);
			robot.delay(3000);
			BufferedImage screencapture=robot.createScreenCapture(new Rectangle(67, 99,1233, 589));
			File tempf= new File("C:/Users/PhanBear/Desktop/abc.png");
            ImageIO.write(screencapture, "png", tempf);*/
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	/*	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} 
		
		
	//	System.out.println(abc.length());
	}

}
