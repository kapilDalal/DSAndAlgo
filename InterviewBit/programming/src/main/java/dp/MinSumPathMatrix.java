package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumPathMatrix {
	int[] xMoves = {-1,0};
	int[] yMoves = {0,-1};
	ArrayList<Integer> res = new ArrayList<>();
	public int minPathSum(ArrayList<ArrayList<Integer>> A) {
		
		
		ArrayList<ArrayList<Integer>> r = new ArrayList<>(A);
		for(int j=1;j<A.get(0).size();j++){
			int sum = r.get(0).get(j-1)+r.get(0).get(j);
			r.get(0).set(j, sum);
		}
		for(int i=1;i<A.size();i++){
			int sum = r.get(i-1).get(0)+r.get(i).get(0);
			r.get(i).set(0, sum);			
		}
		for(int i=1;i<r.size();i++){
			for(int j=1;j<r.get(0).size();j++){
				int sum = r.get(i).get(j);				
				sum = sum + r.get(i+xMoves[0]).get(j+yMoves[0]) < sum + r.get(i+xMoves[1]).get(j+yMoves[1]) ? sum + r.get(i+xMoves[0]).get(j+yMoves[0]) : sum + r.get(i+xMoves[1]).get(j+yMoves[1]);
				r.get(i).set(j, sum);
			}
		}
		//System.out.println(r);
		
		return r.get(A.size()-1).get(A.get(0).size()-1);
    }
	
	public static void main(String[] args) {
		MinSumPathMatrix mpm = new MinSumPathMatrix();
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		A.add(new ArrayList<Integer>(Arrays.asList(20, 29, 84, 4, 32, 60, 86, 8, 7, 37)));
		A.add(new ArrayList<Integer>(Arrays.asList(77, 69, 85, 83, 81, 78, 22, 45, 43, 63)));
		A.add(new ArrayList<Integer>(Arrays.asList(60, 21, 0, 94, 59, 88, 9, 54, 30, 80)));
		A.add(new ArrayList<Integer>(Arrays.asList(40, 78, 52, 58, 26, 84, 47, 0, 24, 60)));
		A.add(new ArrayList<Integer>(Arrays.asList(40, 17, 69, 5, 38, 5, 75, 59, 35, 26)));
		A.add(new ArrayList<Integer>(Arrays.asList(64, 41, 85, 22, 44, 25, 3, 63, 33, 13)));
		A.add(new ArrayList<Integer>(Arrays.asList(2, 21, 39, 51, 75, 70, 76, 57, 56, 22)));
		A.add(new ArrayList<Integer>(Arrays.asList(31, 45, 47, 100, 65, 10, 94, 96, 81, 14)));
		mpm.minPathSum(A);
	}

}
