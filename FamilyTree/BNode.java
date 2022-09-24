public class BNode {
		BNode right, left, parent, child, sibling;
		String name;
		int children;

		public BNode(String name, int children)
		{
			this.name = name;
			this.children = children;
			left=right=parent=null;
		}

}
