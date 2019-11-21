import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.ArrayList;
public class BankAccountSimulator {	
	public static ArrayList<BankAccount> acc = new ArrayList<BankAccount>();
	public static void main(String[] args)
	{ 
		boolean esc = false;//vong lap chinh cua chuong trinh	
		JTextField menu = new JTextField();
		Object[] mainmenu = {"Choose one of following options:\n\n"
						+"1: Add an new account\n"
						+"2: Delete an account\n"
						+"3: Deposit to or withdraw from an account\n"
						+"4: Transfer money from one account to another\n" 
						+"5: Account infomation\n\n\n"
						+"_There is no account number \"#0\" cause \"0\" is reserved only for exit code.\n"
						+"_However, the amount of money or balance can still be \"$0\",\n"
						+" but you must type \"0\" instead of leaving it with $ empty value.\n"
						+"_Everytime need to exit, please type \"0\" at suitable places or press \"Esc\" !\n\n\n"
						+"You choose: \n",menu,
		};
		while(!esc)
		{
			int choice = JOptionPane.showConfirmDialog(null, mainmenu, "Welcome !!!", JOptionPane.OK_CANCEL_OPTION);
			if (choice == JOptionPane.OK_OPTION)
			{
				int option=  Integer.parseInt(menu.getText());
				if (option == 1)
					{
						new_acc();
					}
				else if(option == 2)
					{
						del_acc();
					}
				else if(option == 3)
					{
						dpswth();
					}
				else if(option == 4)
					{
						transfer();
					}
				else if(option == 5)
					{
						info();
					}
				else if(option ==0)
					{
						esc=true;//thoat chuong trinh hoan toan
					}
				else
					{
						JOptionPane.showMessageDialog(null,"This option isn't exist. Please choose again!\n");
					}
			}
			else
			{
				esc=true;//thoat khi nhan escape hay cancel
			}
		}
		JOptionPane.showMessageDialog(null,"Thank you! See you again!");
		System.exit(0);
	}
	
