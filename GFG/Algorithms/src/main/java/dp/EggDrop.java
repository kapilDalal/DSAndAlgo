package dp;

public class EggDrop {

	int minEggDropsRec(int totalEggs, int totalFloors) {

		if (totalEggs == 1)
			return totalFloors;

		if (totalFloors == 1 || totalFloors == 0)
			return totalFloors;

		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= totalFloors; i++) {

			int res = Math.max(minEggDropsRec(totalEggs, totalFloors - i)/* doesn't break case */,
					minEggDropsRec(totalEggs - 1, i - 1)/* break case */);
			if (res < min)
				min = res;
		}
		return min + 1;

	}

	//GFG dp solution
	/*
	 * Function to get minimum number of trials needed in worst case with n eggs and
	 * k floors
	 */
	static int eggDrop(int n, int k) {
		/*
		 * A 2D table where entery eggFloor[i][j] will represent minimum number of
		 * trials needed for i eggs and j floors.
		 */
		int eggFloor[][] = new int[n + 1][k + 1];
		int res;
		int i, j, x;

		// We need one trial for one floor and
		// 0 trials for 0 floors
		for (i = 1; i <= n; i++) {
			eggFloor[i][1] = 1;
			eggFloor[i][0] = 0;
		}

		// We always need j trials for one egg
		// and j floors.
		for (j = 1; j <= k; j++)
			eggFloor[1][j] = j;

		// Fill rest of the entries in table using
		// optimal substructure property
		for (i = 2; i <= n; i++) {
			for (j = 2; j <= k; j++) {
				eggFloor[i][j] = Integer.MAX_VALUE;
				for (x = 1; x <= j; x++) {
					res = 1 + Math.max(eggFloor[i - 1][x - 1], eggFloor[i][j - x]);
					if (res < eggFloor[i][j])
						eggFloor[i][j] = res;
				}
			}
		}

		// eggFloor[n][k] holds the result
		return eggFloor[n][k];
	}

	public static void main(String[] args) {
		EggDrop eg = new EggDrop();
		System.out.println(eg.minEggDropsRec(3, 3));

	}
}
