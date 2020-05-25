package graph;

import java.util.ArrayList;

public class SteppingNumbers {
	
	public ArrayList<Integer> stepnum(int A, int B) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for(;A<=B;A++) {
			if(isStepNum(A))
				res.add(A);
		}
		
		return res;
    }

	private boolean isStepNum(int a) {
		// TODO Auto-generated method stub
		if(a<=9)
			return true;
		String str = String.valueOf(a);
		for(int i=0;i<str.length()-1;i++) {
			int first = str.charAt(i)-'a';
			int sec = str.charAt(i+1)-'a';
			if(Math.abs(first-sec)!=1)
				return false;
		}
		return true;
	}

}
