import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Client {
	public static Component frame;

public static void main(String args[]) throws IOException{


    
	InetAddress address=InetAddress.getLocalHost();
    
    JFrame Client = new JFrame("BankAccount_Client");
	Client.setLayout(new GridLayout(5,1,0,5));
    Client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel head = new JLabel("Client Address : "+address);
    JLabel head1 = new JLabel("Enter Server IP");
	JTextField port = new JTextField(20);
    JButton c = new JButton("Connect");
    JButton Exit = new JButton("Exit");
    Client.add(head);Client.add(head1);
	Client.add(port);
	Client.add(c);
	Client.add(Exit);
	c.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent o)
	    {
			String num = port.getText();
			if (num.equals(""))
			{
				port.requestFocus();
			}
			else 
			{
				String address = port.getText();
				ClientConnect client = new ClientConnect(address,9999);
				client.menu();
			}
	    }});
	Exit.addActionListener(new ActionListener()	{
		public void actionPerformed(ActionEvent e)
		{
				System.exit(0);
		
		}});		
	Client.pack();
    Client.setLocationRelativeTo(null);
    Client.setVisible(true);
    
}
}
	class ClientConnect {
	    //Define
		Socket s1=null;
	    String line=null;
	    BufferedReader br=null;
	    BufferedReader is=null;
	    PrintWriter os=null;
	    
	    
	    /**This section creates the request menu for clients*/
	    public void menu() {
	    JFrame menu = new JFrame("Client menu");
	    menu.setLayout(new GridLayout(10,1,0,5));
	    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JLabel title = new JLabel("-- Welcome to client request center --");
	    JLabel title1 = new JLabel("Please choose your desired action");
	    JButton create  = new JButton("Create account");
	    JButton delete = new JButton("Delete account");
	    JButton deposit  = new JButton("Deposit money");
	    JButton withdraw  = new JButton("Withdraw money");
	    JButton transfer  = new JButton("Trasnfer money");
	    JButton dis1  = new JButton("Display an account information");
	    JButton disall  = new JButton("Display ALL account information");
	    JButton Exit  = new JButton("Exit");
	    menu.add(title);
	    menu.add(title1);
	    menu.add(create);
	    menu.add(delete);
	    menu.add(deposit);
	    menu.add(withdraw);
	    menu.add(transfer);
	    menu.add(dis1);
	    menu.add(disall);
	    menu.add(Exit);
	    
	    /** Action performed when hit button*/
	    /**Exit button*/
	    Exit.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent e)
			{
					System.exit(0);
			
			}});
	    /**Create Button*/
	    create.addActionListener(new ActionListener()	{
	    	public void actionPerformed(ActionEvent arg0)
	    	{		add_account();
	    }});
	    /**Delete Button*/
	    delete.addActionListener(new ActionListener()	{
	    	public void actionPerformed(ActionEvent arg0)
	    	{		del_account();
	    }});
	    /**Deposit button*/
	    deposit.addActionListener(new ActionListener()	{
	    	public void actionPerformed(ActionEvent arg0)
	    	{		deposit_account();
	    }});
	    /**Withdraw button*/
	    withdraw.addActionListener(new ActionListener()	{
	    	public void actionPerformed(ActionEvent arg0)
	    	{		withdraw_account();
	    }});
	    /**Transfer button*/
	    transfer.addActionListener(new ActionListener()	{
	    	public void actionPerformed(ActionEvent arg0)
	    	{		transfer();
	    }});		
	    /**Display an account button*/
	    dis1.addActionListener(new ActionListener()	{
	    	public void actionPerformed(ActionEvent arg0)
	    	{		display1();
	    }});
	    /**Display all accounts button*/
	    disall.addActionListener(new ActionListener()	{
	    	public void actionPerformed(ActionEvent arg0)
	    	{
				display();
			
	    }});
	    menu.pack();
	    menu.setLocationRelativeTo(null);
	    menu.setVisible(true);
	    }
	    
	    /**Frame for add account*/
	    public void add_account()
		{
			//Create JFrame
			JFrame add = new JFrame("Add account");
			add.setLayout(new GridLayout(6, 1, 2, 2));
			//add field text
			JTextField acc_num = new JTextField(10); 
			JTextField acc_bal = new JTextField(10);
			
			//add content
			add.add(new JLabel ("Enter new account number"));
			add.add(acc_num);
			add.add(new JLabel ("Enter new balance:"));
			add.add(acc_bal);	
			
			//add buttons
			JButton ok = new JButton("Submit");
			add.add(ok);

			//Procedure when press ADD
			ok.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent o)
			    {
					String num = acc_num.getText();
					os.println("1");
					os.flush();
					
					//If don't fill the Textbox
					if (num.equals(""))
					{
						acc_num.requestFocus(); //Cursor to the black Textbox
					}
						else 
						{
						 int a = Integer.parseInt(num);
						 if (a<0) {
							 os.println(a);
							 os.flush();
							 JOptionPane.showMessageDialog(null, "Invalid account value, please use only positive number");
						 	 	}
						 else
						 		{
							 os.println(a);
							 os.flush();
							 num = acc_bal.getText();
								if (num.equals("")){
									acc_bal.requestFocus();//Cursor to the black Textbox
								}
								else {
										String check=null;
										try{
											check=is.readLine();
										}catch(Exception e){
											JOptionPane.showMessageDialog(null, "Sorry for this inconvenience!!! Something goes wrong !!!");
										}
										if (Integer.parseInt(check)!=1){
											double b = Double.parseDouble(num);
											//check if negative//
											if(b<0)	{
													os.println(b);
													os.flush();
													JOptionPane.showMessageDialog(null, "Invalid balance value, please use only positive number");
													
													}
											else
												{
												os.println(b);
												os.flush();
												JOptionPane.showMessageDialog(null, "Account has been created successfully");
												}
										}
										else{
											JOptionPane.showMessageDialog(null, "Account has been existed !!!");
										}
									}
						 		}
						
						 }
				}
			});
			// close button
			JButton close = new JButton("Cancel");
			add.add(close);
			
			close.addActionListener(new ActionListener()
			{
			    public void actionPerformed(ActionEvent e)
			    {
			       add.dispose();
			    }
			});
			
			//Display the window.
	        add.pack();
	        add.setLocationRelativeTo(null);
	        add.setVisible(true); 
		}
	    
	    /**Frame for delete account*/
	    public void del_account()
		{
			//Create JFrame
			JFrame del = new JFrame("Delete account");
			del.setLayout(new GridLayout(5, 1, 2, 2)); //Create a Label with 5 rows and 1 column
					
			//add field text
			JTextField del_num = new JTextField(10); 
			
			//add content
			del.add(new JLabel("Enter the account number you want to delete:"));
			del.add(del_num);
			
			//add buttons
			JButton confirm = new JButton("Submit");
			
			del.add(confirm);
			confirm.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent d)
				  {
					int n = JOptionPane.showConfirmDialog(null,"The process of deleteting this account can not be undone. Continue anyway ?","Confirm",JOptionPane.YES_NO_OPTION);
					os.println("2");
					os.flush();
					if(n==JOptionPane.YES_OPTION)
				        {
				        	String text = del_num.getText();
				        	if (text.equals(""))
				        	{
								del_num.requestFocus();
							}
							else 
							{						
								int a = Integer.parseInt(text);
								os.println(a);
								os.flush();
								JOptionPane.showMessageDialog(null, "Your account has been deleted successfully");
				    						}
									}
							}
				        
					}
				);
								
			JButton close = new JButton("Cancel");
			del.add(close);
			
			close.addActionListener(new ActionListener() 
			{
			    public void actionPerformed(ActionEvent e)
					  {
					     del.dispose();
					  }
			});
					
			//Display the window.
	        del.pack();
	        del.setLocationRelativeTo(null);
	        del.setVisible(true);    
		}
	    
	    /**Frame for deposit*/
	    public void deposit_account()
		{
			//Create JFrame
			JFrame deposit = new JFrame("Deposit money");
			deposit.setLayout(new GridLayout(6, 2, 2, 2)); //Create a Label with 6 rows and 2 column
					
			//add field text
			JTextField num = new JTextField(10);
			JTextField dep = new JTextField(10);
			
			//add content
			deposit.add(new JLabel ("Enter the account number you want to deposit"));
			deposit.add(num);
			deposit.add(new JLabel ("Amount of money"));
			deposit.add(dep);
			
			//add buttons
			JButton ok = new JButton("Submit");
			deposit.add(ok);
			ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			 {
				String text = num.getText();
				os.println("3");
				os.flush();
				if (text.equals(""))
				{
					num.requestFocus();
				}
					else 
					{
					 int a = Integer.parseInt(text);
					 os.println(a);
					 os.flush();
					text = dep.getText();
					if (text.equals("")){
						dep.requestFocus();
					}
						else {
					 double b = Double.parseDouble(text);
					 os.println(b);
					 os.flush();
						JOptionPane.showMessageDialog(null, "Deposit Successfully");
					}
				}
				
		    }
		});
		
			JButton close = new JButton("Cancel");
			deposit.add(close);
			close.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{
					deposit.dispose();
				}
			});
			
			//Display the window.
	        deposit.pack();
	        deposit.setLocationRelativeTo(null);
	        deposit.setVisible(true);    
	}
	    
	    /**Frame for withdraw account*/
	    public void withdraw_account()
		{
			//Create JFrame
			JFrame withdraw = new JFrame("Withdraw money");
			withdraw.setLayout(new GridLayout(6, 1, 2, 2)); 

			//add field text
			JTextField num = new JTextField(10);
			JTextField wit = new JTextField(10);
			
			//add content
			withdraw.add(new JLabel ("Enter the account number you want to withdraw:"));
			withdraw.add(num);
			withdraw.add(new JLabel ("Amount of money:"));
			withdraw.add(wit);
			
			//add buttons
			JButton ok = new JButton("Submit");
			withdraw.add(ok);
			
			ok.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					String text = num.getText();
					os.println("4");
					if (text.equals(""))
					{
						num.requestFocus();
					}
					else 
					{
						int a = Integer.parseInt(text);
						os.println(a);
						os.flush();
						text = wit.getText();
						if (text.equals(""))
						{
							wit.requestFocus();
						}
						else 
						{
							double b = Double.parseDouble(text);
							os.println(b);
							os.flush();
								JOptionPane.showMessageDialog(null, "Withdraw successfully");
						}
					}			
				}
			});
			JButton close = new JButton("Cancel");
			withdraw.add(close);
			close.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				    {
				      withdraw.dispose();
				    }
			});
					
			//Display the window.
	        withdraw.pack();
	        withdraw.setLocationRelativeTo(null);
	        withdraw.setVisible(true);    
	    	}
	    
	    /**Frame for transfer money*/
	    public void transfer()
		{
			//Create JFrame
			JFrame transfer = new JFrame("Transfer money");
			transfer.setLayout(new GridLayout(8, 1, 2, 2)); //Create a Label with 8 rows and 1 column
			
			//add Field Text
			JTextField num1 = new JTextField(10);
			JTextField num2 = new JTextField(10);
			JTextField trans= new JTextField(10);
			
			//add content
			transfer.add(new JLabel("Sender account"));
			transfer.add(num1);
			transfer.add(new JLabel("Receiver account"));
			transfer.add(num2);
			transfer.add(new JLabel("Amount of money"));
			transfer.add(trans);
					
			//add button close
			JButton ok = new JButton("Submit");
			transfer.add(ok);
			ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			 {
				String text = num1.getText();
				os.println("5");
				os.flush();
				if (text.equals(""))
				{
					num1.requestFocus();
				}
					else 
					{
					int a = Integer.parseInt(text);
					os.println(a);
					os.flush();
					text = num2.getText();
					if (text.equals("")){
						num2.requestFocus();
					}
						else {
					 int b = Integer.parseInt(text);
					 os.println(b);
					 os.flush();
					 text = trans.getText();
					 if (text.equals("")){
							num2.requestFocus();
						}
					 else 
					 {
					 double c = Double.parseDouble(text);
					 os.println(c);
					 os.flush();
					
					 }
					}
				}
		    }
		});
			JButton close = new JButton("Cancel");
			transfer.add(close);
			close.addActionListener(new ActionListener() 
			{
			    public void actionPerformed(ActionEvent e)
			    {
			       transfer.dispose();
			    }
			});
			//Display the window.
	        transfer.pack();
	        transfer.setLocationRelativeTo(null);
	        transfer.setVisible(true);    
		}
	    
	    /**Display an account*/
	    
	    public void display1()
		{	
	    	os.println("6");
		    os.flush();
	    	try{
	       	String a = is.readLine();
			int n = Integer.parseInt(a);
			//Create JFrame
			JFrame display1 = new JFrame("Display accounts");
			display1.setLayout(new GridLayout(2, 1, 2, 2));
			JLabel header= new JLabel("Find account number:");
			
			//add Field Text
			JTextField num1 = new JTextField(10);
			JButton ok= new JButton("Find");
			JButton cancel = new JButton("Close");
			display1.add(header);
			display1.add(num1);
			display1.add(ok);
			display1.add(cancel);
			
			ok.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e)
					{
					 String text1 = num1.getText();
				    if( text1.equals("")){
				    	num1.requestFocus();}
				    	
				    	else
				    	{
				    		try{
				    		int b = Integer.parseInt(text1);
				    		os.println(b);
				    		os.flush();
				    		String d = is.readLine();
							String f = is.readLine();
							int m = JOptionPane.showConfirmDialog(null, "Account: " + d + " Balance: " +f,"message",JOptionPane.YES_NO_OPTION);
							if(m==JOptionPane.YES_OPTION){
								os.println("6");
							    os.flush();
							}
							else{
								display1.dispose();
							}
				    		}catch(IOException ie){
				    			ie.printStackTrace();
				    			System.out.println("Socket error");
				    		}
				    }
					
					}});
					
			//add button close
		
			cancel.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
					{
					       display1.dispose();
					}
					});
					
			//Display the window.
	        display1.pack();
	        display1.setLocationRelativeTo(null);
	        display1.setVisible(true);    
		}catch(IOException ie){
			ie.printStackTrace();
			System.out.println("Socket error");
		}
		}
	

	    /**Display all accounts*/
	    
	    public void display()
		{	
	    	os.println("7");
	    	os.flush();
	    	try{
	       	String a = is.readLine();
			int n = Integer.parseInt(a);
			//Create JFrame
			JFrame display = new JFrame("Display accounts");
			display.setLayout(new GridLayout(n+1, 1, 2, 2)); 
					
			//add content
			for(int i=0; i < n; i++)
			{
				
				String b = is.readLine();
				String c = is.readLine();
				display.add(new JLabel("Account number "+ b +", balance: "+ c));
			}
			//add button close
			JButton close = new JButton("Cancel");
			display.add(close);
			close.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
					{
					       display.dispose();
					}
					});
					
			//Display the window.
	        display.pack();
	        display.setLocationRelativeTo(null);
	        display.setVisible(true);    
		}catch(IOException ie){
			ie.printStackTrace();
			System.out.println("Socket error");
		}
		}
	    	
		
	    
	    /**Define port*/
		public ClientConnect (String destination, int port){
			try{
				s1= new Socket(destination,port);
				is= new BufferedReader(new InputStreamReader(s1.getInputStream()));
				os= new PrintWriter(s1.getOutputStream());		
			} catch(Exception e)
			{
				System.out.print(e);
			}
		}
		/**Create connection to server */
	

        }
	
