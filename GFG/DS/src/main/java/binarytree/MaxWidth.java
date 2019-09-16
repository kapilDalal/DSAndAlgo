package binarytree;

import java.util.LinkedList;
import java.util.Queue;

import binarytree.TreeTraversals.Node;

public class MaxWidth {

	@SuppressWarnings("unused")
	private static int width = 0;

	static int height(Node node) {
		if (node == null)
			return 0;
		int lh = height(node.left);
		int rh = height(node.right);
		return 1 + Math.max(lh, rh);
	}

	static int width(Node node, int start, int target) {
		if (start <= target) {
			if (node == null)
				return 0;
			if (start == target) {
				MaxWidth.width++;
				return 1;
			} else {
				return width(node.left, start + 1, target) + width(node.right, start + 1, target);
			}
		}
		return 0;
	}

	static int getMaxWidth(Node node) {
		if (node == null)
			return 0;
		int height = height(node);
		int maxWidth = 1;

		for (int i = 2; i <= height; i++) {
			MaxWidth.width = 0;
			int w = width(node, 0, i);
			if (maxWidth < w)
				maxWidth = w;
		}
		return maxWidth;
	}

	static int getMaxWidthUsingQueue(Node node) {
		if (node == null)
			return 0;
		Queue<Node> que = new LinkedList<Node>();
		que.add(node);
		int count = que.size();
		int maxWidth = count;
		while (!que.isEmpty() || count > 0) {
			while (count-- > 0) {
				Node dequeNode = que.poll();
				if (dequeNode.left != null)
					que.add(dequeNode.left);
				if (dequeNode.right != null)
					que.add(dequeNode.right);
			}
			count = que.size();
			if (count > maxWidth)
				maxWidth = count;
		}

		return maxWidth;
	}

	public static void main(String[] args) {

		Node root = TreeTraversals.getRoot();
		System.out.println(getMaxWidth(root));
		System.out.println(getMaxWidthUsingQueue(root));
	}

}
