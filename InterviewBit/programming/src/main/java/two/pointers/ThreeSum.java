package two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSum {
	
	static public int threeSumClosest(ArrayList<Integer> A, int B) {
		int res = Integer.MAX_VALUE;
		Collections.sort(A);
		int fs = 0;
		for(int i=0;i<A.size();i++){
			int first = A.get(i);
			int start = 0;
			int end = A.size()-1;
			
			
			while(start<end){				
				if(i==start){
					start++;
					continue;
				}
				else if(i==end){
					end--;
					continue;					
				}
				int second = A.get(start);
				int third = A.get(end);
				int sum = first+second+third;
				
				if(Math.abs(sum-B)<Math.abs(res)){
					res = Math.abs(sum-B);
					fs = sum;
				}
				if(sum < B)
					start++;
				else
					end--;
				
			}
		}
		
		return fs;
    }
	public static void main(String[] args) {
		
		System.out.println(threeSumClosest(new ArrayList<Integer>(Arrays.asList(-1,2,1,-4)), 1));
	}

}
