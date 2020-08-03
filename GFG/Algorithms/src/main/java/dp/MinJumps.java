package dp;

import java.util.Arrays;

public class MinJumps {
	
	static int minJumps(int[] arr) {
		int[] dp = new int[arr.length];		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(j+arr[j]>=i && 1+dp[j]<dp[i])
					dp[i] = 1 + dp[j];
			}
		}
		return dp[arr.length-1];
	}
	
	public static void main(String[] args) {
		System.out.println(minJumps(new int[] {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
	}

}
