package array;

public class SearchElementInSortedRotatedArray {

	static int getPivot(Integer[] arr, int low, int high) {

		if (high > low) {
			int mid = (low + high) / 2;
			if (mid > low && arr[mid] < arr[mid - 1])
				return mid - 1;
			if (mid < high && arr[mid] > arr[mid + 1])
				return mid;
			if (arr[low] >= arr[mid])
				return getPivot(arr, low, mid);
			return getPivot(arr, mid + 1, high);
		}

		return -1;
	}

	static int binarySearch(Integer[] arr, int low, int high, int key) {

		if (high >= low) {
			int mid = (high + low) / 2;
			if (arr[mid] == key)
				return mid;
			if (arr[mid] < key)
				return binarySearch(arr, mid + 1, high, key);
			if (arr[mid] > key)
				return binarySearch(arr, low, mid, key);
		}
		return -1;
	}

	static int searchElement(Integer[] arr, int key) {
		int pivot = getPivot(arr, 0, arr.length);
		if (pivot == -1)
			return binarySearch(arr, 0, arr.length, key);
		else if (arr[0] > key)
			return binarySearch(arr, pivot + 1, arr.length, key);
		return binarySearch(arr, 0, pivot, key);
	}

	public static void main(String[] args) {

		Integer[] arr = { 3, 4, 5, 6, 7, 1 };
		// System.out.println(getPivot(arr, 0, arr.length - 1));
		System.out.println(searchElement(arr, 7));

	}

}
