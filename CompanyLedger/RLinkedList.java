import java.io.BufferedWriter;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * RLinkedList : queue-inspired linked list implementation 
 * which adds new receipts to end of list 
 * but able to also put back at the beginning if quantity of type 
 * of wood left unsold after completion of purchase
 * @author Saoirse siobhan Ebert
 */
public class RLinkedList {
	/**
	 * 
	 * create node in linked list
	 *
	 */
	private class Node
	{
		Receipt receipt;
		Node next;
		Node prev;
		/**
		 * create subsequent nodes in linked list
		 * @param rec : the receipt class object
		 * @param n : the next node
		 * @param p : the previous node
		 */
		Node(Receipt rec, Node n, Node p)  
		{
			receipt = rec;
			next = n;
			prev = p;
		}
		/**
		 * create first node
		 * @param rec : the receipt class object
		 */
		Node(Receipt rec)
		{
			this(rec, null, null);
		}
	}
	
	private Node first;
	private Node last;
	
	public RLinkedList()
	{
		first = null; //head
		last = null; //tail
	}
	
	/**
	 * isEmpty : determines if the linked list is empty
	 * @return null if empty
	 */
	public boolean isEmpty()
	{
		return first == null;
	}
	
	/**
	 * size : determines the number of nodes in the linked list
	 * @return the number of nodes 
	 */
	public int size()
	{
		int count = 0;
		Node p = first;
		while (p!= null)
		{
			count++;
			p = p.next;
		}
		return count;
	}
	
	/**
	 * add : to the end of the list, queue fashion
	 * @param rec 
	 */
	public void add(Receipt rec)
	{
		//add first node
		if (isEmpty())
		{
			last = new Node(rec);
			first = last;
		}
		//add next node to end of list 
		else
		{
			last.next = new Node(rec, null, last);
			last = last.next;
		}
	}
	
	/**
	 * add : receipt object to a position in the linked list
	 * in this program it will add to the beginning of the linked list - index 0
	 * @param index the position in the list to add the receipt
	 * @param rec the receipt class object
	 */
	public void add(int index, Receipt rec)
	{
		if (index < 0 || index > size())
		{
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}
		
		if (index == 0)
		{
			//new element at beginning
			Node p = first; 
			first = new Node(rec, p, null);
			if (p != null)
				p.prev=first; 
			if (last == null)
				last = first;
			return;
		}
		
		//go from pred--succ
		//to pred--middle-succ
		Node pred = first;
		for (int k = 1; k <=index -1; k++)
		{
			pred = pred.next;
		}
		
		Node succ = pred.next;
		Node middle = new Node(rec, succ, pred);
		pred.next = middle; 
		if (succ == null)
			last = middle;
		else
			succ.prev = middle;
	}
	
	/**
	 * printList : prints the remaining inventory of linked lists
	 * @param bw : buffered writer 
	 * @throws IOException
	 */
	public void printList(BufferedWriter bw)throws IOException
	{
		Node p = first;
		while (p!=null) {
			bw.write(String.format("%d at $ %.2f each, $ %.2f total \n",p.receipt.getQuantity(), p.receipt.getPrice(), p.receipt.getQuantity()*p.receipt.getPrice()));
			p = p.next;
		}
	}
	
	/**
	 * remove : removes a receipt object from the list
	 * @return : the first receipt on the linked list
	 */
	public Receipt remove() {
		if (isEmpty()) {
			throw new NoSuchElementException("List is empty");
		}
		Node target = first;
		
		if (first == last) {
			last = null;
		} else {
			first.next.prev = null;
		}
		first = first.next;
		Receipt rec = target.receipt;
		target.next =null;
		
		return rec;
	}
}
