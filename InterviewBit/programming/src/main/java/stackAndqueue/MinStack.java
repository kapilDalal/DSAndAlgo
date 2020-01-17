package stackAndqueue;

import java.util.Stack;

public class MinStack {
	
	Stack<Integer> s = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();

	public void push(int x) {
		
		if(min.isEmpty()){			
			min.push(x);
		}
		else{
			if(min.peek()>x)
				min.push(x);
			else{
				min.push(min.peek());
			}
		}
		s.push(x);

	}

	public void pop() {

		if(!s.isEmpty()){
			s.pop();
			min.pop();
		}
		
	}

	public int top() {

		if(!s.isEmpty()){
			return s.peek();
		}
		return -1;
	}

	public int getMin() {

		if(!min.isEmpty()){
			return min.peek();
		}
		return -1;
		
	}

}
