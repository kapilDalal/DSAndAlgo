package stack;

public class StackWithGetMidAndDeleteMid {
	private Node top;
	private int count;
	private Node mid;

	public StackWithGetMidAndDeleteMid() {
		this.top = null;
		this.count = 0;
		this.mid = null;
	}

	static class Node {
		Node next;
		Node prev;
		int data;

		public Node(int data) {
			this.data = data;
			this.next = this.prev = null;
		}
	}

	public void push(int data) {
		if (top == null) {
			top = new Node(data);
			this.count = 1;
			mid = top;
			return;
		}
		top.next = new Node(data);
		top.next.prev = top;
		top = top.next;

		this.count = this.count + 1;

		if (this.count % 2 == 0)
			mid = mid.next;

	}
	
	public void deletMid(){
		if(top.prev==null){
			top=null;
			return;
		}
		Node pre = mid.prev;
		Node next = mid.next;
		
		pre.next = next;
		next.prev = pre;
		this.count = this.count-1;
		mid = pre;
		
	}
	public int pop(){
		
		if(top==null)
			return -1;
		int data = top.data;
		top= top.prev;
		top.next.prev = null;
		top.next = null;
		
		this.count = this.count-1;
		
		if (this.count % 2 == 0)
			mid = mid.prev;
		
		return data;
	}
	

	public static void main(String[] args) {

		StackWithGetMidAndDeleteMid stack = new StackWithGetMidAndDeleteMid();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.deletMid();
		stack.push(5);
		stack.push(6);
		stack.deletMid();
		stack.push(7);
		

	}

}
