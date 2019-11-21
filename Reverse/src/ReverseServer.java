import java.net.*;
import java.io.*;

public class ReverseServer {
	public static void main (String[] args) {
		try {
			ServerSocket server = new ServerSocket(23);
			int localPort = server.getLocalPort();
			System.out.println("Reverse Server is listening on port " + localPort);
			Socket client = server.accept();
			String destName = client.getInetAddress().getHostName();
			int destPort = client.getPort();
			System.out.println("Accepted connection to " + destName + " on port " + destPort);
			BufferedReader inStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
			DataOutputStream outStream = new DataOutputStream(client.getOutputStream());
			boolean finished = false;
			System.out.println("\n\n\n------------------------------------------------------------------------------");
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("\nWelcome!!! Client has logged in!!!");
			do {
				CashRegister register= new CashRegister();
				double purchase=0;
				int[] payment=new int[7];
				int count=0;
				boolean okay=true;
				String inLine = inStream.readLine();
				if (inLine==null)
				{
					System.out.println("\nClient has logged out!!!");
					finished=true;
				}
				else
				{
					System.out.println("\n\n\n------------------------------------------------------------------------------");
					System.out.println("------------------------------------------------------------------------------");
					System.out.println("\nReceived from client: " + inLine);
					inLine=xoakhoangtrang(inLine);
					if (inLine.equalsIgnoreCase("quit")) finished = true;
					else
					{
						if (stringtonumberok(inLine)==true)
						{
							for (int i = 0;i < inLine.length(); i++)
							{
								if (inLine.charAt(i)==' ')
								{
									if (count==0)
									{
										purchase=Double.parseDouble(inLine.substring(0,i));
										count=1;
										payment[count]=i;
									}
									else 
									{
										payment[count]=Integer.parseInt(inLine.substring(payment[count]+1,i));
										count=count+1;
										payment[count]=i;
									}	
								}
							}
							if (count==5)
								payment[count]=Integer.parseInt(inLine.substring(payment[count]+1,inLine.length()));
							else
								okay=false;
						}
						else
						{
							okay=false;
						}
						if (okay==false){
							String idk="There is something go wrong here!!!";
							for (int i = 0;i < idk.length(); i++)
								outStream.write((byte)idk.charAt(i));
							outStream.write(13);
							outStream.write(10);
							outStream.flush();
							System.out.println("\n>>> "+idk);
							System.out.println("\n>>> Sent back to client: " + "\""+idk+"\"");
						}
						else//neu moi thu deu ok
						{
							System.out.println("\n>>> Purchase = "+purchase);
							System.out.println(">>> Payment = "+payment[1]+" + "+ payment[2]+"*0.25"+" + "+payment[3]+"*0.1"
																		+" + "+payment[4]+"*0.05"+" + "+payment[5]+"*0.01");
							register.recordPurchase(purchase);
							register.enterPayment(payment[1],payment[2],payment[3],payment[4],payment[5]);
							String change="Change = "+register.giveChange();
							System.out.println("\n\n>>> "+change);
							for (int i = 0;i < change.length(); i++)
								outStream.write((byte)change.charAt(i));
							outStream.write(13);
							outStream.write(10);
							outStream.flush();
							System.out.println("\n>>> Sent back to client: " + "\""+change+"\"");
						}					
					}
				}
			} while (!finished);
			System.out.println("\n------------------------------------------------------------------------------\n");
			inStream.close();
			outStream.close();
			client.close();
			server.close();
		} catch (IOException e) {
			System.out.println(e);
		}
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
	}
	
	public static boolean stringtonumberok(String str)
	{
		boolean ok=true;
		for (int i=0; i<str.length();i++)//xu ly chuoi so, xem tat ca ky tu nhap vao co ok ko
		{
			if (ok=true)
			{
				switch (str.charAt(i)){
				case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case ' ':
					break;		
				default:
					ok=false;
					break;
				}
			}
			else break;
		}
		return ok;
	}
}

class ReverseString {
	String s;
	public ReverseString (String in ) {
		int len = in.length();
		char outChars[] = new char[len];
		for (int i = 0; i < len; i++)
			outChars[len-1-i] = in.charAt(i);
		s = String.valueOf(outChars);		
	}
	public String getString() {
		return s;
	}
}
