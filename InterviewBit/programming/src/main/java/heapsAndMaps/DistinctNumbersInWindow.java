package heapsAndMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DistinctNumbersInWindow {

	static public ArrayList<Integer> dNums(List<Integer> A, int B) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (B > A.size()) {
			return res;
		}
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int cnt=1;
		for(int i=0;i<A.size();i++){
			if(map.containsKey(A.get(i))){
				int val = map.get(A.get(i));
				map.put(A.get(i), val+1);
			}
			else{
				map.put(A.get(i), 1);
			}
			if(cnt==B){				
				res.add(map.keySet().size());
				int k = A.get(i-B+1);
				if(map.get(k)>1){
					int val = map.get(k);
					map.put(k, val-1);
				}
				else
					map.remove(k);
				cnt=B-1;
			}
			cnt++;
			
		}
		
		/*for (int i = 0; i < A.size() - B + 1; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = i; j < i+B; j++) {
				set.add(A.get(j));
			}
			res.add(set.size());
			set.clear();
		}*/
		return res;

	}
	public static void main(String[] args) {
		System.out.println(dNums(Arrays.asList(2, 7, 7, 81, 81), 1));
	}

}
