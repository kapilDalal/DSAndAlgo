package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumPathInTriangle {

	static public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
		int res = Integer.MAX_VALUE;				
		for(int i=1;i<a.size();i++){
			ArrayList<Integer> prevList = a.get(i-1);
			ArrayList<Integer> currList = a.get(i);
			for(int j=0;j<currList.size();j++){
				if(j==0){
					currList.set(j, currList.get(0)+prevList.get(0));
				}else if(j==currList.size()-1){
					currList.set(j, currList.get(j)+prevList.get(prevList.size()-1));
				}else{
					int min = Math.min(prevList.get(j-1),prevList.get(j));
					currList.set(j, currList.get(j)+min);
				}
			}
		}
		System.out.println(a.get(a.size()-1));
		for(int i=0;i<a.get(a.size()-1).size();i++){
			res = Math.min(a.get(a.size()-1).get(i), res);
		}
		System.out.println(res);
		return res;
	}
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		a.add(new ArrayList<Integer>(Arrays.asList(2)));
		a.add(new ArrayList<Integer>(Arrays.asList(3,4)));
		/*a.add(new ArrayList<Integer>(Arrays.asList(6,5,7)));
		a.add(new ArrayList<Integer>(Arrays.asList(4,1,8,3)));*/
		minimumTotal(a);
	}

}
