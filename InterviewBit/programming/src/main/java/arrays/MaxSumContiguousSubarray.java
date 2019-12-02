package arrays;

import java.util.List;

public class MaxSumContiguousSubarray {
	
	
	 static public int maxSubArray(final List<Integer> A) {
	    int maxSum = Integer.MIN_VALUE;
	    int sumTillNow = A.get(0);
	    for(int i=1;i<A.size();i++){
	    	//sumTillNow = sumTillNow + A.get(i);
	    	sumTillNow = Math.max(sumTillNow+A.get(i), A.get(i));
	    	
	    	maxSum = Math.max(sumTillNow, maxSum);
	    	
	    }	 
	    return maxSum;
	 }
	
	 
	 
	 public static void main(String[] args) {
		
		/* List<Integer> A = Arrays.asList( 1,-1,-1,1,-1,-1,-1,1,1,1,1,-1,-1 );
		 System.out.println(maxSubArrayWithIndices(A));*/
		 //System.out.println(A.get(51));
	}

}
