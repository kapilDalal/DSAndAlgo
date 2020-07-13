package dp;

public class Knapsack0_1 {
	
	static int knapSack(int capcity, int wt[], int val[]) {
		int n = wt.length;
		int m = capcity;
		int[][] dp = new int[n+1][m+1];
		for(int i=0;i<=n;i++)
			dp[i][0] = 0;
		for(int j=0;j<=m;j++)
			dp[0][j] = 0;
		for(int i=1;i<=n;i++) {
			
			for(int j=1;j<=m;j++) {											
				if(wt[i-1]<=j) {
					dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]]);					
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][m];
	}
	
	public static void main(String[] args) {
		System.out.println(knapSack(6, new int[] {1,2,3}, new int[] {10,15,40}));		
	}

}
