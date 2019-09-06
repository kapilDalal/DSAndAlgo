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

	public int length(Node head) {
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

	public Node deleteNode(Node head, int position) {

		int cnt = 0;
		Node temp = head;
		Node prev = temp;
		if (position > length(head) - 1)
			System.out.println("position is greater than length, enter a valid position");
		else if (position < 0)
			System.out.println("position is less than zero, enter a valid position");
		else {
			while (cnt < position && temp != null) {
				prev = temp;
				temp = temp.next;
				cnt++;
			}
			if (prev == temp)
				head = head.next;
			else
				prev.next = temp.next;
		}

		return head;
	}

	public static int lengthRec(Node head) {
		if (head == null)
			return 0;
		return lengthRec(head.next) + 1;
	}

	public Node getNode(Node head, int key) {
		Node node = head;
		while (node != null && node.data != key)
			node = node.next;
		return node;
	}

	public Node getPrev(Node head, Node node) {
		if (head == node)
			return null;
		while (head.next != null && head.next != node)
			head = head.next;
		if (head.next == null) {
			System.out.println("could not find the node");
			throw new IndexOutOfBoundsException();
		}
		return head;
	}

	Node recRev(Node prev, Node curr) {
		if (curr.next == null) {
			head = curr;
			curr.next = prev;
			return null;
		}
		recRev(curr, curr.next);
		curr.next = prev;
		return head;
	}

	Node itrRev(Node head) {
		if (head == null)
			return null;
		Node prev = null;
		Node next = null;
		Node curr = head;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}

	public Node swapNodes(Node head, int key1, int key2) {

		Node node1 = getNode(head, key1);
		Node node2 = getNode(head, key2);

		if (node1 == node2)
			return head;

		Node prev1 = getPrev(head, node1);
		Node prev2 = getPrev(head, node2);
		;

		if (prev1 != null)
			prev1.next = node2;
		else
			head = node2;

		if (prev2 != null)
			prev2.next = node1;
		else
			head = node1;

		Node temp = node2.next;
		node2.next = node1.next;
		node1.next = temp;

		return head;
	}
	
	

	Node mergeSortedLinkedList(Node head1, Node head2) {
		Node master;
		if (head1 == null && head2 == null)
			return null;
		if (head1 == null || head2 == null) {
			if (head1 == null)
				return head2;
			else
				return head1;
		}

		if (head1.data < head2.data) {
			master = head1;
			head1 = head1.next;
		} else {
			master = head2;
			head2 = head2.next;
		}
		Node temp = master;
		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				temp.next = head1;
				temp = temp.next;
				head1 = head1.next;
			} else {
				temp.next = head2;
				temp = temp.next;
				head2 = head2.next;
			}
		}
		if (head1 != null)
			temp.next = head1;
		else
			temp.next = head2;

		return master;
	}

	Node recMergeSortedLinkedList(Node head1, Node head2) {
		Node master = null;
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		if (head1.data <= head2.data) {
			master = head1;
			master.next = recMergeSortedLinkedList(head1.next, head2);
		} else {
			master = head2;
			master.next = recMergeSortedLinkedList(head1, head2.next);
		}

		return master;
	}

	Node batchReversal(Node node, int size) {
		Node curr = node;
		Node prev = null;
		Node next = null;
		int count = 0;
		while (curr != null && count < size) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if (curr != null) {
			node.next = batchReversal(curr, size);
		}
		return prev;
	}

	Node mergeSort(Node head) {

		int n = lengthRec(head);

		if (n < 2)
			return head;

		Node headTemp = head;
		int mid = n / 2;
		Node left = new Node(-1);
		Node leftTemp = left;
		Node right = new Node(-2);
		Node rightTemp = right;
		for (int i = 0; i < mid; i++) {
			leftTemp.next = new Node(headTemp.data);
			headTemp = headTemp.next;
			leftTemp = leftTemp.next;
		}
		while (headTemp != null) {
			rightTemp.next = new Node(headTemp.data);
			headTemp = headTemp.next;
			rightTemp = rightTemp.next;
		}
		left = left.next;
		right = right.next;

		left = mergeSort(left);
		right = mergeSort(right);

		Node sortedList = merge(head, left, right);
		return sortedList;
	}

	private Node merge(Node head2, Node left, Node right) {
		Node headtemp;
		if (left.data < right.data) {
			headtemp = left;
			left = left.next;
		} else {
			headtemp = right;
			right = right.next;
		}
		Node temp = headtemp;
		while (left != null && right != null) {
			if (left.data < right.data) {
				headtemp.next = left;
				left = left.next;
				headtemp = headtemp.next;
			} else {
				headtemp.next = right;
				right = right.next;
				headtemp = headtemp.next;
			}

		}
		if (left != null)
			headtemp.next = left;
		else
			headtemp.next = right;
		return temp;
	}

	Node mergeSortGFG(Node head) {

		if (head == null || head.next == null)
			return head;

		Node middle = getMiddle(head);
		Node nextOfMiddle = middle.next;
		middle.next = null;
		Node left = mergeSortGFG(head);
		Node right = mergeSortGFG(nextOfMiddle);

		Node sortedList = recMergeSortedLinkedList(left, right);
		return sortedList;

	}

	private Node getMiddle(Node head) {
		Node slowPtr;
		Node fastPtr;
		slowPtr = head;
		fastPtr = head.next;

		while (fastPtr != null) {
			fastPtr = fastPtr.next;
			if (fastPtr != null) {
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next;
			}
		}
		return slowPtr;
	}

	// returns 0 if no loop found else if loop found then removes it and returns
	// 1
	int detectAndRemoveLoop(Node head) {

		Node slow = head;
		Node fast = head.next;

		while (fast != null && fast.next != null && slow != null) {
			if (slow == fast) {
				removeloop(head, slow);
				return 1;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return 0;
	}

	private void removeloop(Node head2, Node slow) {

		Node ptr2 = slow;
		while (true) {

			while (ptr2.next != slow && ptr2.next != head2)
				ptr2 = ptr2.next;
			slow = ptr2;
			if (ptr2.next == head2) {
				ptr2.next = null;
				break;
			}
			head2 = head2.next;
		}

	}
	
	Node addTwoLinkedList(Node first,Node second){
		Node res=new Node(-1);
		Node temp = res;
		int carry=0;
		while(first!=null && second!=null){
			int sum = carry + first.data + second.data;
			carry = sum>=10 ? 1 : 0;
			int data = sum % 10;
			first = first.next;
			second = second.next;
			res.next = new Node(data);
			res = res.next;
		}
		
		while(first!=null){
			int sum = carry + first.data;			
			carry = sum>=10 ? 1 : 0;
			int data = sum % 10;
			first = first.next;
			res.next = new Node(data);
			res = res.next;
		}
		while(second!=null){
			int sum = carry + second.data;
			carry = sum>=10 ? 1 : 0;
			int data = sum % 10;
			second = second.next;
			res.next = new Node(data);
			res = res.next;
		}
		if(carry!=0)
			res.next = new Node(carry);
		return temp.next;
	}

	public Node swapNodes3Sept(Node head,int key1,int key2){
		
		Node currX = getNode(head,key1);
		Node currY = getNode(head,key2);
		
		Node prevX = getPrev(head,currX);
		Node prevY = getPrev(head,currY);
		
		if(prevX!=null)
			prevX.next = currY;
		else
			head = currY;
		
		if(prevY!=null)
			prevY.next = currX;
		else
			head = currX;
		
		
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
		
		
		return head;
	} 
	
	public void reverseRecursive3Sep(Node curr,Node prev){
		if(curr.next==null){
			head = curr;
			curr.next = prev;
			return;
		}
		reverseRecursive3Sep(curr.next,curr);
		curr.next = prev;			
	}
	static public void reverseIterative(Node head){
		Node curr = head;
		Node prev = null;
		Node next = null;
		
		while(curr!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		SingleLinkedListOperations.head = prev;
	}
	
	
	public static void main(String[] args) {

		SingleLinkedListOperations linkedList = new SingleLinkedListOperations();

		Node head2 = null;
		// head = new Node(0);
		/*
		 * head = linkedList.append(head, 1); head = linkedList.append(head, 4);
		 * head = linkedList.append(head, 7);
		 */
		head2 = linkedList.append(head2, 7);
		head2 = linkedList.append(head2, 5);
		head2 = linkedList.append(head2, 9);
		head2 = linkedList.append(head2, 4);
		head2 = linkedList.append(head2, 6);
		head = linkedList.append(head, 8);
		head = linkedList.append(head, 4);
//		head = linkedList.append(head, 2);
		/*
		 * head = linkedList.addNodeFront(head, -1); head =
		 * linkedList.push(head, 5, 6); // head = linkedList.push(head, 6, 8);
		 * head = linkedList.push(head, -2, 1); head = linkedList.push(head, 6,
		 * 8); head = linkedList.push(head, 89, 3);
		 */
		// head = linkedList.deleteKey(head, 3);
		// head = linkedList.deleteNode(head, 9);
		// head = linkedList.swapNodes(head, -2, -1);
		// head = linkedList.recRev(null, head);
		// head = linkedList.mergeSortedLinkedList(head, head2);
		// head = linkedList.recMergeSortedLinkedList(head, head2);
		// head = linkedList.itrRev(head);
		// head2=linkedList.mergeSortGFG(head2);
		//head2.next.next.next.next.next = head2.next;
		//linkedList.detectAndRemoveLoop(head2);
		head2 = linkedList.addTwoLinkedList(head, head2);
		linkedList.print(head2);
		// System.out.println(linkedList.detectAndRemoveLoop(head2));
	}

}
