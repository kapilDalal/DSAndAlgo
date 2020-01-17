package linkedlist;

import java.util.ArrayList;

import linkedlist.DeleteNodeFromLast.ListNode;



public class RemoveDuplicatesII {
	
	 public ListNode deleteDuplicates(ListNode A) {
	        ListNode temp = A;
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        
	        while(temp!=null && temp.next!=null){
	            if(temp.val==temp.next.val){
	                if(!list.contains(temp.val))
	                    list.add(temp.val);
	                temp.next = temp.next.next;
	            }
	            else{
	                temp = temp.next;
	            }
	        }
	        if(A!=null && list.contains(A.val)){
	            while(A!=null && list.contains(A.val))
	                A = A.next;
	        }
	        ListNode temp1 = A;
	        while(temp1!=null && temp1.next!=null){
	            if(list.contains(temp1.next.val))
	                temp1.next = temp1.next.next;
	            else
	                temp1 = temp1.next;
	        }
	        return A;
	    }

}
