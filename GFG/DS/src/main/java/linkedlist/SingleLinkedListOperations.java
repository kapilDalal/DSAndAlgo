package linkedlist;

public class SingleLinkedListOperations {
	static Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void print(Node head) {
		if (head == null)
			return;
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	public int length(Node head){
		int lengthOfLinkedList = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			lengthOfLinkedList++;
		}
		return lengthOfLinkedList;
	}

	public Node push(Node head, int data, int pos) {

		int lengthOfLinkedList = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			lengthOfLinkedList++;
		}
		if (pos > lengthOfLinkedList + 1) {
			System.out.println("Unable to insert as pos is greater than linked list length plus one");
			return head;
		}
		if (pos == 1)
			head = addNodeFront(head, data);
		else if (pos == lengthOfLinkedList + 1)
			head = append(head, data);
		else {
			temp = head;
			int cnt = 0;
			Node prev = temp;
			while (cnt < pos - 1) {
				prev = temp;
				temp = temp.next;
				cnt++;
			}
			Node next = prev.next;
			prev.next = new Node(data);
			prev.next.next = next;
		}
		return head;
	}

	public Node append(Node head, int data) {
		if (head == null) {
			head = new Node(data);
			return head;
		}
		Node temp = head;
		while (temp.next != null)
			temp = temp.next;
		temp.next = new Node(data);

		return head;
	}

	public Node addNodeFront(Node head, int data) {
		if (head == null) {
			head = new Node(data);
			return head;
		}

		Node node = new Node(data);
		node.next = head;
		head = node;

		return head;
	}

	public Node deleteKey(Node head, int key) {

		if (head == null)
			return head;

		Node temp = head;
		Node prev = null;

		if (head.data == key) {
			head = head.next;
			return head;
		}

		while (temp.data != key && temp != null) {
			prev = temp;
			temp = temp.next;
		}
		if (temp == null)
			return head;

		prev.next = temp.next;

		return head;

	}
	
	public Node deleteNode(Node head,int position){
		
		int cnt = 0;
		Node temp = head;
		Node prev = temp;		
		if(position>length(head)-1)
			System.out.println("position is greater than length, enter a valid position");
		else if(position<0)
			System.out.println("position is less than zero, enter a valid position");
		else{
			while(cnt<position && temp!=null){
				prev = temp;
				temp = temp.next;
				cnt++;
			}
			if(prev == temp)
				head = head.next;
			else
				prev.next = temp.next;									
		}
		
		
		return head;
	}

	public static void main(String[] args) {

		SingleLinkedListOperations linkedList = new SingleLinkedListOperations();
		head = new Node(0);
		head = linkedList.append(head, 1);
		head = linkedList.append(head, 2);
		head = linkedList.append(head, 3);
		head = linkedList.addNodeFront(head, -1);
		head = linkedList.push(head, 5, 6);
		// head = linkedList.push(head, 6, 8);
		head = linkedList.push(head, -2, 1);
		head = linkedList.push(head, 6, 8);
		head = linkedList.push(head, 89, 3);
		//head = linkedList.deleteKey(head, 3);
		//head = linkedList.deleteNode(head, 9);
		linkedList.print(head);

	}

}
