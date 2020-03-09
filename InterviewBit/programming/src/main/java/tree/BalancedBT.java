package tree;

import tree.IsSymmetric.TreeNode;

public class BalancedBT {
	
	public int isBalanced(TreeNode A) {
		if(A==null)
			return 1;
		if(notBalanced(A))
			return 0;
		return (isBalanced(A.left)==1 && isBalanced(A.right)==1 ? 1 : 0 );
    }

	private boolean notBalanced(TreeNode a) {
		// TODO Auto-generated method stub
		int leftHeight = height(a.left);
		int rightHeight = height(a.right);
		if(Math.abs(leftHeight-rightHeight)>1)
			return true;
		return false;
	}

	private int height(TreeNode node) {
		// TODO Auto-generated method stub
		if(node == null)
			return 0;
		return Math.max(height(node.left), height(node.right))+1;
	}

}
