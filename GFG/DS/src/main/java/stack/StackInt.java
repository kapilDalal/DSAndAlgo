package stack;

public class StackInt {
	
	private Integer[] arr;
	private int top;

	public StackInt(int capacity) {
		arr = new Integer[capacity];
		top = -1;
	}

	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}

	public boolean push(Integer data) {
		
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
		Integer popped = arr[top];
		top--;
		return popped;
	}

	public Integer peek() {
		if (top == -1)
			throw new ArrayIndexOutOfBoundsException();
		Integer popped = arr[top];
		return popped;
	}

}
