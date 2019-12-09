package hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DiffkII {
	
	static public int diffPossible(final List<Integer> A, int B) {
		
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0;i<A.size();i++){
			int ele = A.get(i);
			int res = B+ele;
			int res1 = ele-B;
			if(set.contains(res) || set.contains(res1))
				return 1;
			set.add(ele);
			
		}
		
		return 0;
		
    }
	public static void main(String[] args) {
		 List<Integer> A = Arrays.asList(34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29);
		 System.out.println(diffPossible(A, 97));
	}

}
