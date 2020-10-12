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
/*
1. If left subtree exists, process the left subtree
…..1.a) Recursively convert the left subtree to DLL.
…..1.b) Then find inorder predecessor of root in left subtree (inorder predecessor is rightmost node in left subtree).
…..1.c) Make inorder predecessor as previous of root and root as next of inorder predecessor.
2. If right subtree exists, process the right subtree (Below 3 steps are similar to left subtree).
…..2.a) Recursively convert the right subtree to DLL.
…..2.b) Then find inorder successor of root in right subtree (inorder successor is leftmost node in right subtree).
…..2.c) Make inorder successor as next of root and root as previous of inorder successor.
3. Find the leftmost node and return it (the leftmost node is always head of converted DLL).
* */
    static class Node{
        Node left, right;
        public int data;
        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    Node bintree2listUtil(Node node)
    {
        // Base case
        if (node == null)
            return node;

        // Convert the left subtree and link to root
        if (node.left != null)
        {
            // Convert the left subtree
            Node left = bintree2listUtil(node.left);

            // Find inorder predecessor. After this loop, left
            // will point to the inorder predecessor
            for (; left.right != null; left = left.right);

            // Make root as next of the predecessor
            left.right = node;

            // Make predecssor as previous of root
            node.left = left;
        }

        // Convert the right subtree and link to root
        if (node.right != null)
        {
            // Convert the right subtree
            Node right = bintree2listUtil(node.right);

            // Find inorder successor. After this loop, right
            // will point to the inorder successor
            for (; right.left != null; right = right.left);

            // Make root as previous of successor
            right.left = node;

            // Make successor as next of root
            node.right = right;
        }

        return node;
    }

    // The main function that first calls bintree2listUtil(), then follows
    // step 3 of the above algorithm

    Node bintree2list(Node node)
    {
        // Base case
        if (node == null)
            return node;

        // Convert to DLL using bintree2listUtil()
        node = bintree2listUtil(node);

        // bintree2listUtil() returns root node of the converted
        // DLL.  We need pointer to the leftmost node which is
        // head of the constructed DLL, so move to the leftmost node
        while (node.left != null)
            node = node.left;

        return node;
    }

    public void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data+"\t");
        inorder(root.right);
    }



    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(25);
        root.left.left = new Node(12);
        root.left.right = new Node(37);

        root.right = new Node(75);
        root.right.left = new Node(62);
        root.right.right = new Node(87);
        BiNode bn = new BiNode();
        bn.inorder(root);



    }
}
