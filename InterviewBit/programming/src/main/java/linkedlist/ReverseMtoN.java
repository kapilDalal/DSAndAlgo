package linkedlist;

import linkedlist.DeleteNodeFromLast.ListNode;

public class ReverseMtoN {
	
	public ListNode reverseBetween(ListNode A, int B, int C) {
		
		int m = 1;
		ListNode temp = new ListNode(-1);
		temp.next = A;
		while(m<B){
			temp = temp.next;
			m++;
		}
		int cnt = C-B;
		ListNode curr = temp.next;
		ListNode next = null;
		ListNode prev = null;
		while(curr!=null && cnt>=0){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			cnt--;
		}
		ListNode revEnd = temp.next;
		temp.next = prev;
		if(B==1)
			A = prev;
		revEnd.next = next;		
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
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(6);
		node.next.next.next.next.next.next = new ListNode(7);
		ReverseMtoN rmn = new ReverseMtoN();
		node = rmn.reverseBetween(node, 3, 3);
		printList(node);
	}

}
