package stack;

public class Stack {

	private Character[] arr;
	private int top;

	public Stack(int capacity) {
		arr = new Character[capacity];
		top = -1;
	}

	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}

	public boolean push(char data) {
		
		if (top < arr.length-1) {
			top = top + 1;
			arr[top] = data;
			return true;
		}
		return false;
	}

	public char pop() {
		if (top == -1)
			throw new ArrayIndexOutOfBoundsException();
		char popped = arr[top];
		top--;
		return popped;
	}

	public char peek() {
		if (top == -1)
			throw new ArrayIndexOutOfBoundsException();
		char popped = arr[top];
		return popped;
	}

}
