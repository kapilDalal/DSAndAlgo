package dp;

import java.util.HashMap;

public class SubMatrixWithSumZero {

	static public class Solution {
		
		public int solve(int[][] A) {
			if (A == null || A.length == 0 || A[0].length == 0)
				return 0;
			int n = A.length;
			int m = A[0].length;
			int ans = 0;
			for (int i = 0; i < n; i++) {
				int col[] = new int[m];
				for (int j = i; j < n; j++) {
					HashMap<Integer, Integer> map = new HashMap<>();
					for (int k = 0; k < m; k++) {
						col[k] += A[j][k];
						// System.out.print(col[k]+" “);
					}
					// System.out.println();
					int[] pre = new int[m + 1];
					for (int k = 0; k < m; k++) {
						pre[k + 1] = pre[k] + col[k];
						// System.out.print(pre[k+1]+” ");
					}
					// System.out.println();
					for (int k = 0; k <= m; k++) {
						if (map.containsKey(pre[k])) {
							ans += map.get(pre[k]);
						}
						map.put(pre[k], map.getOrDefault(pre[k], 0) + 1);

					}
					// System.out.println(ans+" "+i+" "+j);
				}
			}
			return ans;
		}
	}

}
