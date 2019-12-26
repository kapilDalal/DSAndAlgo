package math;

public class SortedPermutationRank {

	public int findRank(String A) {
		int res = 0;
		for (int i = A.length() - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (A.charAt(i) < A.charAt(j)) {
					res = (res + (int) fact(A.length() - j - 1)) % 1000003;
				}
			}
		}
		return res + 1;
	}

	public long fact(int n) {
		if (n <= 1)
			return 1;
		return n * fact(n - 1);
	}

}
