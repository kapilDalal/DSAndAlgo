package binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixMedian {

	public int findMedian(ArrayList<ArrayList<Integer>> A) {
		int res = -1;		
		/*int n = A.size() * A.get(0).size() - 1;
		int medianIndex = n / 2;
		int cnt = 0;
		while (cnt <= medianIndex) {
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int i = 0; i < A.size(); i++) {
				if (A.get(i).size() > 0) {
					if (min >= A.get(i).get(0)) {
						min = A.get(i).get(0);
						minIndex = i;
					}
				}
			}
			int minE = A.get(minIndex).remove(0);
			if(cnt==medianIndex)
				return minE;
			cnt++;
		}*/
		int row = A.size();
        int col = A.get(0).size();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                list.add(A.get(i).get(j));
            }
        }
        Collections.sort(list);
        
        int med = list.get(list.size()/2);
        list.clear();
        return med;

		//return res;
	}
	
	
	private int countSmaller(final List<Integer> A, int B) {
        int left = 0, right = A.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (B <= A.get(mid))
                right = mid - 1;
            else // if B > A.get(mid)
                left = mid + 1;
        }
        return left;
    }

    private int countSmaller(ArrayList<ArrayList<Integer>> A, int B) {
        int smaller = 0;
        for (int i = 0; i < A.size(); i++) {
            smaller += countSmaller(A.get(i), B);
        }
        return smaller;
    }

    public int findMedianOptimised(ArrayList<ArrayList<Integer>> A) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (int) (left + ((long) right - left) / 2);
            int total = A.size() * A.get(0).size();
            int smaller = countSmaller(A, mid);
            if (smaller > total / 2)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right;
    }
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(3);
		l1.add(5);
		
		
		ArrayList<Integer> l2 = new ArrayList<>();
		l2.add(2);
		l2.add(6);
		l2.add(10);
		
		ArrayList<Integer> l3 = new ArrayList<>();
		l3.add(3);
		l3.add(6);
		l3.add(9);
		
		
		A.add(l1);
		A.add(l2);
		A.add(l3);
		
		MatrixMedian mm = new MatrixMedian();
		
		System.out.println(mm.findMedianOptimised(A));
		
	}

}
