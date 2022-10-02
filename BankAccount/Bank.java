/**
 * This class creates an array accounts of BankAccount object references
 * @author Saoirse Siobhan Ebert
 *
 */
public class Bank {
	
	private int n; //number accounts
	private BankAccount [] accounts;
	
	/**
	 * This class creates an array of possible bank accounts and initializes the count of the accounts n to zero
	 */
	public Bank()
	{
		accounts = new BankAccount[100000];                                                                
		n = 0;
		//acctNums
	}
	
	/**
	 * addAccount method adds each new BankAccount object and uses accumulator to create new accounts 
	 * @param acctNum the account number
	 * @param acctName the account name (last name,first name)
	 */
	public void addAccount(String acctNum, String acctName)
	{ 
			accounts[n] = new BankAccount(acctNum,acctName);
			n++;
	}
	
	public void addCheckingAccount(String acctNum, String acctName)
	{
			accounts[n] = new CheckingAccount(acctNum,acctName);
			n++;
	}
	
	/**
	 * findAccount method searches the accounts object array for the account associated with the account number, 
	 * @param acctNum the account number
	 * @return the BankAccount object, or else if there was no account associated with the account number, null
	 */
	public BankAccount findAccount(String acctNum)
	{
		for (int index=0; index<n; index++) 
			if (accounts[index].getAcctNum().equals(acctNum))
				return accounts[index];
		return null;

	}
	
	public void delete (int deletePos)
	{
				accounts[deletePos]=accounts[n-1];
				n--;
	}
	
	/**
	 * getAccount method gets the BankAcount object stored in the accounts array
	 * @param i the index of the accounts array
	 * @return the account object 
	 */
	public BankAccount getAccount(int i)
	{
		return accounts[i];
	}
	
	/**
	 * getNumAccounts method
	 * @return the number of accounts n
	 */
	public int getNumAccounts()
	{
		return n;
	}

	/** sortAccounts method 
	 *  sorts the accounts array objects by last name
	 */
	
	public void sortAccounts()
	{
		for (int index = 0; index < (n); index++) 
		{
			int minPos = findMin(index);
			swap(accounts, index, minPos);
		}
	}
	/**
	 * swap method allows sortAccount method to swap the accounts by index
	 * @param accounts the array of account objects
	 * @param i1 the first index of the accounts array tested
	 * @param i2 the second index
	 */
	private static void swap(BankAccount[]accounts, int i1, int i2)
	{
		BankAccount temp = accounts[i1];
		accounts[i1] = accounts[i2];
		accounts[i2] = temp;
	}
	
	/**
	 * findMin method allows sortAccounts method to find the index of the lesser valued array object
	 * @param start the starting index value of lesser value
	 * @return the new index in the object array of lesser value
	 */
	private int findMin(int start)
	{
		int minPos = start;
		for (int i = start+1; i<n; i++) {
			if (accounts[i].getName().compareTo(accounts[minPos].getName()) < 0)
				minPos = i;
		}
		return minPos;
	}

	public int findIndex(String acctNum)
	{
			for (int index=0; index<n; index++) {
				if (accounts[index].getAcctNum().equals(acctNum))
					return index;
	}
			return -1;
	}
}
