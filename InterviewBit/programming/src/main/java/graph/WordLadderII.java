package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


//failing for few cases.
public class WordLadderII {
	
	
	
	ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
	public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
		
		HashMap<Character,ArrayList<Character>> map = new HashMap<>();
		for(int i=0;i<start.length();i++) {
			Character ch = start.charAt(i);
			ArrayList<Character> l = new ArrayList<Character>();
			for(int j=0;j<dict.size();j++) {
				if(dict.get(j).length()==start.length()) {
					if(!l.contains(dict.get(j).charAt(i)) && ch!=dict.get(j).charAt(i))
						l.add(dict.get(j).charAt(i));
				}
			}
			map.put(ch, l);
		}		
		fillLadder(new StringBuffer(start), new StringBuffer(end), dict, new ArrayList<String>(), new HashSet<String>(), map);
		int minSize = Integer.MAX_VALUE;
		for(int i=0;i<res.size();i++) {			
			minSize = Math.min(minSize, res.get(i).size());
		}
		
		return res;
    }
	void fillLadder(StringBuffer str, StringBuffer end, ArrayList<String> dict,ArrayList<String> list,HashSet<String> visited,HashMap<Character,ArrayList<Character>> map) {
		if(reached(str,end)) {
			res.add(list);
			return;
		}
		visited.add(str.toString());
		for(int i=0;i<str.length();i++) {
			ArrayList<Character> arrayList = map.get(str.charAt(i));
			StringBuffer temp = new StringBuffer(str);
			if(arrayList!=null)
			for(int j=0;j<arrayList.size();j++) {
				StringBuffer replace = temp.replace(i, i+1, ""+arrayList.get(j));
				String s = replace.toString();
				if(dict.contains(s) && !visited.contains(s)) {
					list.add(s);
					fillLadder(new StringBuffer(replace), end, dict, new ArrayList<String>(list), visited, map);
					list.remove(list.size()-1);
				}
			}
		}
		visited.remove(str.toString());
	}
	private boolean reached(StringBuffer str, StringBuffer end) {
		// TODO Auto-generated method stub
		if(str.length()!=end.length())
			return false;
		int cnt = 0;
		for(int i=0;i<str.length();i++)
			if(str.charAt(i)!=end.charAt(i)) {
				cnt++;
			}
		return cnt==1?true:false;
	}
	public static void main(String[] args) {
		WordLadderII wlii = new WordLadderII();
		System.out.println(wlii.findLadders("bbaa", "babb", new ArrayList<String>(Arrays.asList("baba","abba","aaba","bbbb","abaa","abab","aaab","abba","abba","abba","bbba","aaab","abaa","baba","baaa","bbaa","babb"))));
	}

}
