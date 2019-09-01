package searchAndSort;

public class MergeSort {


	static void sort(Integer[] arr, int n) {
		if (n >= 2) {
			int mid = n / 2;
			Integer[] left = new Integer[mid];
			for (int i = 0; i < mid; i++)
				left[i] = arr[i];
			Integer[] right = new Integer[n - mid];
			for (int i = mid ; i < n; i++)
				right[i - mid ] = arr[i];
			sort(left, mid);
			sort(right, n - mid);
			merge(arr, left, right);
		}
	}

	private static void merge(Integer[] arr, Integer[] left, Integer[] right) {

		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < left.length) {
			arr[k] = left[i];
			k++;
			i++;
		}
		while (j < right.length) {
			arr[k] = right[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		Integer[] arr ={3,2,-7,1,4,5};
		sort(arr,arr.length);
		for(Integer i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");
		}
	}


}
