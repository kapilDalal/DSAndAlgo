package binarysearchtree;

import java.util.Stack;

import binarysearchtree.SearchAndInsert.Node;

public class PairWithGivenSum {
	
	static void pairWithGivenSum(Node root,int sum){
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		Node curr1,curr2;
		curr1=curr2=root;
		boolean done1,done2;
		done1=done2=false;
		while(true){
			
			if(done1==false){
				while(curr1!=null){
					s1.push(curr1);
					curr1 = curr1.left;
				}				
				/*if(curr1!=null && curr1.right!=null)
					curr1 = curr1.right;*/	
			}
			
			if(done2==false){
				while(curr2!=null){
					s2.push(curr2);
					curr2 = curr2.right;					
				}
				/*if(curr2.left!=null)
					curr2 = curr2.left;*/
			}
			
			int val1 = s1.peek().data;
			int val2 = s2.peek().data;
			
			if(val1!=val2 && val1+val2==sum){
				System.out.println(val1+"\t"+val2);
				break;
			}
			
			if(val1+val2<sum){
				Node temp = s1.pop();
				if(temp.right!=null)
					curr1 = temp.right;
				done1 = false;
				done2 = true;
			}
			else if (val1+val2>sum){
				Node temp = s2.pop();
				if(temp.right!=null)
					curr2 = temp.left;
				done1 = true;
				done2 = false;
			}
				
			if(val1>=val2){
				System.out.println("no pair");
				return;
			}
			
		}	
	}
	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.right.left = new Node(21);
		root.right.right = new Node(24);

		
		pairWithGivenSum(root, 43);
		
	}

}
