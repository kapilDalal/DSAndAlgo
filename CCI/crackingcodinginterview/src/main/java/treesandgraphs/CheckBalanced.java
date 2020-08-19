package treesandgraphs;

public class CheckBalanced {
	
	private static int height(TreeNode root) {
		if(root==null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	public static boolean checkBalanced(TreeNode node) {
		if(node==null)
			return true;
		if(!isHeightBalanced(node))
			return false;
		return checkBalanced(node.left) && checkBalanced(node.right);
	}
	
	private static boolean isHeightBalanced(TreeNode node) {
		if(node==null)
			return true;
		int left = height(node.left);
		int right = height(node.right);
		return Math.abs(left-right)<=1 ? true : false;
	}
	
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.getBiggerTree();
		System.out.println(checkBalanced(root));
	}
	

}
