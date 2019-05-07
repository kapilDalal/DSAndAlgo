package array;

public class NumberOccuringOddTimes {
	
	//all other numbers occur even times except one number return that number.
	static int getOddOccurenceNumber(Integer[] arr){
		int num =0;
		for(int i=0;i<arr.length;i++)
			num = num ^ arr[i];// xor operation as 2xor2 = 0 and (2xor2xor2 = 2)
		return num;
	}
	
	
	public static void main(String[] args) {
		Integer[] arr = {1,1,2,3,4,4,2};
		System.out.println(getOddOccurenceNumber(arr));
	}
}
