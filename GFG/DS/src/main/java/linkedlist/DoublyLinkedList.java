package linkedlist;

public class DoublyLinkedList {

	Node head;

	static class Node {
		int data;
		Node prev;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = this.prev = null;
		}
	}

	Node insertAtStart(Node head, int data) {
		if (head == null) {
			head = new Node(data);
			return head;
		}
		Node newHead = new Node(data);

		newHead.next = head;
		newHead.prev = null;

		head.prev = newHead;

		return newHead;

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

	Node insertBefore(Node head, Node next, int data) {

		if (next == null) {
			System.out.println("SERIOUSLY DUDE!!!" + "\n" + "you gotta check your next, it is null."
					+ "So.. i am returning null,You are on your own.");
			return null;
		}
		Node newNode = new Node(data);

		newNode.next = next;
		if (next.prev != null) {
			newNode.prev = next.prev;
		} else {
			head = newNode;
		}
		Node prev = next.prev;
		next.prev = newNode;

		if (prev != null)
			prev.next = newNode;

		return head;

	}

	void print(Node head) {
		while (head != null) {
			System.out.print(head.data + "\t");
			head = head.next;
		}

	}
	
	Node deleteNode(Node head,Node node){
		if(head==node){
			head = head.next;
			head.prev.next=null;
			head.prev = null;
			return head;
		}
		Node prev = node.prev;
		Node next = node.next;
		
		node.prev=node.next=null;
		
		if(prev!=null)
			prev.next = next;
		
		if(next!=null)
			next.prev = prev;
		
		return head;				
	}
	
	void recRev(Node node) {
		if (node == null) {
			return;
		}
		if (node.next == null)
			this.head = node;
		recRev(node.next);

		Node next = node.next;
		node.next = node.prev;
		node.prev = next;

	}
	
	Node mergeSort(Node node){
		
		if(node == null ||node.next == null)
			return node;
		
		Node middle = getMiddle(node);
		Node nextOfMiddle = middle.next;
		
		middle.next = null;
		nextOfMiddle.prev = null;
		
		Node left = mergeSort(node);
		Node right = mergeSort(nextOfMiddle);
		
		Node sortedList = merge(left,right);
		return sortedList;
	}
	
	private Node merge(Node left, Node right) {
		
		Node result;
		if(left==null)
			return right;
		if(right==null)
			return left;		
		if(left.data<right.data){
			result = left;
			result.next = merge(left.next,right);
			result.next.prev = result;
		}else{
			result = right;
			result.next = merge(left,right.next);
			result.next.prev = result;
		}
		
		return result;
	}

	private Node getMiddle(Node node) {

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
	void _quickSort(Node node,Node last){
		
		if(node==last || last==null || node==last.next)
			return;
		
		Node pivot = getPivot(node,last);
		Node nextOfPivot = pivot.next;
		//pivot.next = null;
		_quickSort(node,pivot.prev);
		_quickSort(nextOfPivot,last);
		
	}
	
	private Node getPivot(Node node,Node last){
		Node temp = last;
		int pivot = temp.data;
		Node pindex=node;
		temp = node;
		while(temp.next!=null){
			if(temp.data<pivot){
				int tempData = pindex.data;
				pindex.data = temp.data;
				temp.data = tempData;
				pindex = pindex.next;
			}
			temp = temp.next;
					
		}
		int tempData = last.data;
		last.data = pindex.data;
		pindex.data = tempData;
		
		return pindex;
	}
	
	void quickSort(Node node){
		Node last = node;
		while(last.next!=null)
			last=last.next;
		_quickSort(node,last);
	}
	
	
	
	
	
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		/*dll.head = dll.insertAtStart(dll.head, 5);
		dll.head = dll.insertAtStart(dll.head, 4);
		dll.head = dll.insertAtStart(dll.head, 3);
		dll.head = dll.insertAtStart(dll.head, 2);*/
		
		dll.head = dll.insertAtEnd(dll.head, 4);
		dll.head = dll.insertAtEnd(dll.head, 1);
		dll.head = dll.insertAtEnd(dll.head, 3);
		dll.head = dll.insertAtEnd(dll.head, 2);
		dll.head = dll.insertAtEnd(dll.head, 0);
		dll.head = dll.insertAtEnd(dll.head, 7);
		
		/*dll.head = new Node(5);
		Node next = dll.head;
		dll.head = dll.insertBefore(dll.head, dll.head, 1);
		dll.head = dll.insertBefore(dll.head, next, 3);
		
		//dll.head = dll.deleteNode(dll.head, dll.head);
		dll.head = dll.deleteNode(dll.head, dll.head.next);*/
		
		//dll.recRev(dll.head);
		dll.quickSort(dll.head);
		dll.print(dll.head);
	}

}











