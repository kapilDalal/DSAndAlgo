package binary_search;

import java.util.Arrays;
import java.util.List;

public class CountElementOccurence {

	public int findCount(final List<Integer> A, int B) {
		int lIndex = bs(A, B, true);
		if(lIndex==-1)
			return 0;
		int rIndex = bs(A, B, false);
		return (rIndex - lIndex + 1);
	}

	private int bs(List<Integer> a, int target, boolean lIndex) {
		int res = -1;
		int start = 0;
		int end = a.size()-1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (a.get(mid) == target) {
				res = mid;
				if (lIndex) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (a.get(mid) > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return res;
	}
	public static void main(String[] args) {
		CountElementOccurence cee = new CountElementOccurence();
		System.out.println(cee.findCount(Arrays.asList(4, 7, 7, 7, 8, 10, 10 ), 4));
		;
	}

}
