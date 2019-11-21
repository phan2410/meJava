import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
public class AddrLookupApp {
	public static void main(String args[]){
		try{
			Scanner in = new Scanner(System.in);
			System.out.print("Host name or Host adress:");
			String strin=in.next();
			InetAddress host = InetAddress.getByName(strin);
			String hostName=host.getHostName();
			System.out.println("Host name: "+hostName);
			System.out.println("IP Address: "+host.getHostAddress());
		}catch(UnknownHostException e){
			System.out.println("Address not found");
			return;
		}
	}
}
