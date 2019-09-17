package binarytree;

import binarytree.TreeTraversals.Node;

public class AncestorsOfANode {
	
	static boolean printAncestor(Node node,int data){
		if(node==null)
			return false;
		if(node.data==data)
			return true;
		
		if((printAncestor(node.left, data))||(printAncestor(node.right, data))){
		
			System.out.print(node.data+"\t");
			return true;
		
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		
		Node node = TreeTraversals.getRoot();
		printAncestor(node, 4);
		
	}

}
