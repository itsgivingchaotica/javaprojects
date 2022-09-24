import java.util.ArrayList;

public class FamilyBinaryTree {
	
	BNode root;
	
	/**
	 * adds root node
	 * @param name first name of family member
	 * @param num the number of children
	 * @return
	 */
	BNode addNode(String name, int num)
	{
		if (root == null)
		root = new BNode(name,num);
		return root;
	}
	/**
	 * adds a left son 
	 * @param father the parentnode which is not necessarily father in real life
	 * @param name 
	 * @param num
	 */
	void addLeft(BNode father, String name, int num)
	{
		BNode leftSon;
		
		if (father == null)
		{
			System.out.println("Can't add node; father node not pointing to anything");
		}
		
		else if (father.left != null)
		{
			System.out.println("Left son already there");
		}
		
		else
		{
			leftSon = new BNode(name,num);
			father.left = leftSon;
			leftSon.parent = father;
			System.out.println(leftSon.name + " is the left son of " + father.name);
		}
	}
	/**
	 * adds right son to father
	 * @param father
	 * @param name
	 * @param num
	 */
	void addRight(BNode father, String name, int num)
	{
		BNode rightSon;
		
		if (father == null)
		{
			System.out.println("Can't add node; father node not pointing to anything");
		}
		
		else if (father.right != null)
		{
			System.out.println("Right son already there");
		}
		
		else
		{
			rightSon = new BNode(name, num);
			father.right = rightSon;
			rightSon.parent = father;
			System.out.println(rightSon.name + " is the right son of " + father.name);
		}
	}
	/**
	 * prints the family in terms of oldest sons offspring first
	 * @param node
	 */
	void printInorder(BNode node)
	{
		
	BNode temp = node;
	// if the tree is empty do nothing 
		if (temp!=null)
		{
		 System.out.println(node.name + " " + temp.children);
		 printInorder(temp.left);
		 printInorder(temp.right);
		}
	}
	
	BNode findNode(BNode root, String firstName)
	{
		if (root == null || root.name.equals(firstName))
		return root;
		
		if(root.right==null)
		return findNode(root.left, firstName);
			
		return findNode(root.right, firstName);
		
		
	}
	/**
	 * finds the real father of the family member
	 * @param search the family member in question
	 * @return the father's name
	 */
	public String findParent(BNode search)
	{
		BNode dad;
		
		if (search.parent==null)
			return " not listed.";
		dad = search.parent;
		if (dad.left == search)
			return dad.name;
		
		while (dad.parent!=null) {
		if (dad.right!=null) {
			dad = dad.parent;
		}
		}
		return dad.name;
	}
	
	/**
	 * finds the family member's sons
	 * @param search the family member in question
	 * @return the sons or null is no sons
	 */
	public ArrayList<String> findSons(BNode search)
	{
		ArrayList<String> sons = new ArrayList<>();
	
		String son = null;
		if (search.left==null)
		{
			return null;
		}
		if (search.left !=null) {
			son = search.left.name;
			sons.add(son);
			search = search.left;
		}
		BNode temp = search.right;
		while (temp!=null)
		{
			son = temp.name;
			sons.add(son);
			temp = temp.right;
		}
		return sons;
	}
	
	/**
	 * finds the brothers
	 * @param search the family member in question
	 * @return the arraylist of brothers or null if no brothers
	 */
	public ArrayList<String> findBrothers(BNode search)
	{
		ArrayList<String> brothers = new ArrayList<>();
		
		String name;
		BNode brother;
		BNode temp = search;
		while (temp.parent!=null)
		{
			brother = temp.parent;
			name = brother.name;
			if (brother.left == temp)
				break;
			brothers.add(name);
			temp=brother;
		}
		while (search.right!=null)
		{
			brother = search.right;
			name = brother.name;
			brothers.add(name);
			search = search.right;
		}
		return brothers;
	}
	
	/**
	 * finds the oldest brother 
	 * @param search the family member in question
	 * @return the oldest brother or message
	 */
	public String findOldestBrother(BNode search)
	{
		BNode father;
		
		String oldestBrother = null;
		
		father = search.parent;
		
		if (father == null)
		{
			return " has no brother listed";
		}
		if (father.left == search && search.right!=null)
		{
			return "'s oldest brother is: " + search.right.name;
		}
		if (father.left == search && search.right==null)
		{
			return " has no brothers";
		}
		while (father!=null)
		{
			if (father.parent.left != father)
			{
				father = father.parent;
			}
			else
			{
				break;
			}
		}
		oldestBrother = father.name;
		return "'s oldest brother is: " + oldestBrother;
	}
	/**
	 * finds the youngest brother 
	 * @param search the family member in question
	 * @return the youngest brother or message
	 */ 
	public String findYoungestBrother(BNode search)
	{
		BNode son;
		
		String youngestBrother = null;
		
		son = search.right;
		
		if (son == null && search.parent == null)
		{
			return " has no brother listed";
		}
		if (son == null && search.parent.left!=search)
		{
			return "'s youngest brother is: " + search.parent.name;
		}
		if (son == null && search.parent.left==search)
		{
			return " has no brothers";
		}
		while (search.right!=null)
		{
			search = search.right;
		}
		youngestBrother = search.name;
		return "'s youngest brother is: " + youngestBrother;
	}
}
