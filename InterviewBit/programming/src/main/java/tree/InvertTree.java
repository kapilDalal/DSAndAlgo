package tree;

import java.util.ArrayList;
import java.util.List;

public class InvertTree {
	
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
	
	/*public static void invert(TreeNode A){
		
		List<TreeNode> q = new ArrayList<TreeNode>();
		if(A!=null)
			q.add(A);
		
		while(!q.isEmpty()){
			
			int start = 0;
			int end = q.size()-1;
			while(start<end){
				
				int data = q.get(start).val;
				q.get(start).val = q.get(end).val;
				q.get(end).val = data;
				
				start++;
				end--;
				
			}
			for(int i=0;i<q.size();i++){
				TreeNode node = q.get(i);
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
				q.remove(0);
			}
		}
		
	}*/
	static public void invert(TreeNode A){
        if(A==null)
            return;
        
        if(A.left!=null && A.right!=null){
            TreeNode data = A.left;
            A.left = A.right;
            A.right = data;
        }
        invert(A.left);
        invert(A.right);
        
        
    }
	static public void inorder(TreeNode node){
		if(node==null)
			return;
		inorder(node.left);
		System.out.print(node.val+"\t");
		inorder(node.right);
	}
	
	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(6);
		A.right.right = new TreeNode(7);
		inorder(A);
		invert(A);
		System.out.println();
		inorder(A);
	}

}
