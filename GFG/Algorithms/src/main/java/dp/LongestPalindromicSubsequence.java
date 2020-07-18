package dp;

public class LongestPalindromicSubsequence {
	
	static int lpsRec(char[] seq,int i,int j) {
		if(i==j)
			return 1;
		
		if(seq[i]==seq[j] && i+1==j)
			return 2;
		
		if(seq[i]==seq[j])
			return lpsRec(seq, i+1, j-1) + 2;
		
		else
			return Math.max(lpsRec(seq, i+1, j),lpsRec(seq, i, j-1));						
	}
	
	static int lps(char[] seq) 
	{
		int n = seq.length;
		int[][] dp = new int[n][n];
		
		for(int i=0;i<n;i++) {
			dp[i][0] = 0;	
			dp[0][i] = 0;
		}
		for(int i=0;i<n;i++)
			dp[i][i] = 1;
		
		for(int l=2;l<=n;l++)
		{
			for(int i=0;i<n-l+1;i++) {
				
				int j = i+l-1;
				
				if(seq[i]==seq[j] && l==2)
					dp[i][j] = 2;
				else if(seq[i]==seq[j])
					dp[i][j] = dp[i+1][j-1]+2;
				else
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				
			}
		}
		return dp[0][n-1];
	}
	
	public static void main(String[] args) {
		System.out.println(lpsRec(new char[] {'a','b','c','k','b','a','d'}, 0, 6));
		System.out.println(lps(new char[] {'a','b','c','k','b','a','d'}));
	}
}
