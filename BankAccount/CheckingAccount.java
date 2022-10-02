/**
 * this class allows the bankaccount array of objects to have checkingaccount information added 
 * @author siobhan
 *
 */
public class CheckingAccount extends BankAccount
{
	private double interestRate = .10;
	private double balance;
	
	/**
	 * the CheckingAccount constructors calls the superclass constructor from BankAccount using the acctNum and acctName methods
	 * @param acctNum the account number
	 * @param acctName the account name
	 */
	public CheckingAccount(String acctNum, String acctName)
	{
		super(acctNum, acctName);
		balance=0;
	}
	
	/**
	 * this getCheckingBalance accessor method returns the balance in the Checking Account
	 * @return
	 */
	public double getCheckingBalance()
	{
		return balance;
	}
	/**
	 * the deposit method overrides the BankAccount deposit method to add interest to balance each time a deposit is made
	 * shows message each time
	 */
	@Override
	public void deposit(double depositMoney)
	{
		this.balance+=depositMoney;
		this.balance+=balance * interestRate;
		System.out.printf("Deposit successful! Your balance is: $%-,10.2f",balance);
		System.out.println();
		
	}
	/**
	 * toString method overrides the superclasses toString method to print the checking balance instead of a savings balance
	 */
	@Override
	public String toString()
	{
		String str = "Checking Account: " + getName() + " Account Number: " + getAcctNum() + " $" + getCheckingBalance();
		return str;
	}
	
}
