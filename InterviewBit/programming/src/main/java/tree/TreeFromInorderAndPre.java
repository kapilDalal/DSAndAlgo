package tree;

import java.util.ArrayList;
import java.util.Arrays;

import tree.IsSymmetric.TreeNode;

public class TreeFromInorderAndPre {

	
	
	static public TreeNode construct(ArrayList<Integer> A, ArrayList<Integer> B) {
		return build(A,B,0,A.size()-1);
    }

	private static TreeNode build(ArrayList<Integer> in, ArrayList<Integer> pre, int left, int right) {
		// TODO Auto-generated method stub
		if(left<=right){
			int rootIndex = findRootIndex(in,pre,left,right);
			TreeNode node = new TreeNode(in.get(rootIndex));
			node.left = build(in, pre, left, rootIndex-1);
			node.right = build(in, pre, rootIndex+1, right);
			return node;
		}
		return null;
	}

	private static int findRootIndex(ArrayList<Integer> in, ArrayList<Integer> pre, int left, int right) {
		// TODO Auto-generated method stub
		int res = left;
		int index = Integer.MAX_VALUE;
		for(int i=left;i<=right;i++){
			if(pre.indexOf(in.get(i))<index){
				index = pre.indexOf(in.get(i));
				res = i;
			}
		}		
		return res;
	}
	static void inorder(TreeNode node){
		if(node==null)
			return;
		inorder(node.left);
		System.out.print(node.val+"\t");
		inorder(node.right);
	}
	static void pre(TreeNode node){
		if(node ==null)
			return;
		System.out.print(node.val+"\t");
		pre(node.left);
		pre(node.right);
	}
	
	
	//optimised
	public static int rIdx = 0;       
    public TreeNode buildTree(ArrayList<Integer> pre, ArrayList<Integer> in) {
        if (pre.isEmpty() || in.isEmpty()) {return null;}
        if (rIdx > pre.size()) {return null;}
        TreeNode root = new TreeNode(pre.get(rIdx++));
        if (in.size() == 1) {return root;}
        int idx = in.indexOf(root.val);
        root.left = buildTree(pre, new ArrayList<>(in.subList(0, idx)));
        root.right = buildTree(pre, new ArrayList<>(in.subList(idx + 1, in.size())));
        return root;
    }
	
	
	
	public static void main(String[] args) {
		TreeNode node = construct(new ArrayList<Integer>(Arrays.asList(5, 6, 1, 2, 3, 4 )), new ArrayList<Integer>(Arrays.asList(2, 1, 6, 5, 3, 4)));
		inorder(node);
		System.out.println();
		pre(node);
	}
}
