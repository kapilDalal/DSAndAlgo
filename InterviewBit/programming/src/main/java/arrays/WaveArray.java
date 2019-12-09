package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WaveArray {
	
	static public List<Integer> wave(List<Integer> A) {
		
		Collections.sort(A);
		System.out.println(A);
		for(int i=0;i<=A.size()-2;i=i+2){
			int temp = A.get(i);
			A.set(i, A.get(i+1));
			A.set(i+1, temp);
		}
		
		return A;
    }
	
	
	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(1, 1, 1, 2);
		
		System.out.println(wave(A));
	}

}
