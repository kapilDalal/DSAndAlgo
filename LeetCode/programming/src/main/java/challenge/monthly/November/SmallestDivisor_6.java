package challenge.monthly.November;

import java.util.Arrays;

public class SmallestDivisor_6 {

    public int smallestDivisor(int[] nums, int threshold) {

        Arrays.sort(nums);
        int start = 1;
        int end = nums[nums.length-1];
        int res = -1;
        while (start<=end){
            int mid = (start+end)/2;
            if(sum(nums,mid,threshold)){
                res = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }

    private boolean sum(int[] nums, int mid,int threshold) {
        int sum =0;
        for(int i=0;i<nums.length;i++)
            sum += Math.ceil((double)nums[i]/(double) mid);
        return sum<=threshold?true:false;
    }

    public static void main(String[] args) {
        SmallestDivisor_6 sd = new SmallestDivisor_6();
        System.out.println(sd.smallestDivisor(new int[]{19},5));
    }

}
