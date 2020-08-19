package treesandgraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepths {
	
	public static List<LinkedList<TreeNode>> listOfDepths(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> ld = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);		
		while(!q.isEmpty()) {			
			int size = q.size();
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			for(int i=0;i<size;i++) {
				TreeNode poll = q.poll();
				list.add(poll);
				if(poll.left!=null)
					q.add(poll.left);
				if(poll.right!=null)
					q.add(poll.right);
			}
			ld.add(list);
			
		}		
		return ld;
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.getBiggerTree();
		List<LinkedList<TreeNode>> ld = listOfDepths(root);
		Iterator<LinkedList<TreeNode>> iterator = ld.iterator();
		while(iterator.hasNext()) {
			LinkedList<TreeNode> list = iterator.next();
			Iterator<TreeNode> iterator2 = list.iterator();
			while(iterator2.hasNext())
				System.out.print(iterator2.next().val+"\t");
			
			System.out.println();
		}
		
	}

}
