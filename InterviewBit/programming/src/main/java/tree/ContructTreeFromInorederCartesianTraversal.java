package tree;

import java.util.ArrayList;
import java.util.Arrays;

import tree.IsSymmetric.TreeNode;

public class ContructTreeFromInorederCartesianTraversal {

	public TreeNode buildTree(ArrayList<Integer> A) {
		TreeNode node = build(A, 0, A.size());
		return node;
	}

	public TreeNode build(ArrayList<Integer> A, int left, int right) {
		if(A.size()==1)
			return new TreeNode(A.get(0));
		if (left < right) {
			int max = getMax(A);
			TreeNode node = new TreeNode(A.get(max));
			if(left<=right)
				node.left = build(new ArrayList<Integer>(A.subList(0, max)), 0, max - 1);
			else
				node.left = null;
			if(max+1<=right)
				node.right = build(new ArrayList<Integer>(A.subList(max+1, A.size())), max + 1, A.size());
			else
				node.right = null;
			return node;
		}
		return null;
	}

	private int getMax(ArrayList<Integer> a) {
		// TODO Auto-generated method stub
		if (a.size() == 1)
			return 0;
		int maxIndex = 0;
		for (int i = 1; i < a.size(); i++)
			maxIndex = a.get(i) > a.get(maxIndex) ? i : maxIndex;
		return maxIndex;
	}

	static void pre(TreeNode node){
		if(node==null)
			return;
		System.out.print(node.val+"\t");
		pre(node.left);
		
		pre(node.right);
	}
	public static void main(String[] args) {
		ContructTreeFromInorederCartesianTraversal a = new ContructTreeFromInorederCartesianTraversal();
		TreeNode node = a.buildTree(new ArrayList<Integer>(Arrays.asList(2, 1, 3)));
		pre(node);
	}

}
