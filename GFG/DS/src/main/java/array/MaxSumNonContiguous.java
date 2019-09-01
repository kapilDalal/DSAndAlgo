package array;

public class MaxSumNonContiguous {
	
	static int getMaxSum(Integer[] arr){
		int cnt=0;
		int maxSum=0;
		int j=0;
		int n = arr.length;
		for(int i=0;i<n;i++){
			int sum=0;
			if(cnt==0)
				j=i+2;
			else if(cnt==1)
				j=i+3;
			sum = sum+arr[i];
			if(sum>maxSum)
				maxSum=sum;
			for(;j<n;j=j+2){
				sum = sum+arr[j];
				if(sum>maxSum)
					maxSum=sum;
			}
			if(cnt==1)
			{
				cnt=0;
			}
			else if(cnt==0){
				i=i-1;
				cnt=1;
			}
		}
		return maxSum;
	}
	
	static int findMaxSumGFG(Integer[] arr){		
		
		int exc=0;
		int inc=arr[0];
		
		for(int i=1;i<arr.length;i++){
			int excNew = Math.max(exc, inc);
			
			inc = exc+arr[i];
			exc = excNew;
		}
		
		return Math.max(inc, exc);
	}
	
	
	public static void main(String[] args) {
		Integer[] arr = {5,  5, 10, 40, 50, 35};
		System.out.println(findMaxSumGFG(arr));
	}

}
