package binary_search;

import java.util.Arrays;
import java.util.List;

public class RotatedArray {
	
	public int findMin(final List<Integer> a) {
		
		int start = 0;
		int end = a.size()-1;		
		while(start<=end){			
			int mid = (start+end)/2;
			int pre = (mid-1+a.size())%a.size();
			int next = (mid+1)%a.size();
			if(a.get(start)<=a.get(end)){
				return a.get(start);
			}
			else if(a.get(mid)<a.get(pre) && a.get(mid)<a.get(next))
				return a.get(mid);
			else if(a.get(mid)<=a.get(end))
				end = mid-1;
			else if(a.get(mid)>=a.get(start))
				start = mid+1;			
		}
		
		return -1;
    }
	public static void main(String[] args) {
		RotatedArray ra = new RotatedArray();
		;
		System.out.println(ra.findMin(Arrays.asList(4,5,6,7)));
	}

}
