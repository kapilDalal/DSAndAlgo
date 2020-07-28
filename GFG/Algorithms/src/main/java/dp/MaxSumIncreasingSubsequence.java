package dp;

public class MaxSumIncreasingSubsequence {

	static int maxSum(int[] nums)
	{
		int[] dp = new int[nums.length];		
		dp[0] = nums[0];
		int gMax = dp[0];
		for(int i=1;i<nums.length;i++) {
			int max = nums[i];
			for(int j=0;j<i;j++) {				
				if(nums[i]>nums[j]) {
					max = Math.max(max, nums[i]+dp[j]);
				}
			}
			dp[i] = max;			
			gMax = Math.max(gMax, dp[i]);
		}
		return gMax;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,101,2,3,100,4,5};
		System.out.println(maxSum(nums));
	}
}
