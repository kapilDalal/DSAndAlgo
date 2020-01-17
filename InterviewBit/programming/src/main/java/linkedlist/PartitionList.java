package linkedlist;

import linkedlist.DeleteNodeFromLast.ListNode;

public class PartitionList {

	
	
	ListNode head;
	public ListNode partition(ListNode A, int B) {
		
		ListNode temp = A;
		head = A;
		while(temp!=null && temp.next!=null && temp.val<=B){
			temp = temp.next;
		}
		ListNode xPtr = temp;
		
		while(temp!=null){
			if(temp.next!=null && temp.next.val<B){
				int val = temp.next.val;
				temp.next = temp.next.next;
				xPtr = insertVal(xPtr,val);
			}
			temp = temp.next;
		}
		
		return head;
    }

	private ListNode insertVal(ListNode a, int val) {
		// TODO Auto-generated method stub
		ListNode next = a.next ;				
		ListNode node = new ListNode(val);
		a.next = node;
		node.next = next;
		return node;
		/*if(temp.val>val){
			
			node.next = temp;
			return node;
		}
		ListNode prev = null;
		while(temp.val<val){
			prev = temp;
			temp = temp.next;
		}
		prev.next = node;
		node.next = temp;		
		return a;*/
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
		PartitionList pl = new PartitionList();
		node = pl.partition(node, 6);
		printList(node);
	}
	
}
