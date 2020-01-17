package linkedlist;

import linkedlist.DeleteNodeFromLast.ListNode;

public class InsertionSortList {
	
	public ListNode insertionSortList(ListNode A) {
		ListNode temp = A;
		
		while(temp!=null){
			
			if(temp.next!=null && temp.val>temp.next.val){
				ListNode next = temp.next.next;
				A = insertAtStart(A,temp.next);
				temp.next = next;
			}else{
				temp = temp.next;
			}
			
		}
		
		
		return A;
    }

	private ListNode insertAtStart(ListNode a, ListNode node) {
		ListNode temp = a;		
		if(temp.val>node.val){
			node.next = temp;
			a= node;
		}else{
			while(temp.next.val<node.val){
				temp = temp.next;
			}
			ListNode next = temp.next;
			temp.next = node;
			node.next = next;
		}
		return a;
	}
	static void printList(ListNode a){
		while(a!=null){
			System.out.print(a.val+"\t");
			a = a.next;
		}
	}
	public static void main(String[] args) {
		ListNode node = new ListNode(4);
		node.next = new ListNode(1);
		node.next.next = new ListNode(5);
		node.next.next.next = new ListNode(2);
		node.next.next.next.next = new ListNode(7);
		node.next.next.next.next.next = new ListNode(2);
		InsertionSortList isl = new InsertionSortList();
		node = isl.insertionSortList(node);
		printList(node);
	}

}
