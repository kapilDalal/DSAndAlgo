package jav.rev.threads;

import java.util.Arrays;
import java.util.Collections;

public class SimultaneousAscendingDescendingSortArray {
	
	static public class AscendingSort implements Runnable{

		Integer[] nums;
		
		public AscendingSort(Integer[] arr) {
			// TODO Auto-generated constructor stub
			nums = new Integer[arr.length];
			for(int i=0;i<arr.length;i++)
				nums[i] = arr[i];
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Arrays.sort(nums);
			display();
		}
		
		private void display() {
			
			for(int i=0;i<nums.length;i++)
				System.out.println(Thread.currentThread().getName() +"\t"+nums[i]);
			System.out.println();
		}
		
	}
	static public class DescendingSort implements Runnable{

		Integer[] nums;
		
		public DescendingSort(Integer[] arr) {
			// TODO Auto-generated constructor stub
			nums = new Integer[arr.length];
			for(int i=0;i<arr.length;i++)
				nums[i] = arr[i];
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Arrays.sort(nums,Collections.reverseOrder());
			display();
		}
		private void display() {
			
			for(int i=0;i<nums.length;i++)
				System.out.println(Thread.currentThread().getName() +"\t"+nums[i]);
		
		}
		
	}
	public static void main(String[] args) {
		Integer[] arr = {5,1,3,2};
		Thread t1 = new Thread(new AscendingSort(arr));
		Thread t2 = new Thread(new DescendingSort(arr));
		t1.start();
		t2.start();
		
		
	}

}
