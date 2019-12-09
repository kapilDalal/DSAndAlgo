package linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import linkedlist.DeleteNodeFromLast.ListNode;

public class DeleteDuplicates {

	public ListNode deleteDuplicates(ListNode A) {
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();

		while (A != null) {
			if (!set.contains(A.val)) {
				set.add(A.val);
				list.add(A.val);
			}
			A = A.next;
		}
		ListNode B = new ListNode(-1);
		ListNode temp = B;
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer val = iterator.next();
			temp.next = new ListNode(val);
			temp = temp.next;
		}
		return B.next;

	}
}
