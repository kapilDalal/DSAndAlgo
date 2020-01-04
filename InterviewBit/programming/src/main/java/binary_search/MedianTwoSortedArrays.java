package binary_search;

import java.util.Arrays;
import java.util.List;

public class MedianTwoSortedArrays {

	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		
		if(a.size()>b.size())
			return findMedianSortedArrays(b, a);
		
		int x = a.size();
		int y = b.size();
		
		int low = 0;
		int high = x;
		
		while(low<=high){
			
			int partitionX = (low+high)/2;
			int partitionY = (x+y+1)/2 - partitionX;
			
			int maxLeftX = partitionX==0 ? Integer.MIN_VALUE : a.get(partitionX-1);
			int maxLeftY = partitionY==0 ? Integer.MIN_VALUE : b.get(partitionY-1);
			
			int minRightX = partitionX==x ? Integer.MAX_VALUE : a.get(partitionX);
			int minRightY = partitionY==y ? Integer.MAX_VALUE : b.get(partitionY);
			
			
			if(maxLeftX<=minRightY && maxLeftY<=minRightX){
				if((x+y)%2==0)
					return (double)(Math.max(maxLeftX, maxLeftY)+Math.min(minRightX, minRightY))/2;
				return (double)(Math.max(maxLeftX, maxLeftY));
			}
			else if(maxLeftX>minRightY)
				high = partitionX-1;
			else
				low = partitionX+1;
			
		}

		return -1;
		
	}
	
	public static void main(String[] args) {
		MedianTwoSortedArrays msa = new MedianTwoSortedArrays();
		
		System.out.println(msa.findMedianSortedArrays(Arrays.asList(2,7,9), Arrays.asList(1,3,5)));
	}

}
