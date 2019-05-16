package array;

public class MergeNArrayInMPlusN {

	static void moveToEnd(Integer[] arr) {
		int j = arr.length - 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] != -1) {
				arr[j] = arr[i];
				arr[i] = -1;
				j--;
			}
		}
	}

	static void merge(Integer[] arr1, Integer[] arr2, int m, int n) {
		int k = 0;
		int j = 0;
		m = m + 1;
		while (m < arr1.length && j < arr2.length) {
			if (arr1[m] < arr2[j]) {
				arr1[k] = arr1[m];
				k++;
				m++;
			} else {
				arr1[k] = arr2[j];
				k++;
				j++;
			}
		}
		while (m < arr1.length) {
			arr1[k] = arr1[m];
			k++;
			m++;
		}
		while (j < arr2.length) {
			arr1[k] = arr2[j];
			k++;
			j++;
		}
	}

	static void mergeNToMPlusN(Integer[] arr1, Integer[] arr2) {
		moveToEnd(arr1);
		merge(arr1, arr2, arr1.length - arr2.length, arr2.length);
	}

	public static void main(String[] args) {
		Integer[] arr1 = { 2, -1, 7, -1, -1, 10, -1 };
		Integer[] arr2 = { 5, 8, 12, 14 };
		mergeNToMPlusN(arr1, arr2);
		for (int i = 0; i < arr1.length; i++)
			System.out.print(arr1[i] + "\t");
	}
}
