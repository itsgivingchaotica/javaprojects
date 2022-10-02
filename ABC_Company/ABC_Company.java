import java.io.*;
import java.util.*;

/** 
 * 
 * @author Saoirse Siobhan Ebert
 */
class ABC_Company{
	
	public static void main(String[] args) throws IOException {
		//Three ArrayLists: one for read accounts from the input accounts file, one for transactions, and one for exporting processed accounts
		ArrayList<String> masterImport = new ArrayList<String>();
		ArrayList<String> transactionFile = new ArrayList<String>();
		ArrayList<String> masterExport = new ArrayList<String>();
		String importFile = "/Users/siobhan/javaprojects/ABC_Company/ABC_CompanyAccounts.txt";
		removeDuplicates(importFile);
		//store accounts as ArrayList masterImport
		masterImport = readAccounts(importFile);
		//ArrayList to keep the original accounts to print for prior balances. Storing the masterImport here.
		ArrayList<String>masterFile = new ArrayList<>(masterImport);
		//read in the transactions
		transactionFile = readTransactions();
		//process the transactions and use the masterExport ArrayList to rewrite fields with updated account information
		masterExport = processTransactions(importFile,transactionFile,masterFile);
		//print the invoices using the transactions, the unedited original duplicate-free accounts masterFile 
		//and the updated accounts information of the masterExport
		printInvoices(transactionFile,masterFile,masterExport);
		
	}
	
	/**
	 * removeDuplicates method rewrite the input file, deleting lines that are repeated 
	 * @param filename the ABC Accounts file
	 * @throws IOException 
	 */
	public static void removeDuplicates(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		Set<String> hs = new LinkedHashSet<String>();
		String input;
		while((input=br.readLine())!=null)
		{
			hs.add(input);
		}
		br.close();
		//rewrite the file
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		for (String lines : hs) {
			writer.write(lines);
			writer.newLine();
		}
		writer.close();
	}
	/**
	 * readAccounts method stores the data from duplicate-free accounts file and stores in ArrayList
	 * @param filename the accounts file
	 * @return accountsList, an ArrayList of accounts
	 * @throws IOException
	 */
	public static ArrayList<String> readAccounts(String filename) throws IOException {
		ArrayList<String> accountList = new ArrayList<String>();
		try {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String input;
		while((input=br.readLine())!= null) {
			accountList.add(input);
		}
		br.close();
		
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		return accountList;
	}
	
	/**
	 * readTransactions method stores all the transactions lines into an ArrayList
	 * @return transactionList, the list of transactions
	 * @throws IOException
	 */
	public static ArrayList<String> readTransactions() throws IOException {
		ArrayList<String> transactionList = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("/Users/siobhan/eclipse-workspace/HW1Lowenthal/src/hw1_lowenthal/ABC_CompanyTransactions.txt"));
		String input;
		while((input=br.readLine())!= null) {
			transactionList.add(input);
		}
		br.close();
		return transactionList;
	}
	
/**
 * processTransactions method calculates all transactions, preparing for storage in the masterExport ArrayList
 * @param importFile the original accounts file
 * @param transactionFile 
 * @param masterFile allows to check the accounts file
 * @return masterExport, the updated A/C accounts as an ArrayList
 * @throws IOException
 */
	public static ArrayList<String> processTransactions(String importFile,ArrayList<String>transactionFile, ArrayList<String>masterFile) throws IOException{
		
		//Two arrays needed - one to store the elements of each transaction file line transactionField[] 
		//and one to allow the elements to be updated adjAccountField[]
		String[] transactionFields = new String[transactionFile.size()];
		String[] adjAccountFields = new String[masterFile.size()];
		//We need to split the elements of the ArrayList lines by spaces taking into account they aren't uniform
		String regex = "(\\s)+"; 
		//use the masterExport ArrayList to store unedited account data. It will be rewritten using the adjAccountField[] arrays
		ArrayList<String> masterExport = readAccounts(importFile);
		
		//for loop reads all elements of each line of the transactionField ArrayList 
		for (int i = 0; i <transactionFile.size(); i++)
		{
			//split the transactionFile into elements, each of which is placed into the transactionFields[] 
			transactionFields = transactionFile.get(i).split(regex); 
			//For payment - process transactions for each line which is associated with the account number 
			//transaction field starts with P or O determine Payment or Order
			if (transactionFields[0].startsWith("P"))
			{
				//find the index of the accountFile with the matching account number
				int j = findAccountIndex(transactionFields[1],masterFile);
				
				//split the line determined by index of transactionFile - including balances - into elements of adjAccountFields[]
				adjAccountFields = masterExport.get(j).split(regex); 
				
				// update the balance
				double discount = (Double.parseDouble(transactionFields[2])*Float.parseFloat(transactionFields[3])/100);
				double payment = Double.parseDouble(transactionFields[2]);
				double balance = Double.parseDouble(adjAccountFields[2]); 
				balance = balance - payment;
				balance = balance - discount;
				//the new balance is stored in the new accounts field by first storing array
				adjAccountFields[2] = Double.toString(balance);
				//export the line to the export account file
				String adjLine = String.join(" ", adjAccountFields);
				masterExport.set(j, adjLine);
			//same process for order 
			} if (transactionFields[0].startsWith("O")) {
				int k = findAccountIndex(transactionFields[1],masterFile);
				adjAccountFields = masterExport.get(k).split("\\s+");
				double discount = (Integer.parseInt(transactionFields[3]) * Double.parseDouble(transactionFields[4]) * (Float.parseFloat(transactionFields[5])/100));		
				double purchase = (Integer.parseInt(transactionFields[3]) * Double.parseDouble(transactionFields[4]) - discount);
				double balance = Double.parseDouble(adjAccountFields[2]);
				//update balance
				balance+=purchase;
				adjAccountFields[2] = Double.toString(balance);
				String adjLine = String.join(" ", adjAccountFields);
				masterExport.set(k, adjLine);
			}
		}
		return masterExport;
	}
	
