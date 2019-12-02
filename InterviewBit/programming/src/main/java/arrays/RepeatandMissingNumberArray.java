package arrays;

import java.util.Arrays;
import java.util.List;

public class RepeatandMissingNumberArray {
	
	static public void repeatedNumber(final List<Integer> A) {
        
        int[] arr = new int[A.size()+1];
        int n = arr.length;
        int twice = -1;
        long origSum = 0;
        for(int i=0;i<A.size();i++){
            int ele = A.get(i);
        	arr[ele]++; 
        	origSum = origSum + ele;
            if(arr[ele]==2)
            	twice = ele;
        }
        for(int i=1;i<arr.length;i++){
        	if(arr[i]==0)
        		System.out.println(i);                                 
        }
        /*System.out.println(twice);
        origSum = origSum - twice;
        long sum = (n * (n+1))/2;
        System.out.println(sum);
        System.out.println(sum - origSum);*/
        
        
    }
	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(3 ,1 ,2 ,5 ,3);
		repeatedNumber(A);
	}

}
