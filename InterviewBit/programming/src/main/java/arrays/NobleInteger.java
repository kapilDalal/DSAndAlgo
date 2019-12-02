package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class NobleInteger {
	
	static public int solve(List<Integer> A) {
		int result = -1;
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		for(int i=0;i<A.size();i++){
			int key = A.get(i);
			if(map.containsKey(key)){
				int val = map.get(key);
				map.put(key, val+1);
			}else{
				map.put(key, 1);
			}
		}
		
		Set<Integer> keySet = map.keySet();
		Collection<Integer> values = map.values();
		ArrayList<Integer> k = new ArrayList<Integer>(keySet);
		ArrayList<Integer> v = new ArrayList<Integer>(values);
		System.out.println(k);
		System.out.println(v);
		
		for(int i=0;i<k.size();i++){
			int e = k.get(i);
			int sum = 0;
			for(int j=i+1;j<v.size();j++){
				sum += v.get(j);	
				if(sum>e)
					break;
			}
			if(sum==e)
				return 1;
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		List<Integer> A =  Arrays.asList(6, 7, 5);
		System.out.println(solve( A));
		
	}

}
