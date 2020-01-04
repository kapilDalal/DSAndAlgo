package binary_search;

import java.util.Arrays;
import java.util.List;

public class RotatedArraySearch {

	private int pivotIndex(final List<Integer> A) {

		int start = 0;
		int end = A.size() - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int prev = (mid - 1 + A.size()) % A.size();
			int next = (mid + 1) % A.size();
			if (A.get(start) <= A.get(end))
				return start;
			else if (A.get(mid) < A.get(next) && A.get(mid) < A.get(prev))
				return mid;
			else if (A.get(mid) <= A.get(end))
				end = mid - 1;
			else if (A.get(mid) >= A.get(start))
				start = mid + 1;
		}
		return -1;
	}

	private int bs(final List<Integer> A, int start, int end, int B) {
		int res = -1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (A.get(mid) == B)
				return mid;
			else if (A.get(mid) < B)
				start = mid + 1;
			else
				end = mid - 1;
		}

		return res;
	}

	public int search(final List<Integer> A, int B) {
		int pivot = pivotIndex(A);
		int ls = -1, rs = -1;
		
		if(A.get(A.size()-1)>=B)
			return bs(A, pivot, A.size() - 1, B);
		
		return  bs(A, 0, pivot - 1, B);
		
		/*if (pivot != 0) {
			ls = bs(A, 0, pivot - 1, B);
			rs = bs(A, pivot, A.size() - 1, B);
			if (ls != -1)
				return ls;
			if (rs != -1)
				return rs;
		} else {
			return bs(A, 0, A.size() - 1, B);
		}
		return -1;*/
	}
	
	public static void main(String[] args) {
		RotatedArraySearch rs = new RotatedArraySearch();
		
		System.out.println(rs.search(Arrays.asList( 9, 10, 12, 13, 24, 26, 27, 28, 29, 43, 48, 51, 54, 56, 57, 59, 62, 66, 70, 71, 72, 74, 75, 77, 78, 81, 83, 85, 87, 88, 89, 90, 91, 92, 93, 97, 98, 99, 101, 102, 104, 105, 107, 112, 113, 115, 123, 126, 127, 132, 133, 134, 135, 136, 143, 144, 148, 150, 151, 152, 154, 159, 160, 161, 163, 167, 169, 170, 174, 176, 177, 179, 180, 181, 183, 185, 186, 187, 188, 193, 194, 196, 197, 198, 199, 200, 203, 1, 6, 7, 8), 38));
	}

}
