package dp;

import java.util.Arrays;

public class KnapsackZeroOne {
	
	static public int getMaxPriceWithFixedCapacity(int[] val,int[] wt,int w) {
		
		/*
		 * int[][] maxPriceMat = new int[val.length+1][w+1]; for(int
		 * i=0;i<=val.length;i++) { maxPriceMat[i][0]=0; } for(int j=0;j<=w;j++) {
		 * maxPriceMat[0][j]=0; }
		 * 
		 * for(int item=1;item<=val.length;item++) { for(int
		 * weight=1;weight<=w;weight++) { int priceWithoutCurrentItem =
		 * maxPriceMat[item-1][weight]; int priceWithCurrentItem = 0;
		 * if(wt[item-1]<=weight) { priceWithCurrentItem = val[item-1] +
		 * maxPriceMat[item-1][weight-wt[item-1]]; } maxPriceMat[item][weight] =
		 * Math.max(priceWithCurrentItem, priceWithoutCurrentItem); } } return
		 * maxPriceMat[val.length][w];
		 */
		int n = val.length;
		// Populate base cases
        int[][] mat = new int[n + 1][w + 1];
        for (int r = 0; r < w + 1; r++) {
            mat[0][r] = 0;
        }
        for (int c = 0; c < n + 1; c++) {
            mat[c][0] = 0;
        }
        
        // Main logic
        for (int item = 1; item <= n; item++) {
            for (int capacity = 1; capacity <= w; capacity++) {
                int maxValWithoutCurr = mat[item - 1][capacity]; // This is guaranteed to exist
                int maxValWithCurr = 0; // We initialize this value to 0
                
                int weightOfCurr = wt[item - 1]; // We use item -1 to account for the extra row at the top
                if (capacity >= weightOfCurr) { // We check if the knapsack can fit the current item
                    maxValWithCurr = val[item - 1]; // If so, maxValWithCurr is at least the value of the current item
                    
                    int remainingCapacity = capacity - weightOfCurr; // remainingCapacity must be at least 0
                    maxValWithCurr += mat[item - 1][remainingCapacity]; // Add the maximum value obtainable with the remaining capacity
                }
                
                mat[item][capacity] = Math.max(maxValWithoutCurr, maxValWithCurr); // Pick the larger of the two
            }
        }
        
       // System.out.println(mat[n][w]); // Final answer
        System.out.println(Arrays.deepToString(mat)); // Visualization of the table
		return mat[n][w];
	}
	
	public static void main(String[] args) {
		System.out.println(getMaxPriceWithFixedCapacity(new int[] {10, 40, 30, 50}, new int[] {5, 4, 6, 3}, 10));
	}

}
