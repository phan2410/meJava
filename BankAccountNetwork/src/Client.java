import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//Nhom 9 || Tran Bao Duy || Pham Anh Hao  || Bui THanh Nguyen || Phan Hoang An
public class Client{
	public static Component frame;
	public static void main(String args[]) throws IOException{
		InetAddress Address = InetAddress.getLocalHost();
		JFrame Client = new JFrame("Bank Account Client");
		Client.setLayout(new GridLayout(5,1,10,10));
		Client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		JLabel head1 = new JLabel("Client Address: "+ Address);
		JLabel head2 = new JLabel("Enter Server IP");
		final JTextField port = new JTextField(20);
		JButton Connect = new JButton("Connect");
		JButton Exit = new JButton("Exit");
		Client.add(head1);
		Client.add(head2);
		Client.add(port);
		Client.add(Connect);
		Client.add(Exit);		
		Connect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent o){
				String num = port.getText();
				if (num.equals("")){
					port.requestFocus();
				}else {
					String address = port.getText();
					ClientConnect client = new ClientConnect(address, 9999);
					client.menu();
				}
			}
		});		
		Exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});		
		Client.pack();
		Client.setLocationRelativeTo(null);
		Client.setVisible(true);
    }
}
	
class ClientConnect{
	Socket socket = null;
	String line = null;
	BufferedReader read = null;
	PrintWriter write = null;	    
	public void menu(){
		JFrame menu = new JFrame("Client menu");
		menu.setLayout(new GridLayout(10,1,10,10));
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		JLabel title1 = new JLabel("Request center");
		JLabel title2 = new JLabel("Please choose an action");		
		JButton create  = new JButton("Create account");
		JButton delete = new JButton("Delete account");
		JButton deposit  = new JButton("Deposit money");
		JButton withdraw  = new JButton("Withdraw money");
		JButton transfer  = new JButton("Trasnfer money");
		JButton displayone  = new JButton("Display an account information");
		JButton displayall  = new JButton("Display all account information");
		JButton Exit  = new JButton("Exit");	    
		menu.add(title1);
		menu.add(title2);
		menu.add(create);
		menu.add(delete);
		menu.add(deposit);
		menu.add(withdraw);
		menu.add(transfer);
		menu.add(displayone);
		menu.add(displayall);
		menu.add(Exit);	    
		Exit.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		System.exit(0);
	    	}
	    });
		create.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				add();
			}
		});	    
	    delete.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0){
	    		delete();
	    	}
	    });	    
	    deposit.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0){
	    		deposit();
	    	}
	    });	    
	    withdraw.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0){
	    		withdraw();
	    	}
	    });	    
	    transfer.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0){
	    		transfer();
	    	}
	    });			    
	    displayone.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0){
	    		displayone();
	    	}
	    });	    
	    displayall.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0){
	    		displayall();
	    	}
	    });	    
	    menu.pack();
	    menu.setLocationRelativeTo(null);
	    menu.setVisible(true);
	}
	    
	public void add(){
		final JFrame add = new JFrame("Add account");
		add.setLayout(new GridLayout(6,1,10,10));			
		final JTextField AccountNumber = new JTextField(10); 
		final JTextField AccountBalance = new JTextField(10);			
		add.add(new JLabel ("Account number:"));
		add.add(AccountNumber);
		add.add(new JLabel ("Balance:"));
		add.add(AccountBalance);				
		JButton ok = new JButton("Submit");
		add.add(ok);
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o){
				String Number = AccountNumber.getText();
				write.println("1");
				write.flush();if (Number.equals("")){
					AccountNumber.requestFocus(); 
				}else{
					int a = Integer.parseInt(Number);
					if (a < 0){
						write.println(a);
						write.flush();
						JOptionPane.showMessageDialog(null, "Invalid account balance, please use positive number only");
					}else{
						write.println(a);
						write.flush();
						Number = AccountBalance.getText();
						if (Number.equals("")){
							AccountBalance.requestFocus();
						}else{
							String check = null;
							try{
								check = read.readLine();
							}catch(Exception e){JOptionPane.showMessageDialog(null, "Sorry for this inconvenience!!! Something goes wrong !!!");}							
							if (Integer.parseInt(check)!=1){
								double b = Double.parseDouble(Number);
								if (b < 0){
									write.println(b);
									write.flush();
									JOptionPane.showMessageDialog(null, "Invalid balance value, please use only positive number");
								}else{
									write.println(b);
									write.flush();
									JOptionPane.showMessageDialog(null, "Account has been created successfully");
								}
							}else
								JOptionPane.showMessageDialog(null, "Account has been existed");
						}
					}
				}
			}
		});
		JButton close = new JButton("Cancel");
		add.add(close);			
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				add.dispose();
			}
		});			
		add.pack();
		add.setLocationRelativeTo(null);
		add.setVisible(true); 
	}
	    
	public void delete(){
		final JFrame delete = new JFrame("Delete account");
		delete.setLayout(new GridLayout(5,1,10,10)); 
		final JTextField DeleteNumber = new JTextField(10); 
		delete.add(new JLabel("Account number:"));
		delete.add(DeleteNumber);
		JButton confirm = new JButton("Submit");
		delete.add(confirm);
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d){
				int n = JOptionPane.showConfirmDialog(null,"The process of deleteting this account can not be undone. Continue anyway ?","Confirm",JOptionPane.YES_NO_OPTION);
				write.println("2");
				write.flush();
				if (n == JOptionPane.YES_OPTION){
					String text = DeleteNumber.getText();
					if (text.equals("")){
						DeleteNumber.requestFocus();
					}else {						
						int a = Integer.parseInt(text);
						write.println(a);
						write.flush();
						JOptionPane.showMessageDialog(null, "Your account has been deleted successfully");
					}
				}
			}
		});								
		JButton close = new JButton("Cancel");
		delete.add(close);			
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)	{
				delete.dispose();
			}
		});
					
		delete.pack();
		delete.setLocationRelativeTo(null);
		delete.setVisible(true);    
	}
	
	public void deposit(){
		final JFrame deposit = new JFrame("Deposit money");
		deposit.setLayout(new GridLayout(6,2,10,10));
		final JTextField Number = new JTextField(10);
		final JTextField Deposit = new JTextField(10);
		deposit.add(new JLabel ("Account number:"));
		deposit.add(Number);
		deposit.add(new JLabel ("Amount of money:"));
		deposit.add(Deposit);
		JButton ok = new JButton("Submit");
		deposit.add(ok);
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text = Number.getText();
				write.println("3");
				write.flush();
				if (text.equals("")){
					Number.requestFocus();
				}else {
					int a = Integer.parseInt(text);
					write.println(a);
					write.flush();
					text = Deposit.getText();
					if (text.equals("")){
						Deposit.requestFocus();
					}else{
						double b = Double.parseDouble(text);
						write.println(b);
						write.flush();
						JOptionPane.showMessageDialog(null, "Deposited successfully");
					}
				}
			}
		});		
		JButton close = new JButton("Cancel");
		deposit.add(close);
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				deposit.dispose();
			}
		});
		deposit.pack();
		deposit.setLocationRelativeTo(null);
		deposit.setVisible(true);    
	}

	public void withdraw(){
		final JFrame withdraw = new JFrame("Withdraw money");
		withdraw.setLayout(new GridLayout(6,1,10,10)); 
		final JTextField Number = new JTextField(10);
		final JTextField Withdraw = new JTextField(10);
		withdraw.add(new JLabel ("Account number:"));
		withdraw.add(Number);
		withdraw.add(new JLabel ("Amount of money:"));
		withdraw.add(Withdraw);
		JButton ok = new JButton("Submit");
		withdraw.add(ok);
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text = Number.getText();
				write.println("4");
				write.flush();
				if (text.equals("")){
					Number.requestFocus();
				}else{
					int a = Integer.parseInt(text);
					write.println(a);
					write.flush();
					text = Withdraw.getText();
					if (text.equals("")){
						Withdraw.requestFocus();
					}else {
						double b = Double.parseDouble(text);
						write.println(b);
						write.flush();
						JOptionPane.showMessageDialog(null, "Withdrew successfully");
					}
				}			
			}
		});
		JButton close = new JButton("Cancel");
		withdraw.add(close);
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				withdraw.dispose();
			}
		});
		withdraw.pack();
		withdraw.setLocationRelativeTo(null);
		withdraw.setVisible(true);    
	}

	public void transfer(){
		final JFrame transfer = new JFrame("Transfer money");
		transfer.setLayout(new GridLayout(8,1,10,10));
		final JTextField Number1 = new JTextField(10);
		final JTextField Number2 = new JTextField(10);
		final JTextField Transfer = new JTextField(10);
		transfer.add(new JLabel("From account number"));
		transfer.add(Number1);
		transfer.add(new JLabel("To account number"));
		transfer.add(Number2);
		transfer.add(new JLabel("Amount of money"));
		transfer.add(Transfer);
		JButton ok = new JButton("Submit");
		transfer.add(ok);
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text = Number1.getText();
				write.println("5");
				write.flush();
				if (text.equals("")){
					Number1.requestFocus();
				}else {
					int a = Integer.parseInt(text);
					write.println(a);
					write.flush();
					text = Number2.getText();
					if (text.equals("")){
						Number2.requestFocus();
					}
					
					else{
						int b = Integer.parseInt(text);
						write.println(b);
						write.flush();
						text = Transfer.getText();
						if (text.equals("")){
							Number2.requestFocus();
						}
						
						else {
							double c = Double.parseDouble(text);
							write.println(c);
							write.flush();
						}
					}
				}
			}
		});
			
		JButton close = new JButton("Cancel");
		transfer.add(close);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)	{
				transfer.dispose();
			}
		});
	        transfer.pack();
	        transfer.setLocationRelativeTo(null);
	        transfer.setVisible(true);    
		}

	public void displayone(){	
		write.println("6");
		write.flush();
		try	{
			String message = read.readLine();
			if (message.equalsIgnoreCase("empty")){
				JOptionPane.showMessageDialog(null, "There is no database in Bank Server !!!");
			}else{
				final JFrame displayone = new JFrame("Display an account");
				displayone.setLayout(new GridLayout(Integer.parseInt(message)+1,1,10,10));
				JLabel header = new JLabel("Find an account number:");
				final JTextField Number = new JTextField(10);
				JButton ok = new JButton("Find");
				JButton cancel = new JButton("Close");				
				displayone.add(header);
				displayone.add(Number);
				displayone.add(ok);
				displayone.add(cancel);				
				ok.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String text1 = Number.getText();
						if( text1.equals("")){
							Number.requestFocus();
						}else{
							try	{
								int b = Integer.parseInt(text1);
								write.println(b);
								write.flush();
								String d = read.readLine();
								String f = read.readLine();
								int m = JOptionPane.showConfirmDialog(null, "Acc #" + d + ", Bal $" + f,"message",JOptionPane.YES_NO_OPTION);
								if (m == JOptionPane.YES_OPTION){
									write.println("6");
									write.flush();
								}
								
								else{displayone.dispose();
								}
							}
							catch(IOException ie){ie.printStackTrace();}
						}
					}
				});
				
				cancel.addActionListener(new ActionListener()	{
					public void actionPerformed(ActionEvent e)	{
						displayone.dispose();
					}
				});
				displayone.pack();
				displayone.setLocationRelativeTo(null);
				displayone.setVisible(true);    
			}
		}
		catch(IOException ie){ie.printStackTrace();}
	}

	public void displayall(){	
		write.println("7");
		write.flush();
		try	{
			String message = read.readLine();
			if (message.equalsIgnoreCase("empty")){
				JOptionPane.showMessageDialog(null, "There is no database in Bank Server !!!");
			}else{
				int n = Integer.parseInt(message);
				final JFrame displayall = new JFrame("Display all the accounts");
				displayall.setLayout(new GridLayout(n+1,1,10,10)); 

				for (int i=0; i < n; i++){
					String b = read.readLine();
					String c = read.readLine();
					displayall.add(new JLabel("Acc #"+ b +", Bal $"+ c));
				}
				JButton close = new JButton("Cancel");
				displayall.add(close);
				close.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						displayall.dispose();
					}
				});
				displayall.pack();
				displayall.setLocationRelativeTo(null);
				displayall.setVisible(true);
			}			    
		}catch(IOException ex){ex.printStackTrace();}
	}

	public ClientConnect (String destination, int port)	{
		try	{
			socket = new Socket(destination,port);
			read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			write = new PrintWriter(socket.getOutputStream());		
		}catch(Exception e)	{
			System.out.print(e);
		}
	}
}