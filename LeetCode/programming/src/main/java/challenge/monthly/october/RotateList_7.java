package challenge.monthly.october;
/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
* */
public class RotateList_7 {


    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(k==0)
                return head;
            ListNode temp = head;
            int len = 0;
            while(temp!=null){
                temp = temp.next;
                len++;
            }
            if(len==0)
                return head;
            k = k%len;
            if(k==0)
                return head;
            k = len-k;
            temp = head;
            while(temp!=null && k>=1){
                temp = temp.next;
                k--;
            }
            ListNode head1 = head;
            ListNode head2 = head;
            while(head2!=null && head2.next!=temp)
                head2 = head2.next;
            head2.next = null;

            head = temp;
            while(temp!=null && temp.next!=null){
                temp = temp.next;
            }
            temp.next = head1;
            return head;


        }
    }

}
