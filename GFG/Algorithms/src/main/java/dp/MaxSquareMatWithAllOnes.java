package dp;

public class MaxSquareMatWithAllOnes {
	
	
	static int maxSquareSubMatrix(int[][] mat){
		int size = 1;
		int[][] dp = new int[mat.length+1][mat[0].length+1];
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				
					dp[i][j] = mat[i-1][j-1];
				
			}
		}
	
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				
				if(dp[i-1][j]==0 || dp[i][j-1]==0 || dp[i][j]==0)
					continue;
				
				dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]))+1;
				size = Math.max(size, dp[i][j]);
				
			}
		}
		
		return size;
	}
	
	public static void main(String[] args) {
		int[][] mat = {{0,1,1,0,1},
					   {1,1,1,1,0},
					   {1,1,1,1,0},
					   {1,1,1,1,0},
					   {1,1,1,1,1},
					   {0,0,0,0,0}};
		System.out.println(maxSquareSubMatrix(mat));
		
	}

}
