package challenge.monthly.November;

public class AddLinkedLists_7 {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        ListNode temp = res;
        while (l1!=null && l1!=null){
            int r = l1.val + l2.val + carry;
            carry = r/10;
            temp.next = new ListNode(r%10);
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }

        while (l1!=null){
            int r = l1.val + carry;
            carry = r/10;
            temp.next = new ListNode(r%10);
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2!=null){
            int r = l2.val + carry;
            carry = r/10;
            temp.next = new ListNode(r%10);
            temp = temp.next;
            l2 = l2.next;
        }

        temp.next = new ListNode(carry);

        temp = res;
        res = res.next;
        temp.next = null;
        res = reverse(res);
        while (res!=null && res.val==0 && res.next!=null)
            res = res.next;

        return res;
    }

    private static ListNode reverse(ListNode node){
          if(node==null)
              return null;
          ListNode curr = node;
          ListNode prev = null;
          ListNode next = node.next;

          while(curr!=null){
              curr.next = prev;
              prev = curr;
              curr = next;
              if(next!=null)
                next = next.next;
          }
          return prev;
    }

    static void printLL(ListNode node){
          while (node!=null){
              System.out.print(node.val+"\t");
              node = node.next;
          }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        //head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
      //  head.next.next.next = new ListNode(3);
        printLL(head);
        System.out.println();
        head = reverse(head);
        printLL(head);
    }

}
