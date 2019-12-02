package arrays;

import java.util.ArrayList;

public class AddOneToNumber {

	static public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		ArrayList<Integer> res1 = new ArrayList<Integer>();
		
		int c =  1;
		 
		for(int i=A.size()-1;i>=0;i--){
			
			int sum = c + A.get(i);
			int j = sum % 10;
			c = sum / 10;						
			res.add(j);
			
		}
		if(c!=0)
			res.add(c);
		
		int k = res.size()-1;
		while(k>=0 && res.get(k)==0){
			res.remove(k);
			k--;
		}
		
		for(int i=res.size()-1;i>=0;i--){
			res1.add(res.get(i));
		}
		
		return res1;
		
	}
	
	public static void main(String[] args) {
		//Integer[] a = {1,2,3};
		ArrayList<Integer> A =  new ArrayList<Integer>();
		A.add(9);
		A.add(9);
		A.add(9);
		A.add(9);
		
		System.out.println(plusOne(A));
	}

}
