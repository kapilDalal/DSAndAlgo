package binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeSearch {
	
	public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
		ArrayList<Integer> res = new ArrayList<>();
		int lIndex = bs(A, B, true);
		if(lIndex==-1){
			
			res.add(-1);
			res.add(-1);
			return res;
			
		}
		int rIndex = bs(A, B, false);
		/*if(lIndex==rIndex)
			return res;*/
		res.add(lIndex);
		res.add(rIndex);
		return res;
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
		RangeSearch rs = new RangeSearch();
		
		System.out.println(rs.searchRange(Arrays.asList(5,7,7,8), 9));
	}

}
