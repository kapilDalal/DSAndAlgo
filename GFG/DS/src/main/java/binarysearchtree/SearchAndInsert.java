package binarysearchtree;

public class SearchAndInsert {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static Node insert(Node head, int data) {
		if (head == null) {
			head = new Node(data);
			return head;
		}
		if (data < head.data)
			head.left = insert(head.left, data);
		else
			head.right = insert(head.right, data);

		return head;
	}

	static Node search(Node root, int data) {
		if (root == null || root.data == data)
			return root;
		if (root.data < data)
			return search(root.right, data);
		return search(root.left, data);
	}

	static void inorder(Node head) {
		if (head == null)
			return;
		inorder(head.left);
		System.out.print(head.data + "\t");
		inorder(head.right);
	}

	static Node getBst() {
		Node head = insert(null, 8);
		head = insert(head, 7);
		head = insert(head, 6);
		head = insert(head, 4);
		head = insert(head, 5);
		head = insert(head, 3);
		head = insert(head, 9);
		head = insert(head, 11);
		head = insert(head, 10);
		head = insert(head, 12);
		return head;
	}

	public static void main(String[] args) {
		Node head = insert(null, 8);
		head = insert(head, 7);
		head = insert(head, 6);
		head = insert(head, 4);
		head = insert(head, 5);
		head = insert(head, 3);
		head = insert(head, 9);
		head = insert(head, 11);
		head = insert(head, 10);
		head = insert(head, 12);

		inorder(head);
		Node node = search(head, 10);
		System.out.println();
		System.out.println(node.data);
	}
}
