package binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;

import binarysearchtree.SearchAndInsert.Node;

public class BinaryTreeToBst {

	static void inorderList(Node node, ArrayList<Integer> list) {
		if (node == null)
			return;
		inorderList(node.left, list);
		if (node != null)
			list.add(node.data);
		inorderList(node.right, list);
	}

	static void putListDataToTree(Node node, ArrayList<Integer> list) {
		if (node == null)
			return;
		putListDataToTree(node.left, list);
		if (node != null && list.size() > 0) {
			node.data = list.get(0);
			list.remove(0);
		}
		putListDataToTree(node.right, list);
	}
	
	static void convertBinaryTreeToBst(Node node){
		if(node==null)
			return;
		ArrayList<Integer> inorderList = new ArrayList<Integer>();
		
		inorderList(node,inorderList);
		Collections.sort(inorderList);
		putListDataToTree(node, inorderList);		
	}
	
	static void inorder(Node node){
		if(node==null)
			return;
		inorder(node.left);
		System.out.print(node.data+"\t");
		inorder(node.right);
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(8);
		root.left.right = new Node(4);
		convertBinaryTreeToBst(root);
		inorder(root);
	}

}
