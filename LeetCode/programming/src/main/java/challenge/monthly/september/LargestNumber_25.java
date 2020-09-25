package challenge.monthly.september;

import java.util.Arrays;
import java.util.Comparator;

/*
*
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
* */
public class LargestNumber_25 {

    public class NumberComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return -1*(o1+o2).compareTo(o2+o1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        String res = "";
        for(int i=0;i<nums.length;i++){
            numsStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr,new NumberComparator());
        for(int i=0;i< numsStr.length;i++)
            res = res + numsStr[i];
        int index = 0;

        while(index<res.length() && res.charAt(index)=='0')
            index++;
        return res.substring(index,res.length());
    }

    public static void main(String[] args) {
        LargestNumber_25 ln = new LargestNumber_25();
        System.out.println(ln.largestNumber(new int[]{3,30,34,5,9}));
    }


}
