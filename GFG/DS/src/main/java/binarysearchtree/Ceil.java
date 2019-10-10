package binarysearchtree;

import binarysearchtree.SearchAndInsert.Node;

public class Ceil {

	int suc = -1;
	static int ceil(Node root, int key) {
		if (root == null)
			return -1;
		if(root.data == key)
			return root.data;
		
		if(root.data<key)
			return ceil(root.right,key);
		
		int ceil = ceil(root.left,key);
		
		return ceil>=key ? ceil : root.data;
		
		

	}

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.right.left = new Node(21);
		root.right.right = new Node(24);

		for (int i = 0; i < 24; i++)
			System.out.println(ceil(root, i));
	}

}
