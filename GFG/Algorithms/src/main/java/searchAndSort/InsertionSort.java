package searchAndSort;

public class InsertionSort {
	
	private static void swap(Integer[] arr, int i, int minIndex) {
		int temp = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex]=temp;
		
	}
	
	static void sort(Integer[] arr){		
		for(int i=1;i<arr.length;i++){				
			if(arr[i-1]>arr[i]){
				int j=i-1;				
				while(j>=0 && arr[j]>arr[i])
					j--;
				swap(arr,i,j+1);
			}			
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
