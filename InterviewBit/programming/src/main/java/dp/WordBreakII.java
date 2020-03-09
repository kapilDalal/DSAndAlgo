package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreakII {
	
	static public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
		
		ArrayList<String> res = new ArrayList<>();
		
		boolean[] dp = new boolean[A.length()+1];
		dp[0] = true;
		
		for(int i=1;i<=A.length();i++){
			for(int j=0;j<i;j++){
				if(dp[j] && B.contains(A.substring(j,i))){
					dp[i] = true;
					break;
				}
			}
		}
		if(dp[A.length()]==false)
			return res;
		
		for(int i=0;i<A.length();i++){
			for(int j=i+1;j<=A.length();j++){
				if(B.contains(A.substring(i,j)))
					res.add(A.substring(i,j));
			}
		}
		Arrays.sort(res.toArray());
		return res;
    }
	
	public static void main(String[] args) {
		System.out.println(wordBreak("catsanddog",new ArrayList<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
	}

}
