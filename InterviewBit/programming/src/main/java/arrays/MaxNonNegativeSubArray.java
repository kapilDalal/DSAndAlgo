package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNonNegativeSubArray {

	static public long maxNonNegativeSubArray(final List<Integer> A) {
		long maxSum = Integer.MIN_VALUE;
		long sumTillNow = A.get(0);
		int start = 0,end = 0,newStart = 0;
		for (int i = 1; i < A.size(); i++) {
			int ele = A.get(i);

			if (ele < 0) {
				sumTillNow = 0;
				newStart = i+1;
			} else {
				sumTillNow = sumTillNow + ele;				
			}
			if (sumTillNow >= maxSum){
				
				if(sumTillNow == maxSum){
					if(i-newStart > (end-start)){
						start = newStart;
			    		end = i;
					}
				}else{
					start = newStart;
		    		end = i;
				}
				maxSum = sumTillNow;
			}	

		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i=start;i<=end;i++)
			res.add(A.get(i));
		if(maxSum == 0 && A.get(0)>0)
			res.add(A.get(0));
		System.out.println(res);
		return maxSum;
	}
	
	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(137806862, -982906996, -511702305, -1937477084 );
		System.out.println(maxNonNegativeSubArray(A));
	}

}
