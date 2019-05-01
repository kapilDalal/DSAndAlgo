package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min])
					min = j;
			}
			if (min != i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean swapped = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			if (swapped == false)
				break;
		}
	}

	public static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				int temp = arr[i];
				int j;
				for (j = i - 1; j >= 0; j--) {
					if (arr[j] > temp)
						arr[j + 1] = arr[j];
					else
						break;
				}
				arr[j + 1] = temp;
			}
		}
	}

	private static void merge(int[] arr, int[] left, int[] right) {
		int lLength = 0, rLength = 0, tLength = 0;
		while (lLength < left.length && rLength < right.length) {
			if (left[lLength] < right[rLength]) {
				arr[tLength++] = left[lLength++];
			} else {
				arr[tLength++] = right[rLength++];
			}

		}
		while (lLength < left.length)
			arr[tLength++] = left[lLength++];
		while (rLength < right.length)
			arr[tLength++] = right[rLength++];
	}

	public static void mergeSort(int[] arr) {
		int n = arr.length;
		if (n < 2)
			return;
		{

			int mid = n / 2;
			int[] left = new int[mid];
			int[] right = new int[n - mid];
			for (int i = 0; i < mid; i++)
				left[i] = arr[i];
			for (int i = mid; i < n; i++)
				right[i - mid] = arr[i];
			mergeSort(left);
			mergeSort(right);
			merge(arr, left, right);

		}

	}

	private static int partition(int[] arr, int start, int end) {

		int pivot = end - 1;
		int pindex = start;

		for (int i = start; i < end - 1; i++) {
			if (arr[i] < arr[pivot]) {
				int temp = arr[i];
				arr[i] = arr[pindex];
				arr[pindex] = temp;
				pindex++;
			}
		}
		int temp = arr[pivot];
		arr[pivot] = arr[pindex];
		arr[pindex] = temp;

		return pindex;
	}

	public static void quickSort(int[] arr, int start, int end) {

		if (start < end) {
			int pivot = partition(arr, start, end);
			
			// we are not taking pivot-1 here
			// because in partition function
			// pivot = end-1 and we are passing
			// length as total length not
			// length-1 while calling quickSort.
			quickSort(arr, start, pivot);
			quickSort(arr, pivot + 1, end);

		}

	}

	private static void maxHeapify(int[] arr, int n, int i) {
		if (i < 0 || i > n)
			return;
		int largest = i;
		int leftChild = 2 * i + 1;
		int rightChild = 2 * i + 2;
		if (leftChild < n && arr[leftChild] > arr[largest])
			largest = leftChild;
		if (rightChild < n && arr[rightChild] > arr[largest])
			largest = rightChild;
		if (i != largest) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			maxHeapify(arr, n, largest);
		}
	}

	public static void buildAndSortMaxHeap(int[] arr) {
		//build max heap
		for (int i = arr.length / 2; i >= 0; i--)
			maxHeapify(arr, arr.length, i);
		
		//sort the heap, swap the max element node with last element and call maxHeapify
		//now last is max, and the second-max element is at root 
		//so swap the second max with second last and call maxHeapify
		//so that the third max will be placed at third last position
		//repeat it till i>=0
		for (int i = arr.length - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			maxHeapify(arr, i, 0);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		 
		/*List<String> collected = integers
		  .stream()
		  .filter(i -> i != 2)
		  .map(Object::toString)
		  .collect(Collectors.toList());*/
		 
		
	}
}
