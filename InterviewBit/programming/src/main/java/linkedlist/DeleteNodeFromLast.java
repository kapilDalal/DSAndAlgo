package linkedlist;

public class DeleteNodeFromLast {

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	static public ListNode removeNthFromEnd(ListNode A, int B) {
		
		ListNode node = A;
		int len=0;
		while(node!=null){
			len++;
			node=node.next;
		}
		int toDelete = len-B;
		System.out.println(toDelete);
		if(toDelete<=0)
			return A.next;
		int i=1;
		ListNode d = A;
		while(i<toDelete){
			d = d.next;
			i++;
		}
		d.next = d.next.next;
		return A;
    }
	static void printList(ListNode a){
		while(a!=null){
			System.out.print(a.val+"\t");
			a = a.next;
		}
	}
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		/*node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);*/
		node = removeNthFromEnd(node, 4);
		printList(node);
	}

}
