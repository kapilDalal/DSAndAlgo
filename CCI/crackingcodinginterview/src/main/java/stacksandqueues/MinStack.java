package stacksandqueues;

import java.util.Stack;

public class MinStack {

	Stack<Integer> s;
	Stack<Integer> m;

	public MinStack() {
		s = new Stack<Integer>();
		m = new Stack<Integer>();
	}

	public void push(int val) {
		s.push(val);
		if (!m.isEmpty() && m.peek() < val) {
			m.push(m.peek());
			return;
		}
		m.push(val);
	}

	public int pop() {
		if (!s.isEmpty()) {
			m.pop();
			return s.pop();

		}
		return -1;
	}

	public int getMin() {
		return m.peek();
	}

	public static void main(String[] args) {
		MinStack m = new MinStack();
		m.push(11);
		System.out.println(m.getMin());
		m.push(13);
		m.push(6);
		m.push(17);
		m.push(10);
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
		

	}

}