	private static void new_acc()
	{
		boolean esc2=false;//thoat current task tro ve main menu
		JTextField field1 = new JTextField();
		JTextField field2 = new JTextField();
		
		Object[] message = {
		    "New account number (0 means exit):", 	field1,
		    "Initial balance of the new account:", 	field2,
		};		
		while(!esc2) //vong lap de nhap account moi nhieu lan
		{
			int acc_num = 0;		
			double inibalance = 0;	
			int input = JOptionPane.showConfirmDialog(null, message, "Create a new account", JOptionPane.OK_CANCEL_OPTION);
			if (input == JOptionPane.OK_OPTION)
			{
			    acc_num = Integer.parseInt(field1.getText());
			    inibalance = Double.parseDouble(field2.getText());
			}
			else //khi nhan esc hay ko dong y
			{
				esc2=true;
			}
			if (acc_num==0)//exit code detected, quay ve main menu khi nhap 0 va khi press esc, thuc chat la ko nhap gi
			{	
				esc2=true;
			}
			else if (!accountduplication(acc_num))//check acc number co roi hay chua
			{
				acc.add(new BankAccount(acc_num, inibalance));
				JOptionPane.showMessageDialog(null,"Account number #"+ acc_num +" with initial balance of $"+inibalance
													+ " is successfully added into the database!");
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"This account number already exists. Please enter a new one!\n");
			}
		}
	}
		
	private static void del_acc()
	{
		boolean esc2=false;//thoat current task tro ve main menu
		JTextField del_field = new JTextField();
		Object[] del = {"Account number to be deleted (0 means exit): ", del_field,};
		while(!esc2) //vong lap de xoa account cu nhieu lan
		{
			int acc_num = 0;
			int input = JOptionPane.showConfirmDialog(null, del, "Delete an account", JOptionPane.OK_CANCEL_OPTION);
			if (input == JOptionPane.OK_OPTION)
			{
				acc_num = Integer.parseInt(del_field.getText());
			}
			else// khi nhan esc hay ko dong y
			{
				esc2=true;
			}
			if (acc_num==0)//exit code detected, quay ve main menu hoac khi ko co gia tri do khoi tao bien acc_num da la 0
			{	
				esc2=true;
			}
			else if (!accountduplication(acc_num))//check acc co trong array hay ko
			{
				JOptionPane.showMessageDialog(null,"There is no account with number #"+ acc_num
													+" in the database to be deleted !!!");
			}
			else // khi biet acc co ton tai thi moi xoa
			{
				int i=0;
				for (i = 0; i < (acc.size()); i++)
				{
					if(acc.get(i).getAccountNumber() ==  acc_num)
					{
						if (acc.get(i).getBalance()>0)//hoi lai neu con tien trong tai khoan trc khi xoa
						{
							Object[] withdrawall= {"There is still $"+acc.get(i).getBalance()+" in this account! Would you like "
													+ "to withdraw before deletion?",};
							int ask = JOptionPane.showConfirmDialog(null, withdrawall, "Get back money from the account", JOptionPane.OK_CANCEL_OPTION);
							if (ask==JOptionPane.OK_OPTION)
							{
								JOptionPane.showMessageDialog(null,"OK! Here are all money $"+acc.get(i).getBalance()
																	+".\n Account #"+acc_num+" is now empty!");
								acc.get(i).withdraw(acc.get(i).getBalance());//tru het tien rut vao tai khoan
							}
						}
						acc.remove(i);//xoa acc du co rut hay da rut het tien
						JOptionPane.showMessageDialog(null,"Account number #"+ acc_num+" is successfully removed"
															+ " from the database!");
						break;
					}
				}
			}
		}
	}

	private static void dpswth()
	{
		boolean esc2=false;//thoat current task tro ve main menu
		JTextField num = new JTextField();
		JTextField ss = new JTextField();
		Object[] depowith = {"Account number concerned (0 means exit):", num,
							 "With amount of money to proceed: ",ss,
							 };
		while(!esc2) //vong lap de lap lai task nhieu lan
		{
			int acc_num=0;
			double money=0;
			int option2=0;
			int input = JOptionPane.showConfirmDialog(null, depowith, "Deposit to or withdraw from an account", JOptionPane.OK_CANCEL_OPTION);
			if (input == JOptionPane.OK_OPTION)
			{
				acc_num = Integer.parseInt(num.getText());
				money = Double.parseDouble(ss.getText());
			}
			else //khi nhan esc hoac ko dong y
			{
				esc2=true;
			}
			if (acc_num==0)//exit code detected, quay ve main menu
			{	
				esc2=true;
			}
			else if (!accountduplication(acc_num))//check acc co trong array hay ko
			{
				JOptionPane.showMessageDialog(null,"There isn't no account with number "+acc_num
													+" in the database to perform this task !!!");
			}
			else//acc nay ton tai
			{
				boolean cont=true;//kiem tra lua chon dung hay sai cho vong lap chon deposit or withdraw
				JTextField choice2 = new JTextField();				
				Object[] mess = {"1: Deposit $"+ money +" to account number #" + acc_num +"\n"
								+"2: Withdraw $"+ money +" from account number #" + acc_num +"\n\n"
								+"Type \"0\" or press \"Esc\" to cancel this task and back to main menu\n"
								+"You choose: \n", choice2,};		
				while(cont)//lua chon deposit hay withdraw
				{
					int input2 = JOptionPane.showConfirmDialog(null, mess, "Now deposit or withdraw ?", JOptionPane.OK_CANCEL_OPTION);
					if (input2 == JOptionPane.OK_OPTION)
					{
						option2 = Integer.parseInt(choice2.getText());
						if ((option2==1)||(option2==2)||(option2==0))
						{
							cont=false;
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Choose again deposit 1 or withdraw 2 please!");
							cont=true;
						}
					}
					else//khi nhan esc hoac ko dong y tiep tuc
					{
						cont=false;
						break;
					}
				}
				if (option2==0)//exit code detected back to menu
				{
					break;//break while va quay ve main menu ngay lap tuc
				}
				else if (!((option2==2)&&(!validwithdraw(money, acc_num))))
				{//neu khong phai rut tien qua so luong trong tai khoan
					int i=0;
					for (i = 0; i < (acc.size()); i++)
					{
						if(acc.get(i).getAccountNumber() ==  acc_num)
						{
							if (option2==1) //deposit
							{
								acc.get(i).deposit(money);
								JOptionPane.showMessageDialog(null,"$"+money+" has just been deposited to "
																		+ "account number #"+ acc_num);
								break;
							}
							else//withdraw
							{
								acc.get(i).withdraw(money);
								JOptionPane.showMessageDialog(null,"$"+money+" has just been withdrawn "
																	+ "from account number #"+ acc_num);
								break;
							}	
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"User can not withdraw money exceeding the balance !!!");
				}
			}
		}
	}
	
	private static void transfer()
	{	
		boolean esc2=false;//thoat current task tro ve main menu
		JTextField send = new JTextField();
		JTextField receive = new JTextField();
		JTextField ss = new JTextField();
		Object[] mess = {"Sender's account number (0 means exit):", send,
						 "Receiver's Account number (0 means exit):", receive,
						 "Amount of money to be transfered:", ss,};

		while(!esc2) //vong lap de lap lai task nhieu lan
		{
			int input = JOptionPane.showConfirmDialog(null, mess, "Transfer money from one to another", JOptionPane.OK_CANCEL_OPTION);
			int acc_num1 = 0;
			int acc_num2 = 0;	
			double money = 0;
			if (input == JOptionPane.OK_OPTION)
			{
				acc_num1 = Integer.parseInt(send.getText());
				acc_num2 = Integer.parseInt(receive.getText());	
				money = Double.parseDouble(ss.getText());
			}
			else//thoat khi nhan esc hay ko dong y
			{
				esc2=true;
			}

			if ((acc_num1==0)||(acc_num2==0))//exit code detected, quay ve main menu
			{	
				esc2=true;
			}
			else if (!accountduplication(acc_num1))//kiem tra ton tai acc_num 1 trong array chua
			{
				JOptionPane.showMessageDialog(null,"There isn't no account with number #"
													+acc_num1+" in the database to send money!!!");
			}
			else//accnum1 ton tai thi tiep tuc
			{
				if (!accountduplication(acc_num2))//kiem tra ton tai acc_num 2 trong array chua
				{
					JOptionPane.showMessageDialog(null,"There isn't no account with number #"
														+acc_num2+" in the database to receive money!!!");
				}
				else //accnum2 + accnum1 ton tai thi tiep tuc
				{
					if ((acc_num1==acc_num2)||(money==0))//neu sender va receiver cung la 1 acc hoac so tien la 0
					{
						JOptionPane.showMessageDialog(null,"There's no need to do anything !!!");
					}
					else if (validwithdraw(money, acc_num1))
					{//kiem tra tien chuyen ra khoi accnum1 co lon hon so tien accnum1 co hay ko
						int i=0;
						int k=-1;//ho tro kiem tra dieu kien if co dc thuc hien hay ko
						int j=-1;//dung 2 bien k,j de giam thieu so lan chay cua for
						for (i = 0; i < (acc.size()); i++)
						{
							if ((j>0)&&(k>0))//break khi da lam xong, tranh ton thoi gian nen dung them 2 bien k,j
							{//khi chuyen tien xong thi k va j se lon hon 0 vi lay gia tri cua i luc chay
								break;
							}
							else 
							{	if(acc.get(i).getAccountNumber() ==  acc_num1)
								{
									acc.get(i).withdraw(money);
									k=i;
								}
								else if(acc.get(i).getAccountNumber() ==  acc_num2)
								{
									acc.get(i).deposit(money);
									j=i;
								}
							}
						}
						JOptionPane.showMessageDialog(null,"Account number #"+ acc_num1 
								+ " successfully sent $" + money + " to account number #"+ acc_num2);
					}
					else//neu chuyen tien vuot qua so tien co trong tai khoan cua sender
					{
						JOptionPane.showMessageDialog(null,"Money to be transferred can not exceed sender's balance !!!");
					}
				}
			}
		}
	}

	private static void	info()//ham thong tin
	{
		if (acc.size()!=0)
		{
			int i = 0;
			String Inf = "Order | Account no.          | Balance\n";
			for (i = 0; i<(acc.size()) ;i++)
			{
				Inf += (i+1) + "                # " + acc.get(i).getAccountNumber()
						+ "                    $" + acc.get(i).getBalance()+"\n";			
			}
			JOptionPane.showMessageDialog(null,Inf);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"There is completely nothing in database !!!");
		}
	}

	private static boolean accountduplication(int accountnumber) //ham xet account trung lap
	{
		int i=0;
		if (acc.size()==0)
		{
			return false;
		}
		else //acc.size khac 0
		{
			for (i = 0; i < (acc.size()); i++)
			{
				if(acc.get(i).getAccountNumber() ==  accountnumber)
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
	
	private static boolean validwithdraw(double moneyy, int accountnumber)//ham kiem tra so tien rut ra va so tien trong tai khoan
	{
		int i=0;
		for (i = 0; i < (acc.size()); i++)
		{
			if(acc.get(i).getAccountNumber() ==  accountnumber)
			{
				if (acc.get(i).getBalance()>=moneyy)
				{
					i=-1;//neu tien duoc rut ra
				} // lon hon tien co san trong tai khoan
				break;//thi ket thuc vong lap i>0>-1
			}			//vi if nay se ko bao gio xay ra
		}		
		if (i==-1)
		{
			return true;//tien rut ra it hon tien co san
		}
		else
		{
			return false;//tien rut ra lon hon
		}
	}
}
