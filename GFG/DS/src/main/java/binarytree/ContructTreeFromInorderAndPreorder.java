package binarytree;

public class ContructTreeFromInorderAndPreorder {

	static class Node {
		char data;
		Node left, right;

		public Node(char data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	private static int getInorderIndex(Character[] in, char preData) {
		for (int i = 0; i < in.length; i++) {
			if (in[i] == preData)
				return i;
		}
		return -1;
	}

	static void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.data + "\t");
		inorder(node.right);

	}
	static int preIndex = 0;
	static Node constructTree(Character[] in, Character[] pre, int start, int end) {
		if (start <= end ) {
			char preData = pre[preIndex++];
			int inIndex = getInorderIndex(in, preData);
			Node node = new Node(in[inIndex]);
			node.left = constructTree(in, pre, start, inIndex - 1);
			node.right = constructTree(in, pre, inIndex + 1, end);
			return node;
		} else{
			//preIndex = preIndex-1;
			return null;
		}
	}

	public static void main(String[] args) {
		Character in[] = { 'D', 'B', 'E', 'A', 'F', 'C' }; 
		Character pre[] = { 'A', 'B', 'D', 'E', 'C', 'F' }; 
	    
	    Node root = constructTree(in, pre, 0, in.length-1);
	    inorder(root);
	}

}
