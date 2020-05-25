package dp;

public class MaxProductSubarray {
	
	static public int maxProduct(final int[] A) {				
		int currMax = A[0];
		int max = A[0];		
		for(int i=0;i<A.length;i++) {
			currMax = A[i];
			max = Math.max( currMax, max);
			for(int j=i+1;j<A.length;j++) {
				currMax = currMax * A[j]; 
				max = Math.max( currMax, max);
			}
		}
		return max;
    }
	
	static public int maxProductDp(final int[] A) {				
		int min = A[0];
		int max = A[0];		
		int res = A[0];
		for(int i=1;i<A.length;i++) {
			if(A[i]<0) {
				int temp = max;
				max = min;
				min = temp;
			}
			max = Math.max(max, max*A[i]);
			min = Math.min(min, min*A[i]);
			res = Math.max(res, max);
		}
		return res;
    }
	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] {2, 3, -2, 4}));
	}

}
