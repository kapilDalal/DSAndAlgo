package binarytree;

import java.awt.List;
import java.util.ArrayList;

import binarytree.TreeTraversals.Node;

public class CheckSubtree {

	static boolean areIdentical(Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return true;

		if (node1 == null || node2 == null)
			return false;

		return ((node1.data == node2.data) && areIdentical(node1.left, node2.left)
				&& areIdentical(node1.right, node2.right));
	}
	
	static boolean isSubTree(Node root1,Node root2){
		if(root1==null)
			return false;
		
		if(root2==null)
			return true;
		
		if(areIdentical(root1, root2))
			return true;
		
		return (isSubTree(root1.left, root2) || isSubTree(root1.right, root2));
		
	}
	
	static void inorder(Node node , ArrayList<Integer> inorderData){
		if(node==null)
			return;
		inorder(node.left,inorderData);
		inorderData.add(node.data);
		inorder(node.right,inorderData);
	}
	static void preorder(Node node,ArrayList<Integer> preorderData){
		if(node==null)
			return;
		preorderData.add(node.data);
		preorder(node.left,preorderData);
		preorder(node.right,preorderData);
	}
	
	static boolean isSubtreeUsingPreorderAndInorder(Node root1,Node root2){
		ArrayList<Integer> parentPreoderData = new ArrayList<Integer>();
		ArrayList<Integer> childPreoderData = new ArrayList<Integer>();
		
		preorder(root1,parentPreoderData);
		preorder(root2, childPreoderData);
		
		ArrayList<Integer> parentInoderData = new ArrayList<Integer>();
		ArrayList<Integer> childInoderData = new ArrayList<Integer>();
		
		inorder(root1,parentInoderData);
		inorder(root2,childInoderData);
		
		if(parentInoderData.containsAll(childInoderData) && parentPreoderData.containsAll(childPreoderData))
			return true;
		
		return false;
	}
	
	
	public static void main(String[] args) {
		// TREE 1 
        /* Construct the following tree 
              26 
             /   \ 
            10     3 
           /    \     \ 
          4      6      3 
           \ 
            30  */
		Node root1 = new Node(26); 
        root1.right = new Node(3); 
        root1.right.right = new Node(3); 
        root1.left = new Node(10); 
        root1.left.left = new Node(4); 
        root1.left.left.right = new Node(30); 
        root1.left.right = new Node(6); 
        // TREE 2 
        /* Construct the following tree 
           10 
         /    \ 
         4      6 
          \ 
          30  */
        Node root2 = new Node(10); 
        root2.right = new Node(6); 
        root2.left = new Node(4); 
        root2.left.right = new Node(30); 
        
        System.out.println(isSubTree(root1, root2));
        System.out.println(isSubtreeUsingPreorderAndInorder(root1,root2));
	}

}
