package dp;

public class MinCost {

	static int[] step_i = { 0, 1, 1 };
	static int[] step_j = { 1, 1, 0 };

	static int minDist(int[][] cost, int n_row, int n_col, int t_row, int t_col) {
		if (n_row > t_row || n_col > t_col)
			return Integer.MAX_VALUE;

		else if (n_row == t_row && n_col == t_col)
			return cost[n_row][n_col];

		else {
			int min = min(minDist(cost, n_row + step_i[0], n_col + step_j[0], t_row, t_col),
					minDist(cost, n_row + step_i[1], n_col + step_j[1], t_row, t_col),
					minDist(cost, n_row + step_i[2], n_col + step_j[2], t_row, t_col));
			return cost[n_row][n_col] + min;
		}
	}

	static void minDistUsingDp(int[][] cost, int t_row, int t_col) {
		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost.length; j++) {
				int top, left, diagonal;
				top = left = diagonal = Integer.MAX_VALUE;
				if (i - 1 >= 0 && j - 1 >= 0)
					diagonal = cost[i - 1][j - 1];
				if (i - 1 >= 0)
					top = cost[i - 1][j];
				if (j - 1 >= 0)
					left = cost[i][j - 1];
				if (top == left && top == diagonal)
					cost[i][j] = cost[i][j];
				else
					cost[i][j] = cost[i][j] + min(top, left, diagonal);
			}
		}

		System.out.println(cost[t_row][t_col]);
	}

	private static int min(int x, int y, int z) {
		if (x <= y && x <= z)
			return x;
		else if (y <= x && y <= z)
			return y;
		else
			return z;
	}

	public static void main(String[] args) {
		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		// System.out.println(minDist(cost,0,0,2,2));
		minDistUsingDp(cost, 2, 2);

	}

}
