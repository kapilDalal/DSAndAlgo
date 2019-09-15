package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversals {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.data + "\t");
		inorder(node.right);
	}

	public static void preorder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + "\t");
		preorder(node.left);
		preorder(node.right);
	}

	public static void postorder(Node node) {
		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + "\t");
	}
	
	public static int height(Node node) {
		if (node == null)
			return 0;
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		return 1 + (Math.max(leftHeight, rightHeight));
	}

	public static void printLevel(Node node, int start, int target) {
		if (start <= target) {
			if(node==null)
				return;
			if (start == target) {
				System.out.print(node.data + "\t");
				return;
			}
			printLevel(node.left, start + 1, target);
			printLevel(node.right, start + 1, target);
		}
	}

	public static void bfsTraversal(Node node) {
		int height = height(node);
		for (int i = 1; i <= height; i++)
			printLevel(node, 1, i);
	}
	
	public static void bfsTraversalUsingQueue(Node node) {
		Queue<Node> que = new LinkedList<Node>();
		que.add(node);
		while (!que.isEmpty()) {
			Node temp = que.poll();
			System.out.print(temp.data + "\t");
			if (temp.left != null)
				que.add(temp.left);
			if (temp.right != null)
				que.add(temp.right);
		}
	}
	
		
	/*			 1
	 * 		  /	    \
	 * 		 2	     3
	 * 	   /  \	    / 
	 * 	  4    5   7
	 * 			\
	 * 			 6
	 * */
	public static Node getRoot(){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(6);
		root.right.left = new Node(7);
		return root;
	}

	public static void main(String[] args) {
		Node root = getRoot();
		inorder(root);
		System.out.println();
		preorder(root);
		System.out.println();
		postorder(root);
		System.out.println();
		System.out.println(height(root));		
		bfsTraversal(root);
		System.out.println();
		bfsTraversalUsingQueue(root);
	}

}
