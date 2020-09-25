package hard;
/*
BiNode: Consider a simple data structure called BiNode, which has pointers to two other nodes.

public class BiNode {
    public BiNode node1, node2;
    public int data;
}

The data structure BiNode could be used to represent both a binary tree (where node1 is the left
node and node2 is the right node) or a doubly linked list (where node1 is the previous node and
node2 is the next node). Implement a method to convert a binary search tree (implemented with
BiNode) into a doubly linked list. The values should be kept in order and the operation should be
performed in place (that is, on the original data structure).

* */
public class BiNode {

    static class Node{
        Node node1,node2;
        public int data;
        public Node(int data){
            this.data = data;
            this.node1 = this.node2 = null;
        }
    }

    public void inorder(Node root){
        if(root==null)
            return;
        inorder(root.node1);
        System.out.print(root.data+"\t");
        inorder(root.node2);
    }

    Node dllHead = null;
    public void convertToDll(Node root,Node prev,Node next){
        if(root==null){
            return;
        }
        convertToDll(root.node1,prev,root);
        if(prev==null)
            dllHead = root;
        root.node1 = prev;
        Node temp = root.node2;
        root.node2 = next;
        convertToDll(temp,root,next);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.node1 = new Node(25);
        root.node1.node1 = new Node(12);
        root.node1.node2 = new Node(37);

        root.node2 = new Node(75);
        root.node2.node1 = new Node(62);
        root.node2.node2 = new Node(87);
        BiNode bn = new BiNode();
        bn.inorder(root);

        bn.convertToDll(root,null,null);
        while(bn.dllHead!=null){
            if(bn.dllHead.node1!=null)
                System.out.print("prev="+bn.dllHead.node1.data+"\t");
            else
                System.out.print("prev=null\t");
            if(bn.dllHead.node2!=null)
                System.out.println("next="+bn.dllHead.node2.data+"\t");
            else
                System.out.println("next=null\t");

            bn.dllHead = bn.dllHead.node2;
        }

    }
}
