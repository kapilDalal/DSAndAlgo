package binarytree;

import java.util.Stack;

import binarytree.TreeTraversals.Node;

public class InorderWithoutRecursion {

	public static void inorder(Node root) {

		Node node = root;
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);

		while (!stack.isEmpty()) {

			while (node != null && node.left != null) {
				node = node.left;
				stack.push(node);
			}

			Node popped = stack.pop();
			System.out.print(popped.data + "\t");

			if (popped.right != null) {
				stack.push(popped.right);
				node = stack.peek();
			}

		}

	}

	public static void main(String[] args) {
		Node root = TreeTraversals.getRoot();
		inorder(root);
		System.out.println();
		TreeTraversals.inorder(root);
	}

}
