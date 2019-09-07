package stack;

public class ReverseStackUsingRecurssion {
	
	static void pushAtBottom(Stack stack,char ch){
		if(stack.isEmpty()){
			stack.push(ch);
			return;
		}
		char popped = stack.pop();
		pushAtBottom(stack,ch);
		stack.push(popped);
	}
	
	static void reverseStack(Stack stack){
		if(stack.isEmpty())
			return;
		char popped = stack.pop();
		reverseStack(stack);
		pushAtBottom(stack,popped);
	}
	
	public static void main(String[] args) {
		
		Stack stack = new Stack(5);
		stack.push('a');
		stack.push('b');
		stack.push('c');
		stack.push('d');
		stack.push('e');
		reverseStack(stack);
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		
	}

}
