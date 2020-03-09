package tree;

import tree.IsSymmetric.TreeNode;

public class SortedArrayToBalancedBst {
	
	public TreeNode buildTree(int[] A) {
		TreeNode node = build(A, 0, A.length);
		return node;
	}

	private TreeNode build(int[] a, int left, int right) {
		// TODO Auto-generated method stub
		if((left+right)/2>=a.length)
			return null;
		while(left<=right){
			int mid = (left+right)/2;
			TreeNode node = new TreeNode(a[mid]);
			node.left = build(a, left, mid-1);
			node.right = build(a, mid+1, right);
			return node;
		}
		return null;
	}
	static void inorder(TreeNode node){
		if(node==null)
			return;
		inorder(node.left);
		System.out.print(node.val+"\t");
		inorder(node.right);
	}
	public static void main(String[] args) {
		SortedArrayToBalancedBst sb = new SortedArrayToBalancedBst();
		//TreeNode node = sb.buildTree(new ArrayList<Integer>(Arrays.asList()));
		//inorder(node);
	}

}
