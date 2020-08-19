package treesandgraphs;

public class Subtree {
	
	public boolean isSubtree(TreeNode n1, TreeNode n2) {
		if(n1==null || n2==null)
			return false;
		if(n1.val==n2.val)
			if(checkSubtree(n1,n2))
				return true;
		return isSubtree(n1.left, n2) || isSubtree(n1.right, n2);
	}

	private boolean checkSubtree(TreeNode n1, TreeNode n2) {
		// TODO Auto-generated method stub
		if(n2==null)
			return true;
		if(n1==null)
			return false;
		if(n1.val!=n2.val)
			return false;
		return checkSubtree(n1.left, n2.left) && checkSubtree(n1.right, n2.right);
	}
	
	public static void main(String[] args) {
		TreeNode n1 = TreeNode.getBiggerTree();
		TreeNode n2 = TreeNode.getTree();
		Subtree sub = new Subtree();
		System.out.println(sub.isSubtree(n1, n2));
	}

}
