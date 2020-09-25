package challenge.monthly.september;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array of size n, find all elements that appear more than n/3 times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
* */
public class MajorityElementII_23 {

    //apply moore's algo
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res  = new ArrayList<>();
        if(nums.length<=2){

            for(int i=0;i< nums.length;i++){
                if(!res.contains(nums[i]))
                    res.add(nums[i]);
            }
            return res;
        }

        int e1 = nums[0];
        int e2 = nums[0];
        int c1 = 1;
        int c2 = 1;

        for(int i=1;i<nums.length;i++){

            if(e1 == nums[i] || c1==0){
                e1 = nums[i];
                c1++;
            }
            else if(e2 == nums[i] || c2==0){
                e2 = nums[i];
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }
        int fc1 = 0;
        int fc2 = 0;

        for(int i=0;i<nums.length;i++){
            if(e1==nums[i])
                fc1++;
            if(e2==nums[i])
                fc2++;
        }
        if(e1==e2 && fc1>nums.length/3){
            res.add(e1);
            return res;
        }
        if(fc1> nums.length/3)
            res.add(e1);
        if(fc2> nums.length/3)
            res.add(e2);

        return res;
    }

    public static void main(String[] args) {
        MajorityElementII_23 me = new MajorityElementII_23();
        System.out.println(me.majorityElement(new int[]{1,2,3}));
    }

}
