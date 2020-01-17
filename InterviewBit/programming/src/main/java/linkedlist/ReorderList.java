package linkedlist;

import linkedlist.DeleteNodeFromLast.ListNode;

public class ReorderList {
	
	public ListNode reorderList(ListNode A) {
		
		int len = len(A);
		if(len<=2)
			return A;
		//System.out.println(len);
		ListNode half = A;
		
		for(int i=1;i<len/2;i++){
			half = half.next;
		}
		
		ListNode next = half.next;
		half.next = null;
		half = next;
		
		half = reverse(half);
		
		ListNode start = A;
		
		while(start!=null && half!=null){
			ListNode temp = half.next;
			ListNode startNext = start.next;
			start.next = half;
			half.next = startNext;
			half = temp;
			start = start.next.next;
		}
		if(half!=null){
			ListNode l = A;			
			while(l.next!=null){
				l = l.next;
			}
			l.next = half;
		}
			
		
			
		return A;
		
    }

	private ListNode reverse(ListNode half) {
		// TODO Auto-generated method stub
		ListNode curr = half;
		ListNode next = curr.next;
		ListNode prev = null;
		while(next!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}		
		return prev;
	}

	private int len(ListNode a) {
		// TODO Auto-generated method stub
		
		int len=0;
		while(a!=null){
			len++;
			a = a.next;
		}
		
		return len;
	}
	static void printList(ListNode a){
		while(a!=null){
			System.out.print(a.val+"\t");
			a = a.next;
		}
	}
	public static void main(String[] args) {
		ReorderList rl = new ReorderList();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		//node.next.next = new ListNode(3);
		/*node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(6);*/
		printList(node);
		System.out.println();
		node = rl.reorderList(node);
		printList(node);
		//node = rl.reverse(node);
		System.out.println();
		
	}

}
