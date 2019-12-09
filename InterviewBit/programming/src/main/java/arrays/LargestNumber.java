package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	static public String largestNumber(final List<Integer> a) {
		String[] arr = new String[a.size()];
	    for (int i = 0; i < a.size(); i++) {
	        arr[i] = String.valueOf(a.get(i));
	    }
	    
	    
	    Arrays.sort(arr, new Comparator<String>(){
	        public int compare(String a, String b){
	            return (b+a).compareTo(a+b);
	        }
	    });
	    
	 
	    StringBuilder sb = new StringBuilder();
	    for(String s: arr){
	        sb.append(s);
	    }
	 
	    if(sb.charAt(0) == '0'){     //check if all zeroes are there
	        return String.valueOf(0);
	    }
	    
	    return sb.toString();   
	    
	}

	public static void main(String[] args) {

		List<Integer> A = Arrays.asList(3, 30, 34, 5, 9);
		
		System.out.println(largestNumber(A));

	}

}
