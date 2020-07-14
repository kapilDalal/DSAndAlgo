package dp;

public class BinomialCoefficient {
	
	int binomialCo(int n,int k) {
		int[][] dp = new int[n+1][k+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=Math.min(i, k);j++) {
				
				if(i==0||j==0)
					dp[i][j] = 1;				
				else
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				
			}
		}
		
		return dp[n][k];
	}
	
	public static void main(String[] args) {
		BinomialCoefficient bc = new BinomialCoefficient();
		System.out.println(bc.binomialCo(5, 3));
	}

}
