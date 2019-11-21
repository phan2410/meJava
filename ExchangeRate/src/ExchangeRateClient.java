import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ExchangeRateClient {
	public static void main(String[] args) {
		System.out.println("Currency Exchange Rate Updating Application");
		String dataRate = "";
		ExchangeThreat exRate = new ExchangeThreat(dataRate); exRate.start();
		System.out.print(dataRate);
	}
}

class ExchangeThreat extends Thread {
	String dataRate;
	ExchangeData rate = new ExchangeData();
	public ExchangeThreat(String dataRate) {
		this.dataRate = dataRate;
	}
	public void run(){
		while(true){
			String data = rate.getRates(); delay(2000);
		}
	}
	private void delay (int miliSeconds) {
		try {
			this.sleep(miliSeconds);
		} catch (Exception e) {
			System.out.println("Sleep error!");
		}
	}
}

class ExchangeData {
	DatagramSocket socket;
	InetAddress serverAddress;
	String localHost;
	int bufferLength = 256;
	byte inBuffer[] = new byte[bufferLength];
	byte outBuffer[];
	DatagramPacket outDatagram;
	DatagramPacket inDatagram;
	public ExchangeData() {
		try {
			socket = new DatagramSocket();
			inDatagram = new DatagramPacket(inBuffer, inBuffer.length);
			Scanner in = new Scanner(System.in);
			System.out.print("Server to connect (name or address): ");
			String hostin = in.next();
			serverAddress = InetAddress.getByName(hostin);
		} catch (Exception e) {
			System.out.println("Connect error!");
		}
	}
	public String getRates() {
		String data = "";
		try {
			outBuffer = new byte[bufferLength]; outBuffer = "rate".getBytes();
			outDatagram = new DatagramPacket(outBuffer,outBuffer.length,serverAddress,23);
			socket.send(outDatagram); socket.receive(inDatagram);
			InetAddress destAddress = inDatagram.getAddress();
			String destHost = destAddress.getHostName().trim();
			int destPort = inDatagram.getPort();
			System.out.println("\nSent a request datagram to " + destHost + " at port " + destPort + ".");
			System.out.println("Received a data package from " + destHost + " at port " + destPort + ".");
			data = new String(inDatagram.getData());
			data = data.trim();
			System.out.println("It contained:"); System.out.println(data);
		} catch (IOException ex) {
			System.out.println("IOException occurred.");
		}
		return data;
	}
}