package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FinishingCourses {

	private int findParent(int i, int[] parent) {
		if (parent[i] == -1)
			return i;
		return findParent(parent[i], parent);
	}

	private void union(int i, int j, int[] parent) {
		int parentI = findParent(i, parent);
		int parentJ = findParent(j, parent);
		parent[parentI] = parentJ;
	}

	public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
		int[] parent = new int[A + 1];		
		Arrays.fill(parent, -1);
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
		for(int i=0;i<B.size()-1;i++) {
			int first = B.get(i);
			int second = B.get(i+1);
			if(map.containsKey(second)) {
				ArrayList<Integer> arrayList = map.get(second);
				if(!arrayList.contains(first))
					arrayList.add(first);
			}else {
				ArrayList<Integer> arrayList = new ArrayList<Integer>();
				arrayList.add(first);
				map.put(second,arrayList);
			}
		}
		for(int i=0;i<C.size()-1;i++) {
			int first = C.get(i);
			int second = C.get(i+1);
			if(map.containsKey(second)) {
				ArrayList<Integer> arrayList = map.get(second);
				if(!arrayList.contains(first))
					arrayList.add(first);
			}else {
				ArrayList<Integer> arrayList = new ArrayList<Integer>();
				arrayList.add(first);
				map.put(second,arrayList);
			}
		}
		Iterator<Entry<Integer, ArrayList<Integer>>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Integer, ArrayList<Integer>> next = iterator.next();
			ArrayList<Integer> arrayList = next.getValue();
			int first = next.getKey();
			for(int i=0;i<arrayList.size();i++) {				
				int sec = arrayList.get(i);
				int firstP = findParent(first, parent);
				int secP = findParent(sec, parent);
				if(firstP==secP)
					return 0;
				union(first, sec, parent);
			}
		}
		
		return 1;
	}
	public static void main(String[] args) {	
		FinishingCourses fc = new FinishingCourses();
		int res = fc.solve(2, new ArrayList<Integer>(Arrays.asList(1,2)), 
				new ArrayList<Integer>(Arrays.asList(2,1)));
		System.out.println(res);
	}

}
