package tree;

import java.util.Stack;

import tree.IsSymmetric.TreeNode;

public class TwoNodesSumEqualsK {

	static public int t2Sum(TreeNode A, int B) {

		Stack<TreeNode> ls = new Stack<TreeNode>();
		Stack<TreeNode> rs = new Stack<TreeNode>();

		TreeNode leftNode = A, rightNode = A;

		while (!ls.isEmpty() || !rs.isEmpty() ||   leftNode != null && rightNode != null && leftNode.val <= rightNode.val) {
			while (leftNode != null) {
				ls.push(leftNode);
				leftNode = leftNode.left;
			}
			while (rightNode != null) {
				rs.push(rightNode);
				rightNode = rightNode.right;
			}
			TreeNode start = null, end = null;
			if (!ls.isEmpty())
				start = ls.pop();
			if (!rs.isEmpty())
				end = rs.pop();
			if (start != null && end != null && start!=end) {
				if (start.val + end.val == B)
					return 1;

				else if (start.val + end.val < B) {
					rs.push(end);
					leftNode = start.right;
				} else {
					ls.push(start);
					rightNode = end.left;
				}
			}
		}

		return 0;
	}
	
	public static void main(String[] args) {
		TreeNode A = new TreeNode(10);
		A.left =new TreeNode(9);
		A.right = new TreeNode(20);
		System.out.println(t2Sum(A,18));
	}

}
