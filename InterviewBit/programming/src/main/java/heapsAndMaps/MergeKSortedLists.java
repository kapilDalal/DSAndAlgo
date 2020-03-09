package heapsAndMaps;

import java.util.ArrayList;

public class MergeKSortedLists {

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	static public ListNode mergeKLists(ArrayList<ListNode> a) {
		while(a.size()>1){
			ListNode first = a.get(0);
			ListNode firstT = first;
			ListNode second = a.get(1);
			ListNode secondT = second;
			ListNode res = new ListNode(-1);
			ListNode temp = res;
			while(first!=null && second!=null){
				if(first.val<second.val){
					res.next = new ListNode(first.val);
					first = first.next;								
				}else{
					res.next = new ListNode(second.val);
					second = second.next;					
				}
				res = res.next;
			}
			
			while(first!=null){
				res.next = new ListNode(first.val);
				first = first.next;
				res = res.next;
			}
			
			while(second!=null){
				res.next = new ListNode(second.val);
				second = second.next;	
				res = res.next;
			}
			
			a.add(temp.next);
			a.remove(firstT);
			a.remove(secondT);
			
		}
		
		
		return a.get(0);
    }
	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		first.next = new ListNode(10);
		first.next.next = new ListNode(20);
		
		ListNode sec = new ListNode(4);
		sec.next = new ListNode(11);
		sec.next.next = new ListNode(13);
		
		ListNode third = new ListNode(3);
		third.next = new ListNode(8);
		third.next.next = new ListNode(9);
		
		ArrayList<ListNode> a = new ArrayList<>();
		a.add(first);
		a.add(sec);
		a.add(third);
		ListNode k = mergeKLists(a);
		System.out.println(k.val);
		
	}
}
