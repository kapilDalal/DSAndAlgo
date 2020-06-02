package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class WordSearchProblem {
	int[] x = {-1,1,0,0};
	int[] y = {0,0,-1,1};
	boolean found;
	public int exist(ArrayList<String> A, String B) {		
		found = false;
		for(int i=0;i<A.size();i++) {
			String str = A.get(i);
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)==B.charAt(0)) {
					dfs(i,j,A,B,0);
					if(found)
						return 1;
				}
			}
		}
		
		
		return 0;
    }

	private void dfs( int i, int j, ArrayList<String> a,String B,int index) {
		// TODO Auto-generated method stub
		if(index==B.length()-1) {
			found = true;
			return ;
		}
				
		
		for(int k=0;k<x.length;k++) {
			int nextI = i+x[k];
			int nextJ = j+y[k];
			if (nextI >= 0 && nextI < a.size() && nextJ >= 0
					&& nextJ < a.get(0).length() &&!found && a.get(nextI).charAt(nextJ)==B.charAt(index+1))
				dfs( nextI, nextJ, a, B, index+1);
		}		
	}
	
	public static void main(String[] args) {
		WordSearchProblem wsp = new WordSearchProblem();
		int res = wsp.exist(new ArrayList<String>(Arrays.asList("ABCE",
																						  "SFCS",
																						  "ADEE")), "ABFSAB");
		System.out.println(res);
	}

}
