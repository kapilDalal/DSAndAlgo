package binarysearchtree;

import binarysearchtree.SearchAndInsert.Node;

public class IsBst {

	static boolean isBst(Node root) {
		if (root == null)
			return true;
		isBst(root.left);
		isBst(root.right);
		return (checkLeftSubTree(root == null ? root : root.left, root.data)
				&& checkRightSubTree(root == null ? root : root.right, root.data));
	}

	static boolean checkLeftSubTree(Node node, int key) {
		if (node == null)
			return true;
		if (key < node.data)
			return false;
		return (checkLeftSubTree(node.left, key) && checkLeftSubTree(node.right, key));
	}

	static boolean checkRightSubTree(Node node, int key) {
		if (node == null)
			return true;
		if (key > node.data)
			return false;
		return (checkRightSubTree(node.left, key) && checkRightSubTree(node.right, key));
	}

	static boolean isBstUtilGFG(Node node, int min, int max) {
		if (node == null)
			return true;
		if (node.data < min || node.data > max)
			return false;
		return (isBstUtilGFG(node.left, min, node.data) && isBstUtilGFG(node.right, node.data, max));
	}

	static boolean isBstGFG(Node root) {
		return isBstUtilGFG(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		Node root = new Node(8);
		root.left = new Node(7);
		root.left.left = new Node(6);
		root.left.left.left = new Node(4);
		root.left.left.left.left = new Node(3);
		root.left.left.left.right = new Node(5);
		root.right = new Node(9);
		root.right.right = new Node(11);
		root.right.right.right = new Node(12);
		root.right.right.left = new Node(10);
		System.out.println(isBstGFG(root));
	}

}