	/**
	 * 
	 * @param acctNum the account nubmer
	 * @param file the account file from masterFile
	 * @return the index of the account matching the account number - if not found, return 0
	 */
	public static int findAccountIndex(String acctNum, ArrayList<String> file) {
		int index = 0;
		String regex = "(\\s)+"; 
		String[] accountField = new String[file.size()];
		for (int i = 0; i < file.size(); i++)
		{
			accountField = file.get(i).split(regex);
			if (acctNum.equals(accountField[0]))
			{
				index = i;
				return index;
			}
		}
		return 0;
	}
	
	/**
	 * 
	 * @param acctNum the account number 
	 * @param transactionFile the transaction File
	 * @return the index associated with the account number in the transaction file
	 */
	public static int findTransIndex(String acctNum, ArrayList<String> transactionFile) { 
		int index = 0;
		String regex = "(\\s)+"; 
		//maximum amount of elements in transactionFile lines is six (for orders)
		String[] transactionFields = new String[6];
		for (int i = 0; i < transactionFile.size(); i++) 
		{
			transactionFields = transactionFile.get(i).split(regex);
			if (acctNum.equals(transactionFields[1]))
			{
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * printInvoices method prints all the transactiosn for each account and provides the beginning and ending balances
	 * @param transactionFile the transactionFile
	 * @param masterFile the accounts File before transactions processed; includes starting blanace
	 * @param masterExport the accoutns file after transactions processed; includes updated balanace
	 * @throws FileNotFoundException 
	 */
	public static void printInvoices(ArrayList<String> transactionFile, ArrayList<String> masterFile, ArrayList<String> masterExport) throws FileNotFoundException
	{
	
		File file = new File ("/Users/siobhan/eclipse-workspace/HW1Lowenthal/src/hw1_lowenthal/ABC_Invoices.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String priorBalanceLine = "";
			String previous = "Previous Balance: ";
			String update = "New Balance: ";
			String mark = "-------------------------------------------------------------------------------";
			String doubleMark = "===============================================================================";
			String regex = "(\\s)+"; 
			String[] transactionLines = new String[masterFile.size()];
			String[] useMasterField = new String[masterFile.size()];
			String[] useTransactionField = new String[transactionFile.size()];
			String[] invoiceFields = new String[masterExport.size()];
			//outer loop allows invoices to be printed for each account
			for (int i = 0; i<transactionLines.length; i++) //12
			{
				int line = 0;
				//use original masterFile to get elements of that master ArrayList which correspond to the information needed to print the invoices
				useMasterField = masterFile.get(i).split(regex);  
				String companyName = useMasterField[1].toString();
				companyName = companyName.replace("_", " ");
				String accountNumber = useMasterField[0];
				Double priorBalance = Double.parseDouble(useMasterField[2]); 
				priorBalanceLine = String.format("%-20s %5s %28s $%-20.2f \n",companyName,accountNumber,previous,priorBalance);
				//find transIndex - this allows to loop through each line of the transactions. Invoices are thus itemized by order/payment. Only final payment/order prices printed
				int transIndex = findTransIndex(useMasterField[0],transactionFile);
				
				//loop through each transaction for the account
				for (int j = transIndex; j < transactionFile.size(); j++) 
				{
					//split the transaction line into transaction fields
					useTransactionField = transactionFile.get(j).split(regex);
					//for payments
					if (useTransactionField[0].startsWith("P"))
					{
						if (useTransactionField[1].equals(useMasterField[0]))
						{
							String transactionNumber = useTransactionField[0].toString();
							String pay = "Payment";
							double discount = Double.parseDouble(useTransactionField[2])*(Double.parseDouble(useTransactionField[3])/100);
							double payment = Double.parseDouble(useTransactionField[2]) + discount;
							String transactionLine = String.format("Transaction # %-10s %-30s $%-1.2f",transactionNumber,pay,payment);
							transactionLines[line] = transactionLine;
							line++;
						}
					}
					//for orders
					if (useTransactionField[0].startsWith("O"))
					{
						if (useTransactionField[1].equals(useMasterField[0]))
						{
							String transactionNumber = useTransactionField[0].toString();
							String orderDescription = useTransactionField [2].toString();
							orderDescription = orderDescription.replace("_", " ");
							double discount = (Double.parseDouble(useTransactionField[3]) * Double.parseDouble(useTransactionField[4]) * (Double.parseDouble(useTransactionField[5])/100));		
							double purchase = (Integer.parseInt(useTransactionField[3]) * Double.parseDouble(useTransactionField[4]) - discount);
							String transactionLine = String.format("Transaction # %-10s %-30s $%-1.2f",transactionNumber,orderDescription,purchase);
							transactionLines[line] = transactionLine;
							line++; 
						}
					}
					//break loop if no more transactions corresponding to the account number
					else if (!useTransactionField[1].equals(useMasterField[0]))
						
					{	
						break;
					}  
				}	
				//initialize invoiceFields corresponding to each element of each masterExport account line
				invoiceFields = masterExport.get(i).split(regex); 
				//pull the new balance that was in masterExport from the corresponding element in the invoiceFields array
				double newBalance = Double.parseDouble(invoiceFields[2]);
				
				//start writing in voice, beginning with prior balance 
				bw.write(priorBalanceLine + "\n");
				bw.write(mark + "\n" );
				
				//using line counter, initialize numberLines needed for each invoice
				int numberLines = line;
				//write each final transaction line by looping through array
				for (int k = 0; k<numberLines; k++) 
				{
					bw.write(transactionLines[k] + "\n");
				}
				bw.write(doubleMark + "\n");
				//finally, write the final balance of the account
				bw.write(String.format("%55s $%-20.2f \n\n",update,newBalance));
				//repeat from beginning of the nested loop for each account until each account has an itemized invoice written to the output file through bw
			}
			bw.close();
			} 
			//in vase the file is not found, catch exception
			catch (Exception e) 
			{
			System.err.println("Error: " + e.getMessage());
		
		}
	}
}
