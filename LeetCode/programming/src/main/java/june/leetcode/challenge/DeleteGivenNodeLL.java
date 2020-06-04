package june.leetcode.challenge;

public class DeleteGivenNodeLL {

	
	  
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	 public void deleteNode(ListNode node) {
	        ListNode prev = null;
	        while(node!=null && node.next!=null){
	            node.val = node.next.val;
	            prev = node;
	            node = node.next;
	        }
	        if(prev!=null)
	            prev.next=null;
	        
	    }
}
