package arrays;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        for(;i<s.length();i++)
        {
            Character ch = s.charAt(i);
            if(set.contains(ch)){
                while(s.charAt(start)!=ch){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }else{
                set.add(ch);
            }
            //System.out.println(start);
            max = Math.max(max,i-start+1);
        }

        return max;
    }
}
