package binarysearchtree;

import binarysearchtree.SearchAndInsert.Node;

public class InorderSuccessor {
	
	static void inorderSucUtil(Node node,Node suc,int key){
		if(node == null)
			return;
		if(node.data == key){
			if(node.right!=null){
				node = node.right;
				while(node.left!=null)
					node = node.left;
				System.out.println("suc=="+node.data);
			}else{
				if(suc!=null)
					System.out.println("suc=="+suc.data);
				else
					System.out.println("suc==-1");
			}
		}
		if(key<node.data){
			suc = node;
			inorderSucUtil(node.left, suc, key);
		}
		if(key>node.data)
			inorderSucUtil(node.right, suc, key);					
	}
	
	static void inorderSuc(Node root,int key){
		inorderSucUtil(root, null, key);		
	}
	
	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		
		inorderSuc(root, 10);
	}

}
