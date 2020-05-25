package dp;

import java.util.Arrays;

public class NDigitNumberWithDigitSumS {
	static int num = 0;

	public static int solve(int A, int B) {

		num = 0;
		calc(0, 0, A, B);
		return num;
	}

	private static void calc(int numOfDigits, int sum, int targetNumOfDigits, int targetSum) {
		// TODO Auto-generated method stub
		if (sum > targetSum)
			return;
		if (sum == targetSum && numOfDigits == targetNumOfDigits) {
			num++;
			return;
		}
		if (numOfDigits >= targetNumOfDigits)
			return;
		for (int i = 0; i <= 9; i++) {
			if (sum + i >= 1 && sum + i <= targetSum)
				calc(numOfDigits + 1, sum + i, targetNumOfDigits, targetSum);
		}
	}

	static public int solveDp(int n, int s) {
		long[][] memo = new long[n + 1][s + 1];
		for (int i = 0; i < memo.length; ++i) {
			Arrays.fill(memo[i], -1);
		}
		int res = (int) solve(n, s, memo);
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=s;j++) {
				System.out.print(memo[i][j]+"\t");
			}
			System.out.println();
		}
		return res;
	}

	private static long solve(int n, int s, long[][] memo) {
		if (n == 0) {
			return s == 0 ? 1L : 0L;
		}
		if (s <= 0) {
			return 0L;
		}
		if (memo[n][s] != -1L) {
			return memo[n][s];
		}

		long count = 0;
		for (int d = 0; d < 10 && d <= s; ++d) {
			count += solve(n - 1, s - d, memo);
		}

		return memo[n][s] = count % 1000000007L;
	}

	public static void main(String[] args) {
		System.out.println(solveDp(2, 4));
	}
}
