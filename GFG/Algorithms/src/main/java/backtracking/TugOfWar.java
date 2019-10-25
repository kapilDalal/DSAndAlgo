package backtracking;

import java.util.HashSet;

public class TugOfWar {

	static int n = 10;

	static int sum = Integer.MAX_VALUE;

	static int halfSum(Integer[] arr) {
		int sum = 0;
		for (Integer num : arr)
			sum += num;
		return sum / 2;
	}

	static int sum(HashSet<Integer> subset) {
		int sum = 0;
		for (Integer num : subset)
			sum += num;
		return sum;
	}

	static HashSet<Integer> set1 = null;

	static void findFirstSet(int start, HashSet<Integer> subset, Integer[] arr) {
		if (subset.size() == n / 2) {
			if (Math.abs(halfSum(arr) - sum(subset)) < sum) {
				sum = Math.abs(halfSum(arr) - sum(subset));
				set1 = new HashSet<Integer>(subset);
			}
		}
		for (int i = start; i < arr.length; i++) {
			subset.add(arr[i]);
			findFirstSet(start + 1, subset, arr);
			subset.remove(arr[i]);
		}
	}

	public static void main(String[] args) {
		Integer[] arr = { 23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4 };
		HashSet<Integer> subset = new HashSet<Integer>();
		findFirstSet(0, subset, arr);
		System.out.println(set1);
	}

}
