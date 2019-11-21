import java.net.DatagramPacket;

import java.net.InetAddress;
import java.net.MulticastSocket;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//Nhom 9: PHan Hoang An | Tran Bao Duy | Pham Anh Hao | Bui Thanh Nguyen
public class Peer {
	
	static String id="";//username
	JTextArea incoming;//bang hien thi tin nhan
	JTextField receiver;//bang hien thi nguoi nhan, empty nghia la send all
	JTextField outgoing;//bang nhap vao de gui tin nhan
	JTextField naming;//dung de hoi username
	DatagramPacket packet;
	MulticastSocket socket;
	InetAddress group;
	JFrame frame0;//frame yeu cau username

	public static void main(String[] args) { 	
		Peer client = new Peer(); 
		client.askName();//frame yeu cau username
		while(id==""){};//khi chua co id thi cu roi vao vong lap vo tan
		client.go();//phan lon chuong trinh gom nhan message va hien thi
	}//close main

	public void askName(){
		frame0 = new JFrame("Messenger Login");
		JPanel mainPanel0 =new JPanel();
		JLabel username=new JLabel("Username ");
		naming=  new JTextField(10);
		JButton ok =new JButton("Okay");
		ok.addActionListener(new  okButtonListener());
		mainPanel0.add(username);
		mainPanel0.add(naming);
		mainPanel0.add(ok); 
		frame0.getContentPane().add(BorderLayout.CENTER, mainPanel0); 
		frame0.setSize(300,100);
		frame0.setVisible(true);
	}//close askName

	public void go (){
		JOptionPane.showMessageDialog(null, "Notice: \n_if RECIPIENTS box is left empty, you will send messages to everyone online now"
				+ "\n_if you wish to send only some people, then fill their usernames in RECIPIENTS box, separated by space"
				+ "\n_@Prof.Dr.Huy Nguyen: Group 9 wishes you a Merry Chrismas!!! ^_^");
		JFrame frame = new JFrame(id+"'s Messenger");
		JPanel mainPanel =new JPanel();
		JLabel recipient = new JLabel("RECIPIENTS >>> ");
		recipient.setForeground(Color.RED);
		receiver=  new JTextField(27);
		receiver.setBackground(Color.yellow);
		receiver.setBorder(BorderFactory.createBevelBorder(0, Color.RED, Color.GREEN));
		incoming= new JTextArea(15,30); 
		incoming.setLineWrap(true); 
		incoming.setWrapStyleWord(true); 
		incoming.setEditable(false);
		incoming.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
		incoming.setFont(new Font("Monotype Corsiva",Font.BOLD,29));
		incoming.setForeground(Color.BLUE);
		JScrollPane qScroller = new JScrollPane(incoming); 
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
		outgoing=  new JTextField(33);
		outgoing.setBorder(BorderFactory.createTitledBorder(id+"! Go say something ... "));
		JButton sendButton =new JButton("SEND");
		sendButton.setForeground(Color.GREEN);
		sendButton.addActionListener(new SendButtonListener());
		frame.getContentPane().add(sendButton);
		mainPanel.add(recipient);
		mainPanel.add(receiver);
		mainPanel.add(qScroller); 
		mainPanel.add(outgoing);
		mainPanel.add(sendButton); 
		connect();
		Thread readerThread=new Thread(new IncomingReader());
		readerThread.start();
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel); 
		frame.setSize(685,635);
		frame.setVisible(true);
	}//close go

	public void connect() {
		try {
				socket = new MulticastSocket(9999);	
				group = InetAddress.getByName("229.9.9.9");
				socket.joinGroup(group);
		}catch(IOException ex) {ex.printStackTrace () ;}
	}//close connect

	public class okButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			String temp=naming.getText().trim();
			if (temp.contains(" ")){
				JOptionPane.showMessageDialog(null, "An username cannot contain space !!!");
			}else if(temp.isEmpty()){
				JOptionPane.showMessageDialog(null, "Username must be specified !!!");
			}else{
				id=temp;
				frame0.dispose();
			}		
		}
	}//close inner class

	public class SendButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			try{ 	
				String tempo=receiver.getText().trim();
				String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());				
				if ((tempo!=null)&&(!tempo.isEmpty())){
					if (!tempo.contains(id))
						incoming.append(timeStamp+"\n"+id+": "+outgoing.getText()+"\n");
					tempo=timeStamp+"\u001D"+"RecipientDetected\u001F"+tempo+"\u001F";
				}else
					tempo=timeStamp+"\u001D";
				tempo=tempo.concat(id+": "+outgoing.getText());
				byte[] bytes =tempo.getBytes();
				socket.send(new DatagramPacket(bytes, bytes.length, group, 9999));
			}catch(Exception ex) { 
				ex.printStackTrace();
				outgoing.setText(""); 
				outgoing.requestFocus();
			}
		}
	}//close inner class

	public class IncomingReader implements Runnable{
		public void run(){
			try{
				while (true) {
				    byte[] buf = new byte[256];
			        packet = new DatagramPacket(buf, buf.length);
			        socket.receive(packet);
			        String[] temp=new String(packet.getData(), packet.getOffset(), packet.getLength()).split("\u001D");
			        if (temp[1].startsWith("RecipientDetected\u001F")){
			        	int secondu001f=temp[1].indexOf('\u001F', 18);
			        	int warpuser=temp[1].indexOf(id);
						if ((warpuser>=18)&&(warpuser<secondu001f)
								&&((temp[1].charAt(warpuser-1)==' ')||(temp[1].charAt(warpuser-1)=='\u001F'))
								&&((temp[1].charAt(warpuser+id.length())==' ')||(temp[1].charAt(warpuser+id.length())=='\u001F')))						
							incoming.append(temp[0]+"\n"+temp[1].substring(secondu001f+1)+"\n");		
					}else
						incoming.append(temp[0]+"\n"+temp[1]+"\n");
				}
			}catch (Exception ex){ex.printStackTrace();}
		}//close run
	}//close inner class

}//close outer class

