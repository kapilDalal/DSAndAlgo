package jav.rev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Test {
	
	
	public static void main(String[] args) {
		ArrayList<Integer> arrayList  = new ArrayList<Integer>(Arrays.asList(5,8));
		LinkedList<Integer> linkedList = new LinkedList<Integer>(Arrays.asList(5,8));
		Map<String,String> map = new HashMap<String, String>();
		map.put("kapil", "complex creature");
		map.computeIfAbsent("kapil", (key) -> "dalal");
		System.out.println(map.get("kapil"));
	}

}
