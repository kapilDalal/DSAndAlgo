package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class ShortestUniquePrefix {
	
	static public class TrieNode{
		TrieNode[] children;
		boolean isEndOfWord = false;
		int numberOfTimesLetterOccured = 0;
		public TrieNode(){
			children = new TrieNode[26];
			for(int i=0;i<26;i++)
				children[i] = null;			
		}
	}
	static TrieNode tCrawl = new TrieNode();
	static void insert(String str){
		TrieNode temp = tCrawl;
		for(int i=0;i<str.length();i++){
			int ch = str.charAt(i) - 'a';
			if(temp.children[ch]==null){
				temp.children[ch] = new TrieNode();				
			}
			temp = temp.children[ch];
			temp.numberOfTimesLetterOccured = temp.numberOfTimesLetterOccured + 1;
		}
		temp.isEndOfWord = true;
	}
	
	static String getPrefix(String str){
		String res = "";
		TrieNode temp = tCrawl;
		int i=0;
		while(i<str.length()){
			int ch = str.charAt(i) - 'a';
			temp = temp.children[ch];
			res = res + String.valueOf(str.charAt(i));
			int cnt=0;
			for(int j=0;j<26;j++){
				if(temp.children[j]!=null)
					cnt++;
			}
			if(cnt==1 && temp.numberOfTimesLetterOccured==1)
				break;
			i++;
		}
		
		return res;
	}
	
	static public ArrayList<String> prefix(ArrayList<String> A) {
		ArrayList<String> res = new ArrayList<>();		
		for(int i=0;i<A.size();i++)
			insert(A.get(i));
		for(int i=0;i<A.size();i++){
			res.add(getPrefix(A.get(i)));
		}
		System.out.println(res);
		return res;
    }
	public static void main(String[] args) {
		prefix(new ArrayList<String>(Arrays.asList("fwkho", "kmcoqhnw", "kuewhsqmgb", "uqcljj", "vsw", "dkqtbxi" )));
		
	}

}
