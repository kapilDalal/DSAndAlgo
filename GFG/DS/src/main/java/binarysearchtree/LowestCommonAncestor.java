package binarysearchtree;

import binarysearchtree.SearchAndInsert.Node;

public class LowestCommonAncestor {

	static int lca, level = Integer.MIN_VALUE;

	static boolean lcaUtil(Node node, int n) {
		if (node == null)
			return false;
		if (node.data == n)
			return true;
		if (lcaUtil(node.left, n) || lcaUtil(node.right, n))
			return true;
		return false;
	}

	static void lca(Node root, int level, int n1, int n2) {
		if (root == null)
			return;
		if (lcaUtil(root, n1) && lcaUtil(root, n2))
			if (LowestCommonAncestor.level < level)
				LowestCommonAncestor.lca = root.data;
		lca(root.left, level + 1, n1, n2);
		lca(root.right, level + 1, n1, n2);

	}

	static Node lcaGFG(Node node, int n1, int n2) {
		if (node == null)
			return null;
		/*if ((node.data > n1 || node.data==n1) && (node.data < n2 || node.data==n2))
			System.out.println(node.data);*/
		
		if (node.data > n1 && node.data > n2)
			return lcaGFG(node.left, n1, n2);
		if (node.data < n1 && node.data < n2)
			return lcaGFG(node.right, n1, n2);
		
		return node;
	}

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		/*lca(root, 0, 10, 22);
		System.out.println(lca);*/
		//lcaGFG(root,14,8);
		System.out.println(lcaGFG(root,14,8).data);
	}

}
