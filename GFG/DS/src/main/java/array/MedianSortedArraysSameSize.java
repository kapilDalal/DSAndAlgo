package array;

public class MedianSortedArraysSameSize {

	static int getMedian(Integer[] arr1, Integer[] arr2) {
		int medianIndex = (arr1.length + arr2.length) / 2;
		int i, j, k;
		i = j = k = 0;
		while (i < arr1.length || j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				i++;
				k++;
			} else {
				j++;
				k++;
			}
			if (k == medianIndex) {
				if ((arr1.length + arr2.length) % 2 != 0) {
					if (arr1[i] < arr2[j])
						return arr1[i];
					else
						return arr2[j];
				} else {
					int second;
					if (arr1[i] < arr2[j]) {
						if (arr1[i - 1] > arr2[j - 1]) {
							second = arr1[i - 1];
						} else {
							second = arr2[j - 1];
						}
						return (arr1[i] + second) / 2;
					} else {
						if (arr1[i - 1] > arr2[j - 1]) {
							second = arr1[i - 1];
						} else {
							second = arr2[j - 1];
						}
						return (arr2[j] + second) / 2;
					}
				}
			}

		}
		return -1;
	}
	
	//gfg second method is better than the one implemented here
	static int medianOfTwoArrays(Integer[] arr1,Integer[] arr2,int start1,int end1,int start2,int end2){
		
		int median =-1;
		
		if(end1-start1==0)
			return (arr1[0]+arr2[0])/2;
		
		if(end1-start1==1)
			return (Math.max(arr1[start1], arr2[start2])+Math.min(arr1[end1], arr2[end2]))/2;
		
		
		int m1 = getMedian27Aug(arr1, start1, end1);
		int m2 = getMedian27Aug(arr2, start2, end2);
		
		if(m1==m2)
			return m1;
		
		
		
		if(m1<m2)
			median = medianOfTwoArrays(arr1, arr2, (start1+end1)/2, end1, start2, (start2+end2)/2);
		else
			median = medianOfTwoArrays(arr1, arr2, start1, (start1+end1)/2, (start2+end2)/2, end2);
		
		return median;
	}
	
	
	static int getMedian27Aug(Integer[] arr1,int start,int end){
		return arr1[(start+end)/2];
	}
	

	public static void main(String[] args) {
		Integer[] arr1 = { 1, 12, 15, 26, 38 };
		Integer[] arr2 = { 2, 13, 17, 30, 45};
		int median = getMedian(arr1, arr2);
		
		System.out.println(medianOfTwoArrays(arr1, arr2, 0, arr1.length-1, 0, arr2.length-1));
		System.out.println(median);
	}
}
