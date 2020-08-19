package treesandgraphs;

public class Successor {

	public static TreeNode getSuccessor(TreeNode node) {
		if(node==null)
			return node;
		
		if(node.right==null) {
			TreeNode parent = node.parent;
			while(parent!=null && parent.val < node.val)
				parent = parent.parent;			
			return parent;		
		}
		
		node = node.right;
		while(node.left!=null)
			node = node.left;		
		return node;
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.getBiggerTreeWithParentPointers();
		root = root.left.left.left;
		
		while(root!=null) {
			System.out.println(root.val);
			root = getSuccessor(root);			
		}
	}
	
}
