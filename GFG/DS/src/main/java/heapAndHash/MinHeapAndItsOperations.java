package heap;

public class MinHeapAndItsOperations {

	static class MinHeap {

		int capacity;
		int heapSize;
		Integer[] data;

		public MinHeap(int n) {
			capacity = n;
			data = new Integer[n];
			heapSize = 0;
		}

		public void insert(int key) {
			if (heapSize >= capacity)
				throw new IndexOutOfBoundsException("heap overflow");

			data[heapSize] = key;

			int i = heapSize;

			while (i != 0 && data[parent(i)] > data[i]) {
				swap(parent(i), i);
				i = parent(i);
			}
			heapSize = heapSize + 1;
		}

		public int extractMin() {
			if (heapSize <= 0)
				throw new IndexOutOfBoundsException("heap empty");
			if (heapSize == 1) {
				heapSize = heapSize - 1;
				return data[0];
			}

			int min = data[0];
			data[0] = data[heapSize - 1];
			data[heapSize - 1] = Integer.MAX_VALUE;
			heapSize = heapSize - 1;
			minHeapify(0);
			return min;
		}

		public void decreaseKey(int index, int newVal) {
			if (index < 0 || index > heapSize)
				throw new IllegalArgumentException("index is not correct");

			data[index] = newVal;

			int i = index;

			while (i != 0 && data[parent(i)] > data[i]) {
				swap(parent(i), i);
				i = parent(i);
			}

		}

		private void minHeapify(int i) {
			int min = i;
			int left = left(i);
			int right = right(i);
			if (left < heapSize && data[left] < data[min])
				min = left;
			if (right < heapSize && data[right] < data[min])
				min = right;
			if (i != min) {
				swap(i, min);
				minHeapify(min);
			}
		}
		
		public int getMin(){
			if(heapSize>0)
				return data[0];
			return Integer.MAX_VALUE;
		}

		private void swap(int i, int j) {
			int temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}

		private int parent(int i) {
			return (i - 1) / 2;
		}

		private int left(int i) {
			return 2 * i + 1;
		}

		private int right(int i) {
			return 2 * i + 2;
		}

	}

	/*static int heapSize = -1;

	static void sort(Integer[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--)
			minHeapify(arr, i, arr.length);

		for (int i = 0; i < arr.length; i++) {
			swap(arr, 0, arr.length - i - 1);
			minHeapify(arr, 0, arr.length - i - 1);
		}
		for (int i = 0, j = arr.length - 1; i < j; i++, j--)
			swap(arr, i, j);

	}

	static void hepify(Integer[] arr) {
		heapSize = arr.length;
		for (int i = arr.length / 2 - 1; i >= 0; i--)
			minHeapify(arr, i, arr.length);
	}

	static void minHeapify(Integer[] arr, int i, int size) {
		int min = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < size && arr[left] < arr[min])
			min = left;
		if (right < size && arr[right] < arr[min])
			min = right;

		if (i != min) {
			swap(arr, i, min);
			minHeapify(arr, min, size);
		}
	}

	static int extractMin(Integer[] arr) {
		if (heapSize <= 0)
			return Integer.MAX_VALUE;

		int min = arr[0];

		if (heapSize == 1) {
			heapSize--;
			return arr[0];
		}

		arr[0] = arr[heapSize];
		arr[heapSize] = Integer.MAX_VALUE;
		heapSize--;
		minHeapify(arr, 0, heapSize);

		return min;
	}

	private static void swap(Integer[] arr, int i, int min) {
		int temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
	}*/

	public static void main(String[] args) {
		//Integer[] arr = { 7, 2, 4, 5, 3, 1, 6 };
		MinHeap minHeap = new MinHeap(7);
		minHeap.insert(7);
		minHeap.insert(2);
		minHeap.insert(4);
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(1);
		minHeap.insert(6);
		
		///System.out.println(minHeap.getMin());
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		//System.out.println(minHeap.extractMin());
		
	}

}
