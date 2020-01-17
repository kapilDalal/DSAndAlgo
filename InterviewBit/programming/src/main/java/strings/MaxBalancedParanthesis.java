package strings;

import java.util.Stack;

public class MaxBalancedParanthesis {
	
	public int longestValidParentheses(String A) {
        int len = 0;
        for(int i=0;i<A.length();i++){
            for(int j=i;j<=A.length();j++){
                    String str = A.substring(i,j);                    
                    if(isValid(str)){
                        len = Math.max(len,str.length());
                    }
            }
        }    
        return len;
    }
	public int lvpOptimised(String str){
		int n = str.length(); 
	       
        // Create a stack and push -1 as initial index to it. 
        Stack<Integer> stk = new Stack<>(); 
        stk.push(-1); 
       
        // Initialize result 
        int result = 0; 
       
        // Traverse all characters of given string 
        for (int i=0; i<n; i++) 
        { 
            // If opening bracket, push index of it 
            if (str.charAt(i) == '(') 
              stk.push(i); 
       
            else // If closing bracket, i.e.,str[i] = ')' 
            { 
                // Pop the previous opening bracket's index 
                stk.pop(); 
       
                // Check if this length formed with base of 
                // current valid substring is more than max  
                // so far 
                if (!stk.empty()) 
                    result = Math.max(result, i - stk.peek()); 
       
                // If stack is empty. push current index as  
                // base for next valid substring (if any) 
                else stk.push(i); 
            } 
        } 
       
        return result; 
	}
	
    private boolean isValid(String str){
    	if(str.length()<=1)
    		return false;
        Stack<Character> s = new Stack<Character>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='(')
                s.push(ch);
            else{
            	if(s.isEmpty())
            		return false;
            	s.pop();
            }
        }
        return s.isEmpty()?true:false;
    }

}
