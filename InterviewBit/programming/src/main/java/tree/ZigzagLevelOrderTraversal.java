package tree;

import java.util.ArrayList;
import java.util.Collections;

import tree.IsSymmetric.TreeNode;

public class ZigzagLevelOrderTraversal {
	
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		
		int h = height(A);
		
		for(int i=0;i<h;i++){
			ArrayList<Integer> l = new ArrayList<>();
			levelOrder(i,A,l);
			if(i%2!=0)
				Collections.reverse(l);
			res.add(l);
		}
		//System.out.println(res);
		return res;
    }

	private void levelOrder(int i, TreeNode a, ArrayList<Integer> l) {
		// TODO Auto-generated method stub
		if(a==null)
			return;
		if(i==0)
			l.add(a.val);
		levelOrder(i-1, a.left, l);
		levelOrder(i-1, a.right, l);
	}

	private int height(TreeNode a) {		
		if(a==null)
			return 0;
		return Math.max(height(a.left), height(a.right))+1;
	}
	
	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.right.left = new TreeNode(5);
		A.right.left.left = new TreeNode(6);
		A.right.left.right = new TreeNode(7);
		ZigzagLevelOrderTraversal zlt = new ZigzagLevelOrderTraversal();
		zlt.zigzagLevelOrder(A);
	}

}
