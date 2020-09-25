package challenge.monthly.september;

/*
An integer has sequential digits if and only
if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high]
inclusive that have sequential digits.

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
* */

import java.util.*;

public class SequentialDigits_19 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList("1","2","3","4","5","6","7","8","9"));
        while(!q.isEmpty()){
            String polled = q.poll();
            int num = Integer.parseInt(polled);
            int val = num%10;
            if(num>=low && num<=high)
                res.add(num);
            if(num<=high){
                if(val!=9){
                    polled = polled+(val+1);
                    q.add(polled);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SequentialDigits_19 sd = new SequentialDigits_19();
        System.out.println(sd.sequentialDigits(1000,13000));
    }
}
