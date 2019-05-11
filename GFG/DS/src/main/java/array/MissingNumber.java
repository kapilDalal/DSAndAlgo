package array;

public class MissingNumber {

	static int getMissingNumberXORMethod(Integer[] arr, int n) {
		int res = 0;
		for (int i = 1; i <= n; i++)
			res = res ^ i;
		for (int i = 0; i < arr.length; i++) {
			res = res ^ arr[i];
		}
		return res;
	}

	static int getMissingNumberSumMethod(Integer[] arr, int n) {
		int res = (n * (n + 1)) / 2;
		for (int i = 0; i < arr.length; i++) {
			res = res - arr[i];
		}
		return res;
	}

	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4, 5, 7 };
		System.out.println(getMissingNumberSumMethod(arr, 7));
	}

}
