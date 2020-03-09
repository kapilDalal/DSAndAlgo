package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenation {

	static public ArrayList<Integer> findSubstring(String A, final List<String> B) {

		HashMap<String, Integer> mainMap = new HashMap<>();
		for (int i = 0; i < B.size(); i++) {
			mainMap.put(B.get(i), mainMap.getOrDefault(B.get(i), 0) + 1);
		}
		ArrayList<Integer> res = new ArrayList<>();
		if (B.size() == 0 || A.length() == 0)
			return res;
		int len = B.get(0).length();
		for (int i = 0; i <= A.length() - len; i++) {
			String str = A.substring(i, i + len);
			HashMap<String, Integer> map = new HashMap<>(mainMap);
			if (map.containsKey(str)) {
				if (map.get(str) > 1) {
					map.put(str, map.get(str) - 1);
				} else {
					map.remove(str);
				}
				if (map.isEmpty()) {
					res.add(i);
					continue;
				}
				int j = i + len;
				for (; j <= A.length() - len; j = j + len) {
					str = A.substring(j, j + len);
					if (map.containsKey(str)) {
						if (map.get(str) > 1) {
							map.put(str, map.get(str) - 1);
						} else {
							map.remove(str);
						}
						if (map.isEmpty()) {
							res.add(i);

							break;
						}
					}else{
						break;
					}
				}

			}
		}
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {
		findSubstring("c", new ArrayList<String>(Arrays.asList("c")));
	}

}
