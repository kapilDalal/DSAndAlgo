package searchAndSort;

public class QuickSort {
	
	private static void swap(Integer[] arr, int i, int minIndex) {
		int temp = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex]=temp;
		
	}
	
	static void sort(Integer[] arr,int start,int end){
		if(start<end){
			int pivotIndex = partition(arr,start,end);
			sort(arr,start,pivotIndex-1);
			sort(arr,pivotIndex+1,end);
		}
	}

	private static int partition(Integer[] arr, int start, int end) {
		int pivot = arr[end];
		int pivotIndex=start;
		for(int i=start;i<end;i++){
			if(arr[i]<pivot){
				swap(arr,i,pivotIndex);
				pivotIndex++;
			}
		}
		swap(arr,pivotIndex,end);
		return pivotIndex;
	}
	
	public static void main(String[] args) {
		Integer[] arr ={3,2,-7,1,4,5};
		sort(arr,0,arr.length-1);
		for(Integer i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");
		}
	}


}
