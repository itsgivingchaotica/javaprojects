public class CompanyAccount {
	protected String acctNum;
	protected String acctName;
	private double balance;
	
	public CompanyAccount(String acctNum, String acctName, double balance)
	{
		this.acctNum = acctNum;
		this.acctName = acctName;
		this.balance = balance;
	}
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
	
	public void payment(double pay)
	{
		this.balance = balance - pay;
		System.out.printf("Deposit successful! Your balance is: $%-,10.2f",balance);
		System.out.println();
		
	}
	
	public void order (double order)
	{
		
			this.balance = balance + order;
			System.out.printf("Withdrawal successful! Your balance is $%-,10.2f",balance);
			System.out.println();
	}
	
	public void earlyPayment (double pay, double percentOff) 
	{
		this.balance = balance - pay - (pay*(percentOff/100));
	}
	
	public void bulkOrder (double order, double percentOff)
	{
		this.balance = balance - (order*(percentOff/100));
	}
	
	
	
}
