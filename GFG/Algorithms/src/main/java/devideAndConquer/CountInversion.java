package devideAndConquer;

public class CountInversion {
	
	
	
	static int countInversion(int[] arr,int n){
		int count = 0;
		
		if(n>=2){
			
			int mid = n/2;
			int[] left = new int[mid];
			int[] right = new int[n-mid];
			
			for(int i=0;i<mid;i++){
				left[i] = arr[i];
			}
			for(int i=mid;i<n;i++)
				right[i-mid] = arr[i];
			
			count += countInversion(left,left.length);
			count += countInversion(right, right.length);
			count += count(arr,left,right);		
		}
		
		return count;
	}

	private static int count(int[] arr, int[] left, int[] right) {
		
		int i,j,k;
		i=j=k=0;
		int mid = (left.length+right.length)/2;
		int count = 0;
		while(i<left.length && j<right.length){
			
			if(left[i]<right[j]){
				arr[k] = left[i];
				i++;
				k++;
			}
			else{
				arr[k] = right[j];
				count = count + (mid-i);
				k++;
				j++;
			}
		}
		while(i<left.length)
			arr[k++] = left[i++];
		while(j<right.length)
			arr[k++] = right[j++];
		
		return count;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1, 20, 6, 4, 5};
		System.out.println(countInversion(arr, arr.length));
		
	}
	

}
