package stackAndqueue;

import java.util.ArrayList;
import java.util.List;

public class SimplifyDirectoryPath {

	static public String simplifyPath(String A) {

		String[] path = A.split("/");

		List<String> s = new ArrayList<>();

		for (String elem : path) {
			switch (elem) {
			case "..":
				if (!s.isEmpty())
					s.remove(s.size() - 1);
				break;
			case "":
			case ".":
				break;
			default:
				s.add(elem);
			}
		}

		StringBuilder sb = new StringBuilder(s.isEmpty() ? "/" : "");
		for (String elem : s)
			sb.append("/").append(elem);

		return sb.toString();

	}

	public static void main(String[] args) {
		System.out.println(simplifyPath("/home/.."));
	}

}
