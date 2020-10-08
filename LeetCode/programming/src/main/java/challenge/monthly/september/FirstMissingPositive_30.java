package challenge.monthly.september;

import java.util.Iterator;
import java.util.TreeSet;

public class FirstMissingPositive_30 {

    public int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        if(min>1 || max<1)
            return 1;
        if(max==1)
            return 2;

        //boolean[] arr = new boolean[max-min+1];
        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0;i<nums.length;i++){
            //   if(nums[i]>0)
            //      arr[nums[i]-min] = true;
            if(nums[i]>0)
                set.add(nums[i]);
        }
        int i = min;

        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()){
            if(i!= itr.next())
                return i;
            i++;
        }
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i]==false)
        //        return i+min;
        //}

        return max+1;

    }

    public static void main(String[] args) {
        FirstMissingPositive_30 mp = new FirstMissingPositive_30();
        System.out.println(mp.firstMissingPositive(new int[]{1,2,3,10,2147483647,9}));
    }
}
