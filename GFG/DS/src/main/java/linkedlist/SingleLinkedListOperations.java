package linkedlist;

public class SingleLinkedListOperations {
	Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		
		SingleLinkedListOperations linkedList = new SingleLinkedListOperations();
		linkedList.head = new Node(0);
		

	}

}
