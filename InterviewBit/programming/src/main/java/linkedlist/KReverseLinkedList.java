package linkedlist;

import linkedlist.DeleteNodeFromLast.ListNode;

public class KReverseLinkedList {
	ListNode nextHead;
	public ListNode kReverse(ListNode A,int B){
		ListNode a = new ListNode(-1);
		int len = len(A);
		if(B>len || B<=1)
			return A;
		int numOfBatches = len/B;
		ListNode temp = a;
		nextHead = A;
		while(numOfBatches>0){
			temp.next = reverse(nextHead,B);			
			int cnt = 0;
			while(cnt<B){
				temp = temp.next;
				cnt++;
			}
			/*if(numOfBatches==len/K)
				temp = temp.next;
*/			numOfBatches--;
		}
		if(nextHead!=null)
			temp.next = nextHead;
		return a.next;
	}

	private ListNode reverse(ListNode a, int k) {
		// TODO Auto-generated method stub
		
		ListNode next = null;
		ListNode curr = a;
		ListNode prev = null;
		int cnt = 0;
		
		while(curr!=null && cnt<k){
			
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr =next;
			cnt++;
		}
		nextHead = curr;
		
		return prev;
	}

	private int len(ListNode a) {
		// TODO Auto-generated method stub
		int len = 0;
		while(a!=null){
			len++;
			a=a.next;
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
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(6);
		node.next.next.next.next.next.next = new ListNode(7);
		KReverseLinkedList krl = new KReverseLinkedList();
		printList(node);
		node = krl.kReverse(node, 3);
		System.out.println();
		printList(node);
	}

}
