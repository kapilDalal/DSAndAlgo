package array;

public class LargestSumContiguousSubarray {

	static int getLargestSumInContiguousArray(Integer[] arr) {
		int sumTillNow, maxSum;
		sumTillNow = maxSum = 0;
		for (int i = 0; i < arr.length; i++) {
			sumTillNow = sumTillNow + arr[i];
			if (sumTillNow < 0) {
				sumTillNow = 0;
			}
			else if (maxSum < sumTillNow)
				maxSum = sumTillNow;
		}
		return maxSum;
	}

	//to handle all negative elements
	static int getLargestSumInContiguousArrayAllNegativeNumbers(Integer[] arr){
		int maxSoFar = arr[0];
		int currMax = arr[0];
		
		for(int i=0;i<arr.length;i++){
			currMax = Math.max(currMax, currMax+arr[i]);
			maxSoFar = Math.max(currMax, maxSoFar);
		}
		
		return maxSoFar;
	}
	
	
	//print sum as well as indices of the subarray
	static void getLargestSumInContiguousArrayAndPrintIndices(Integer[] arr){
		int sumTillNow, maxSum;
		sumTillNow = maxSum = 0;
		int s = -1,start = -1,end = -1;
		for (int i = 0; i < arr.length; i++) {
			sumTillNow = sumTillNow + arr[i];
			if (sumTillNow < 0) {
				sumTillNow = 0;
				s = i+1;
			}
			else if (maxSum < sumTillNow){
				maxSum = sumTillNow;
				start = s;
				end = i;
			}
		}
		
		System.out.println("start = "+start+"\tend = "+end+"\nsum = "+maxSum);
		
	}
	
	public static void main(String[] args) {
		Integer[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		getLargestSumInContiguousArrayAndPrintIndices(arr);
		//System.out.println(getLargestSumInContiguousArray(arr));
	}

}
