package treesandgraphs;

import java.util.ArrayList;

//operations are done assuming it is bst.
public class RandomNodeTree {

	ArrayList<TreeNode> listOfNodesInTree;

	public RandomNodeTree() {
		listOfNodesInTree = new ArrayList<TreeNode>();
	}

	public TreeNode insert(TreeNode root, int val) {
		TreeNode node = new TreeNode(val);
		insertInList(node);
		return insertInTree(root, node);
	}

	public TreeNode find(TreeNode root, int val) {
		if (root == null)
			return null;
		if (root.val == val)
			return root;
		if (root.val < val)
			return find(root.right, val);
		return find(root.left, val);
	}
	//missed this - should also remove the node from list
	public TreeNode delete(TreeNode root,int val) {
		if(root.val==val)
		{
			if(root.left==null && root.right==null)
				return null;
			
			if(root.left==null)
				return root.right;
			
			if(root.right==null)
				return root.left;
			
			int successor = getSuccessorVal(root);
			root.val = successor;
			root.right =  delete(root.right,successor);
			return root;
		}
		if(root.val<val)
			root.right = delete(root.right, val);
		else
			root.left = delete(root.left, val);
		
		return root;
	}
	
	public TreeNode getRandomNode()
	{
		int index = (int) (Math.random() * listOfNodesInTree.size());
		return listOfNodesInTree.get(index);
	}

	private int getSuccessorVal(TreeNode root) {
		// TODO Auto-generated method stub
		root = root.right;
		while(root.left!=null)
			root = root.left;
		return root.val;
	}

	private TreeNode insertInTree(TreeNode root, TreeNode node) {
		// TODO Auto-generated method stub
		if (root == null)
			return node;
		if (root.val > node.val)
			root.left = insertInTree(root.left, node);
		else
			root.right = insertInTree(root.right, node);
		return root;
	}

	private void insertInList(TreeNode node) {
		// TODO Auto-generated method stub
		listOfNodesInTree.add(node);
	}

	public void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.val+"\t");
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		RandomNodeTree rt = new RandomNodeTree();
		TreeNode root = rt.insert(null, 20);
		root = rt.insert(root, 15);
		root = rt.insert(root, 25);
		root = rt.insert(root, 22);
		root = rt.insert(root, 30);
		root = rt.insert(root, 10);
		root = rt.insert(root, 17);
		
		rt.inorder(root);
		
		root = rt.delete(root, 25);
		System.out.println();
		rt.inorder(root);
	}

}
