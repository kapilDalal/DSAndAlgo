package dp;

import java.util.HashSet;

public class WaysToDecode {
	
	HashSet<String> set = new HashSet<String>();
	static int numOfWays = 0;
	public int numDecodings(String A) {

		numOfWays = 0;
		set.clear();
		for(int i=1;i<=26;i++) {
			set.add(String.valueOf(i));
		}
		ways("", A);
		return numOfWays;
    }
	
	private void ways(String candidate, String remaining) {
		
		// TODO Auto-generated method stub
		if(remaining.length()==0)
			numOfWays++;;
		for(int i=0;i<=1 && i<remaining.length();i++) {
			if(set.contains(remaining.substring(0, i+1))) {
				String newCandidate = candidate + remaining.substring(0, i+1);
				String remString =  remaining.substring(i+1);
				ways(newCandidate, remString);
			}
		}		
	}
	public static void main(String[] args) {
		WaysToDecode w = new WaysToDecode();
		System.out.println(w.numDecodings("1"));
		
	}

}
