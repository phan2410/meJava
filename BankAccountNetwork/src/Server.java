import java.io.*;
import java.net.*;
import java.util.*;
//Nhom 9 || Tran Bao Duy || Pham Anh Hao  || Bui THanh Nguyen || Phan Hoang An
/** 
A bank account has a balance that can be changed by  
deposits and withdrawals. 
*/ 
class BankAccount 
{   
	private int accountNumber; 
	private double balance; 

	/** 
	   Constructs a bank account with a zero balance. 
	   @param anAccountNumber the account number for this account 
	*/ 
	public BankAccount(int anAccountNumber) 
	{    
	   accountNumber = anAccountNumber; 
	   balance = 0; 
	} 

	/** 
	Constructs a bank account with a given balance 
	@param anAccountNumber the account number for this account 
	@param initialBalance the initial balance 
	*/ 
	public BankAccount(int anAccountNumber, double initialBalance) 
	{    
		accountNumber = anAccountNumber; 
		balance = initialBalance; 
	} 

	/** 
	Gets the account number of this bank account. 
	@return the account number 
	*/ 
	public int getAccountNumber() 
	{    
		return accountNumber; 
	} 

	/** 
	Deposits money into the bank account. 
	@param amount the amount to deposit 
	*/ 
	public void deposit(double amount) 
	{   
		double newBalance = balance + amount; 
		balance = newBalance; 
	} 
	/** 
	Withdraws money from the bank account. 
	@param amount the amount to withdraw 
	*/ 
	public void withdraw(double amount) 
	{    
		double newBalance = balance - amount; 
		balance = newBalance; 
	} 

	/** 
	Gets the current balance of the bank account. 
	@return the current balance 
	*/ 
	public double getBalance() 
	{    
		return balance; 
	} 
} 


public class Server
{
	public static void main(String args[]) {
		Socket client=null;
		ServerSocket server=null;
		System.out.println("Server is listening....");
		try
		{
			server = new ServerSocket(9999); //connect to port 9999
		}catch(IOException es){
			es.printStackTrace();
			System.out.println("Opps !!! Server collapses !!!");
		}

		while (true){
			try{
				client = server.accept();
				InetAddress destName = client.getInetAddress();
				int destPort = client.getPort();
				System.out.println("Established connection to " + destName + " on port " + destPort);
				Main main = new Main(client);
				main.start();
			}catch(Exception e)	{
				e.printStackTrace();
				System.out.println("Opps!!! Something goes wrong !!!");
			}
		}
	}
}

class Main extends Thread
{  
	BufferedReader read;
	PrintWriter write;
	Socket client;
	
	public static ArrayList<BankAccount> accs = new ArrayList<BankAccount>();
	public static int accnum = 0;
	public Main(Socket client){
		this.client = client;
	}

