package treesandgraphs;

import java.util.ArrayList;
import java.util.HashMap;

public class PathsWithSum {
	
	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	
	public void findAllPathWithSum(TreeNode node,int sum) {
		if(node==null)
			return;		
		addPaths(node,sum,new ArrayList<Integer>());
		findAllPathWithSum(node.left, sum);
		findAllPathWithSum(node.right, sum);
	}
	
	public void addPaths(TreeNode node,int sum,ArrayList<Integer> l) {
		if(sum==0) {				
			if(!res.contains(l))
				res.add(new ArrayList<Integer>(l));			
		}
		if(node==null)
			return;		
		l.add(node.val);
		addPaths(node.left, sum - node.val, new ArrayList<Integer>(l));
		addPaths(node.right, sum - node.val, new ArrayList<Integer>(l));
	}
	
	
	//optimized cci approach.
	public int countPathWithSum(TreeNode root,int taget)
	{
		return countPathWithSumUtil(root,0,taget,new HashMap<Integer,Integer>());
	}
	
	private int countPathWithSumUtil(TreeNode node, int runningSum, int taget, HashMap<Integer, Integer> map) {
		// TODO Auto-generated method stub
		if(node==null)
			return 0;
		
		runningSum += node.val;
		
		int totalPaths = map.getOrDefault(runningSum-taget, 0);
		
		if(runningSum==taget)
			totalPaths++;
		
		//increment hash count
		int count = map.getOrDefault(runningSum, 0);
		map.put(runningSum,count+1);
		
		totalPaths += countPathWithSumUtil(node.left, runningSum, taget, map);
		totalPaths += countPathWithSumUtil(node.right, runningSum, taget, map);
				
		return totalPaths;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(23);
		node.left = new TreeNode(-2);
		node.left.left = new TreeNode(4);
		node.left.left.left = new TreeNode(21);
		
		node.right = new TreeNode(2);
		node.right.left = new TreeNode(-25);
		node.right.left.right = new TreeNode(25);
		
		PathsWithSum ps = new PathsWithSum();
		ps.findAllPathWithSum(node, 25);
		System.out.println(ps.res.size());
		System.out.println(ps.countPathWithSum(node, 25));
	}

}
