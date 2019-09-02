package searchAndSort;

public class HeapSort {
	
	private static void swap(Integer[] arr, int i, int minIndex) {
		int temp = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex]=temp;
		
	}
	
	static void sort(Integer[] arr){
		
		for(int i=arr.length/2-1;i>=0;i--)
			maxHeapify(arr,arr.length,i);
		
		
		for(int i=arr.length-1;i>=0;i--){
			swap(arr,0,i);
			maxHeapify(arr, i, 0);
			
		}
		
	}
	
	static void maxHeapify(Integer[] arr,int size,int largest){
		int i=largest;
		
		int left = 2*largest+1;
		int right = 2*largest+2;
		
		if(left<size && arr[left]>arr[largest])
			largest=left;
		if(right<size && arr[right]>arr[largest])
			largest = right;
		
		if(i!=largest){
			swap(arr,i,largest);
			maxHeapify(arr,size,largest);
		}
	}
	
	static void minHeapify(Integer[] arr,int size,int smallest){
		int i=smallest;
		
		int left = 2*smallest+1;
		int right = 2*smallest+2;
		
		if(left<size && arr[left]<arr[smallest])
			smallest=left;
		if(right<size && arr[right]<arr[smallest])
			smallest = right;
		
		if(i!=smallest){
			swap(arr,i,smallest);
			minHeapify(arr,size,smallest);
		}
	}
	public static void main(String[] args) {
		Integer[] arr ={3,2,-7,1,4,5};
		sort(arr);
		for(Integer i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");
		}
	}
	

}
