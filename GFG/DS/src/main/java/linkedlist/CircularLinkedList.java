package linkedlist;

public class CircularLinkedList {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	Node insertAtBeginning(Node last, int data) {
		if (last == null) {
			Node node = new Node(data);
			node.next = node;
			return node;
		}

		Node head = last.next;
		last.next = new Node(data);
		last.next.next = head;

		return last;
	}

	Node insertAtEnd(Node last, int data) {
		if (last == null) {
			last = new Node(data);
			last.next = last;
			return last;
		}

		Node head = last.next;
		last.next = new Node(data);
		last.next.next = head;
		last = last.next;
		return last;

	}

	Node insertAfter(Node last, int dataToInsert, int target) {
		Node temp = last;
		while (temp.data != target && temp.next != last)
			temp = temp.next;

		if (temp.data == target) {
			Node tempNext = temp.next;
			temp.next = new Node(dataToInsert);
			temp.next.next = tempNext;
			if (temp == last)
				last = last.next;
		}
		return last;
	}

	void printCLL(Node last) {
		Node head = last.next;
		Node temp = head;
		do {
			System.out.print(head.data + "\t");
			head = head.next;
		} while (head != temp);
	}

	Node getMiddle(Node last) {
		Node slowptr = last.next;
		Node fastptr = last.next.next;

		while (fastptr != last) {
			fastptr = fastptr.next;
			if (fastptr != last) {
				slowptr = slowptr.next;
				fastptr = fastptr.next;
			}
		}
		return slowptr;
	}

	static Node last1;
	static Node last2;

	void split(Node last) {
		Node middle = getMiddle(last);
		Node head = last.next;
		last1 = middle;

		last.next = middle.next;

		last1.next = head;
		last2 = last;

	}
	
	Node sortedInsert(Node last,int data){
		if(last==null){
			last = new Node(data);
			last.next = last;
			return last;
		}
		
		Node head = last.next;
		Node temp = head;
		Node earlier = null;
		while(data>head.data && head.next!=temp){
			earlier = head;
			head=head.next;
		}	
		if(earlier==null){
			Node headOld = last.next;
			last.next = new Node(data);
			last.next.next = headOld;
			return last;
		}
		if(head==last && data>last.data){
			head = last.next;
			last.next = new Node(data);
			last.next.next = head;
			last = last.next;
			return last;
		}
		
		Node next = earlier.next;
		earlier.next= new Node(data);
		earlier.next.next = next;
			
		return last;
		
	}
	
	

	public static void main(String[] args) {

		CircularLinkedList cll = new CircularLinkedList();
		Node last = null;
		/*last = cll.insertAtEnd(last, 4);
		last = cll.insertAtEnd(last, 3);
		last = cll.insertAtEnd(last, 2);
		last = cll.insertAtEnd(last, 1);
		last = cll.insertAfter(last, 0, 1);
		last = cll.insertAfter(last, -2, 2);
		last = cll.insertAfter(last, -3, 3);
		last = cll.insertAfter(last, -4, 4);
		last = cll.insertAfter(last, -1, 1);
		last = cll.insertAfter(last, -8, -1);

		cll.printCLL(last);
		System.out.println();
		

		cll.split(last);

		cll.printCLL(last1);
		System.out.println();
		cll.printCLL(last2);
		System.out.println();*/
		
		last = cll.sortedInsert(last, 5);
		last = cll.sortedInsert(last, 2);
		last = cll.sortedInsert(last, 4);
		last = cll.sortedInsert(last, 1);
		last = cll.sortedInsert(last, 3);
		//last = cll.sortedInsert(last, 6);
		cll.printCLL(last);
		

	}

}
