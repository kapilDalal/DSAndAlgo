package treesandgraphs;

public class TreeNode {
	
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	
	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
	
	
	
	/*
	 * 			    21
	 * 			/		\
	 * 		   13		 49
	 * 			\		 /
	 * 			19      47
	 */
	
	public static TreeNode getTree() {
		TreeNode root = new TreeNode(21);
		root.left = new TreeNode(13);
		root.right = new TreeNode(49);
		root.left.right = new TreeNode(19);
		//root.left.right.left = new TreeNode(20);
		root.right.left = new TreeNode(47);
		return root;
	}
	
	public static TreeNode getTreeWithParentPointers() {
		TreeNode root = new TreeNode(21);
		root.parent = null;
		
		root.left = new TreeNode(13);
		root.left.parent = root;		
		
		root.right = new TreeNode(49);
		root.right.parent = root;
		
		
		root.left.right = new TreeNode(19);
		root.left.right.parent = root.left;
		//root.left.right.left = new TreeNode(20);
		root.right.left = new TreeNode(47);
		root.right.left.parent = root.right;
		return root;
	}
	
	
	
	
	
	
	/* 
	                 21
	              /       \
	  			 /         \    
	  			/   		\
	  		   /             \
	  		  13		     49
		  	/   \	    	 /
		   /     \          /
		   5     19         47
		  /	\
		 1	 8    
		  	    
	 */
	
	public static TreeNode getBiggerTree() {
		TreeNode root = new TreeNode(21);
		root.left = new TreeNode(13);		
		root.left.right = new TreeNode(19);
		root.left.left = new TreeNode(5);
		root.left.left.left = new TreeNode(1);
		root.left.left.right = new TreeNode(8);
		//root.left.left.right.right = new TreeNode(8);
		root.right = new TreeNode(49);
		root.right.left = new TreeNode(47);
		
		return root;
	}
	
	public static TreeNode getBiggerTreeWithParentPointers() {
		TreeNode root = new TreeNode(21);
		root.parent = null;
		
		root.left = new TreeNode(13);
		root.left.parent = root;
		
		root.left.right = new TreeNode(19);
		root.left.right.parent = root.left;
		
		root.left.left = new TreeNode(5);
		root.left.left.parent = root.left;
		
		root.left.left.left = new TreeNode(1);
		root.left.left.left.parent = root.left.left;
		
		root.left.left.right = new TreeNode(8);
		root.left.left.right.parent = root.left.left;
		//root.left.left.right.right = new TreeNode(8);
		root.right = new TreeNode(49);
		root.right.parent = root;
		
		root.right.left = new TreeNode(47);
		root.right.left.parent = root.right;
		
		return root;
	}
	
	
}
