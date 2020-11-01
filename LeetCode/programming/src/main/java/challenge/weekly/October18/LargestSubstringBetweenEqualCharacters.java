package challenge.weekly.October18;

import java.util.HashMap;
/*
1624. Largest Substring Between Two Equal Characters
Difficulty:Easy

Given a string s, return the length of the longest substring between two equal characters,
excluding the two characters. If there is no such substring return -1.

A substring is a contiguous sequence of characters within a string.

Example 1:

Input: s = "aa"
Output: 0
Explanation: The optimal substring here is an empty substring between the two 'a's.
Example 2:

Input: s = "abca"
Output: 2
Explanation: The optimal substring here is "bc".
Example 3:

Input: s = "cbzxy"
Output: -1
Explanation: There are no characters that appear twice in s.
Example 4:

Input: s = "cabbac"
Output: 4
Explanation: The optimal substring here is "abba". Other non-optimal substrings include "bb" and "".


Constraints:

1 <= s.length <= 300
s contains only lowercase English letters.
* */
public class LargestSubstringBetweenEqualCharacters {

    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(!map.containsKey(ch))
                map.put(ch,i);
        }
        int len = -1;
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(map.get(ch)<i){
                len = Math.max(i-map.get(ch),len);
            }
        }
        return len==-1?len:len-1;
    }


}
