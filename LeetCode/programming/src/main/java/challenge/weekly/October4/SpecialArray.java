package challenge.weekly.October4;

import java.util.Arrays;

public class SpecialArray {

    public int specialArray(int[] nums) {
        if(nums.length==1){
            if(nums[0]>=1)
                return 1;
            return -1;
        }
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length-1];
        for(int i=min;i<=max;i++){
            int index = Arrays.binarySearch(nums,i);
            if(index<0){
                index = -1*index -1;
            }
            while(index-1>=0 && nums[index-1]==i){
                index--;
            }
            if(nums.length-index==i)
                return i;

        }
        return -1;
    }

    public static void main(String[] args) {
        SpecialArray sa = new SpecialArray();
        System.out.println(sa.specialArray(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100}));
    }

}
