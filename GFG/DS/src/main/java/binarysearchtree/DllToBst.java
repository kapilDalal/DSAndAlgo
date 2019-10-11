package binarysearchtree;

import binarysearchtree.DllToBst.dll.Node;

public class DllToBst {

	public static class dll {
		static Node head;

		static class Node {
			int data;
			Node next, prev;

			public Node(int data) {
				this.data = data;
				this.next = this.prev = null;
			}
		}

		void push(int data) {
			if (head == null) {
				head = new Node(data);
			} else {
				Node node = new Node(data);
				node.next = head;
				head.prev = node;
				head = node;
			}
		}
		public dll(){
			dll.head = null;
		}
		
	}
	// 1 2 3 4 5 6 7
	static Node convertToBst(Node start,Node end){
		if(start==null || end==null || start.data>end.data)
			return null;
		
		Node root = getMid(start,end);		
		Node prev = root.prev;
		Node next = root.next;
		root.prev = null;
		root.next = null;
		if(prev!=null)
			prev.next = null;
		if(next!=null)
			next.prev = null;
		root.prev = convertToBst(start,prev);
		root.next = convertToBst(next,end);
		
		return root;
	}
	
	static int count(Node node,Node end){
		int count=0;
		while(node!=null && node.data!=end.data){
			count++;
			node=node.next;
		}
		return count;
	}
	private static Node getMid(Node start,Node end) {		
		int length = count(start,end);
		int mid = length/2;
		Node temp = start;
		for(int i=1;i<=mid;i++)
			temp = temp.next;
		
		return temp;
	}


	static void printDll(){	
		Node head = dll.head;
		while(head!=null){
			System.out.println(head.data+"\t");
			head = head.next;	
		}					
	}
	
	static Node endOfList(){
		Node temp = dll.head;
		while(temp.next!=null)
			temp = temp.next;
		return temp;
	}

	static void inorder(Node node){
		if(node==null)
			return;
		inorder(node.prev);
		System.out.print(node.data+"\t");
		inorder(node.next);
	}
	
	public static void main(String[] args) {
		dll llist = new dll();
		llist.push(7); 
		llist.push(6); 
		llist.push(5); 
		llist.push(4); 
		llist.push(3); 
		llist.push(2); 
		llist.push(1); 
		
		//printDll();
		Node root = convertToBst(dll.head, endOfList());
		inorder(root);

	}

}
