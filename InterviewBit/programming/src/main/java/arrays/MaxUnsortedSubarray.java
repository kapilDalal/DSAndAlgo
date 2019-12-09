package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxUnsortedSubarray {

	// O(nlogn)
	static public ArrayList<Integer> subUnsort(List<Integer> A) {
		ArrayList<Integer> res = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>(A);
		Collections.sort(list);

		int f = -1, s = -1;
		for (int i = 0; i < A.size(); i++) {
			if (list.get(i) - A.get(i) != 0) {
				if (f == -1)
					f = i;
				else
					s = i;
			}
		}
		if (f != -1) {
			res.add(f);
			res.add(s);
		} else
			res.add(-1);
		// System.out.println(res);
		return res;
	}
	//O(n)
	public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		int st = -1, end = -1;

		// from left
		for (int i = 1; i < A.size(); ++i) {
			if (A.get(i) < A.get(i - 1)) {
				st = i - 1;
				break;
			}
		}

		// fully sorted
		if (st == -1) {
			list.add(-1);
			return list;
		}

		// from right
		for (int i = A.size() - 2; i >= 0; --i) {
			if (A.get(i) > A.get(i + 1)) {
				end = i + 1;
				break;
			}
		}

		// find min and max in the range [st, end]
		int min = A.get(st);
		int max = A.get(st);
		for (int i = st; i <= end; ++i) {
			min = Math.min(min, A.get(i));
			max = Math.max(max, A.get(i));
		}

		for (int i = 0; i < st; ++i) {
			if (A.get(i) > min) {
				st = i;
				break;
			}
		}

		for (int i = A.size() - 1; i >= end + 1; --i) {
			if (A.get(i) < max) {
				end = i;
				break;
			}
		}

		list.add(st);
		list.add(end);

		return list;
	}

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(4, 15, 4, 4, 18, 19, 20);
		subUnsort(A);
	}

}
