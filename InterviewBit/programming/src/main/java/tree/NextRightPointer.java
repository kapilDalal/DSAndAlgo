package tree;

import java.util.LinkedList;
import java.util.Queue;

public class NextRightPointer {

	static public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		
		Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
		if(root!=null){
			q.add(root);
			q.add(null);
		}
		while(!q.isEmpty()){
			int n = q.size();
			TreeLinkNode node;
			for(int i=0;i<n;i++){
				node = q.poll();
				if(node!=null){
				node.next = q.peek();
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
				}				
			}
			if(q.peek()!=null)
				q.add(null);
		}

	}
	public void pre(TreeLinkNode node){
		if(node == null)
			return;
		System.out.print(node.val+"\t");
		if(node.next!=null)
			System.out.println(node.next.val);
		else
			System.out.println("null");
		pre(node.left);
		pre(node.right);
	}
	public static void main(String[] args) {
		TreeLinkNode node = new TreeLinkNode(1);
		node.left = new TreeLinkNode(2);
		node.right = new TreeLinkNode(3);
		node.left.left = new TreeLinkNode(4);
		node.right.right = new TreeLinkNode(5);
		NextRightPointer nrp = new NextRightPointer();
		nrp.connect(node);
		nrp.pre(node);
	}

}
