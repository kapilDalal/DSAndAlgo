package devideAndConquer;

public class MedianOfTwoSortedArrays {

	static int getMedian(int[] arr1, int[] arr2, int n) {
		if (arr1.length == 2)
			return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1])) / 2;

		int m1 = median(arr1);
		int m2 = median(arr2);

		
		int[] temp1;
		int[] temp2;
		
		if(n%2==0){
			temp1 = new int[arr1.length / 2];
			temp2 = new int[arr2.length / 2];
		}else{
			temp1 = new int[arr1.length / 2+1];
			temp2 = new int[arr2.length / 2+1];
		}
		
		if (m1 == m2)
			return m1;

		if (m1 < m2) {
			for (int i = n / 2; i < n; i++)
				temp1[i - n / 2] = arr1[i];
			for (int i = 0; i < n / 2+1; i++)
				temp2[i] = arr2[i];
		} else {
			for (int i = n / 2; i < n; i++)
				temp2[i - n / 2] = arr2[i];
			for (int i = 0; i < n / 2+1; i++)
				temp1[i] = arr1[i];
		}
		if(n%2==0)
			return getMedian(temp1, temp2, n / 2);
		else
			return getMedian(temp1, temp2, n / 2+1);
			
	}

	private static int median(int[] arr1) {
		// TODO Auto-generated method stub

		if (arr1.length % 2 == 0) {
			return (arr1[arr1.length / 2] + arr1[arr1.length - 1]) / 2;
		}
		return arr1[arr1.length / 2];
	}
	public static void main(String[] args) {
		 int arr1[] = {1, 12, 15, 26, 38};  
		 int arr2[] = {2, 13, 17, 30, 45};
		 System.out.println(getMedian(arr1, arr2, arr1.length));
	}

}
