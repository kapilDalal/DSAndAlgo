package dp;

public class RepeatingSubsequence {

	public int anytwo(String A) {
		
		int[][] dp = new int[A.length()][A.length()];
		
		for(int j=0;j<A.length();j++) {
			if(j==0)
				dp[0][j] = 0;
			else if(A.charAt(0)==A.charAt(j))
				dp[0][j]=1;
		}
		for(int i=1;i<A.length();i++) {
			if(A.charAt(0)==A.charAt(i))
				dp[i][0] = 1;
		}
		int max = 0;
		for(int i=1;i<A.length();i++) {
			for(int j=1;j<A.length();j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])+ (A.charAt(i)==A.charAt(j)?1:0);
				max = Math.max(max, dp[i][j]);
			}
		}
		
		return max<=1?0:1;
	}
	
	static int repeats(String str1, String str2,int i,int j) {
		if(i==str1.length() || j==str2.length())
			return 0;
		
		if(str1.charAt(i)==str2.charAt(j) && i!=j)
			return 1 + repeats(str1, str2, i+1, j+1);
		
		return Math.max(repeats(str1, str2, i+1, j), repeats(str1, str2, i, j+1));
		
	}
	
	

	public static void main(String[] args) {
		RepeatingSubsequence rs = new RepeatingSubsequence();
		System.out.println(rs.anytwo("abba"));
	}

}
