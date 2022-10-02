import java.util.Random;
import java.util.Scanner;

/**
 * This program creates a Bank object then loops and prompts for new accounts, transactions, account inquiries, 
 * then sorts and prints the accounts added when all transactions are complete.
 * @author Saoirse Siobhan Ebert
 */

class BankAccountProject {

	/*
	 * The main program should create a Bank object mybank then loop and prompt for transactions, including *new accounts*. 
	 * The output can be printed to the console. 
	 * You don’t need file output. 
	 * When the transactions are done, sort the accounts and print them all (by a method in the mybank object.
	 */
	public static void main(String[] args) {
			String acctNum;
			String acctName;
			Bank mybank = new Bank();
			
			Scanner keyboard = new Scanner(System.in);
			
			//menu
			System.out.println("Welcome to Big Bucks Bank. Please make a selection from the menu: ");
			System.out.println("1 to add a new Savings account");
			System.out.println("2 to add a new Checking account");
			System.out.println("3 to make a deposit");
			System.out.println("4 to make a withdrawal");
			System.out.println("5 to make an account inquiry");
			System.out.println("6 to delete an account");
			int choice = keyboard.nextInt();
			
			while (choice != -1)
			{
				switch (choice)
				{
				//add new savings account
				case 1:
					Random randAccountNum = new Random();
					int upperbound = 100000;
					int newAccount = randAccountNum.nextInt(upperbound);
					acctNum = String.valueOf(newAccount);
					System.out.println("Please enter your Name (last,first) : ");
					acctName = keyboard.next();
					mybank.addAccount(acctNum,acctName);
					String firstName = acctName.substring(acctName.indexOf(",")+1);
					firstName.trim();
					System.out.println("Welcome to Big Bucks Bank, " + firstName + ". Your savings account number is: " + acctNum);
					break;
				//add new checking account
				case 2:
					Random randCheckingAccountNum = new Random();
					int checkingUpperbound = 100000;
					int newCheckingAccount = randCheckingAccountNum.nextInt(checkingUpperbound);
					acctNum = String.valueOf(newCheckingAccount);
					System.out.println("Please enter your Name (last,first) : ");
					acctName = keyboard.next();
					mybank.addCheckingAccount(acctNum,acctName);
					String firstCheckingName = acctName.substring(acctName.indexOf(",")+1);
					firstCheckingName.trim();
					System.out.println("Welcome to Big Bucks Bank, " + firstCheckingName + ". Your checking account number is: " + acctNum);
					break;
				
				//deposit
				case 3:
					System.out.println("To make a deposit, enter the account number: ");
					String inputAccountDeposit = keyboard.next();
					BankAccount currAccountDeposit;
					currAccountDeposit = mybank.findAccount(inputAccountDeposit);
					if (currAccountDeposit == null)
					{
						System.out.println("Account not found.");
					}
					else 
					{
						System.out.println("Make your deposit: ");
						double depositMoney = keyboard.nextDouble();
						currAccountDeposit.deposit(depositMoney);
					}
					break;
					
				//withdrawal	
				case 4:
					System.out.println("To make a withdrawal, enter the account number: ");
					String inputAccountWithdrawal = keyboard.next();
					BankAccount currAccountWithdraw;
					currAccountWithdraw = mybank.findAccount(inputAccountWithdrawal);
					if (currAccountWithdraw == null)
					{
						System.out.println("Account not found.");
					}
					else
					{
						System.out.println("Make your withdrawal: ");
						double withdrawMoney = keyboard.nextDouble();
						currAccountWithdraw.withdrawal(withdrawMoney);
						//System.out.println("Your balance is " + currAccountWithdraw.getBalance());
					}
					break;
					
				//account inquiry	
				case 5:
					System.out.println("To make an account inquiry, please enter the account number: ");
					String inputAccountInquiry = keyboard.next();
					BankAccount currAccountInquiry;
					currAccountInquiry = mybank.findAccount(inputAccountInquiry);
					if (currAccountInquiry == null)
					{
						System.out.println("Account not found.");
					}
					else
					{
					currAccountInquiry.inquiry(inputAccountInquiry);
					}
					break;
				
				//delete an account
				case 6:
					System.out.println("To delete an account, please enter the account number: ");
					String deleteAccount = keyboard.next();
					BankAccount currDeleteAccount;
					//searches for user input among account numbers in the Bank and returns the Bank Account object for the specified account number
					currDeleteAccount = mybank.findAccount(deleteAccount);
					if (currDeleteAccount == null)
					{
						System.out.println("Account not found.");
					} 
					else 
					{
					//finds the index value of the account to delete from the bank
					int i = mybank.findIndex(deleteAccount);
					//delete based on that index value in Bank class method
					mybank.delete(i);
					System.out.println("Bank account #" + deleteAccount + " was closed");
					}
					break;
					
				}
				System.out.println("Make your next selection (-1 to quit): ");
				choice = keyboard.nextInt();
			}
			keyboard.close();
			
			//sort the accounts 
			mybank.sortAccounts();
			int n = mybank.getNumAccounts();
			
			//print the sorted accounts
			for (int i = 0; i<n; i++)
			{
				BankAccount currentAccount = mybank.getAccount(i);
				System.out.println(currentAccount);
			}	
	}
}
