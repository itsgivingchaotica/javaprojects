import java.util.ArrayList;
import java.util.Scanner;

class FamilyTreeHW5 {

	public static void main(String[] args) {
		FamilyLinkedList familyOne = new FamilyLinkedList();
		FamilyBinaryTree ftree = new FamilyBinaryTree();
		QNode fatherNode, travelNode, trailerNode;
		BNode rootNode,master,search;
		int num,numCount;
		String name;
		
		//add the general tree data to a linkedlist
		familyOne.add("Jones", 3);
		familyOne.add("Bob", 2);
		familyOne.add("Dan", 0);
		familyOne.add("Brian", 1);
		familyOne.add("Richard", 0);
		familyOne.add("Jake", 1);
		familyOne.add("Michael", 1);
		familyOne.add("Bill", 0);
		familyOne.add("Deville", 0);
		
		//the father node is the front of the list for now
		fatherNode = familyOne.getFront();
		//initialize pointer to father node;
		travelNode = trailerNode = fatherNode;
		name = fatherNode.firstName;
		num = fatherNode.numChildren;
		//we begin adding children by using the number of children for the count
		numCount = num;
		
		//add the root node
		rootNode = ftree.addNode(name,num);
		//initialize tree node pointers
		search = master = rootNode;
		//move linked list travel pointer
		travelNode = travelNode.next;
		//this will be the first child node of the root node
		name = travelNode.firstName;
		num = travelNode.numChildren;
		
		while (trailerNode.next != null)
		{
			for (int i = numCount; i>0; i--)
			{
				if (master.left == null) {
					ftree.addLeft(search,name,num);
					System.out.println("Added left son to " + search.name);
					if (travelNode.next == null) 
					{
						break;
					}
					trailerNode = travelNode;
					travelNode = travelNode.next;
					search = search.left;
					System.out.println("Next node to add to: " + search.name);
					name = travelNode.firstName;
					num = travelNode.numChildren;
					
				}
				else if (master.left != null && search.right == null)
				{
					ftree.addRight(search, name, num);
					System.out.println("Added right son to " + search.name);
					if (travelNode.next == null) 
					{
						break;
					}
					trailerNode = travelNode;
					travelNode = travelNode.next;
					search = search.right;
					System.out.println("Next node to add to: " + search.name);
					name = travelNode.firstName;
					num = travelNode.numChildren;
				}
				
			}
			//moving where the next father of the data is along the linkedlist
			trailerNode = fatherNode.next;
			fatherNode = trailerNode;
			
			String tempName = fatherNode.firstName;
			int tempNum = fatherNode.numChildren;
			//find the node we will be adding family sons to
			master = ftree.findNode(rootNode,tempName);
			if (master==null)
			{
				int n = rootNode.children;
				BNode tempNode = rootNode.left;
				//launch algorithm along left sides of tree until the correct node is found
				for (int i = n; i>0; i--) {
					master = ftree.findNode(tempNode, tempName);
					if (master==null)
						tempNode = tempNode.left;
				}		
			}
			//move binary tree search node 
			search = master;
			numCount = fatherNode.numChildren;
			name = travelNode.firstName;
			num = travelNode.numChildren;
		}
		//printing the nodes by oldest sons first
		ftree.printInorder(rootNode);
		//menu to choose functions
		Scanner sc = new Scanner(System.in);
		System.out.println("Pick an option to find");
		System.out.println("1: Father");
		System.out.println("2: Sons");
		System.out.println("3: Brothers");
		System.out.println("4: Oldest brother");
		System.out.println("5: Youngest brother");

		int choice = sc.nextInt();

		while (choice!=-1)
		{
		String familyMember;
		BNode searchNode;
		String result;
		switch (choice)
		{
		case 1:
			//father of the name given
			System.out.print("Enter the name of the family member: ");
			familyMember = sc.next();
			searchNode = ftree.findNode(rootNode,familyMember);
			
			if (searchNode==null)
			{
				int n = rootNode.children;
				BNode tempNode = rootNode.left;
				for (int i = n; i>0; i--) {
					searchNode = ftree.findNode(tempNode, familyMember);
					if (searchNode==null)
						tempNode = tempNode.left;
				}		
			}
			System.out.println();
			result = ftree.findParent(searchNode);
			
			System.out.println(familyMember + "'s father is " + result);
			
			System.out.println("Main Menu: choose an option, -1 to quit: ");
			choice = sc.nextInt();
		
		case 2:
			//sons
			ArrayList<String> sons = new ArrayList<>();
			int numSons;
			System.out.print("Enter the name of the family member: ");
			familyMember = sc.next();
			searchNode = ftree.findNode(rootNode, familyMember);
			if (searchNode==null)
			{
				int n = rootNode.children;
				BNode tempNode = rootNode.left;
				for (int i = n; i>0; i--) {
					searchNode = ftree.findNode(tempNode, familyMember);
					if (searchNode==null)
						tempNode = tempNode.left;
				}		
			}
			System.out.println();
			sons = ftree.findSons(searchNode);
			if (sons==null) {
				System.out.println(familyMember + " has no sons");
			}else {
			
			numSons = sons.size();
			System.out.print(familyMember + " has " + numSons + " son(s): ");
			for (String son : sons)
			{
				System.out.print(son + " ");
			}
			System.out.println();
			}
			System.out.println("Main Menu: choose an option, -1 to quit: ");
			choice = sc.nextInt();
			
		case 3:
			//brothers
			ArrayList<String> brothers = new ArrayList<>();
			int numBrothers;
			System.out.print("Enter the name of the family member: ");
			familyMember = sc.next();
			searchNode = ftree.findNode(rootNode, familyMember);
			if (searchNode==null)
			{
				int n = rootNode.children;
				BNode tempNode = rootNode.left;
				for (int i = n; i>0; i--) {
					searchNode = ftree.findNode(tempNode, familyMember);
					if (searchNode==null)
						tempNode = tempNode.left;
				}		
			}
			System.out.println();
			brothers = ftree.findBrothers(searchNode);
			if (brothers == null) {
				System.out.println(familyMember + " has no brothers");
			}else {
				numBrothers = brothers.size();
			System.out.print(familyMember + " has " + numBrothers + " brother(s): ");
			for (String brother : brothers)
			{
				System.out.print(brother + " ");
			}
			System.out.println();
			}
			System.out.println("Main Menu: choose an option, -1 to quit: ");
			choice = sc.nextInt();
			
		case 4: 
			//oldest brother - or the oldest brother's next-oldest brother
			System.out.print("Enter the name of the family member: ");
			familyMember = sc.next();
			searchNode = ftree.findNode(rootNode,familyMember);
			
			if (searchNode==null)
			{
				int n = rootNode.children;
				BNode tempNode = rootNode.left;
				for (int i = n; i>0; i--) {
					searchNode = ftree.findNode(tempNode, familyMember);
					if (searchNode==null)
						tempNode = tempNode.left;
				}		
			}
			System.out.println();
			result = ftree.findOldestBrother(searchNode);
			
			System.out.println(familyMember + result);
			
			System.out.println("Main Menu: choose an option, -1 to quit: ");
			choice = sc.nextInt();
			
		case 5: 
			//youngest brother or youngest brother's next youngest brother
			System.out.print("Enter the name of the family member: ");
			familyMember = sc.next();
			searchNode = ftree.findNode(rootNode,familyMember);
			
			if (searchNode==null)
			{
				int n = rootNode.children;
				BNode tempNode = rootNode.left;
				for (int i = n; i>0; i--) {
					searchNode = ftree.findNode(tempNode, familyMember);
					if (searchNode==null)
						tempNode = tempNode.left;
				}		
			}
			System.out.println();
			result = ftree.findYoungestBrother(searchNode);
			
			System.out.println(familyMember + result);
			
			System.out.println("Main Menu: choose an option, -1 to quit: ");
			choice = sc.nextInt();
		}
		}	
	}
}
