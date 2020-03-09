package dp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;



public class MaxPathSumTree {

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
	static public class Data{
		int ls;
		int rs;
		public Data(int l,int r){
			ls=l;
			rs=r;
		}
	}
	static HashMap<TreeNode,Data> map = new HashMap<>();
	
	static public int maxPathSum(TreeNode A) {
		if(A==null)
            return 0;
		int ls = maxPathSum(A.left);//Math.max(A.val,A.val + maxPathSum(A.left));
		int rs = maxPathSum(A.right);//Math.max(A.val, A.val + maxPathSum(A.right));
		if(ls==rs && ls==0){
			map.put(A, new Data(0,0));
		    return A.val;
		}
		map.put(A, new Data(ls,rs));
		return Math.max(Math.max(ls+A.val, rs+A.val),A.val);
    }
	
	public static void main(String[] args) {
		TreeNode A = new TreeNode(-200);
		A.left = new TreeNode(-100);
		A.left = new TreeNode(-300);
		A.left = new TreeNode(-400);
		maxPathSum(A);
		int max = Integer.MIN_VALUE;
		Iterator<Entry<TreeNode, Data>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<TreeNode, Data> next = iterator.next();
			int max1 = Math.max(next.getKey().val+ next.getValue().ls + next.getValue().rs,next.getKey().val);
			int max2 = Math.max(max1, next.getValue().ls+A.val);
			int max3 = Math.max(max2, next.getValue().rs+A.val);
			max = Math.max(max3, max);
		}
		System.out.println(max);
	}

}
