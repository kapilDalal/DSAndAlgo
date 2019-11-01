package dp;

public class LongestIncreasingSubsequence {
	
	
	
	static int lisUtil(int[] arr,int start){
		
		if(start==arr.length-1)
			return 1;
		
		for(int i=start;i<arr.length;i++){
			if(arr[start]<arr[i]){				
				return 1 + lisUtil(arr, i);
			}
		}
		
		return 1;
	}
	//recursive approach
	static void lis(int[] arr){
		for(int i=0;i<arr.length;i++)
			System.out.println(lisUtil(arr, i));
	}
	
	
	
	static void lisUsingDp(int[] arr){
		
		int[] lis = new int[arr.length];
		
		for(int i=0;i<arr.length;i++)
			lis[i]=1;
		
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j] && lis[i]<lis[j]+1)
					lis[i] = lis[j]+1;
			}
		}
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<lis.length;i++){
			if(lis[i]>max)
				max=lis[i];
		}
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
		lis(arr);
		System.out.println();
		lisUsingDp(arr);
	}

}
