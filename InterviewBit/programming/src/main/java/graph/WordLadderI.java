package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class WordLadderI {	
	boolean conversion;
	int minT;
	public int solve(String A, String B, ArrayList<String> C) {		
		conversion = false;
		minT = Integer.MAX_VALUE;
		transformations(A,A, B, C,0);
		if(minT!=Integer.MAX_VALUE)
			return 0;
		return minT;
	}

	void transformations(String src,String a, String b, ArrayList<String> c,int t) {
		if (a.equals(b)) {
			conversion = true;
			minT = Math.min(t, minT);
			return;
		}
		if (charDiff(a, b) == 1) {			
			conversion = true;
			minT = Math.min(t+1, minT);
			return;
		}
		Iterator<String> itr = c.iterator();
		while (itr.hasNext()) {
			String next = itr.next();
			if (charDiff(a, next) == 1 && !next.equals(src)) {
				itr.remove();
				transformations(src,next, b, c,t+1);
			}
		}		
	}

	private int charDiff(String a, String b) {
		// TODO Auto-generated method stub
		int count = 0;

		if (a.length() != b.length())
			return count;

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				count++;
			if (count >= 2)
				return count;
		}

		return count;
	}

	public static void main(String[] args) {
		WordLadderI wli = new WordLadderI();
		int res = wli.solve("sgtra", "plvgf", new ArrayList<String>(Arrays.asList("pjvgf", "pgtra", "pglga", "pgwra", "pgggf", "pglra", "ppggf", "ppvgf", "pggga", "sgtra", "plvgf")));
		System.out.println(res);
	}

}
