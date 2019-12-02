package arrays;

import java.util.ArrayList;

public class Flip {
	
	static public int maxSubArrayWithIndices(final String A) {
	    int maxSum = Integer.MIN_VALUE;
	    int sumTillNow = 0;
	    int start, end, newStart;
	    newStart = start = end = 1;
	    ArrayList<Integer> a = new ArrayList<Integer>();
		 for(int i=0;i<A.length();i++){
			 if(A.charAt(i)=='0')
				 a.add(1);
			 else
				 a.add(-1);
				 
		 }
	    for(int i=0;i<a.size();i++){
	    	sumTillNow = sumTillNow + a.get(i);
	    	if(sumTillNow<0){
	    		sumTillNow = 0;
	    		newStart = i+1;
	    	}else if(maxSum<sumTillNow){
	    		maxSum = sumTillNow;
	    		start = newStart;
	    		end = i+1;
	    	}		    	
	    }	
	    System.out.println(start+"\t"+end);
	    return maxSum;
	 }

}
