package binarysearchtree;

import java.util.Stack;

import binarysearchtree.SearchAndInsert.Node;

public class MergeTwoBst {

	static Node insert(Node root, int key) {
		if (root == null) {
			return new Node(key);
		}
		if (key < root.data)
			root.left = insert(root.left, key);
		else if (key >= root.data)
			root.right = insert(root.right, key);

		return root;
	}

	static void merge(Node root1, Node root2) {
		if (root2 == null)
			return;
		root1 = insert(root1, root2.data);
		merge(root1, root2.left);
		merge(root1, root2.right);
	}

	static void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + "\t");
		inorder(root.right);
	}

	// TC = O(m+n) and auxiliary space = O(h1+h2)
	static void mergeBstGFG(Node root1, Node root2) {
		Node curr1 = root1;
		Node curr2 = root2;

		if (curr1 == null) {
			inorder(curr2);
			return;
		}
		if (curr2 == null) {
			inorder(curr1);
			return;
		}

		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		while (curr1 != null || curr2 != null || !s1.isEmpty() || !s2.isEmpty()) {

			if (curr1 != null || curr2 != null) {
				if (curr1 != null) {
					s1.push(curr1);
					curr1 = curr1.left;
				}
				if (curr2 != null) {
					s2.push(curr2);
					curr2 = curr2.left;
				}
			} else {

				if (s1.isEmpty() || s2.isEmpty()) {
					if (s1.isEmpty()) {
						curr2 = s2.pop();
						inorder(curr2);
						return;
					}
					if (s2.isEmpty()) {
						curr1 = s1.pop();
						inorder(curr1);
						return;
					}
				} else {
					curr1 = s1.pop();
					curr2 = s2.pop();
					if (curr1.data < curr2.data) {
						System.out.print(curr1.data + "\t");
						curr1 = curr1.right;						
						s2.push(curr2);
						curr2 = null;
					}
					else if (curr1.data >= curr2.data) {
						System.out.print(curr2.data + "\t");
						curr2 = curr2.right;						
						s1.push(curr1);
						curr1=null;
					}

				}
			}

		}

	}
	//1 2 3 4 5 6
	static int bs(int[] arr ,int start,int end){

		if(start<=end){
	
			int mid = (start+end)/2;
			if(start==end || start==mid)
				return arr[start];
			
			if(mid-1>=0 && mid+1<arr.length)
				if(arr[mid]<arr[mid-1] && arr[mid]<arr[mid+1])
					return arr[mid];
			
			if(arr[mid]>arr[end])
				return bs(arr,mid+1,end);
			
			else
				return bs(arr,start,mid-1);
		}
	    
		return -1;
	}
	
	
	public static void main(String[] args) {
		/*Node root1, root2;
		
		 * first tree 									  3 
		 * 												 / \ 
		 * 												1   5
		 
		root1 = new Node(3);
		root1.left = new Node(1);
		root1.right = new Node(5);

		
		 * Let us create the following tree as second tree 4
		 * 												  / \ 
		 * 												 2   6
		 
		root2 = new Node(4);
		root2.left = new Node(2);
		root2.right = new Node(6);
		mergeBstGFG(root1, root2);*/
		//inorder(root1);
		
		int[] arr = {1,2,3,4,5,6};
		System.out.println(bs(arr, 0, 5));
	}

}
