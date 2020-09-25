package challenge.monthly.september;

/*
Given a node from a Circular Linked List which is sorted in ascending order,
write a function to insert a value insertVal into the list such that it remains
a sorted circular list. The given node can be a reference to any single node in the list,
and may not be necessarily the smallest value in the circular list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value.
After the insertion, the circular list should remain sorted.

If the list is empty (i.e., given node is null), you should create a new single circular list and
return the reference to that single node. Otherwise, you should return the original given node.

Input: head = [3,4,1], insertVal = 2
Output: [3,4,1,2]
Explanation: In the figure above, there is a sorted circular list of three elements.
You are given a reference to the node with value 3, and we need to insert 2 into the list.
The new node should be inserted between node 1 and node 3.
After the insertion, the list should look like this, and we should still return node 3.

* */

public class InsertCircularList_23 {


    // Definition for a Node.
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    public Node insert(Node head, int insertVal) {

        if(head==null){
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        if(head.next==head){
            head.next = new Node(insertVal);
            head.next.next = head;
            return head;
        }

        Node temp = head;
        temp = temp.next;

        while(temp!=head){

            if(insertVal>=temp.val && insertVal<=temp.next.val){
                Node next = temp.next;
                temp.next = new Node(insertVal);
                temp.next.next = next;
                return head;
            }

            temp = temp.next;
        }

        if(insertVal>=temp.val && insertVal<=temp.next.val){
            Node next = temp.next;
            temp.next = new Node(insertVal);
            temp.next.next = next;
            return head;
        }

        while(temp.next!=head && temp.next.val>=temp.val)
            temp = temp.next;

        Node next = temp.next;
        temp.next = new Node(insertVal);
        temp.next.next = next;

        return head;

    }
}
