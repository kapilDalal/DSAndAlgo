package stack;

public class Stack {

	private Integer[] arr;
	private int top;

	public Stack(int capacity) {
		arr = new Integer[capacity];
		top = -1;
	}

	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}

	public boolean push(int data) {
		
		if (top < arr.length-1) {
			top = top + 1;
			arr[top] = data;
			return true;
		}
		return false;
	}

	public Integer pop() {
		if (top == -1)
			throw new ArrayIndexOutOfBoundsException();
		int popped = arr[top];
		top--;
		return popped;
	}

	public Integer peek() {
		if (top == -1)
			throw new ArrayIndexOutOfBoundsException();
		int popped = arr[top];
		return popped;
	}

}
