package binary_search;

import java.util.ArrayList;

public class MatrixSearch {
	
	public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
		int res=0;		
		int m = A.size();
		int n = A.get(0).size();
		
		int start = 0;
		int end = m*n-1;
		
		while(start<=end){
			int mid = (start+end)/2;
			int midR = mid/n;
			int midC = mid%n;
			if(A.get(midR).get(midC)==B)
				return 1;
			else if(A.get(midR).get(midC)<B)
				start = mid+1;
			else
				end = mid-1;
		}
		
		return res;
    }
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(3);
		l1.add(5);
		l1.add(7);
		
		ArrayList<Integer> l2 = new ArrayList<>();
		l2.add(10);
		l2.add(11);
		l2.add(16);
		l2.add(20);
		ArrayList<Integer> l3 = new ArrayList<>();
		l3.add(23);
		l3.add(30);
		l3.add(34);
		l3.add(50);
		
		A.add(l1);
		A.add(l2);
		A.add(l3);
		
		MatrixSearch ms = new MatrixSearch();
		
		System.out.println(ms.searchMatrix(A, 15));
		
	}
	
}
