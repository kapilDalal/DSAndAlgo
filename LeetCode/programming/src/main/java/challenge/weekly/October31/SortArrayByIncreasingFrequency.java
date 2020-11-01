package challenge.weekly.October31;

import java.util.*;

/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.



Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]


Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100


* */
public class SortArrayByIncreasingFrequency {

    static class Pair implements Comparable<Pair>{
        int val;
        int count;
        public Pair(int val,int count){
            this.val = val;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.count==o.count)
                return o.val-this.val;
            return this.count-o.count;
        }
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i< nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1 );
            }else{
                map.put(nums[i], 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        List<Pair> pairs = new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            Pair p = new Pair(next.getKey(),next.getValue());
            pairs.add(p);
        }
        Collections.sort(pairs);
        int[] res = new int[nums.length];
        int i=0;
        for(Pair p :pairs){
            for(int j=0;j<p.count;j++)
                res[i+j] = p.val;
            i=i+p.count;
        }
        return res;
    }

}
