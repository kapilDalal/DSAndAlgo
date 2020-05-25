package dp;

public class EditDistance {

	static public int minDistance(String A, String B) {
		int[][] dp = new int[A.length()+1][B.length()+1];
		for(int i=0;i<=A.length();i++)
			dp[i][0] = 0;
		for(int j=0;j<dp[0].length;j++)
			dp[0][j]=0;
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=A.length();i++) {
			for(int j=1;j<=B.length();j++) {
				int match = 0;
				if(A.charAt(i-1)==B.charAt(j-1))
					match = 1;
				dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+match;
				max = Math.max(dp[i][j], max);
			}
		}
		return B.length()-max;
	}
	public static void main(String[] args) {
		System.out.println(minDistance("Anshuman", "Antihuman"));
	}

}
