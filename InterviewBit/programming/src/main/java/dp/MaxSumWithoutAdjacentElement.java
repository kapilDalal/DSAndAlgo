package dp;

public class MaxSumWithoutAdjacentElement {
	
	static public int adjacent(int[][] A) {
		if(A[0].length==1)
            return Math.max(A[0][0],A[1][0]);
        //int dp[]=new int[A[0].length];
        int m=A[0].length;
        int prev_max=Math.max(A[0][0],A[1][0]);
            
        int curr_max=Math.max(prev_max,Math.max(A[0][1],A[1][1]));
        for(int j=2;j<m;j++)
        {
            int temp=curr_max;
            curr_max=Math.max(Math.max(A[0][j],A[1][j])+prev_max,curr_max);
            prev_max=temp;
            
        }
        return curr_max;
    }
	
	public static void main(String[] args) {
		int[][] A = {{14, 87, 36, 23},
					{37, 59, 21, 68}};
		adjacent(A);
	}

}
