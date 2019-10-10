package binarysearchtree;

import binarysearchtree.SearchAndInsert.Node;

public class CorrectBstAfterTwoNodesSwap {

	//commented the code need to invest some more time in this approach.
	/*static void inorderList(Node node, ArrayList<Node> list) {
		if (node == null)
			return;
		inorderList(node.left, list);
		if (node != null)
			list.add(node);
		inorderList(node.right, list);
	}

	static void correctBst(Node root) {
		ArrayList<Node> list = new ArrayList<Node>();
		inorderList(root, list);		
		Node node1, node2;
		node1 = node2 = null;

		for (int i = 1; i < list.size(); i++) {
			if(i+1<list.size())
			if ((list.get(i).data > list.get(i - 1).data && list.get(i).data>list.get(i+1).data)||
					(list.get(i).data < list.get(i - 1).data && list.get(i).data<list.get(i+1).data)) {
				if (node1 == null)
					node1 = list.get(i);
				else
					node2 = list.get(i);
			}

		}

		if(node2==null){
			if(list.get(list.size()-1).data<list.get(list.size()-2).data)
				node2 = list.get(list.size());
		}
		
		if (node1 != null && node2 != null) {
			int temp = node1.data;
			node1.data = node2.data;
			node2.data = temp;
		}
		
		if(node2==null){
			int index = list.indexOf(node1);
			node2 = list.get(index-1);
			int temp = node1.data;
			node1.data = node2.data;
			node2.data = temp;
		}
		
	}*/
	
	static void inorder(Node node){
		if(node==null)
			return;
		inorder(node.left);
		System.out.print(node.data+"\t");
		inorder(node.right);
	}
	
	static Node first,mid,last,prev;
	
	static void correctBstUtilGFG(Node root){
		if(root!=null){
			correctBstUtilGFG(root.left);
			if(prev!=null && root.data<prev.data){
				if(first==null){
					first = prev;
					mid = root;
				}
				else
					last = root;
			}
			prev = root;
			correctBstUtilGFG(root.right);
		}
	}
	
	static void correctBstGFG(Node root){
		first = mid = last = prev = null;
		correctBstUtilGFG(root);
		if(last==null){
			int temp = first.data;
			first.data = mid.data;
			mid.data = temp;
		}else{
			int temp = first.data;
			first.data = last.data;
			last.data = temp;
		}
	}
	
	public static void main(String[] args) {
			/*   6 
		        / \ 
		       2   10
		      / \ / \ 
		     1  3 7 12 
	      
	    	10 and 2 are swapped */
		 
		
		Node root = new Node(6); 
        root.left = new Node(12); 
        root.right = new Node(10); 
        root.left.left = new Node(1); 
        root.left.right = new Node(3); 
        root.right.right = new Node(2); 
        root.right.left = new Node(7);
        inorder(root);
        correctBstGFG(root);
        System.out.println();
        inorder(root);
	}

}
