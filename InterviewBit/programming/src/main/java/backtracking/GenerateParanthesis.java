package backtracking;

import java.util.ArrayList;
import java.util.Stack;

public class GenerateParanthesis {
	
	public ArrayList<String> generateParenthesis(int A) {
		ArrayList<String> res = new ArrayList<>();
		StringBuffer str = new StringBuffer();
		char[] arr = new char[2*A];
		//generateII(0,2*A,arr,res);		
		
		_printParenthesis(arr, res, 0, A, 0, 0);
		System.out.println(res);
		return res;
    }
	static void _printParenthesis(char str[],ArrayList<String> res, int pos, int n, int open, int close) 
    { 
        if(close == n)  
        { 
            // print the possible combinations 
        	String s = "";
            for(int i=0;i<str.length;i++) 
                s = s + String.valueOf(str[i]);
            res.add(s);
            return; 
        } 
        else
        { 
            if(open > close) { 
                str[pos] = '('; 
                _printParenthesis(str,res, pos+1, n, open, close+1); 
            } 
            if(open < n) { 
                str[pos] = ')'; 
                _printParenthesis(str,res, pos+1, n, open+1, close); 
            } 
        } 
    } 
	private void generateII(int s, int n, char[] arr, ArrayList<String> res) {
		// TODO Auto-generated method stub
		if(s==n){
			if(isValidII(arr) /*&& str.length()==n*/){
				String str = "";
				for(int i=0;i<arr.length;i++)
					str = str + String.valueOf(arr[i]);
				if(!res.contains(str))
					res.add(str);
				return;
			}
		}
		
		for(int i=s;i<n;i++){	
			//StringBuffer str1 = new StringBuffer(str);
			//str1.append('(');	
			arr[i] = '(';	
			generateII(i+1, n, arr, res);
			//str1.deleteCharAt(str1.length()-1);
			arr[i] = ')';	
			generateII(i+1,n, arr, res);			
		}
	}

	private boolean isValidII(char[] arr) {
		// TODO Auto-generated method stub
		Stack<Character> s = new Stack<>();
		
		for(int i=0;i<arr.length;i++){
			Character ch = arr[i]; 
			if(ch =='(' )
				s.push(ch);
			else if(ch==')' && s.isEmpty())
				return false;
			else
				s.pop();
		}
		if(!s.isEmpty())
			return false;
		return true;
	}
	private void generate(int s, int n, StringBuffer str, ArrayList<String> res) {
		// TODO Auto-generated method stub
		if(s==n){
			if(isValid(str) /*&& str.length()==n*/){
				res.add(str.toString());
				return;
			}
		}
		
		for(int i=s;i<n;i++){	
			StringBuffer str1 = new StringBuffer(str);
			str1.append('(');		
			generate(i+1, n, str1, res);
			str1.deleteCharAt(str1.length()-1);
			str1.append(')');	
			generate(i+1,n, str1, res);			
		}
	}

	private boolean isValid(StringBuffer str) {
		// TODO Auto-generated method stub
		Stack<Character> s = new Stack<>();
		
		for(int i=0;i<str.length();i++){
			Character ch = str.charAt(i); 
			if(ch =='(' )
				s.push(ch);
			else if(ch==')' && s.isEmpty())
				return false;
			else
				s.pop();
		}
		if(!s.isEmpty())
			return false;
		
		return true;
	}
	public static void main(String[] args) {
		GenerateParanthesis gp = new GenerateParanthesis();
		//System.out.println(gp.isValid(new StringBuffer("()")));
		gp.generateParenthesis(3);
	}

}
