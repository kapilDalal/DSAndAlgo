package array;

import java.util.HashMap;

public class MajorityElement {

	// returns Integer.MIN_VALUE if no majority element
	static int getMajority(Integer[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				Integer val = map.get(arr[i]);
				val = val + 1;
				if (val > arr.length / 2)
					return arr[i];
				map.put(arr[i], val);
			} else {
				map.put(arr[i], 1);
			}
		}
		return Integer.MIN_VALUE;
	}
	

	public static void main(String[] args) {

		Integer[] arr = { 1, 2, 3, 3, 3, 3 };
		System.out.println(getMajority(arr));

	}
}
