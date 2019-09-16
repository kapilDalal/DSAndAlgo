package binarytree;

import binarytree.TreeTraversals.Node;

public class MorrisInorderTraversal {

	static Node predecessor(Node node) {
		Node temp = node.left;

		while (temp.right != null && temp.right != node) {

			temp = temp.right;

		}

		return temp;
	}

	static void inorder(Node node) {

		Node curr = node;

		while (curr != null) {
			if (curr.left == null) {
				System.out.print(curr.data + "\t");
				curr = curr.right;
			} else {
				Node pred = predecessor(curr);
				if (pred.right != curr) {
					pred.right = curr;
					curr = curr.left;
				} else {
					System.out.print(curr.data + "\t");
					curr = curr.right;
					pred.right = null;
				}
			}

		}

	}

	public static void main(String[] args) {

		Node root = TreeTraversals.getRoot();
		TreeTraversals.inorder(root);
		System.out.println();
		inorder(root);

		TreeTraversals.inorder(root);

	}

}
