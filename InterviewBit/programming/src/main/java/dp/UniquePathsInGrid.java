package dp;

public class UniquePathsInGrid {
	public int uniquePathsWithObstacles(int[][] A) {

		if (A[0][0] == 1 || A[A.length - 1][A[0].length - 1] == 1)
			return 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1) {
					A[i][j] = -1;
				}
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i][0] != -1)
				A[i][0] = 1;
			else
				break;
		}
		for (int j = 0; j < A[0].length; j++) {
			if (A[0][j] != -1)
				A[0][j] = 1;
			else
				break;
		}
		for (int i = 1; i < A.length; i++) {
			for (int j = 1; j < A[0].length; j++) {
				if (A[i][j] != -1) {
					if (A[i - 1][j] == -1 || A[i][j - 1] == -1)
						A[i][j] = Math.max(A[i - 1][j], A[i][j - 1]);
					else
						A[i][j] = A[i - 1][j] + A[i][j - 1];
				}
			}
		}
		return A[A.length - 1][A[0].length - 1] == -1 ? 0 : A[A.length - 1][A[0].length - 1];
	}

}
