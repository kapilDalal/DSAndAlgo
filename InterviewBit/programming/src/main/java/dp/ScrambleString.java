package dp;

import java.util.HashMap;

public class ScrambleString {

	public int isScramble(final String A, final String B) {
		String a = new String(A);
		String b = new String(B);
		HashMap<String, Integer> map = new HashMap<>();
		int res = solve(a, b, map);
		return res;
	}

	private int solve(String a, String b, HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		if (a.compareTo(b) == 0)
			return 1;
		if (a.length() <= 0)
			return 0;
		String key = a + " " + b;
		if (map.containsKey(key))
			return map.get(key);
		int res = 0;
		for (int i = 1; i < a.length(); i++) 
		{
			if ( (solve(a.substring(0, i), b.substring(0, i), map) == 1 && solve(a.substring(i), b.substring(i), map) == 1)
					|| (solve(a.substring(0, i), b.substring(b.length() - i), map) == 1 && solve(a.substring(i), b.substring(0, b.length()-i), map) == 1)) 
			{
				res = 1;
				break;
			}
		}
		map.put(key, res);
		return res;
	}

	public static void main(String[] args) {
		ScrambleString ss = new ScrambleString();
		System.out.println(ss.isScramble("great", "rgtae"));
		;
	}
}
