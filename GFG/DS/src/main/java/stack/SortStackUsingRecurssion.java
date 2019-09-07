package stack;

public class SortStackUsingRecurssion {
	
	
	
	static void sort(StackInt stack){
		if(stack.isEmpty())
			return;
		int popped = stack.pop();
		sort(stack);
		pushAtRightPosition(stack,popped);
	}

	private static void pushAtRightPosition(StackInt stack, int popped) {
		if(stack.isEmpty() || stack.peek()<=popped){
			stack.push(popped);
			return;
		}
		int pop = stack.pop();		
		pushAtRightPosition(stack,popped);
		stack.push(pop);
	}
	
	public static void main(String[] args) {
		StackInt stack = new StackInt(5);
		stack.push(3);
		stack.push(1);
		stack.push(2);
		stack.push(5);
		stack.push(4);
		sort(stack);
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

}
