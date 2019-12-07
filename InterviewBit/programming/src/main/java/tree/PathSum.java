package tree;

import java.util.ArrayList;
import java.util.HashSet;

import tree.IsSymmetric.TreeNode;

public class PathSum {
	
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
	
	public int hasPathSumUtil(TreeNode A, int B) {
		if(A==null)
			return 0;		
		if(A.left==null && A.right==null && B-A.val==0)
			return 1;
		int left = hasPathSumUtil(A.left, B-A.val);
		int right = hasPathSumUtil(A.right, B-A.val);
		
		return (left==1 || right==1) ? 1 : 0;
    }
	
	

	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		//A.left.left = new TreeNode(3);
		A.right.left = new TreeNode(4);
		A.right.left.right = new TreeNode(4);
		PathSum ps = new PathSum();
		System.out.println(ps.hasPathSumUtil(A, 3));
		
	}
	


}
