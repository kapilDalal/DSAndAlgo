package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class TusharBirthdayBombs {

	static public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
		TreeMap<Integer, ArrayList<Integer>> res = new TreeMap<Integer, ArrayList<Integer>>();
		findKicks(0, 0, A, B, new ArrayList<Integer>(), res);
		if (res.size() == 0)
			return new ArrayList<Integer>();
		return res.lastEntry().getValue();
	}

	static void findKicks(int index, int sum, int target, ArrayList<Integer> strengths, ArrayList<Integer> list,
			TreeMap<Integer, ArrayList<Integer>> res) {
		if (sum > target)
			return;
		if (list.size() > 0) {
			if (res.isEmpty())
				res.put(list.size(), list);
			else {
				if (res.lastKey() < list.size()) {
					res.put(list.size(), list);
					res.pollFirstEntry();
				}
			}
		}
		for (int i = index; i < strengths.size(); i++) {
			if (sum + strengths.get(i) <= target && sum + strengths.get(i) > sum) {
				ArrayList<Integer> newList = new ArrayList<Integer>(list);
				newList.add(i);
				findKicks(i, sum + strengths.get(i), target, strengths, newList, res);
			}
		}

	}

	static public int sumDiff(ArrayList<Integer> ans, ArrayList<Integer> B, int A) {
		int sum = 0;
		for (int i = 0; i < ans.size(); i++) {
			sum += B.get(ans.get(i));
		}
		return A - sum;
	}

	static public ArrayList<Integer> solveGreedy(int A, ArrayList<Integer> B) {
		int min = Integer.MAX_VALUE;
		int ind = -1;
		for (int i = 0; i < B.size(); i++) {
			if (min > B.get(i)) {
				min = B.get(i);
				ind = i;
			}
		}
		int maxKicks = A / min;
		int temp = maxKicks;
		ArrayList<Integer> ans = new ArrayList<>();
		if (maxKicks == 0) {
			return ans;
		}
		for (int i = 0; i < maxKicks; i++) {
			ans.add(ind);
		}
		int sum = maxKicks * B.get(ind);
		for (int i = 0; i < ind; i++) {
			if (sumDiff(ans, B, A) == 0 || temp == 0) {
				Collections.sort(ans);
				return ans;
			}
			while ((sum - B.get(ind) + B.get(i)) <= A && temp != 0) {
				ans.remove(0);
				ans.add(i);
				temp--;
				sum += (B.get(i) - B.get(ind));
			}
		}
		Collections.sort(ans);
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(solveGreedy(11, new ArrayList<Integer>(Arrays.asList(4, 3))));
	}

}
