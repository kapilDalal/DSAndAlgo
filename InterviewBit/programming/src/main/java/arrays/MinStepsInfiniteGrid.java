package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MinStepsInfiniteGrid {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-7,-13));
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1,-5));
		int steps=0;
		for(int i=1;i<A.size();i++){
			int prevX = A.get(i-1);
			int prevY = B.get(i-1);
			int x = A.get(i);
			int y = B.get(i);			
			//steps = (int) (steps + Math.round(Math.sqrt(((y-prevY)^2) + ((x-prevX)^2))));
			steps = steps+Math.max(Math.abs(x-prevX), Math.abs(y-prevY));
		}
		System.out.println(steps);
		
		
	}
}
