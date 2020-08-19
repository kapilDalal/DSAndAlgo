package treesandgraphs;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimalTree {
	
	public TreeNode getBst(ArrayList<Integer> list) {
		if(list.size()==0)
			return null;
		int mid = list.size()/2;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = getBst(new ArrayList<>(list.subList(0, mid)));
		root.right = getBst(new ArrayList<>(list.subList(mid+1, list.size())));
		return root;
	}
	
	public void inorder(TreeNode root)
	{
		if(root==null)
			return;
		inorder(root.left);
		System.out.println(root.val);
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		MinimalTree mt = new MinimalTree();
		TreeNode root = mt.getBst(new ArrayList<Integer>(Arrays.asList(1,2,3)));
		mt.inorder(root);
	}
}
