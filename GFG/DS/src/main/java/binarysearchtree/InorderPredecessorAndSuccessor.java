package binarysearchtree;

import java.util.ArrayList;

import binarysearchtree.SearchAndInsert.Node;

public class InorderPredecessorAndSuccessor {

	static void inorder(Node node, ArrayList<Integer> list) {
		if (node == null)
			return;
		inorder(node.left, list);
		if (node != null)
			list.add(node.data);
		inorder(node.right, list);
	}

	static void predAndSuc(Node root, int key) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		inorder(root, list);
		int keyIndex = list.indexOf(key);

		if (keyIndex == -1) {
			printRange(list, key);
			return;
		}

		try {
			System.out.println("pred=" + list.get(keyIndex - 1));
		} catch (Exception e) {
			System.out.println("no pred");
		}
		try {
			System.out.println("suc=" + list.get(keyIndex + 1));
		} catch (Exception e) {
			System.out.println("no suc");
		}
	}

	private static void printRange(ArrayList<Integer> list, int key) {
		
	}
	
	static void predAndSecUtilGFG(Node root,int key,Node predecessor,Node successor){
		if(root==null)
			return;
		if(root.data==key){
			if(root.left!=null){
				Node temp = root.left;				
				while(temp.right!=null){
					temp = temp.right;
				}
				System.out.println("pred=="+temp.data);
			}
			else{
					if(predecessor!=null)
						System.out.println("pred=="+predecessor.data);
					else
						System.out.println("pred==-1");
			}
			if(root.right!=null){
				Node temp = root.right;
				while(temp.left!=null)
					temp = temp.left;
				System.out.println("suc=="+temp.data);
			}
			else{
				if(successor!=null)
					System.out.println("suc=="+successor.data);
				else{
					System.out.println("suc==-1");
				}
			}
			return;
		}
		else if(key<root.data){
			successor = root;
			predAndSecUtilGFG(root.left, key, predecessor, successor);
		}
		else if(key>=root.data){
			predecessor = root;
			predAndSecUtilGFG(root.right, key, predecessor, successor);
		}
	}
	static void predAndSucGFG(Node root,int key){
		Node pred,suc; 
		pred=suc=null;
		predAndSecUtilGFG(root, key, pred, suc);
	}

	public static void main(String[] args) {
		Node node = SearchAndInsert.getBst();
		predAndSucGFG(node, 13);

	}

}
