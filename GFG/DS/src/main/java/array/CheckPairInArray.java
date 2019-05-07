package array;

public class CheckPairInArray {

	static boolean checkPairPresent(Integer[] arr, Integer sum) {
		for (int i = 0; i < arr.length; i++) {
			int leftSum = sum - arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] == leftSum)
					return true;
			}
		}
		return false;
	}

	static boolean checkPairPresentGFG(Integer[] arr, int sum) {

		heapSort(arr);

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			if (arr[left] + arr[right] == sum)
				return true;
			else if (arr[left] + arr[right] > sum)
				right--;
			else if (arr[left] + arr[right] < sum)
				left++;
		}

		return false;
	}

	private static void buildMaxHeap(Integer[] arr, int len, int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		int largest = i;

		if (left < len && arr[left] > arr[largest])
			largest = left;
		if (right < len && arr[right] > arr[largest])
			largest = right;

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			buildMaxHeap(arr, len, largest);
		}
	}

	static void heapSort(Integer[] arr) {
		for (int i = ((arr.length / 2) - 1); i >= 0; i--)
			buildMaxHeap(arr, arr.length, i);

		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			buildMaxHeap(arr, i - 1, 0);

		}
	}

	public static void main(String[] args) {

		Integer[] arr = { 1, 4, 8, 9, 2, 7 };

		System.out.print(checkPairPresentGFG(arr, 11));

	}

}
