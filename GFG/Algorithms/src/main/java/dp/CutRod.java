package dp;

public class CutRod {
	
	static int maxPrice(int[] prices, int n){
		if(n<=0)
			return 0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
			max = Math.max(max, prices[i]+maxPrice(prices, n-i-1));
		return max;
	}

	
	
	public static void main(String[] args) {
		
		int[] prices = {1 ,  5 ,  8  , 9 , 10 , 17 , 17 , 20};
		
		System.out.println(maxPrice(prices, 8));
		
	}

}
