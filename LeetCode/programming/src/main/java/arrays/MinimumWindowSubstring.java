package arrays;

import java.util.HashMap;
import java.util.HashSet;

/*
Given a string S and a string T,
find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum
window in S.
* */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0)
            return "";

        int[] ans = new int[]{-1,0,0};

        HashMap<Character,Integer> targetWindow = new HashMap<>();
        HashMap<Character,Integer> currWindow = new HashMap<>();

        for(int i=0;i<t.length();i++){
            targetWindow.put(t.charAt(i),targetWindow.getOrDefault(t.charAt(i),0)+1);
        }
        int formed = 0;
        int l=0;
        int r=0;
        for(int i=0;i<s.length();i++){
            currWindow.put(s.charAt(i),currWindow.getOrDefault(s.charAt(i),0)+1);

            if(targetWindow.containsKey(s.charAt(i)) && currWindow.get(s.charAt(i))==targetWindow.get(s.charAt(i)))
                formed++;

            while(formed==targetWindow.size() && l<=r){

                if(ans[0]==-1 || r-l<ans[2]-ans[1]){
                    ans[0] = ans[2]-ans[1]+1;
                    ans[1] = l;
                    ans[2] = r;
                }
                currWindow.put(s.charAt(l),currWindow.get(s.charAt(l))-1);
                if(targetWindow.containsKey(s.charAt(l)) && currWindow.get(s.charAt(l))<targetWindow.get(s.charAt(l)))
                    formed--;
                l++;
            }
            r++;
        }


        return ans[0]==-1?"":s.substring(ans[1],ans[2]+1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring mw=  new MinimumWindowSubstring();
        System.out.println(mw.minWindow("ADOBECODEBANC","ABC"));
    }

}
