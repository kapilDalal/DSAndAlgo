package tree;

import java.util.ArrayList;
import java.util.Arrays;

import tree.IsSymmetric.TreeNode;

public class TreeFromInorderAndPost {

	static int postIndex = 0;
	static public TreeNode construct(ArrayList<Integer> A, ArrayList<Integer> B) {
		postIndex = B.size()-1;
		return build(A,B);
    }
	private static TreeNode build(ArrayList<Integer> in, ArrayList<Integer> post) {
		// TODO Auto-generated method stub
		if(in.isEmpty() || post.isEmpty())
			return null;
				
		if(postIndex<0)
			return null;
		
		TreeNode node = new TreeNode(post.get(postIndex--));
		int index = in.indexOf(node.val); 
		node.right = build(new ArrayList<Integer>(in.subList(index+1,in.size())), post);
		node.left = build(new ArrayList<Integer>(in.subList(0, index)), post);
		
		
		return node;
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
	public static void main(String[] args) {
		TreeNode node = construct(new ArrayList<Integer>(Arrays.asList(4,2,5,1,7,3)), new ArrayList<Integer>(Arrays.asList(4,5,2,7,3,1)));
		inorder(node);
		System.out.println();
		pre(node);
	}
	
}
