package dp;

import java.util.HashMap;

public class CutRod {
	//gfg approach
	static int maxPrice(int[] prices, int n){
		if(n<=0)
			return 0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
			max = Math.max(max, prices[i]+maxPrice(prices, n-i-1));
		return max;
	}
	
	static int maxPriceDpTopDown(int[] prices,int n,HashMap<Integer,Integer> dp)
	{
		if(n<=0)
			return 0;
		if(dp.containsKey(n))
			return dp.get(n);
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			max = Math.max(max, prices[i]+maxPriceDpTopDown(prices, n-i-1, dp));
		}
		dp.put(n, max);
		return max;
	}

	static int maxPriceDpBottomUp(int[] prices,int n)
	{
		int[] val = new int[n+1];
		val[0] = 0;
		
		for(int i=1;i<=n;i++) {
			
			int max = Integer.MIN_VALUE;
			
			for(int j = 0;j<i;j++) {
				max = Math.max(max, prices[j]+val[i-j-1]);
			}
			val[i] = max;
		}
		return val[n];
	}
	
	//my approach
	static int fun(int maxLength,int partSize,int[] price)
	{
		if(maxLength==0)
			return 0;
		
		int max = Integer.MIN_VALUE;
		for(int i=partSize;i>0;i--)
		{
			if(i<=maxLength)
			{
				int p = Math.max(price[partSize-1]+fun(maxLength-partSize,partSize,price) , fun(maxLength,partSize-1,price));
				if(max<p)
					max = p;			
			}
		}
		return max;

	}
	
	public static void main(String[] args) {
		
		int[] prices = {1,4,3};//{1 ,  5 ,  8  , 9 , 10 , 17 , 17 , 20};
		System.out.println(maxPrice(prices, 3));
		System.out.println(fun(3,3,prices));
		System.out.println(maxPriceDpTopDown(prices, 3,new HashMap<Integer, Integer>()));
		System.out.println(maxPriceDpBottomUp(prices, 3));
	}

}
