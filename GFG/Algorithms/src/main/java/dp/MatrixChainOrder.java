package dp;

import java.util.Arrays;

public class MatrixChainOrder {
	
	int minMultiplicationRec(int[] p,int i,int j) {
		if(i==j)
			return 0;
		int min = Integer.MAX_VALUE;
		for(int k=i;k<j;k++) {
			int r = minMultiplicationRec(p, i, k)+minMultiplicationRec(p, k+1, j)+p[i-1]*p[k]*p[j];
			if(r<min)
				min = r;
		}
		
		return min;
	}

	public int minMultiplication(int[] arr) {
		
		int n = arr.length;
		int[][] dp = new int[n][n];
		
		for(int i=0;i<n;i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		
		int m = 0;
		
		while(m<n)
		{
			dp[m][m] = 0;
			m++;
		}
				
		for (int l = 2; l < n; l++) {
			for (int i = 1; i < n - l + 1; i++) {
				int j = i + l - 1;
				//if(j == n) continue; 
				for (int k = i; k <= j - 1; k++) {					
					int q = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
					if (q < dp[i][j])
						dp[i][j] = q;
				}
			}
		}

		return dp[1][n-1];
	}
	public static void main(String[] args) {
		MatrixChainOrder mc = new MatrixChainOrder();
		System.out.println(mc.minMultiplication(new int[] {1,2,3,4}));
	}

}
