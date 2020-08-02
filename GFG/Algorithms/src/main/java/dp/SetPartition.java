package dp;

import java.util.ArrayList;

public class SetPartition {

	static boolean found = false;
	static void sets(int[] arr,int index,ArrayList<Integer> l,int sum)
	{
		//if sum is odd there can not be two subsets with equal sum.
		
		if(sum-listSum(l)==sum/2) {
			//System.out.println(l);
			found = true;
			return;
		}
		if(!found)
		for(int i=index;i<arr.length;i++)
		{
			l.add(arr[i]);
			sets(arr, i+1, l,sum);
			l.remove(l.size()-1);
		}
	}
	
	private static int listSum(ArrayList<Integer> l) {			
		return l.stream()
				  .reduce(0, Integer::sum);
	}
	// Returns true if arr[] can be partitioned in two subsets of 
    // equal sum, otherwise false 
    static boolean findPartition (int arr[], int n) 
    { 
        int sum = 0; 
        int i, j; 
  
        // Calculate sum of all elements 
        for (i = 0; i < n; i++) 
            sum += arr[i]; 
  
        if (sum%2 != 0) 
            return false; 
  
        boolean part[][]=new boolean[sum/2+1][n+1]; 
  
        // initialize top row as true 
        for (i = 0; i <= n; i++) 
            part[0][i] = true; 
  
        // initialize leftmost column, except part[0][0], as 0 
        for (i = 1; i <= sum/2; i++) 
            part[i][0] = false; 
  
        // Fill the partition table in bottom up manner 
        for (i = 1; i <= sum/2; i++) 
        { 
            for (j = 1; j <= n; j++) 
            { 
                part[i][j] = part[i][j-1]; 
                if (i >= arr[j-1]) 
                    part[i][j] = part[i][j] || 
                                 part[i - arr[j-1]][j-1]; 
            } 
        } 
  
         // uncomment this part to print table 
        for (i = 0; i <= sum/2; i++) 
        { 
            for (j = 0; j <= n; j++) 
                System.out.print (part[i][j]+"\t"); 
            System.out.printf("\n"); 
        } 
  
        return part[sum/2][n]; 
    }

	public static void main(String[] args) {
		sets(new int[]{1, 5, 11}, 0, new ArrayList<Integer>(),17);
		System.out.println(found);
		System.out.println(findPartition(new int[] {1,5,11,5}, 4));
	}
	
}
