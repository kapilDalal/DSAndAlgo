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

	public static void main(String[] args) {
		Integer[] arr1 = { 1, 12, 15, 26, 38 };
		Integer[] arr2 = { 2, 13, 17, 30, 45};
		int median = getMedian(arr1, arr2);
		System.out.println(median);
	}
}
