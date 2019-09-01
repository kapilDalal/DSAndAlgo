package searchAndSort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
	
	
	private static void swap(Integer[] arr, int i, int minIndex) {
		int temp = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex]=temp;
		
	}
	
	static void sort(Integer[] arr){
		
		boolean isSorted = false;
		
		while(!isSorted){
			isSorted = true;
			for(int i = 0;i<arr.length-1;i++){
				if(arr[i]>arr[i+1]){
					isSorted = false;
					swap(arr,i,i+1);
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		/*Integer[] arr ={3,2,-7,1,-4};
		sort(arr);
		for(Integer i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");
		}*/
		List<String> list = new ArrayList<String>();
		list.add("kapil");
		list.add("dalal");
		String str = "name is"+list.toString();
		System.out.println(str);
		
	}

}
