package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
	  
	 static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) {
	       val = x;
	       left=null;
	       right=null;
	      }
	  }
	 
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(A==null)
			return res;		
		Queue<TreeNode> q2 = new LinkedList<>();
		q2.add(A);
		res.add(new ArrayList<Integer>(Arrays.asList(A.val)));
		while(!q2.isEmpty()){
			Queue<TreeNode> q1 = new LinkedList<>();
			for(;!q2.isEmpty();){
				TreeNode node = q2.poll();
				if(node.left!=null)
					q1.add(node.left);
				if(node.right!=null)
					q1.add(node.right);
			}
			q2 = new LinkedList<>(q1);
			ArrayList<Integer> list = new ArrayList<>();
			while(!q1.isEmpty()){
				TreeNode node = q1.poll();
				list.add(node.val);
			}
			if(!list.isEmpty())
			res.add(list);
		}
		
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
		LevelOrderTraversal lot = new LevelOrderTraversal();
		System.out.println(lot.levelOrder(A));
	}

}
