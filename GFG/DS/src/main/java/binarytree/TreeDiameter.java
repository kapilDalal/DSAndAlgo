package binarytree;

import binarytree.TreeTraversals.Node;

public class TreeDiameter {

	private static int diameter = 0;

	private static int diameter(Node node) {
		if (node == null)
			return 0;
		int lh = TreeTraversals.height(node.left);
		int rh = TreeTraversals.height(node.right);

		if (TreeDiameter.diameter < (lh + rh + 1))
			TreeDiameter.diameter = lh + rh + 1;
		diameter(node.left);
		diameter(node.right);
		return TreeDiameter.diameter;
	}

	public static int getDiamter(Node node) {
		if (TreeDiameter.diameter != 0)
			TreeDiameter.diameter = 0;
		int d = diameter(node);
		return d;
	}

	public static void main(String[] args) {
		Node root = TreeTraversals.getRoot();
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.left.left = new Node(2);
		root1.left.right = new Node(2);
		root1.left.left.left = new Node(2);
		root1.left.left.right = new Node(2);
		root1.left.left.right.left = new Node(2);
		root1.left.left.right.left.right = new Node(2);
		root1.left.right.right = new Node(2);
		root1.left.right.right.left = new Node(2);
		root1.left.right.right.right = new Node(2);
		root1.left.right.right.right.left = new Node(2);
		System.out.println(getDiamter(root));
		System.out.println(getDiamter(root1));
	}

}
