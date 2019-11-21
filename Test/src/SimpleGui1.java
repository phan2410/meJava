import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;

public class SimpleGui1 {
	
	public static void main (String[] args){
		Robot robot;
		try
		{
			robot = new Robot();
			
			robot.delay(3000);
			PointerInfo a = MouseInfo.getPointerInfo();
			Point b = a.getLocation();
			int x = (int) b.getX();
			int y = (int) b.getY();
			System.out.println(x + "," + y);
			robot.mouseMove(0, 0);
		} catch (Exception ex){ex.printStackTrace();}	
	}

}
