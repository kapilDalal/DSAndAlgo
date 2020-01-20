package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSum {
	
	static public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(B==0){
			res.add(new ArrayList<Integer>());
			return res;
		}
		Collections.sort(A);
		generate(A,B,0,new ArrayList<Integer>(),res);
		System.out.println(res);
		return res;
    }

	static private void generate(ArrayList<Integer> a, int target,int sum, ArrayList<Integer> temp,
			ArrayList<ArrayList<Integer>> res) {
		if(sum==target){
			ArrayList<Integer> l = new ArrayList<>(temp);
			Collections.sort(l);
			if(!res.contains(l))
				res.add(l);
			return;
		}
		else if(sum>target)
			return;
		for(int i=0;i<a.size();i++){
			temp.add(a.get(i));
			generate(a, target, sum+a.get(i), temp, res);
			temp.remove(temp.size()-1);
		}
		
	}
	public static void main(String[] args) {
		combinationSum(new ArrayList<Integer>(Arrays.asList(2,3,6,7)), 0);
	}

}
