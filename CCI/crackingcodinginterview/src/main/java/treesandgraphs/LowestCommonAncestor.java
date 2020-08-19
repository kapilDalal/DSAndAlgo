package treesandgraphs;

public class LowestCommonAncestor {
	
	public int lca(TreeNode root,int a,int b) {		
		boolean found = false;
		while(!found && root!=null) {			
			if(isAncestor(root.left,a,b))
				root = root.left;
			else if(isAncestor(root.right,a,b))
				root = root.right;
			else 
				found = true;			
		}
		return root.val;
	}

	private boolean isAncestor(TreeNode node,int a,int b) {
		// TODO Auto-generated method stub
		boolean aFound = isAncestorUtil(node,a);
		boolean bFound = isAncestorUtil(node,b);
		return aFound && bFound;
	}

	private boolean isAncestorUtil(TreeNode node, int a) {
		// TODO Auto-generated method stub
		if(node==null)
			return false;		
		if(node.val==a)
			return true;
		return isAncestorUtil(node.left, a) || isAncestorUtil(node.right, a);
	}
	public static void main(String[] args) {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		TreeNode root = TreeNode.getBiggerTree();
		System.out.println(lca.lca(root, 13, 19));
	}

}
