package tree;

import java.util.ArrayList;
import java.util.Stack;

public class InorderWithoutRecursion {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
	
	static public ArrayList<Integer> inorderTraversal(TreeNode A) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		TreeNode node = A;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(!stack.isEmpty() || node!=null){
			
			while(node!=null){				
				res.add(node.val);
				stack.push(node);
				node = node.left;
				
			}
			TreeNode temp = null;
			if(node==null){			
				temp = stack.pop();
				
			}
			if(temp!=null && temp.right!=null)
				node = temp.right;
			
		}
		//System.out.println(res);
		return res;
    }

	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(6);
		A.right.right = new TreeNode(7);
		inorderTraversal(A);
	}
	
}
