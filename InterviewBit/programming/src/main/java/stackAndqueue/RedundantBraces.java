package stackAndqueue;

import java.util.Stack;

public class RedundantBraces {
	
	static public int braces(String A) {
		Stack<Character> s = new Stack<Character>();
		String str = A;
		boolean braceLeft = false;
		for(int i=0;i<str.length();i++){
			Character ch = str.charAt(i);
			if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='('){
				s.push(ch);
				continue;
			}
			else if(ch==')'){
				if(s.peek()!='('){
				while(!s.isEmpty() && s.peek()!='(')
					s.pop();
				if(!s.isEmpty())
					s.pop();
				}
			}			
		}
		while(!s.isEmpty()){
			Character ch = s.pop();
			if(ch=='('||ch==')'){
				braceLeft = true;
				break;
			}
		}
		
		return braceLeft ? 1 : 0;
    }
	public static void main(String[] args) {
		String A = "a + b";
		System.out.println(braces(A));
	}

}
