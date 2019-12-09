package tree;

import java.util.ArrayList;

public class KthSmallestNumber {

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

	static public void inorder(TreeNode node, ArrayList<Integer> list) {

		if (node == null)
			return;
		inorder(node.left, list);
		if (node != null)
			list.add(node.val);
		inorder(node.right, list);
	}

	static public int kthsmallest(TreeNode A, int B) {
		ArrayList<Integer> list = new ArrayList<>();
		inorder(A, list);
		//System.out.println(list);
		return list.get(B-1);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(7);
		root.left.left = new TreeNode(6);
		root.left.left.left = new TreeNode(4);
		root.left.left.left.left = new TreeNode(3);
		root.left.left.left.right = new TreeNode(5);
		root.right = new TreeNode(9);
		root.right.right = new TreeNode(11);
		root.right.right.right = new TreeNode(12);
		root.right.right.left = new TreeNode(10);
		
		System.out.println(kthsmallest(root, 4));
	}

}
