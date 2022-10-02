import java.util.ArrayList;

public class BinaryTree {
	
	Node root;
	
	public Node buildTree(ArrayList<Integer> inorder, int start, int end, Node node)
	{
		if (start > end)
			return null;
		
		int i = max(inorder,start,end);
		
		node = new Node(inorder.get(i));
		
		if (start == end)
			return node;
		
		node.left = buildTree(inorder, start, i-1, node.left);
		node.right = buildTree(inorder, i+1, end, node.right);
		
		return node;
	}
	
	public int max (ArrayList<Integer> inorder, int s, int e)
	{
		int i, max = inorder.get(s);
		int maxind = s;
		for (i = s + 1; i <= e; i++)
		{
			if (inorder.get(i) > max)
			{
				max = inorder.get(i);
				maxind = i;
			}
		}
		return maxind;
	}
	
	public void preorder(Node node)
	{
		if (node == null)
			return;
		
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}
	
	public void inorder(Node node)
	{
		if (node == null)
			return;
		
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
		
	}
	
	public void postorder(Node node)
	{
		 if (node == null)
			 return;
		 postorder(node.left);
		 postorder(node.right);
		 System.out.print(node.data + " ");
	}
	
	public int countNodes(Node root)
	{
		if (root == null)
			return 0;
		
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	public int countEven(Node root)
	{
		if (root == null)
			return 0;
		
		int val = (root.data%2==1) ? 0 : 1;
		return val + countEven(root.left) + countEven(root.right);
	}
	
	public int countOdd(Node root)
	{
		if (root == null)
			return 0;
		
		int val = (root.data%2==0) ? 0 : 1;
		return val + countOdd(root.left) + countOdd(root.right);
	}
}
