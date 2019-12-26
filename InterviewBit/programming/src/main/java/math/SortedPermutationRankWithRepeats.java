package math;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class SortedPermutationRankWithRepeats {
	
	public int findRank(String A) {
		int res = 0;
		
		char[] arr = A.toCharArray();
		
		
		for(int i=0;i<arr.length;i++){
			char chi = arr[i];
			HashSet<Character> set = new HashSet<Character>();	
		
			for(int j=i+1;j<arr.length;j++){
				char chj = arr[j];
				if(chi>chj){
					set.add(chj);
					
				}
			}
		}
		
		
		
		for(int i=0;i<A.length()-1;i++){
			char chi = A.charAt(i);
			HashMap<Character,Integer> map = new HashMap<Character,Integer>();
			int numOfSmallerChars=0;
			int uniqueSamllerChars = 0;
			for(int j=i+1;j<A.length();j++){
				char chj = A.charAt(j);
				if(chi>chj){
					numOfSmallerChars++;
					if(map.containsKey(chj)){
						int val = map.get(chj);
						map.put(chj, val+1);
					}
					else{
						map.put(chj, 1);
					}
				}				
			}
			char[] charArray = A.substring(i+1, A.length()).toCharArray();
			uniqueSamllerChars = map.keySet().size();
			int commonNumbersSets = 1;
			Collection<Integer> values = map.values();
			Integer[] array = new Integer[values.size()];
			int l=0;
			for(Integer k : values){
				array[l++] = k;
			}		
			if(array.length>0 && !A.substring(i+1, A.length()).contains(String.valueOf(chi)))
				array[0] = array[0]-1;
			for(int k=0;k<array.length;k++){
				commonNumbersSets *= fact(array[k]);
			}
			res += (uniqueSamllerChars * fact(A.length()-i-1)/commonNumbersSets)%1000003;
		}
		
		return res+1;
    }
	private boolean allValGreaterThanOne(Integer[] array) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<array.length;i++)
			if(array[i]==1)
				return false;
		return true;
	}
	public long fact(int n) {
		if (n <= 1)
			return 1;
		return n * fact(n - 1);
	}
	public static void main(String[] args) {
		SortedPermutationRankWithRepeats sr = new SortedPermutationRankWithRepeats();
		sr.findRank("acbbaa");
		System.out.println(sr.findRank("bbbbaaaa"));
	}

}
