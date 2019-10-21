package backtracking;

import java.util.HashSet;
import java.util.Iterator;

public class AllSubsetOfSet {

	static void subStrings(String str) {

		int cnt = 1;

		while (cnt <= str.length()) {

			for (int i = 0; i < str.length(); i++) {
				if (i + cnt <= str.length())
					System.out.println(str.substring(i, i + cnt));
			}
			cnt++;

		}

	}
	//find all the subsets of a set
	static void powerSet(char[] arr) {
		int setSize = arr.length;
		int powerSetSize = (int) Math.pow(2, setSize);

		for (int i = 0; i < powerSetSize; i++) {

			for (int j = 0; j < setSize; j++) {

				if ((i & (1 << j)) > 0)
					System.out.print(arr[j]);

			}
			System.out.println();

		}

	}
	
	static void subSetsUsingExhaustRec(String remaining,HashSet<String> set){
		if(remaining==null || remaining.length()<=0)
			return;
		//System.out.println(remaining);
		set.add(remaining);
		for(int i=0;i<remaining.length();i++){			
			subSetsUsingExhaustRec(remaining.substring(0,i) + remaining.substring(i+1,remaining.length()),set);
		}
		
	}
	
	
	static void subsetUsingBacktrackingUtil(Character[] set,int start,HashSet<Character> subset,HashSet<HashSet<Character>> powerset){
		
/*		if(set.length==subset.size())
			return;*/
		;
		powerset.add(new HashSet<Character>(subset));
		for(int i=start;i<set.length;i++){
			HashSet<Character> subset1 = new HashSet<Character>(subset);
			subset1.add(set[i]);
			subsetUsingBacktrackingUtil(set, start+1, subset1, powerset);
			subset1.remove(subset1.size()-1);
		}
	}
	
	static void subsetsUsingBacktrack(Character[] set){
		HashSet<Character> subset = new HashSet<Character>();
		HashSet<HashSet<Character>> powerset = new HashSet<HashSet<Character>>();
		subsetUsingBacktrackingUtil(set, 0, subset, powerset);
		Iterator<HashSet<Character>> iterator = powerset.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

	public static void main(String[] args) {
		//subStrings("abcd");
		//powerSet(new char[]{'a','b','c'});
		/*HashSet<String> set = new HashSet<String>();
		subSetsUsingExhaustRec("abcd",set);
		System.out.println(set);*/
		subsetsUsingBacktrack(new Character[]{'a','b','c','d'});
	}

}
