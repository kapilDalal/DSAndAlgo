package recursionanddynamicprogramming;

import java.util.ArrayList;
import java.util.Stack;

public class AllValidParenthesis {

    public static void generateParanthesis(int n, String str){
        if(str.length()==n){
            if(isValid(str)){
                System.out.println(str);
            }
            return;
        }
        str = str + "(";
        generateParanthesis(n,str);
        str = str.substring(0,str.length()-1);

        str = str + ")";
        generateParanthesis(n,str);
        str = str.substring(0,str.length()-1);
    }

    private static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            Character ch = str.charAt(i);
            if(ch =='('){
                s.push(ch);
            }else{
                if(s.isEmpty())
                    return false;
                s.pop();
            }
        }
        return s.isEmpty()?true:false;
    }

    public static void main(String[] args) {
        generateParanthesis(6,"");
    }

}