	public void run()
	{
		try	{
			read = new BufferedReader(new InputStreamReader(client.getInputStream()));
			write =new PrintWriter(client.getOutputStream());
			boolean finished = false;
			do{
				String input = read.readLine();
				if (input.equalsIgnoreCase("quit")) finished = true;
				else{
					if (input.length() > 0)
					{
						switch (input.charAt(0))
						{	
							case '1':
								int accnum = Integer.parseInt(read.readLine());
								if (accountduplication(accnum))	{
									System.out.println("Account has already been existed !!!");
									write.println(1);
									write.flush();
								}else{
									write.println(0);
									write.flush();
									double money = Double.parseDouble(read.readLine());
									if (accnum < 0)
									{
										System.out.println("Account number must be positive !!!");
									}
									
									else if (money < 0)
									{
										System.out.println("Balance number never be negative !!!");
									} 
									
									else 
									{
										System.out.println("Account number: " + accnum + ", balance: "+ money);
										accs.add(new BankAccount(accnum, money));
									}
								}
								break;
							case '2':
								int accnum1 = Integer.parseInt(read.readLine());
								for (int i = 0; i < accs.size();i++)
								{
									if (accnum1 == accs.get(i).getAccountNumber())
									{
										accs.remove(i);
										System.out.println("The account " + accnum1 + " has been deleted");
										break;
									}
								}
								break;
							case '3':
								int accnum3 = Integer.parseInt(read.readLine());
								double dpsmoney = Double.parseDouble(read.readLine());								
								accs.get(get_Arraynumber(accnum3)).deposit(dpsmoney);								
								write.println(String.valueOf(accs.get(get_Arraynumber(accnum3)).getAccountNumber()));
								write.flush();
								write.println(String.valueOf(accs.get(get_Arraynumber(accnum3)).getBalance()));
								write.flush();
								System.out.println("The balance of account number " + accs.get(get_Arraynumber(accnum3)).getAccountNumber() 
													+ " is: " + accs.get(get_Arraynumber(accnum3)).getBalance());
								break;								
							case '4':
								int accnum4 = Integer.parseInt(read.readLine());
								double wdmoney = Double.parseDouble(read.readLine());								
								accs.get(get_Arraynumber(accnum4)).withdraw(wdmoney);								
								write.println(String.valueOf(accs.get(get_Arraynumber(accnum4)).getAccountNumber()));
								write.flush();
								write.println(String.valueOf(accs.get(get_Arraynumber(accnum4)).getBalance()));
								write.flush();
								System.out.println("The balance of account number " + accs.get(get_Arraynumber(accnum4)).getAccountNumber() 
													+ " is: " + accs.get(get_Arraynumber(accnum4)).getBalance());
								break;
							case '5':
								int accnum51 = Integer.parseInt(read.readLine());
								int accnum52 = Integer.parseInt(read.readLine());
								double tfmoney = Double.parseDouble(read.readLine());
								accs.get(get_Arraynumber(accnum51)).withdraw(tfmoney);
								accs.get(get_Arraynumber(accnum52)).deposit(tfmoney);
								write.println(String.valueOf(accs.get(get_Arraynumber(accnum51)).getBalance()));
								write.flush();
								write.println(String.valueOf(accs.get(get_Arraynumber(accnum52)).getBalance()));
								write.flush();
								System.out.printf("The money has been transfered succesfully"+ "\n" + "Balance of Account "
													+ accs.get(get_Arraynumber(accnum51)).getAccountNumber() + " is: " + accs.get(get_Arraynumber(accnum51)).getBalance() + "\n"+ "Balance of Account "
													+ accs.get(get_Arraynumber(accnum52)).getAccountNumber() + " is: " + accs.get(get_Arraynumber(accnum52)).getBalance());
								break;
							case '6':
								if (accs.size()<=0){
									write.println("empty");
									write.flush();
								}else{
									write.println(String.valueOf(accs.size()));
									write.flush();
									String n = read.readLine();
									int AccountNumber = Integer.parseInt(n);
									for(int i = 0; i < accs.size(); i++){
										if (AccountNumber == accs.get(i).getAccountNumber()){			
											System.out.println("Account number: "+ accs.get(i).getAccountNumber() + ", Balance: " + accs.get(i).getBalance());
											write.println(String.valueOf(accs.get(i).getAccountNumber()));
											write.flush();
											write.println(String.valueOf(accs.get(i).getBalance()));
											write.flush();
										}
									}
								}
								break;
							case '7':
								if (accs.size()<=0){
									write.println("empty");
									write.flush();
								}else{
									write.println(String.valueOf(accs.size()));
									write.flush();
									for(int i = 0; i < accs.size(); i++){
										System.out.println("Account number: "+ accs.get(i).getAccountNumber() + ", Balance: " + accs.get(i).getBalance());
										write.println(String.valueOf(accs.get(i).getAccountNumber()));
										write.flush();
										write.println(String.valueOf(accs.get(i).getBalance()));
										write.flush();
									}
								}
								break;
							}
						}
					}			
				}while (!finished);
			}catch (IOException e){System.out.println(e);}
		finally	{    
			try	{
				read.close();
				write.close();
				client.close();
			}catch(IOException ie){System.out.println("Socket Close Error");}
		}
	}
    
	public static int get_Arraynumber(int AccountNumber) {	
    	int ArrayNumber = 0;
    	accnum = accs.size();
    	for (int i = 0; i < accnum; i++){	
    		BankAccount temp = accs.get(i);
    		if (AccountNumber == temp.getAccountNumber()){
    			ArrayNumber = i;
    			break;
    		}
    	}
    	return ArrayNumber;
    }
    
    private boolean accountduplication(int AccountNumber){
		int i = 0;
		if (accs.size() == 0){
			return false;
		}else{
			for (i = 0; i < (accs.size()); i++){
				if (accs.get(i).getAccountNumber() ==  AccountNumber){
					i = -1; 
					break;
				}			
			}			
			if (i == -1){
				return true;
			}else{
				return false;
			}
		}
	}
}