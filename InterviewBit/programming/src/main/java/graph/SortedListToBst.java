package graph;

import java.util.ArrayList;
import java.util.Arrays;

import graph.LevelOrderTraversal.TreeNode;

public class SortedListToBst {
	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	static TreeNode llToBst(ListNode a){
		if(a==null)
			return null;
		int n = len(a);
		if(n>1){
			ListNode mid = getMid(a,n);
			ListNode right = mid.next.next;
			TreeNode node = new TreeNode(mid.next.val);
			mid.next = null;
			node.left = llToBst(a);
			node.right = llToBst(right);
			return node;
		}
		else if(n==1){
			return new TreeNode(a.val);
		}
		return null;
	}

	private static ListNode getMid(ListNode a, int n) {
		// TODO Auto-generated method stub
		int mid = n/2 - 1;		
		for(int i=1;i<=mid;i++){
			a = a.next;
		}		
		return a;
	}

	private static int len(ListNode a) {
		// TODO Auto-generated method stub
		int len = 0;
		while(a!=null){
			a = a.next;
			len++;
		}
		return len;
	}

	static TreeNode toBst(ArrayList<Integer> list) {		
		
		if (list.size() > 1) {
			int mid = list.size() / 2;
			TreeNode node = new TreeNode(list.get(mid));
			node.left = toBst(new ArrayList<Integer>(list.subList(0, mid)));
			node.right = toBst(new ArrayList<Integer>(list.subList(mid + 1, list.size())));
			return node;
		} else if (list.size() == 1)
			return new TreeNode(list.get(0));

		return null;
	}

	static void preorder(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.val);
		preorder(node.left);
		preorder(node.right);
	}

	public static void main(String[] args) {
		/*TreeNode node = toBst(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
		preorder(node);*/
		ListNode head = new ListNode(1);
		//head.next = new ListNode(2);
		//head.next.next = new ListNode(3);
		/*head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);*/
		TreeNode node = llToBst(head);
		preorder(node);
	}

}
