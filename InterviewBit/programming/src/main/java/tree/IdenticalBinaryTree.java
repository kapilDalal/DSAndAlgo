package tree;

public class IdenticalBinaryTree {

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

	static public int isSameTree(TreeNode a, TreeNode b) {

		if (a == null && b == null) {
			return 1;
		}
		if (a == null || b == null) {
			return 0;
		}
		if (a.val != b.val) {
			return 0;
		}
		return isSameTree(a.right, b.right) & isSameTree(a.left, b.left);
	}

	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);

		TreeNode B = new TreeNode(1);
		B.left = new TreeNode(2);
		B.right = new TreeNode(3);

		System.out.println(isSameTree(A, B));

	}

}
