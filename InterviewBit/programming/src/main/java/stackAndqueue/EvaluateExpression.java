package stackAndqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class EvaluateExpression {

	static public int evalRPN(ArrayList<String> A) {

		
		
		Stack<Integer> ansStack = new Stack<Integer>();
		
		for (int i = 0; i < A.size(); i++) {
			String str = A.get(i);
			switch (str) {
			case "/":				
					Integer op1 = ansStack.pop();
					Integer op2 = ansStack.pop();					
					ansStack.push(op2 / op1);				
				break;
			case "*":				
					Integer op = ansStack.pop();
					Integer op3 = ansStack.pop();								
					ansStack.push(op3 * op);					
							
				break;
			case "+":
				Integer op4 = ansStack.pop();
				Integer op5 = ansStack.pop();
				String top2 = str;					
				ansStack.push(op5 + op4);	
				break;
			case "-":
				Integer op7 = ansStack.pop();
				Integer op8 = ansStack.pop();									
				ansStack.push(op8 - op7);	
				break;
			default:
				ansStack.push(Integer.parseInt(str));
			}
		}		
		/*while(ansStack.size()!=1){
			Integer op1 = ansStack.pop();
			Integer op2 = ansStack.pop();
			String top = operationStack.pop();
			if (top.equals("*"))
				ansStack.push(op1 * op2);
			else if (top.equals("/"))
				ansStack.push(op2 / op1);
			else if (top.equals("+"))
				ansStack.push(op2 + op1);
			else if (top.equals("-"))
				ansStack.push(op2 - op1);
		}*/
		
		return ansStack.pop();
	}
	
	public static void main(String[] args) {
		System.out.println(evalRPN(new ArrayList<String>(Arrays.asList("5", "1", "2", "+", "4", "*", "+", "3", "-" ))));
	}

}
