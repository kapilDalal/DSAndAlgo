package backtracking;

import java.util.ArrayList;

public class Combinations {
	static public ArrayList<ArrayList<Integer>> combine(int A, int B) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(B==0){			
			return res;
		}
		generate(A,B,1,new ArrayList<Integer>(),res);
		System.out.println(res);
		return res;
    }

	static private void generate(int a, int b, int s, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {		
		if(temp.size()==b){
			res.add(new ArrayList<Integer>(temp));	
			return;
		}
		for(int i=s;i<=a;i++){			
			temp.add(i);			
			generate(a, b, i+1, temp, res);
			if(temp.size()>0)
				temp.remove(temp.size()-1);			
		}
		
	}
	public static void main(String[] args) {
		combine(4, 2);
	}

}
