package june.leetcode.challenge;

public class InvertBinaryTree {

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		invert(root);
		return root;
	}

	private void invert(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.left = temp;
		invert(root.left);
		invert(root.right);
	}

	public static void main(String[] args) {
		System.out.println("hey");
	}
}
