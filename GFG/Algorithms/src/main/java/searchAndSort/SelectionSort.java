package searchAndSort;

public class SelectionSort {
	
	static void sort(Integer[] arr){
		
		for(int i=0;i<arr.length;i++){
			int minIndex = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[minIndex]>arr[j])
					minIndex = j;
			}
			if(minIndex!=i)
				swap(arr,i,minIndex);
		}
		
		
	}
	
	private static void swap(Integer[] arr, int i, int minIndex) {
		int temp = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex]=temp;
		
	}

	public static void main(String[] args) {
		Integer[] arr ={3,2,-7,1,4};
		sort(arr);
		for(Integer i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");
		}
	}

}
