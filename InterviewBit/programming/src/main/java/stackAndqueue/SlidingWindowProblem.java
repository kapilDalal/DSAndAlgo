package stackAndqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowProblem {

	static class MaxHeap {

		int capacity;
		int heapSize;
		Integer[] data;

		public MaxHeap(int n) {
			capacity = n;
			data = new Integer[n];
			heapSize = 0;
		}

		public void insert(int key) {
			if (heapSize >= capacity)
				throw new IndexOutOfBoundsException("heap overflow");

			data[heapSize] = key;

			int i = heapSize;

			while (i != 0 && data[parent(i)] < data[i]) {
				swap(parent(i), i);
				i = parent(i);
			}
			heapSize = heapSize + 1;
		}

		public int extractMax() {
			if (heapSize <= 0)
				throw new IndexOutOfBoundsException("heap empty");
			if (heapSize == 1) {
				heapSize = heapSize - 1;
				return data[0];
			}

			int max = data[0];
			data[0] = data[heapSize - 1];
			data[heapSize - 1] = Integer.MIN_VALUE;
			heapSize = heapSize - 1;
			maxHeapify(0);
			return max;
		}

		public void decreaseKey(int key) {

			for (int i = 0; i < heapSize; i++) {
				if (data[i] == key)
					data[i] = Integer.MIN_VALUE;
				maxHeapify(i);
			}

		}

		private void maxHeapify(int i) {
			int max = i;
			int left = left(i);
			int right = right(i);
			if (left < heapSize && data[left] > data[max])
				max = left;
			if (right < heapSize && data[right] > data[max])
				max = right;
			if (i != max) {
				swap(i, max);
				maxHeapify(max);
			}
		}

		public int getMax() {
			if (heapSize > 0)
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

	public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
		ArrayList<Integer> res = new ArrayList<>();

		if (B >= A.size()) {
			MaxHeap mh = new MaxHeap(B);
			for (int i = 0; i < A.size(); i++)
				mh.insert(A.get(i));
			res.add(mh.getMax());
			return res;
		}
		int k = 0;
		MaxHeap mh = new MaxHeap(B + A.size());
		for (; k < B; k++) {
			mh.insert(A.get(k));

		}
		res.add(mh.getMax());
		for (; k < A.size(); k++) {
			mh.decreaseKey(A.get(k - B));
			mh.insert(A.get(k));
			res.add(mh.getMax());
		}

		return res;
	}

	public ArrayList<Integer> slidingMaximumOptimised(final List<Integer> A, int B) {
		if (null == A || A.isEmpty()) {
			return null;
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		LinkedList<Integer> window = new LinkedList<Integer>();

		// Create first window of B elements
		for (int i = 0; i < B; i++) {
			int current = A.get(i);
			// Remove all elements from end which are smaller than current
			while (!window.isEmpty() && A.get(window.peekLast()) <= current) {
				window.removeLast();
			}
			window.add(i);
		}
		result.add(A.get(window.peekFirst()));

		for (int i = B; i < A.size(); i++) {
			// Remove first so size of window remains B
			if (window.peekFirst() + B <= i) {
				window.removeFirst();
			}
			int current = A.get(i);
			// Remove all elements from end which are smaller than current
			while (!window.isEmpty() && A.get(window.peekLast()) <= current) {
				window.removeLast();
			}
			window.add(i);
			result.add(A.get(window.peekFirst()));
		}
		return result;
	}

	public static void main(String[] args) {
		SlidingWindowProblem swp = new SlidingWindowProblem();
		System.out.println(swp.slidingMaximum(Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7), 3));
		ArrayList<Integer> l = new ArrayList<>(Arrays.asList(9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10, -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1, -2, 5, -2));
		Collections.sort(l);
		System.out.println(l);
		

	}

}
