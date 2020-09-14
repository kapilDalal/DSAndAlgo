package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int ele = nums[i];
            int start = i+1;
            int end = nums.length-1;
            while(start<end){

                if(nums[start]+nums[end]+ele==0){
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(ele);
                    l.add(nums[start]);
                    l.add(nums[end]);
                    if(!res.contains(l))
                        res.add(l);
                    start++;
                    end--;
                }
                else if(nums[start]+nums[end]+ele<0)
                    start++;
                else
                    end--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-8,5,3,2}));
    }
}
