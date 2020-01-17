package stackAndqueue;

import java.util.Stack;

public class ValidParanthesis {

	static public int isValid(String A) {

		Stack<Character> s = new Stack<Character>();

		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);

			switch (ch) {
			case '(':
				s.push(ch);
				break;
			case '{':
				s.push(ch);
				break;
			case '[':
				s.push(ch);
				break;
			case ')':
				if (s.peek() != '(')
					return 0;
				s.pop();
				break;
			case '}':
				if (s.peek() != '{')
					return 0;
				s.pop();
				break;
			case ']':
				if (s.peek() != ']')
					return 0;
				s.pop();
				break;

			}
		}
		if (!s.isEmpty())
			return 0;
		return 1;
	}

	public static void main(String[] args) {
		System.out.println(isValid("()[]{}"));
	}

}
