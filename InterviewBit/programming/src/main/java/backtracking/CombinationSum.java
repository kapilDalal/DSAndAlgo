package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSum {
	
	static public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(B==0){
			//res.add(new ArrayList<Integer>());
			return res;
		}
		Collections.sort(A);
		generate(A,B,0,new ArrayList<Integer>(),res);
		//System.out.println(res);
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
	
	public ArrayList<ArrayList<Integer>> combinationSumBT(ArrayList<Integer> input, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        if (target == 0) {
            return ans;
        }
        
        Collections.sort(input);
        combinationR(input, ans, target, new ArrayList<>(), 0, 0);
        return ans;
    }
    
    private void combinationR(ArrayList<Integer> input, ArrayList<ArrayList<Integer>> ans, int target, ArrayList<Integer> combination, int sum, int start) {
        if (input.get(start) > target) {
            // Backtrack, as you will never find combination here
            return;
        }
        
        for (int i = start; i < input.size(); i++) {
            if (i != 0 && input.get(i) == input.get(i - 1)) {
                // Avoid duplicates, if adjacent is equal then skip that value, as it will lead to duplicates
                continue;
            }            
            
            if (sum + input.get(i) == target) {
                combination.add(input.get(i));
                ans.add(new ArrayList<>(combination));
                combination.remove(combination.size() - 1);
                break;
            } else if (sum + input.get(i) < target) {
                combination.add(input.get(i));
                combinationR(input, ans, target, combination, sum + input.get(i), i);
                combination.remove(combination.size() - 1);
            } else {
                // As the input is sorted, if current sum + input.get(i) exceeds the target, rest are obviously going to exceed it. So skip the unnecessary work
                // No more combinations possible
                break;
            }
        }
    } 
	public static void main(String[] args) {
		combinationSum(new ArrayList<Integer>(Arrays.asList(2,3,6,7)), 0);
	}

}
