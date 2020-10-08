package challenge.monthly.september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
* */
public class WordBreak_29 {

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0)
            return true;
        for(int i=s.length();i>=0;i--){

            if(wordDict.contains(s.substring(i,s.length())))
                if(wordBreak(s.substring(0,i),wordDict))
                    return true;

        }
        return false;
    }

    public static void main(String[] args) {
        WordBreak_29 wb = new WordBreak_29();
        System.out.println(wb.wordBreak("leetcode",
                new ArrayList<String>(Arrays.asList("leet", "co","d","e"))));
    }


}
