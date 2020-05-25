package dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BuyAndSellStockIII {

	static public int maxProfit(final int[] A,int start,int end) {		
		int currMax = 0;
		int currMin = Integer.MAX_VALUE;
		for(int i=start;i<end;i++) {
			if(A[i]<currMin)
				currMin = A[i];
			if(A[i]-currMin>currMax) {
				currMax = A[i]-currMin;
			}
			
		}		
		return currMax;
    }
	static int maxP(final int[] A) {
		int max = 0;
		for(int i=1;i<=A.length;i++) {
			int f = maxProfit(A, 0, i);
			int s = maxProfit(A, i, A.length);
			max = Math.max(f+s, max);
		}
		
		return max;
	}
	static int maxProfit(int A[], int n) 
    { 
        // Create profit array and initialize it as 0 
		
        int profit[] = new int[n]; 
        for (int i=0; i<n; i++) 
            profit[i] = 0; 
       
        /* Get the maximum profit with only one transaction 
           allowed. After this loop, profit[i] contains maximum 
           profit from price[i..n-1] using at most one trans. */
        int max_price = A[n-1]; 
        for (int i=n-2;i>=0;i--) 
        { 
            // max_price has maximum of price[i..n-1] 
            if (A[i] > max_price) 
                max_price = A[i]; 
       
            // we can get profit[i] by taking maximum of: 
            // a) previous maximum, i.e., profit[i+1] 
            // b) profit by buying at price[i] and selling at 
            //    max_price 
            profit[i] = Math.max(profit[i+1], max_price-A[i]); 
        } 
       
        /* Get the maximum profit with two transactions allowed 
           After this loop, profit[n-1] contains the result */
        int min_price = A[0]; 
        for (int i=1; i<n; i++) 
        { 
            // min_price is minimum price in price[0..i] 
            if (A[i] < min_price) 
                min_price = A[i]; 
       
            // Maximum profit is maximum of: 
            // a) previous maximum, i.e., profit[i-1] 
            // b) (Buy, Sell) at (min_price, price[i]) and add 
            //    profit of other trans. stored in profit[i] 
            profit[i] = Math.max(profit[i-1], profit[i] + 
                                        (A[i]-min_price) ); 
        } 
        int result = profit[n-1]; 
        return result; 
    } 
	
	public static void main(String[] args) throws IOException {
		File f = new File("scanner.ver");		
		System.out.println(f.exists());

		FileReader reader = new FileReader(f);
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		System.out.println(br.readLine().startsWith("16"));
		/*
		 * String st; while ((st = br.readLine()) != null) System.out.println(st);
		 */
		
		String workingDir = "C:\\Program Files\\WebServerScanner\\scanner";
		workingDir = workingDir.substring(0, workingDir.lastIndexOf(File.separator)) + File.separator + f.getName();
		System.out.println(workingDir);
		
	}
}
