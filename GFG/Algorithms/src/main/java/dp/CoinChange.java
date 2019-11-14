package dp;

public class CoinChange {
	
	
	static void countCoinUsingDp(int[] arr,int n){
		int[][] memo = new int[arr.length+1][n+1];
		
		for(int j=0;j<=n;j++){			
				memo[0][j]=0;
		}
		for(int i=0;i<=arr.length;i++)
			memo[i][0]=1;
		
		for(int i=1;i<=arr.length;i++){
			for(int j=1;j<=n;j++){
				int includeSum = 0;
				if(j-arr[i-1]>=0)
					includeSum = memo[i][j-arr[i-1]];
				memo[i][j] = includeSum+memo[i-1][j];
			}
		}
		
		System.out.println(memo[arr.length][n]);
		
	}
	
	static int	 countCoins(int[] arr,int m,int n){
		if(n==0)
			return 1;
		if(n<0)
			return 0;
		if(m<=0 && n>=0)
			return 0;
		return countCoins(arr, m,  n-arr[m-1]) + countCoins(arr, m-1, n);
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 5, 3, 6};
		
		System.out.println(countCoins(arr, arr.length, 10));
		
		
		countCoinUsingDp(arr, 10);
		
		int[] arr1 = {1,2, 3};
		
		System.out.println(countCoins(arr1, arr1.length, 4));
		
		
		countCoinUsingDp(arr1, 4);
	}
	
	
}
