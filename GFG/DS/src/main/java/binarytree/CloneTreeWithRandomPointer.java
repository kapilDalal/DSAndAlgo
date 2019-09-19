package binarytree;

import java.util.HashMap;



public class CloneTreeWithRandomPointer {

	static class Node {
		int data;
		Node left, right, random;

		public Node(int data) {
			this.data = data;
			this.left = this.right = this.random = null;
		}
	}
	
	static Node cloneLeftAndRightChild(Node root,HashMap<Node,Node> map){
		
		if(root == null)
			return null;
		Node node = new Node(root.data);
		
		map.put(root, node);
		
		node.left = cloneLeftAndRightChild(root.left, map);
		node.right = cloneLeftAndRightChild(root.right, map);
		
		return node;
		
	}
	
	static void setRandomPointers(Node root,Node clone,HashMap<Node,Node> map){
		if(clone==null)
			return;
		clone.random = map.get(root.random);
		
		setRandomPointers(root.left, clone.left, map);
		setRandomPointers(root.right, clone.right, map);
					
	}
	
	static Node cloneTree(Node root){
		HashMap<Node,Node> map = new HashMap<Node,Node>();
		
		if(root==null)
			return null;
		
		Node node = cloneLeftAndRightChild(root, map);
		setRandomPointers(root, node, map);
		
		return node;
		
	}
	static void inorder(Node node){
		if(node==null)
			return;
		inorder(node.left);
		System.out.print("node data="+node.data);
		if(node.random!=null)
			System.out.print("\trandom data = "+node.random.data);
		else
			System.out.print("\trandom data = "+node.random);
		System.out.println();
		inorder(node.right);
	}
	
	static void modifyTree(Node node){
		if(node==null)
			return;
		modifyTree(node.left);
		modifyTree(node.right);
		
		Node leftChild = node.left;
		node.left = new Node(node.data);
		Node clone = node.left;
		clone.left = leftChild;
		
		if(node.right!=null)
			clone.right = node.right.left;
		
	}
	
	private static void setRandom(Node node) {
		if(node==null)
			return;
		if(node.random!=null)
			node.left.random = node.random.left;
		if(node.left!=null)
			setRandom(node.left.left);
		setRandom(node.right);		
	}
	private static void takeOutCloneFromTree(Node root, Node clone) {
		if(root==null)
			return;
		if(root.left!=null)
			root.left = root.left.left;
		if(clone.left!=null)
			clone.left = clone.left.left;
		takeOutCloneFromTree(root.left, clone.left);
		takeOutCloneFromTree(root.right, clone.right);
		
	}
	static Node cloneTreeByModifyingOriginalTree(Node root){
		modifyTree(root);
		setRandom(root);
		Node clone = root.left;
		takeOutCloneFromTree(root,clone);
		
		return clone;
		
	}
	

	

	public static void main(String[] args) {
		
		// TREE 1 
        /* Construct the following tree 
              26 (random 6)
             /   \ 
            10     3 
           /    \     \ 
          4      6      3 (random  30)
           \ 
            30 (random 26) */
		Node root1 = new Node(26);
		
        root1.right = new Node(3); 
        root1.right.right = new Node(3); 
        root1.left = new Node(10); 
        root1.left.left = new Node(4); 
        root1.left.left.right = new Node(30);
        root1.left.right = new Node(6);
        root1.random = root1.left.right;
        root1.right.right.random = root1.left.left.right;
        root1.left.left.right.random = root1;
        
       /* Node clone = cloneTree(root1);
        System.out.println(root1);
        System.out.println(clone);
        System.out.println();
        inorder(root1);
        System.out.println();
        inorder(clone);*/
        
        Node clone = cloneTreeByModifyingOriginalTree(root1);
        inorder(root1);
		System.out.println();
		inorder(clone);
		
		System.out.println();
		System.out.println(root1);
		System.out.println(clone);
        
        

	}

}
