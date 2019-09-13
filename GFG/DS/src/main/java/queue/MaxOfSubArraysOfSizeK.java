package queue;

import java.util.Deque;
import java.util.LinkedList;

public class MaxOfSubArraysOfSizeK {

	static void printMaxBruteForce(Integer[] numbers, int k) {
		for (int i = 0; i <= numbers.length - k; i++) {
			int max = numbers[i];
			for (int j = i + 1; j < i + k; j++) {
				if (numbers[j] > max)
					max = numbers[j];
			}
			System.out.print(max + "\t");
		}
	}

	static void maxOfSubArrayGFG(Integer[] arr, int k) {
		Deque<Integer> queue = new LinkedList<Integer>();
		int i;
		for (i = 0; i < k; i++) {
			while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()])
				queue.removeLast();
			queue.addLast(i);
		}

		for (; i < arr.length; i++) {
			System.out.print(arr[queue.peek()]+"\t");
			if (!queue.isEmpty() && i - queue.peek() >= k)
				queue.removeFirst();
			while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()])
				queue.removeLast();
			queue.addLast(i);
		}
		System.out.print(arr[queue.peek()]+"\t");
	}

	public static void main(String[] args) {
		Integer[] numbers = { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 };
		printMaxBruteForce(numbers, 4);
		System.out.println();
		maxOfSubArrayGFG(numbers, 4);
	}

}
