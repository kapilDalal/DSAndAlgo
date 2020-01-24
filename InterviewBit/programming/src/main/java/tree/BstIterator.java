package tree;

import java.util.LinkedList;
import java.util.Queue;

import tree.IsSymmetric.TreeNode;

public class BstIterator {
	
	static public class Solution {

		Queue<Integer> q = new LinkedList<Integer>();
	    public Solution(TreeNode root) {
	        init(root,q);
	    }
	    public void init(TreeNode root,Queue<Integer> q){
	        if(root==null)
	            return;
	        init(root.left,q);
	        q.add(root.val);
	        init(root.right,q);
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        if(!q.isEmpty())
	            return true;
	        return false;
	    }

	    /** @return the next smallest number */
	    public int next() {
	        return q.poll();
	    }
	}
	public static void main(String[] args) {
		
	}

}
