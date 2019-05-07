package array;

import java.util.HashMap;

public class MajorityElement {

	// returns Integer.MIN_VALUE if no majority element
	static int getMajority(Integer[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				Integer val = map.get(arr[i]);
				val = val + 1;
				if (val > arr.length / 2)
					return arr[i];
				map.put(arr[i], val);
			} else {
				map.put(arr[i], 1);
			}
		}
		return Integer.MIN_VALUE;
	}
	
	
	static Integer getMajorityIndexMoore(Integer[] arr){
		int majIndex=0;
		int count=1;
		for(int i=1;i<arr.length;i++){
			if(arr[i]==arr[i-1]){
				count++;				
			}else{
				count--;
			}
			if(count==0){
				majIndex=i;
				count=0;
			}
		}
		return majIndex;
	}
	
	static Integer getMajorityElementMoore(Integer[] arr){
		int majIndex = getMajorityIndexMoore(arr);
		int element = arr[majIndex];
		int count=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==element)
				count++;
		}
		if(count>arr.length/2)
			return element;
		
		return Integer.MIN_VALUE;
	}
	

	public static void main(String[] args) {

		Integer[] arr = { 4, 4, 3, 4, 3, 4 };
		System.out.println(getMajorityElementMoore(arr));

	}
}
