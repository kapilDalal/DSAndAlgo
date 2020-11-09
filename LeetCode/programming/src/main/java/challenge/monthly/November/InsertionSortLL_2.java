package challenge.monthly.November;




public class InsertionSortLL_2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode insertionSortList(ListNode head) {
        if(head==null)
            return null;
        ListNode temp = head;
        temp = temp.next;
        while(temp!=null){

            int val = temp.val;

            ListNode t = head;

            while(t!=temp && t.val<val){
                t = t.next;
            }
            if(t!=temp){

                while(t!=temp){
                    int v = t.val;
                    t.val = val;
                    val = v;
                    t = t.next;
                }
                int v = t.val;
                t.val = val;
                val = v;

            }
            temp = temp.next;

        }

        return head;
    }

    static void printll(ListNode node){
        while(node!=null){
            System.out.print(node.val+"\t");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(-3);
        InsertionSortLL_2 is = new InsertionSortLL_2();
        head = is.insertionSortList(head);
        printll(head);
    }
    
}
