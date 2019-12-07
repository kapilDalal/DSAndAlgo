package tree;

import tree.IdenticalBinaryTree.TreeNode;

public class IsSymmetric {
	
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
	public int isSymmetric(TreeNode A) {		
		return isSymmetricUtil(A.left, A.right);
    }
	
	public int isSymmetricUtil(TreeNode A,TreeNode B) {
		if(A==null && B==null)
			return 1;
		if(A==null || B==null)
			return 0;
		if(A.val!=B.val)
			return 0;
		return isSymmetricUtil(A.left,B.right) & isSymmetricUtil(A.right, B.left);
		
    }
	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(2);
		A.left.left = new TreeNode(3);
		A.right.right = new TreeNode(3);
		A.left.right = new TreeNode(4);
		//A.right.left = new TreeNode(4);
		IsSymmetric s = new IsSymmetric();
		System.out.println(s.isSymmetric(A));
	}

}
