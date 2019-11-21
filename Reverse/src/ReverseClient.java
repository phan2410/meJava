import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ReverseClient {
	public static void main (String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.print("Host to connect (name or address): ");
			String hostin = in.next();
			ClientConnect client = new ClientConnect(hostin,23);
			client.requestServer();
			client.shutdown();
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
	}
}

class ClientConnect {
	Socket connection;
	DataOutputStream out;
	BufferedReader in;

	public ClientConnect (String destination,int port) {
		try {
			connection = new Socket(destination,port);
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			out = new DataOutputStream(connection.getOutputStream());
			System.out.println("Connected to server at port 23");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void requestServer () {
		BufferedReader keyboardInput = new BufferedReader (new InputStreamReader(System.in));
		boolean finished = false;
		boolean servershowed=true;
		do {
			try {
				System.out.println("\n\n\n------------------------------------------------------------------------------");
				System.out.println("------------------------------------------------------------------------------");
				System.out.print("\nSend data to server, Receive data from server or Quit (S/R/Q): ");
				System.out.flush();
				String line = keyboardInput.readLine();
				if (line.length() > 0) {
					line = line.toUpperCase();
					switch (line.charAt(0)) {
						case 'S':
							System.out.println("\nIn following printed order, please enter 1 double value for purchase");
							System.out.println("and 5 integer value for payment(dollars, quarters, dimes, nickels, pennies)!");
							System.out.println("\nPlease enter 6 value above separated by \"space\" (type \"quit\" to exit) : ");
							System.out.print("From client to server >>>");
							System.out.flush();
							String sendLine = keyboardInput.readLine();
							out.writeBytes(sendLine);
							out.write(13);
							out.write(10);
							out.flush();
							if (sendLine.equalsIgnoreCase("quit")) finished = true;
							else
								servershowed=false;
							break;
						case 'R':
							int inByte;
							System.out.print("\nFrom server to client >>> ");
							if (servershowed==false)
							{
								while (((inByte = in.read()) !='\n'))
									System.out.write(inByte);
								System.out.println();		
								servershowed=true;
							}
							else
								System.out.println("There is nothing to send!!!");
							break;
						case 'Q':
							finished = true;
							break;
						default: 
							System.out.println("\nHmm! Choose again please!");
							break;
					}
				} 
			} catch (Exception e) {
				System.out.println(e);
			}
		} while (!finished);
		System.out.println("\n------------------------------------------------------------------------------\n");
	}

	public void shutdown() {
		try {
			connection.close();
		} catch (IOException ex) {
			System.out.println("IO error closing socket");
		}
	}
}
