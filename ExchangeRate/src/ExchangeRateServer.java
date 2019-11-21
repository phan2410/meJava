import java.net.*;
import java.io.*;
import java.util.*;

public class ExchangeRateServer {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(23);
			String localAddress = InetAddress.getLocalHost().getHostName().trim();
			int localPort = socket.getLocalPort();
			System.out.print(localAddress + ": ");
			System.out.println("Exchange rate server is listening on port " + localPort+".");
			int bufferLength = 256;
			byte outBuffer[];
			byte inBuffer[] = new byte[bufferLength];
			DatagramPacket outDatagram;
			DatagramPacket inDatagram = new DatagramPacket (inBuffer, inBuffer.length);
			boolean finished = false;
			do {
				socket.receive(inDatagram);
				InetAddress destAddress = inDatagram.getAddress();
				String destHost = destAddress.getHostName().trim();
				int destPort = inDatagram.getPort();
				System.out.println("\nReceived a request datagram from " + destHost + " at port" + destPort + ".");
				String data = new String(inDatagram.getData()).trim();
				System.out.println("It contained : " + data);
				if (data.equalsIgnoreCase("quit")) finished = true;
				String s = new Date().toString();
				s = s + "\n USD : " + getUSDrate();
				s = s + "\n EUR : " + getEURrate();
				s = s + "\n JPY : " + getJPYrate();
				outBuffer = s.getBytes();
				outDatagram = new DatagramPacket(outBuffer,outBuffer.length,destAddress,destPort);
				socket.send(outDatagram);
				System.out.println("Sent to " + destHost + " at port " + destPort + " on " + s);
			} while (!finished);
		} catch (IOException ex) {
				System.out.println(" IOException occurred.");
		}
	}
	private static String getUSDrate() {
		return Long.toString(20000 + Math.round(Math.random()*2000));
	}
	private static String getEURrate() {
		return Long.toString(28000 + Math.round(Math.random()*4000));
	}
	private static String getJPYrate() {
		return Long.toString(2000 + Math.round(Math.random()*200));
	}
}
