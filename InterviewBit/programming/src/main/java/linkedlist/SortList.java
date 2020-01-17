package linkedlist;

import java.util.Stack;

import linkedlist.DeleteNodeFromLast.ListNode;

public class SortList {

	
	public ListNode sort(ListNode A){
		
		int len = len(A);
		if(len>=2){			
			ListNode mid = mid(A,len);
			ListNode left = A;
			ListNode right = mid.next;
			mid.next = null;
			left = sort(left);
			right = sort(right);
			return merge(left,right);
		}
		
		
		return A;
	}
	
	private ListNode merge(ListNode left, ListNode right) {
		// TODO Auto-generated method stub
		ListNode temp = new ListNode(-1);
		ListNode a=temp;
		while(left!=null && right!=null){
			if(left.val<right.val){
				temp.next = left;
				left = left.next;
			}
			else{
				temp.next = right;
				right = right.next;
			}
			temp = temp.next;
		}
		while(left!=null){
			temp.next = left;
			left = left.next;
			temp = temp.next;
		}
		while(right!=null){
			temp.next = right;
			right = right.next;
			temp = temp.next;
		}				
		return a.next;
	}

	private ListNode mid(ListNode a, int len) {
		// TODO Auto-generated method stub
		
		int mid = len/2;
		
		while(mid>1){
			a = a.next;
			mid--;
		}
		
		return a;
	}

	private int len(ListNode a) {
		// TODO Auto-generated method stub
		int len = 0;
		while(a!=null){
			len++;
			a=a.next;
		}
		return len;
	}
	
	static void printList(ListNode a){
		while(a!=null){
			System.out.print(a.val+"\t");
			a = a.next;
		}
	}
	
	
	public static void main(String[] args) {
		ListNode node = new ListNode(4);
		node.next = new ListNode(1);
		node.next.next = new ListNode(5);
		node.next.next.next = new ListNode(2);
		/*node.next.next.next.next = new ListNode(7);
		node.next.next.next.next.next = new ListNode(3);*/
		SortList sl = new SortList();
		String str = ")()))(())((())))))())()(((((())())((()())(())((((())))())((()()))(()(((()()(()((()()))(())()))(((";
		// System.out.println(sl.longestValidParentheses(str));;
		node = sl.sort(node);
		
		//printList(node);
	}
	
}
