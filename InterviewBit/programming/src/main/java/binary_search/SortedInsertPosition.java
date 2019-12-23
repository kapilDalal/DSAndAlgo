package binary_search;

import java.util.Arrays;
import java.util.List;

public class SortedInsertPosition {
	
	static public int searchInsert(List<Integer> a, int b) {
		int index=0;
		
		index = bs(0,a.size()-1,a,b);
		if(index==-1)
			index = bsNF(0, a.size()-1, a, b);
		return index;
	
	}

	private static int bs(int start, int end, List<Integer> a, int b) {
		if(start<=end){
			int mid = (start+end)/2;		
			if(a.get(mid)==b)
				return mid;
			
			if(a.get(mid)>b){
				
				return bs(start, mid-1, a, b);
			}
			else{
				
				return bs(mid+1, end, a, b);
			}
		}
		return -1;
	}
	private static int bsNF(int start, int end, List<Integer> a, int b) {
			if(start>end)
				return start;
			int mid = (start+end)/2;								
			if(a.get(mid)>b)				
				return bsNF(start, mid-1, a, b);						
			return bsNF(mid+1, end, a, b);		
	}
	
	public static void main(String[] args) {
		System.out.println(searchInsert(Arrays.asList(1,3,5,6), 0));
	}

}
