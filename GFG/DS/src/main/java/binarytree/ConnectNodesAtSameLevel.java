package binarytree;

import java.util.LinkedList;
import java.util.Queue;



public class ConnectNodesAtSameLevel {

	static class Node {
		int data;
		Node left, right, rightNeighbour;

		public Node(int data) {
			this.data = data;
			this.left = this.right = this.rightNeighbour = null;
		}
	}

	static void connectRightNodesUsingQueue(Node node) {
		Queue<Node> que = new LinkedList<Node>();		
		que.add(node);
		int count = que.size();
		while (que.size() > 0) {
			count = que.size();
			Queue<Node> que1 = new LinkedList<Node>();
			while(!que.isEmpty()){				
				Node q = que.poll();
				q.rightNeighbour = que.peek();
				que1.add(q);
			}
			que = que1;
			while (count-- > 0) {
				Node curr = que.poll();
				if (curr.left != null)
					que.add(curr.left);
				if (curr.right != null)
					que.add(curr.right);

			}

		}
	}
	
	static void connectRightNodesQueueGFG(Node node) {
		Queue<Node> que = new LinkedList<Node>();
		que.add(node);
		que.add(null);
		while (!que.isEmpty()) {

			Node p = que.poll();

			if (p != null) {
				p.rightNeighbour = que.peek();

				if (p.left != null)
					que.add(p.left);
				if (p.right != null)
					que.add(p.right);

			}
			
			else if(!que.isEmpty())
				que.add(null);

		}
	}
	
	static void connectRightNodesUsingPreorder(Node node){
		if(node==null)
			return;
		if(node.left!=null)
			node.left.rightNeighbour = node.right;
		if(node.right!=null){
		if(node.rightNeighbour!=null)
			node.right.rightNeighbour = node.rightNeighbour.left;
		else
			node.right.rightNeighbour = null;
		}
		connectRightNodesUsingPreorder(node.left);
		connectRightNodesUsingPreorder(node.right);
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
		//connectRightNodesUsingQueue(root);
		//connectRightNodesQueueGFG(root);
		connectRightNodesUsingPreorder(root);
		inorder(root);
		System.out.println();
		
		
	}


	private static void inorder(Node node) {
		if(node==null)
			return;
		inorder(node.left);
		if(node.rightNeighbour!=null)
			System.out.print(node.rightNeighbour.data+"\t");
		else
			System.out.print("null\t");
		inorder(node.right);
		
	}

}
