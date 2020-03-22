package dp;

import java.util.Stack;

public class MaxRectangleInBinaryMatrix {

	public int maximalRectangle(int[][] A) {
		int area = Integer.MIN_VALUE;
		if(A.length==0)
			return 0;
		area = Math.max(area, area(A[0]));
		
		for (int i = 1; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if(A[i][j]!=0)
					A[i][j] = A[i][j]+A[i-1][j];
			}
			area = Math.max(area, area(A[i]));
		}
		return area;
	}

	private int area(int[] arr) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<Integer>();
		int area = Integer.MIN_VALUE;
		int i=0;
		int n = arr.length;
		while(i<n) {
			if(s.isEmpty() || arr[s.peek()]<=arr[i])
				s.push(i++);
			else {
				int tp = s.peek();
				s.pop();								
				area = Math.max(area, arr[tp] * (s.isEmpty()?i:i-s.peek()-1));
			}
		}
		while(!s.isEmpty()) {
			int tp = s.peek();
			s.pop();								
			area = Math.max(area, arr[tp] * (s.isEmpty()?i:i-s.peek()-1));
		}
		return area;
	}
	
	public static void main(String[] args) {
		MaxRectangleInBinaryMatrix maxRectangle = new MaxRectangleInBinaryMatrix();
		System.out.println(maxRectangle.maximalRectangle(new int[][] {{0, 1, 1, 0}, 
            {1, 1, 1, 1}, 
            {1, 1, 1, 1}, 
            {1, 1, 0, 0}, }));
	}

}
