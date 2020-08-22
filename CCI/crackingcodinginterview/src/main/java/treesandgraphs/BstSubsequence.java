package treesandgraphs;

import java.util.*;

public class BstSubsequence {
	
	//ArrayList<LinkedList<Integer>> res = new ArrayList<LinkedList<Integer>>();
	
	public ArrayList<LinkedList<Integer>> generateSequences(TreeNode node) {
		
		ArrayList<LinkedList<Integer>> res = new ArrayList<LinkedList<Integer>>();
		
		if(node==null) {
			res.add(new LinkedList<Integer>());
			return res;
		}
		LinkedList<Integer> prefix = new LinkedList<Integer>();;
		
		prefix.addLast(node.val);
		
		ArrayList<LinkedList<Integer>> left = generateSequences(node.left);
		ArrayList<LinkedList<Integer>> right = generateSequences(node.right);
		
		for(LinkedList<Integer> l : left) {
			for(LinkedList<Integer> r: right) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weave(l,r,prefix,weaved);
				res.addAll(weaved);
			}
		}
		
		
		return res;
		
		
	}
	
	
	private void weave(LinkedList<Integer> l, LinkedList<Integer> r,
			LinkedList<Integer> prefix, ArrayList<LinkedList<Integer>> weaved) {
		// TODO Auto-generated method stub
		if(l.size()==0 || r.size()==0)
		{			
			LinkedList<Integer> p = (LinkedList<Integer>)prefix.clone();
			p.addAll(l);
			p.addAll(r);
			weaved.add(p);			
			return ;			
		}
		
		
		
		int f = l.removeFirst();
		prefix.addLast(f);
		weave(l, r, prefix,weaved);
		prefix.removeLast();
		l.addFirst(f);
		
		int s = r.removeLast();
		prefix.addLast(s);
		weave(l, r, prefix, weaved);
		prefix.removeLast();
		r.addFirst(s);
		
		
	}


	public static void main(String[] args) 
	{
		BstSubsequence seq = new BstSubsequence();
		TreeNode node = TreeNode.getBiggerTree();
		ArrayList<LinkedList<Integer>> generateSequences = seq.generateSequences(node);
		System.out.println(generateSequences);
		
	}

}
