package stack;

public class InfixToPostfix {
	
	static int precedence(char ch){
		switch(ch){
			case '+':				
			case '-':
				return 1;
			case '*':				
			case '/':
				return 2;
			case '^':
				return 3;			
			default:
				return -1;			
		}
	}
	static boolean isAlhaNumeric(char ch){
		if(Character.isAlphabetic(ch) || Character.isDigit(ch))
			return true;
		return false;
	}
	static String infixToPostfix(Character[] arr){
		Stack stack = new Stack(arr.length/2);
		boolean isBracketPresent = false;
		String result="";
		for(int i=0;i<arr.length;i++){
			if(!isAlhaNumeric(arr[i])){
				
				if(stack.isEmpty())
					stack.push(arr[i]);
				else if(arr[i]=='(')
					isBracketPresent = true;
				else if(arr[i]==')'){
					while(!stack.isEmpty()){
						System.out.print(stack.peek());
						result = result+stack.pop();
					}
					isBracketPresent = false;
				}									
				else{
					if(precedence(stack.peek())<precedence(arr[i]))
						stack.push(arr[i]);
					else{
						while(!isBracketPresent && !stack.isEmpty()){
							System.out.print(stack.peek());
							result = result+stack.pop();
						}
						stack.push(arr[i]);
					}
				}
			}
			else{
				System.out.print(arr[i]);
				result = result+arr[i];
			}
		}
		while(!stack.isEmpty()){
			System.out.print(stack.peek());
			result = result+stack.pop();
		}
		return result;
	}
	static int calculate(char ch1,char ch2,char ch){
		switch(ch){
		case '+':
			return Character.getNumericValue(ch1) + Character.getNumericValue(ch2);
		case '-':
			return Character.getNumericValue(ch1) - Character.getNumericValue(ch2);
		case '*':			
			return Character.getNumericValue(ch1) * Character.getNumericValue(ch2);
		case '/':
			return Character.getNumericValue(ch1) / Character.getNumericValue(ch2);
		case '^':
			return Character.getNumericValue(ch1) ^ Character.getNumericValue(ch2);			
		default:
			return -1;			
	}
	}
	static int calculate(int ch1,char ch2,char ch){
		switch(ch){
		case '+':
			return Character.getNumericValue(ch2) + ch1;
		case '-':
			return Character.getNumericValue(ch2) - ch1;
		case '*':			
			return Character.getNumericValue(ch2) * ch1;
		case '/':
			return Character.getNumericValue(ch2) / ch1;
		case '^':
			return Character.getNumericValue(ch2) ^ ch1;			
		default:
			return -1;			
	}
	}
	static int calculate(int ch1,int ch2,char ch){
		switch(ch){
		case '+':
			return ch2 + ch1;
		case '-':
			return ch2 - ch1;
		case '*':			
			return ch2 * ch1;
		case '/':
			return ch2 / ch1;
		case '^':
			return ch2 ^ ch1;			
		default:
			return -1;			
	}
	}
	
	static int evaluatePostfixUsingStack(String str){
		StackInt stack = new StackInt(str.length());
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(!isAlhaNumeric(ch)){
				int op1 = stack.pop();
				int op2 = stack.pop();
				int res = calculate(op1, op2, ch);
				stack.push(res);
			}else{
				stack.push(ch-'0');
			}
		}
		return stack.pop();
	}
	
	static int evaluatePostfix(String str){
		
		int i=0;
		int j=0;
		int res = -1;
		while(i<str.length()){
			char ch = str.charAt(i);
			if(!Character.isDigit(ch)){
				if(res==-1){
					char op1 = str.charAt(i-1);
					char op2 = str.charAt(i-2);
					j=i-3;
					res = calculate(op2, op1, ch);
				}
				else{
					char op1 = str.charAt(j);
					j--;
					res = calculate(res, op1, ch);
				}
				
				
			}
			i++;
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
		Character[] arr = {'3','*','(','2','+','8','/','4',')'};
		String str = infixToPostfix(arr);
		System.out.println();
		System.out.println(str);
		
		System.out.println(evaluatePostfixUsingStack(str));
	}

}
