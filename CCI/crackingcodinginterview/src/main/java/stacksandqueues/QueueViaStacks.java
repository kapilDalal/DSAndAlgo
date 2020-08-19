package stacksandqueues;

import java.util.*;

public class QueueViaStacks {
	Stack<Integer> s1;
	Stack<Integer> s2;

	public QueueViaStacks() {
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}

	public int poll() {
		if (!s1.isEmpty()) {
			return s1.pop();
		}
		return -1;
	}

	public void add(int val) {
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s2.push(val);
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	public static void main(String[] args) {
		QueueViaStacks qs = new QueueViaStacks();
		qs.add(1);
		qs.add(2);
		qs.add(3);
		
		System.out.println(qs.poll());
		System.out.println(qs.poll());
		System.out.println(qs.poll());
	}

}
