package treesandgraphs;

public class ValidateBST {
	
	//min = Integer.MIN_VALUE; max = Integer.MAX_VALUE;
	public static boolean isValid(TreeNode root,int min,int max) {
		
		if(root==null)
			return true;
		
		if(root.val<min || root.val>max)
			return false;
		
		return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
		
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.getTree();
		System.out.println(isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	

}
