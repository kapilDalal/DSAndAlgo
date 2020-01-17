package hashing;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat {

	public int lengthOfLongestSubstring(String A) {
		int len = 0;

		for (int i = 0; i < A.length(); i++) {
			int j = 0;

			String str = null;
			boolean br = false;
			for (; j <= A.length(); j++) {

				if (i + j <= A.length()) {
					str = A.substring(i, i + j);
					// System.out.println(str);
					HashSet<Character> set = new HashSet<Character>();
					int k = 0;
					for (; k < str.length(); k++) {
						char ch = str.charAt(k);
						if (set.contains(ch)) {
							len = Math.max(len, k);
							br = true;
							break;
						}

						set.add(ch);
					}
					if (br == false && k == str.length())
						len = Math.max(len, k);
					if (br)
						break;
				}

			}

		}
		if (len == 0)
			return A.length();
		return len;
	}

	public int lengthOfLongestSubstringOptimised(String A) {
		HashSet<Character> hashSet = new HashSet<Character>();
		int maxCount = 0;
		int start = 0;
		for (char c : A.toCharArray()) {
			while (hashSet.contains(c)) {
				hashSet.remove(A.charAt(start));
				start++;
			}
			hashSet.add(c);
			maxCount = Math.max(maxCount, hashSet.size());
		}

		return maxCount;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeat lswr = new LongestSubstringWithoutRepeat();

		System.out.println(lswr.lengthOfLongestSubstring("dadbc"));
	}

}
