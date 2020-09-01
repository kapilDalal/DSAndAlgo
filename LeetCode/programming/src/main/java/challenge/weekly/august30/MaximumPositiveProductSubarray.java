package challenge.weekly.august30;

public class MaximumPositiveProductSubarray {

    // got time limit exceeded O(n^3)
    public int getMaxLen(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                System.out.println();
            for(int j=i;j<nums.length;j++){
                if(positive(nums,i,j))
                    max = Math.max(max,j-i+1);
            }
        }
        return max;
    }
    private boolean positive(int[] nums, int i, int j) {
        long prod = 1;
        for(int k=i;k<=j && k<nums.length;k++) {
            prod *= nums[k];
            if(prod>0)
                prod = 1;
            else if(prod<0)
                prod = -1;
        }
        return prod>0?true:false;
    }

    public int getMaxLenOptimised(int[] arr){


        int max = 0;
        int cntNegatives = 0;
        int zeroIndex = -1;
        int negIndex = -1;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                cntNegatives++;
                if(negIndex==-1)
                    negIndex = i;
            }
            if(arr[i]==0){
                zeroIndex = i;
                cntNegatives = 0;
                negIndex = -1;
            }else{
                if((cntNegatives%2)==0)
                    max = Math.max(max,i-zeroIndex);
                else
                    max = Math.max(max,i-negIndex);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumPositiveProductSubarray mp  = new MaximumPositiveProductSubarray();
        System.out.println(mp.getMaxLenOptimised(new int[]{1,2,3,-1,-2,-3,-4}));
    }


}
