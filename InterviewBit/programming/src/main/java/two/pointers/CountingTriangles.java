package two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CountingTriangles {
	
	static public int nTriang(ArrayList<Integer> A) {
		int cnt = 0;
		Collections.sort(A);
		for(int i=A.size()-1;i>=2;i--){
			int start = 0;
			int end = i-1;
			int first = A.get(i);
			
			while(start<end){
				int second = A.get(start);
				int third = A.get(end);
				if(second+third>first){
					cnt += end-start;
					end--;
				}
				else
					start++;
			}
		}
		
		return cnt;
    }
	public static void main(String[] args) {
		System.out.println(nTriang(new ArrayList<Integer>(Arrays.asList( 4, 6, 13, 16, 20, 3, 1, 12))));
	}

}
