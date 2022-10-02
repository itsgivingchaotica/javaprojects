import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * True Lumber Company purchases and sales 
 * prints order lines and ending stock 
 * @author Saoirse Siobhan Ebert
 *
 */
class TrueLumberLedger {

	public static void main(String[] args) throws IOException{	
		
		Scanner sc = new Scanner (new File("/Users/siobhan/eclipse-workspace/lowenthal_hw3/src/lowenthal_hw3/true_lumber_company.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/siobhan/eclipse-workspace/lowenthal_hw3/src/lowenthal_hw3/true_lumber_summary.txt"));
		sc.nextLine();
		sc.nextLine();
		
		String oak = "O";
		String cherryMaple = "C";
		int quantity; //# ordered from manufacturer
		String dollars; 
		//two separate inked lists for oak and cherry maple orders
		RLinkedList oakList = new RLinkedList();
		RLinkedList cherryMapleList = new RLinkedList();
		
		//begin output file
		bw.write("True Lumber Company Ledger \n");
		bw.write("_____________________________ \n");
		while (sc.hasNext())
		{
			String wood="";
			String type = sc.next();	
		
			switch(type) 
			{
			//R for receipt: manufacturer purchase
			case "R": 
			wood = sc.next();
			if (wood.equals(oak)) {
				quantity = sc.nextInt();
				dollars = sc.next();
				//static method to add the oak wood purchase receipt
				//prints message how many were ordered and the cost
				addReceipt(wood,quantity,dollars,oakList,bw);
				break;
			}
			if (wood.equals(cherryMaple))
			{
				quantity = sc.nextInt();
				dollars = sc.next();
				//static method to add the cherry maple wood purchase receipt
				//prints message how many were ordered and the cost
				addReceipt(wood,quantity,dollars,cherryMapleList,bw);
				break;
			}
			//sale to buyer
			case "S":
			wood = sc.next();
			if (wood.equals(oak)) 
			{
				int saleQuantity = sc.nextInt();
				//reconcile oak wood sales, no promotion
				makeSale(saleQuantity,oakList,bw,0);
				bw.newLine();
				bw.flush();
				break;	
			}
			else if (wood.equals(cherryMaple)) {
				int saleQuantity = sc.nextInt();
				//reconcile cherry maple wood sales, no promotion
				makeSale(saleQuantity,cherryMapleList,bw,0);
				bw.newLine();
				bw.flush();
				break;
			}
			//promotion card and corresponding sale
			case "P":
				String percent = sc.next();
				bw.write("Promotion: " + percent + " off \n");
				percent = percent.replace("%", "");
				double parse = Double.parseDouble(percent);
				double promotion = parse/100;
				sc.nextLine();
				sc.next();
				wood = sc.next();
				
				if (wood.equals(oak)) 
				{
					int saleQuantity = sc.nextInt();
					//reconcile oak wood sales, with promotion
					makeSale(saleQuantity,oakList,bw,promotion);
					bw.newLine();
					bw.flush();
					break;	
				}
				else if (wood.equals(cherryMaple)) {
					int saleQuantity = sc.nextInt();
					//reconcile cherry maple wood sales, with promotion
					makeSale(saleQuantity,cherryMapleList,bw,promotion);
					bw.newLine();
					bw.flush();
					break;
				}
			}
		}
		//start remaining inventory report
		bw.write("Remaining Inventory \n");
		bw.write("__________________________________");
		bw.newLine();
		//oak wood inventory
		bw.write("Oak wood: \n");
		oakList.printList(bw);
		bw.newLine();
		//cherry maple wood inventory
		bw.write("Cherry Maple wood: \n");
		cherryMapleList.printList(bw);
		bw.flush();
		bw.close();
	}
	
/**
 * addReceipt : adds the receipt class object to corresponding linked list 
 * @param code : O or C for the type of wood
 * @param q : the quantity of wood received
 * @param d : the purchase amount
 * @param list : a linked list of receipts
 * @param bw : buffered writer output
 * @throws IOException 
 */
public static void addReceipt(String code, int q, String d, RLinkedList list, BufferedWriter bw) throws IOException{
		
		String wood="";
		double price;
		double purchaseAmount=0;
		
		if (code.equals("O"))
		{
			wood = "Oak";
		}
		else if (code.equals("C"))
		{
			wood = "Cherry Maple";
		}
		//store the price as an integer, remove $ sign
		d = d.replace("$", "");
		price = Double.parseDouble(d);
		purchaseAmount = q*price;
		bw.write(String.format("%s wood received for $ %.2f\n",wood,purchaseAmount));
		bw.newLine();
		//create new receipt
		Receipt rec = new Receipt(q,price);
		//add to corresponding linked list
		list.add(rec);
		bw.flush();
	}

/**
 * makeSale : make wood sale according to FIFO policy
 * @param saleQuantity : the sale amount of wood to be fulfilled
 * @param list : the linked list of purchased wood 
 * @param bw : buffered writer output
 * @param promotion : the promotion card 
 * @throws IOException 
 */
public static void makeSale(int saleQuantity, RLinkedList list, BufferedWriter bw, double promotion) throws IOException{
	//create an array list to store the messages stating quantities of wood purchased and price
	ArrayList<String> orderLines = new ArrayList<String>();
	int totalSold = 0; //the total quantity of wood sold for the sale 
	int quantity = 0; //the quantity of each wood of differing prices originally purchased remaining 
	double price = 0; //the price the wood was originally purchased for
	double markedUp = 0; //the sales price of the wood
	double totalSale = 0; //the final sale amount of the order
	String soldOut = null; 
	
	//if the order cannot be processed at all, write a message
	if (list.isEmpty())
	{
		soldOut = saleQuantity + " pieces of Oak wood not available";
		return;
	}
	
	//sell by FIFO policy
	Receipt firstIn = list.remove();
	quantity = firstIn.getQuantity();
	price = firstIn.getPrice();
	markedUp = price+(price*0.4);
	
	while (saleQuantity>0) {
		
		double sale;
		int remaining; 
		
		
		if (saleQuantity > quantity) {
			saleQuantity -= quantity; //use the quantity of wood being 
			sale = quantity*markedUp;
			totalSale += sale;
			totalSold += quantity;
			orderLines.add(String.format("%d at $ %.2f  \t Sales: $ %.2f",quantity,markedUp,sale));
			//message to indicate the rest of the order cannot be filled 
			if (list.isEmpty())
			{
				soldOut = "Remainder of " + saleQuantity + " pieces of Oak wood not available";
				break;
			}
			firstIn = list.remove();
			quantity = firstIn.getQuantity();
			price = firstIn.getPrice();
			markedUp = price+(price*0.4);
			continue; 
		} 
		else if (saleQuantity <= quantity) 
		{
			if (saleQuantity == quantity) 
			{
				sale = saleQuantity*markedUp;
				totalSale+=sale;
				totalSold+=quantity;
				orderLines.add(String.format("%d at $ %.2f  \t Sales: $ %.2f",saleQuantity,markedUp,sale));
				break;
			}
		//continue to calculate the sale price of the order line
		sale = saleQuantity*(price+(price*0.4));
		remaining = quantity - saleQuantity;
		totalSale += sale;
		totalSold += saleQuantity;
		orderLines.add(String.format("%d at $ %.2f  \t Sales: $ %.2f",saleQuantity,markedUp,sale));
		//make sure to put the unused wood data back in the linked list so to be used for next order
		Receipt putback = new Receipt(remaining,price);
		list.add(0,putback);
		break;
	}
	}
	//for promotion, print out order lines as a type of invoice 
	if (promotion > 0) 
	{
		double promotionSale = totalSale - (totalSale*promotion);
		bw.write(String.format("%d Widgets sold\n", totalSold));
		for (String sales : orderLines) {
			bw.write("\t" + sales + "\n");
		}
		bw.write(String.format("Total Sale: $ %.2f \n", promotionSale));
		if (soldOut != null) {
			bw.write(soldOut + "\n");
		}
	}
	//no promotion, print out order lines as a type of invoice
	else if (promotion==0) 
	{
	bw.write(String.format("%d Widgets sold \n", totalSold));
	for (String sales : orderLines) {
		bw.write("\t" + sales + "\n");
	}
	bw.write(String.format("Total Sale: $ %.2f \n", totalSale));
	if (soldOut != null) {
		bw.write(soldOut + "\n");
	}
	}
	bw.flush();
}
}
