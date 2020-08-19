package stacksandqueues;

import java.util.Stack;

public class SortStack {
	
	public void sort(Stack<Integer> s) {
		if(s.isEmpty() || s.size()==1)
			return;
		int top = s.pop();
		if(top<s.peek()) {
			sort(s);
			s.push(top);
		}
		else {
			adjustTop(top,s);
			sort(s);
		}
		
	}

	private void adjustTop(int top, Stack<Integer> s) {
		// TODO Auto-generated method stub
		Stack<Integer> s2 = new Stack<Integer>();
		while(!s.isEmpty() && s.peek()<top)
			s2.push(s.pop());
		s.push(top);
		while(!s2.isEmpty())
			s.push(s2.pop());
		
	}
	
	public void popAll(Stack<Integer> s) {
		while(!s.isEmpty())
			System.out.println(s.pop());
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(6);
		s.push(5);
		SortStack ss = new SortStack();
		ss.sort(s);
		ss.popAll(s);
		
	}

}
