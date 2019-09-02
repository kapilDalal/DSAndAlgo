package array;

public class MergeNArrayInMPlusN {

	static void moveToEnd(Integer[] arr) {
		int j = arr.length - 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] != -1) {
				arr[j] = arr[i];
				arr[i] = -1;
				j--;
			}
		}
	}

	static void merge(Integer[] arr1, Integer[] arr2, int m, int n) {
		int k = 0;
		int j = 0;
		m = m + 1;
		while (m < arr1.length && j < arr2.length) {
			if (arr1[m] < arr2[j]) {
				arr1[k] = arr1[m];
				k++;
				m++;
			} else {
				arr1[k] = arr2[j];
				k++;
				j++;
			}
		}
		while (m < arr1.length) {
			arr1[k] = arr1[m];
			k++;
			m++;
		}
		while (j < arr2.length) {
			arr1[k] = arr2[j];
			k++;
			j++;
		}
	}

	static void mergeNToMPlusN(Integer[] arr1, Integer[] arr2) {
		moveToEnd(arr1);
		merge(arr1, arr2, arr1.length - arr2.length, arr2.length);
	}
	
	static void moveToEnd26Aug(Integer[] arr,int sizeOfOtherArr){
		for(int i=0;i<=arr.length-sizeOfOtherArr;i++){
			int temp = -1;
			if (arr[i] != -1) {
				temp = arr[i];
				for (int j = i; j < arr.length - 1; j++)
					arr[j] = arr[j + 1];
				arr[arr.length - 1] = temp;
			}
		}
	}
	static void merge26Aug(Integer[] arr1,Integer[] arr2){
		int i = arr1.length-arr2.length+1;
		int k=0;
		int j=0;
		while(i<arr1.length && j<arr2.length){
			if(arr1[i]<arr2[j]){				
				arr1[k] = arr1[i];				
				i++;
			}
			else{
				arr1[k] = arr2[j];				
				j++;
			}
			k++;
		}
		while(j<arr2.length)
			arr1[k++]=arr2[j++];
		
	}
	static void mergeNToMPlusN26Aug(Integer[] arr1,Integer[] arr2){
		moveToEnd26Aug(arr1, arr2.length);		
		merge26Aug(arr1, arr2);
	}

	public static void main(String[] args) {
		Integer[] arr1 = { 2, -1, 7, -1, -1, 10, -1 };
		Integer[] arr2 = { 5, 8, 12, 14 };
		mergeNToMPlusN26Aug(arr1, arr2);
		for (int i = 0; i < arr1.length; i++)
			System.out.print(arr1[i] + "\t");
	}
}
