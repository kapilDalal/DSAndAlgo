package arrays;

import java.util.Arrays;

public class CountingSort {
	
	int range = 9;

	void sort(int[] arr) {

		int[] temp = new int[range + 1];
		int[] res = new int[arr.length];
		Arrays.fill(temp, 0);

		for (int i = 0; i < arr.length; i++)
			temp[arr[i]]++;

		for (int i = 1; i < temp.length; i++)
			temp[i] = temp[i - 1] + temp[i];
		
		// Build the output character array 
        // To make it stable we are operating in reverse order. 
		for (int i = arr.length-1; i >=0; i--) {
			int index = temp[arr[i]]-1;
			temp[arr[i]]--;
			res[index] = arr[i];
		}

		for (int i = 0; i < res.length; i++)
			System.out.print(res[i] + "\t");
	}

	public static void main(String[] args) {
		CountingSort cs = new CountingSort();
		cs.sort(new int[] { 1, 4, 1, 2, 7, 5, 2 });
	}

}
