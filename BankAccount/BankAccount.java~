/**
 * This class creates new Bank Account objects which are a part of Big Bucks Bank and allows transactions to occur through varying methods
 * @author Saoirse Siobhan Ebert
 *
 */
public class BankAccount
{
	
	protected String acctNum;
	protected String acctName;
	private double balance;
	
	/**
	 * This constructor initializes the Bank Accounts in Big Bucks Bank
	 * It sets the balance to 0 to start for each new account
	 * @param acctNum The account number, a random number as defined in the main program
	 * @param acctName The account name as (last name,first name)
	 */
	
	public BankAccount(String acctNum, String acctName)
	{
		balance=0;
		this.acctNum = acctNum;
		this.acctName = acctName;
	}
	
	/** 
	 * getAcctNum accessor method
	 * @return account Number
	 */
	
	public String getAcctNum()
	{
		return acctNum;
	}
	
	/**
	 * getName accessor method
	 * @return the account name (last name,first name)
	 */
	
	public String getName()
	{
		return acctName;
	}
	
	/**
	 * getBalance accessor method
	 * @return balance, the balance in that account
	 */
	
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * deposit method
	 * @param depositMoney the money deposited into the account
	 */
	
	public void deposit(double depositMoney)
	{
		this.balance = balance + depositMoney;
		System.out.printf("Deposit successful! Your balance is: $%-,10.2f",balance);
		System.out.println();
		
	}
	
	/**
	 * withdrawal method allows withdrawals to occur unless the requested withdrawn amount is less than the current balance, 
	 * in which case the user is warned of insufficient funds 
	 * @param withdrawMoney the money to be withdrawn from the account
	 */
	
	public void withdrawal(double withdrawMoney)
	{
		if (balance - withdrawMoney < 0) 
		{
			System.out.printf("Insufficient funds. You have a balance of: $%-,10.2f",balance);
			System.out.println();
		}
		else 
		{
			this.balance = balance - withdrawMoney;
			System.out.printf("Withdrawal successful! Your balance is $%-,10.2f",balance);
			System.out.println();
		}
	}
	
	/**
	 * inquiry method prints the balance of the account
	 * @param acctNum the account number
	 */
	
	public void inquiry(String acctNum)
	{
		System.out.printf("Your account balance is: $%-,10.2f",balance);
		System.out.println();
	}
	
	/**
	 * toString method prints the savings account information for the account
	 */
	public String toString()
	{
		String str = "Savings Account: " + getName() + " Account Number: " + getAcctNum() + " $" + getBalance();
		return str;
	}
}
