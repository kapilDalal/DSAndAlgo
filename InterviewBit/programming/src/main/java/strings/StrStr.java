package strings;

public class StrStr {

	public int strStr(final String A, final String B) {

		if (A.isEmpty() || B.isEmpty())
			return -1;
		int index = getIndexUsingKmp(A.toCharArray(), B.toCharArray());
		return index;
	}

	private int getIndexUsingKmp(char[] str, char[] pattern) {		
		int[] suffixEqualsPrefix = getSufffixEqualsPrefix(pattern);
		int i = 0, j = 0, pos = 0;
		boolean posAtFirstIndex = false;

		while (i < str.length && j < pattern.length) {
			if (str[i] == pattern[j]) {
				if (posAtFirstIndex == false) {
					pos = 0;
					posAtFirstIndex = true;
				}
				i++;
				j++;
			} else {
				if (j != 0) {
					j = suffixEqualsPrefix[j - 1];
					pos = i - j;
				} else {
					i++;
					pos = i;
				}
			}
		}
		if (j == pattern.length)
			return pos;
		return -1;
	}

	private int[] getSufffixEqualsPrefix(char[] pattern) {
		int[] sp = new int[pattern.length];
		int index = 0;
		sp[0] = 0;
		for (int i = 1; i < pattern.length;) {
			if (pattern[index] == pattern[i]) {
				sp[i] = index + 1;
				i++;
				index++;
			} else {
				if (index != 0) {
					index = sp[index - 1];  // not able to understand this, why
											// we are jumping to last prefix end
											// where (prefix == suffix)
				} else {
					sp[i] = 0;
					i++;
				}
			}
		}
		return sp;
	}

	public static void main(String[] args) {
		String str = "abcxabcdabcdabcy";
		String pattern = "abcdabcy";
		StrStr s = new StrStr();
		System.out.println(s.getIndexUsingKmp(str.toCharArray(), pattern.toCharArray()));

	}

}
