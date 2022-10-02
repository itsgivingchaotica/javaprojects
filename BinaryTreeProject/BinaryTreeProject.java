import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class BinaryTreeProject {

	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("/Users/siobhan/eclipse-workspace/lowenthal_hw4/src/lowenthal_hw4/hw4input.txt"));
		ArrayList<Integer> set1 = new ArrayList<>();
		ArrayList<Integer> set2 = new ArrayList<>();
		ArrayList<Integer> set3 = new ArrayList<>();
		ArrayList<Integer> set4 = new ArrayList<>();
		ArrayList<Integer> set5 = new ArrayList<>();
		ArrayList<Integer> set6 = new ArrayList<>();
		
		BinaryTree tree1 = new BinaryTree();
		BinaryTree tree2 = new BinaryTree();
		BinaryTree tree3 = new BinaryTree();
		BinaryTree tree4 = new BinaryTree();
		BinaryTree tree5 = new BinaryTree();
		BinaryTree tree6 = new BinaryTree();
		
		int numberNodes;
		int len;
		
		set1=readInput(set1,scan);
		scan.nextLine();
		set2=readInput(set2,scan);
		scan.nextLine();
		set3=readInput(set3,scan);
		scan.nextLine();
		set4=readInput(set4,scan);
		scan.nextLine();
		set5=readInput(set5,scan);
		scan.nextLine();
		set6=readInput(set6,scan);
		
		len = set1.size();
		Node node1 = tree1.buildTree(set1, 0, len - 1, tree1.root);
		len = set2.size();
		Node node2 = tree2.buildTree(set2, 0, len - 1, tree2.root);
		len = set3.size();
		Node node3 = tree3.buildTree(set3, 0, len - 1, tree3.root);
		len = set4.size();
		Node node4 = tree4.buildTree(set4, 0, len - 1, tree4.root);
		len = set5.size();
		Node node5 = tree5.buildTree(set5, 0, len - 1, tree5.root);
		len = set6.size();
		Node node6 = tree6.buildTree(set6, 0, len - 1, tree6.root);
		
		tree1.preorder(node1);
		System.out.println();
		tree1.inorder(node1);
		System.out.println();
		tree1.postorder(node1);
		System.out.println();
		numberNodes = tree1.countNodes(node1);
		System.out.println("Set 1 tree has " + numberNodes + " nodes");
		
		tree2.preorder(node2);
		System.out.println();
		tree2.inorder(node2);
		System.out.println();
		tree2.postorder(node2);
		System.out.println();
		numberNodes = tree2.countNodes(node2);
		System.out.println("Set 2 tree has " + numberNodes + " nodes");
		
		tree3.preorder(node3);
		System.out.println();
		tree3.inorder(node3);
		System.out.println();
		tree3.postorder(node3);
		System.out.println();
		numberNodes = tree3.countNodes(node3);
		System.out.println("Set 3 tree has " + numberNodes + " nodes");
		
		tree4.preorder(node4);
		System.out.println();
		tree4.inorder(node4);
		System.out.println();
		tree4.postorder(node4);
		System.out.println();
		numberNodes = tree4.countNodes(node4);
		System.out.println("Set 4 tree has " + numberNodes + " nodes");
		
		tree5.preorder(node5);
		System.out.println();
		tree5.inorder(node5);
		System.out.println();
		tree5.postorder(node5);
		System.out.println();
		numberNodes = tree5.countNodes(node5);
		System.out.println("Set 5 tree has " + numberNodes + " nodes");
		
		tree6.preorder(node6);
		System.out.println();
		tree6.inorder(node6);
		System.out.println();
		tree6.postorder(node6);
		System.out.println();
		numberNodes = tree6.countNodes(node6);
		System.out.println("Set 6 tree has " + numberNodes + " nodes");
		
		set1.addAll(set2);
		set1.addAll(set3);
		set4.addAll(set5);
		set4.addAll(set6);
		
		BinaryTree combinedTree1 = new BinaryTree();
		BinaryTree combinedTree2 = new BinaryTree();
		
		len = set1.size();
		Node node7 = combinedTree1.buildTree(set1, 0, len - 1, combinedTree1.root);
		len = set4.size();
		Node node8 = combinedTree2.buildTree(set4, 0, len - 1, combinedTree2.root);
		
		combinedTree1.preorder(node7);
		System.out.println();
		combinedTree1.inorder(node7);
		System.out.println();
		combinedTree1.postorder(node7);
		System.out.println();
		numberNodes = combinedTree1.countNodes(node7);
		System.out.println("Combined tree 1 has " + numberNodes + " nodes");
		
		combinedTree2.preorder(node8);
		System.out.println();
		combinedTree2.inorder(node8);
		System.out.println();
		combinedTree2.postorder(node8);
		System.out.println();
		numberNodes = combinedTree2.countNodes(node8);
		System.out.println("Combined tree 2 has " + numberNodes + " nodes");
		
		int numberEven, numberOdd;
		numberEven = combinedTree1.countEven(node7);
		numberOdd = combinedTree1.countOdd(node7);
		System.out.println("Combined Tree 1 has " + numberEven + " even elements and " + numberOdd + " odd elements.");
		
		numberEven = combinedTree2.countEven(node8);
		numberOdd = combinedTree2.countOdd(node8);
		System.out.println("Combined Tree 2 has " + numberEven + " even elements and " + numberOdd + " odd elements.");
	}
	
	public static ArrayList<Integer> readInput(ArrayList<Integer> inorder, Scanner scan) throws IOException{
		int value=0;
		
		value = scan.nextInt();
		
		while (value != -999)
		{
			
			inorder.add(value);
			value = scan.nextInt();
		}
		
		return inorder;
	}

}
