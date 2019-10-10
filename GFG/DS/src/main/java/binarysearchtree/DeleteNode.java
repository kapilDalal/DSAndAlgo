package binarysearchtree;

import binarysearchtree.SearchAndInsert.Node;

public class DeleteNode {

	static Node deleteNode(Node root, int key) {
		if (root.data == key) {

			Node node = getInorderPred(root);

			if (node == null)
				return root.right;

			root.data = node.data;

			root.left = deleteNode(root.left, node.data);
		} 
		else {
			
			if (key < root.data)
				root.left = deleteNode(root.left, key);
			else
				root.right = deleteNode(root.right, key);
		}
		return root;
	}

	private static Node getInorderPred(Node node) {

		if (node == null || node.left == null)
			return null;

		node = node.left;

		while (node.right != null)
			node = node.right;
		return node;
	}

	public static void main(String[] args) {
		Node node = SearchAndInsert.getBst();

		Node head = deleteNode(node, 8);
		head = deleteNode(head, 12);
		head = deleteNode(head, 11);
		SearchAndInsert.inorder(head);

	}

}
