package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateInArray {

	static public int repeatedNumber(final List<Integer> A) {
		Set<Integer> s = new HashSet<Integer>();
		for(int i=0;i<A.size();i++){
			int ele = A.get(i);
			if(s.contains(ele)){
				return ele;
			}else
				s.add(ele);
				
		}
			
		return -1;
	}
	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(3,4,1,4,1);
		repeatedNumber(A);
	}
}
