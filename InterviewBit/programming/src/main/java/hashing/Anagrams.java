package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Anagrams {

	static public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		HashSet<String> set = new HashSet<String>();
		
		for(int i=0;i<A.size()-1;i++){
			String str1 = A.get(i);
			for(int j=i+1;j<A.size();j++){
				str1.compareTo(A.get(j));
			}
		}
		
		System.out.println(set);
		
		return null;
	}
	public static void main(String[] args) {
		List<String> A = Arrays.asList("cat","dog","god","act");
		
		String str = "abc";
		
		System.out.println(str.compareTo("bca"));
		//charArray.toString();
		//anagrams(A);
	}

}
