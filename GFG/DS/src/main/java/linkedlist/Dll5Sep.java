package linkedlist;

public class Dll5Sep {

	private Node head;
	static class Node{
		int data;
		Node prev;
		Node next;
		public Node(int data){
			this.data = data;
			this.next = this.prev = null;		
		}
	}
	
	
	static void quickSort(Node node,Node last){
		if(node==last|| node==null || last==null || node.next == null)
			return;
		Node pivot = getPivot(node,last);
		quickSort(node, pivot.prev);
		quickSort(pivot.next, last);
	}


	private static Node getPivot(Node node, Node last) {
		int pivot = last.data;
		Node pIndex = node;
		Node temp = node;
		
		while(temp.next!=null){
			if(temp.data<pivot){
				int temp1 = temp.data;
				temp.data = pIndex.data;
				pIndex.data = temp1;
				pIndex = pIndex.next;
			}
			temp = temp.next;
		}
		int temp1 = pIndex.data;
		pIndex.data = last.data;
		last.data = temp1;
		return pIndex;
	}
	
	Node insertAtEnd(Node head, int data) {
		if (head == null) {
			head = new Node(data);
			return head;
		}

		Node temp = head;
		while (temp.next != null)
			temp = temp.next;

		Node newNode = new Node(data);

		newNode.prev = temp;
		newNode.next = null;

		temp.next = newNode;

		return head;
	}
	void print(Node head) {
		while (head != null) {
			System.out.print(head.data + "\t");
			head = head.next;
		}

	}
	
	static void _quickSort(Node node){
		Node head =node;
		while(node.next!=null){
			node = node.next;
		}
		quickSort(head, node);
	}
	
	public Node mergeSort(Node node){
		if(node==null || node.next==null )
			return node;
		Node middle = getMid(node);
		Node next = middle.next;
		middle.next = null;
		//next.prev = null;
		node = mergeSort(node);
		next = mergeSort(next);
		Node result = merge(node,next);
		return result;
	}
	
	private Node merge(Node node, Node next) {
		
		if(node==null)
			return next;
		if(next==null)
			return node;
		
		Node result = null;
		
		if(node.data<next.data){
			result = node;//new Node(node.data);
			result.next = merge(node.next,next);
			result.next.prev = result;
		}else{
			result = next;//new Node(next.data);
			result.next = merge(node,next.next);
			result.next.prev = result;
		}
		return result;
	}


	private Node getMid(Node node) {				
		Node slowPtr = node;
		Node fastPtr = node.next;
		while (fastPtr != null) {
			fastPtr = fastPtr.next;
			if (fastPtr != null) {
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next;
			}
		}
		return slowPtr;
	}


	public static void main(String[] args) {
		Dll5Sep dll = new Dll5Sep();		
		
		dll.head = dll.insertAtEnd(dll.head, 4);
		dll.head = dll.insertAtEnd(dll.head, 1);
		dll.head = dll.insertAtEnd(dll.head, 3);
		dll.head = dll.insertAtEnd(dll.head, 2);
		dll.head = dll.insertAtEnd(dll.head, 0);
		dll.head = dll.insertAtEnd(dll.head, 7);
		
		//_quickSort(dll.head);
		dll.head = dll.mergeSort(dll.head);
		dll.print(dll.head);
		/*System.out.println();
		Node mid = dll.getMid(dll.head);
		System.out.println(mid.data);*/
		
	}
	
}
