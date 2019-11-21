import java.io.*;
import java.net.*;
import java.util.*;


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


public class Server {
	
public static void main(String args[]){


    Socket client=null;
    ServerSocket server=null;
    System.out.println("Server read listening....");
    try{
        server = new ServerSocket(9999); 

    }
    catch(IOException e){
    e.printStackTrace();
    System.out.println("Server error");

    }

    while(true){
        try{
            client= server.accept();
            InetAddress destName = client.getInetAddress();
			int destPort = client.getPort();
			System.out.println("Accepted connection to " + destName + " on port " + destPort);
            Main main=new Main(client);
            main.start();            
        } catch(Exception e){
        e.printStackTrace();
        System.out.println("Opps !!! Something goes wrong !!!");
    }
    }
}
}

class Main extends Thread{  
    BufferedReader read;
    PrintWriter write;
    Socket client;
    public static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
    public static int accountnumber=0;
    public Main(Socket client){
        this.client=client;
    }
    
    public void run() {
    try{
        read= new BufferedReader(new InputStreamReader(client.getInputStream()));
        write=new PrintWriter(client.getOutputStream());
    boolean finished = false;
    do {
		String input = read.readLine();
		if (input.equalsIgnoreCase("quit")) finished = true;
		if (input.length() > 0){
		switch (input.charAt(0)){	
		case '1':
		String inLine = read.readLine();
		int accountNum = Integer.parseInt(inLine);
		if (accountduplication(accountNum)){
			System.out.println("Account has been existed!");
			write.println(1);
			write.flush();
		} else {
			write.println(0);
			write.flush();
			String inLine2 = read.readLine();
			double accountBal = Double.parseDouble(inLine2);
			if (accountNum<0){System.out.println("Invalid account number");}
			else if (accountBal <0){ System.out.println("Invalid balance value");} 
			else 
			{
				System.out.println("Account number: " + accountNum+", balance: "+accountBal);
				accounts.add(new BankAccount(accountNum,accountBal));}
		}
		break;

		case '2':
		String inLine3 = read.readLine();
		int accountNum1 = Integer.parseInt(inLine3);
		for (int t = 0; t < accounts.size();t++)
		{
			BankAccount temp1 = accounts.get(t);
			if( accountNum1 == temp1.getAccountNumber())
				{
					accounts.remove(t);
					System.out.println("The account "+ accountNum1+" has been deleted.");
					break; //Leave out
				}}
		break;

		case '3':
		String inLine4 = read.readLine();
		int accountNum2 = Integer.parseInt(inLine4);
		String inLine5 = read.readLine();
		double depositMoney = Double.parseDouble(inLine5);
		BankAccount temp2 = accounts.get(get_Arraynumber(accountNum2));
		temp2.deposit(depositMoney);
		String outLine= String.valueOf(temp2.getAccountNumber());
		String outLine2 = String.valueOf(temp2.getBalance());
		write.println(outLine);
		write.flush();
		write.println(outLine2);
		write.flush();
		System.out.println("The balance of account number " + temp2.getAccountNumber() + " read: " +temp2.getBalance());
		break;

		case '4':
		String inLine6 = read.readLine();
		int accountNum3 = Integer.parseInt(inLine6);
		String inLine7 = read.readLine();
		double withdrawMoney = Double.parseDouble(inLine7);
		BankAccount temp3 = accounts.get(get_Arraynumber(accountNum3));
		temp3.withdraw(withdrawMoney);
		String outLine3= String.valueOf(temp3.getAccountNumber());
		String outLine4 = String.valueOf(temp3.getBalance());
		write.println(outLine3);
		write.flush();
		write.println(outLine4);
		write.flush();
		System.out.println("The balance of account number " + temp3.getAccountNumber() + " read: " +temp3.getBalance());
		break;

		case '5':
		String inLine8 = read.readLine();
		int accountNum4 = Integer.parseInt(inLine8);
		String inLine9 = read.readLine();
		int accountNum5 = Integer.parseInt(inLine9);
		String inLine10 = read.readLine();
		double transferMoney = Double.parseDouble(inLine10);
		BankAccount temp4 = accounts.get(get_Arraynumber(accountNum4));
		BankAccount temp5 = accounts.get(get_Arraynumber(accountNum5));
		temp4.withdraw(transferMoney);
		temp5.deposit(transferMoney);
		String outLine5 = String.valueOf(temp4.getBalance());
		String outLine6 = String.valueOf(temp5.getBalance());
		write.println(outLine5);
		write.flush();
		write.println(outLine6);
		write.flush();
		System.out.printf("The money has been transfered succesfully"+ "\n"+"Balance of Account "
		+ temp4.getAccountNumber()+" read: "+temp4.getBalance() + "\n"+ "Balance of Account "+temp5.getAccountNumber()+" read: "+temp5.getBalance());
		break;

		case '6':
		int kmp = accounts.size();
		String acc_size = String.valueOf(kmp);
		write.println(acc_size);
		write.flush();
		String n = read.readLine();
		int acc_num = Integer.parseInt(n);
		for(int i=0; i < accounts.size();i++)
			{
				BankAccount e = accounts.get(i);
				if( acc_num == e.getAccountNumber()){			
				System.out.println("Account number "+ e.getAccountNumber()+", balance: "+e.getBalance());
				String outLine7 = String.valueOf(e.getAccountNumber());
				String outLine8 = String.valueOf(e.getBalance());
				write.println(outLine7);
				write.flush();
				write.println(outLine8);
				write.flush();
			}}
		break;

		case '7':
		int pmk = accounts.size();
		String outLine9 = String.valueOf(pmk);
		write.println(outLine9);
		write.flush();
		for(int i=0; i < accounts.size();i++)
			{
				BankAccount e = accounts.get(i);
				System.out.println("Account number "+ e.getAccountNumber()+", balance: "+e.getBalance());
				String outLine7 = String.valueOf(e.getAccountNumber());
				String outLine8 = String.valueOf(e.getBalance());
				write.println(outLine7);
				write.flush();
				write.println(outLine8);
				write.flush();
			}
		break;
		
		}
		}
	} while (!finished);
    }
    catch (IOException e) {
		System.out.println(e);
	}
     
    
    finally{    
    try{
        System.out.println("Connection Closing..");
        if (read!=null){
            read.close(); 
            System.out.println(" Socket Input Stream Closed");
        }

        if(write!=null){
            write.close();
            System.out.println("Socket Out Closed");
        }
        if (client!=null){
        client.close();
        System.out.println("Socket Closed");
        }
        
        }
    catch(IOException ie){
        System.out.println("Socket Close Error");
    }
    }//end finally
    }
    public static int get_Arraynumber(int acc_num)
    {	
    	int Array_number=0;
    	accountnumber=accounts.size();
    	for (int i = 0; i < accountnumber;i++)
    	{	BankAccount temp1 = accounts.get(i);
    		if( acc_num == temp1.getAccountNumber())
    		{
    			Array_number = i;
    			break;
    		}
    	}
    	return Array_number;
    }
    
    private boolean accountduplication(int accountnumber) //ham xet account trung lap
	{
		int i=0;
		if (accounts.size()==0)
		{
			return false;
		}
		else //accounts.size khac 0
		{
			for (i = 0; i < (accounts.size()); i++)
			{
				if(accounts.get(i).getAccountNumber() ==  accountnumber)
				{
					i=-1;//neu acc khong co san trong array acc, 
					break;//thi ket thuc vong lap i>0>-1
				}			//vi if nay se ko bao gio xay ra
			}
			if (i==-1)
			{
				return true;//acc da co trong array acc
			}
			else
			{
				return false;//acc chua co trong array acc
			}
		}
	}
}

