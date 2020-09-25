package challenge.monthly.september;
/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:

Input: "Hello World"
Output: 5
* */
public class LengthOfLastWord_15 {

    public int lengthOfLastWord(String s) {
        int index = s.length()-1;
        while(index>=0 && s.charAt(index)==' '){
            index--;
        }
        int len = 0;
        while(index>=0 && s.charAt(index)!=' '){
            index--;
            len++;
        }
        return len;
    }

}
