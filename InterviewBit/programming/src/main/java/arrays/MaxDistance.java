package arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class MaxDistance {
	
	static public int maximumGap(final List<Integer> A) {
		
		int maxDist = Integer.MIN_VALUE;
		
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		
		for(int i=0;i<A.size();i++){
			map.put(A.get(i), i);
		}
		
		Integer[] rightMax = new Integer[A.size()];
		Integer[] values = new Integer[A.size()];
		Iterator<Integer> iterator = map.values().iterator();
		int k=0;
		while(iterator.hasNext()){
			values[k] = iterator.next();
			k++;
		}
		
		int max = values[values.length-1];
		rightMax[rightMax.length-1] = max;
		for(int i=values.length-2;i>=0;i--){
			max = Math.max(values[i],max);
			rightMax[i] = max;
			
		}
		maxDist = Integer.MIN_VALUE;
		for(int i=0;i<values.length;i++){
			maxDist = Math.max(maxDist, rightMax[i]-values[i]);
		}
		
		
		System.out.println(maxDist);
		
		return maxDist;
	
	}
	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(3,5,4,2);
		maximumGap(A);
		
	}

}
