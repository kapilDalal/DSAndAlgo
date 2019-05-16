package array;

public class ArrayRotation {

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	static void rotateArray(Integer[] arr, int rotateBy) {
		int n = arr.length;
		int g_c_d = gcd(rotateBy, n);

		for (int i = 0; i < g_c_d; i++) {
			int temp = arr[i];
			int j = i;
			while (true) {
				int k = (j + rotateBy) % n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}

	static void reverse(Integer[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	static void rotateReversalMethod(Integer[] arr, int rotateBy) {
		rotateBy = rotateBy % arr.length;
		reverse(arr, 0, rotateBy - 1);
		reverse(arr, rotateBy, arr.length - 1);
		reverse(arr, 0, arr.length - 1);

	}

	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		// rotateArray(arr, 8);
		// reverse(arr, 2, 6);
		rotateReversalMethod(arr, 8);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + "\t");
	}
}
