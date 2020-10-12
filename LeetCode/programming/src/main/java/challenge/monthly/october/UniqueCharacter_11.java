package challenge.monthly.october;

import challenge.monthly.september.UniquePathsIII_20;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class UniqueCharacter_11 {

    public String removeDuplicateLetters(String s) {
        boolean[] added = new boolean[26];
        int[] lastIndex = new int[26];

        for(int i=0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(added[ch-'a']){
               continue;
            }
            while (!stack.isEmpty() && stack.peek()>ch && lastIndex[stack.peek()-'a']>i){
                added[stack.peek()-'a'] = false;
                stack.pop();
            }
            added[ch-'a'] = true;
            stack.push(ch);
        }

        String res = "";
        while (!stack.isEmpty()){
            res = stack.pop() + res;
        }
        return res;
    }



    public static void main(String[] args) {
        UniqueCharacter_11 uq = new UniqueCharacter_11();
        System.out.println(uq.removeDuplicateLetters("bcabc"));
    }
}
