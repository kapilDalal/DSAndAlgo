package challenge.monthly.November;

public class BinaryNumberToInt_1 {

    
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public int getDecimalValue(ListNode head) {
        String res = "";
        while(head!=null){
            res = res + head.val;
        }
        Integer r = Integer.parseInt(res,2);
        return r;
    }


}
