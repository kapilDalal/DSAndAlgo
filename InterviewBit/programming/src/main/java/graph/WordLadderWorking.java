package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderWorking {

	class Graph {
		Map<String, List<String>> adjList = new HashMap();		
		Map<String,ArrayList<ArrayList<String>>> path = new HashMap<String, ArrayList<ArrayList<String>>>();
		Set<String> visited = new HashSet();
		Map<String, Integer> distTo = new HashMap();
	}

	boolean canBeTransformed(String s1, String s2) {
		boolean ret = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (ret == true)
					return false;
				ret = true;
			}
		}
		return true;
	}

	void bfs(Graph graph, String start, String end) {
		Queue<String> q = new LinkedList<>();
		q.offer(start);
		while (!q.isEmpty()) {
			String cur = q.poll();
			int dis = graph.distTo.getOrDefault(cur, 0) + 1;
			List<String> list = graph.adjList.get(cur);
			for (String l : list) {
				if (!graph.visited.contains(l)) {
					graph.visited.add(l);
					graph.distTo.put(l, dis);
					q.offer(l);
				}
			}
		}
	}
	static ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	void dfs(Graph g,String s,String e,ArrayList<String> res) {
		if(s.equals(e)) {
			result.add(res);
			return;
		}		
		List<String> list = g.adjList.get(s);
		for(String str : list) {			
			if(!g.visited.contains(str)) {
				g.visited.add(str);
				ArrayList<String> res1 = new ArrayList<String>(res);
				res1.add(str);			
				dfs(g, str, e, res1);
			}			
		}
	}

	public int solve(String A, String B, ArrayList<String> C) {
		C.add(B);
		Graph graph = new Graph();
		graph.adjList.put(A, new ArrayList<>());
		if (A.equals(B)) {
			return 1;
		}
		if (canBeTransformed(A, B)) {
			return 2;
		}
		for (String str : C) {
			if (canBeTransformed(A, str)) {
				graph.adjList.get(A).add(str);
			}
		}
		for (int i = 0; i < C.size(); i++) {
			String s1 = C.get(i);
			graph.adjList.put(s1, new ArrayList<>());
			for (int j = 0; j < C.size(); j++) {
				String s2 = C.get(j);
				if (!s1.equals(s2) && canBeTransformed(s1, s2)) {
					graph.adjList.get(s1).add(s2);
				}
			}
		}
		//bfs(graph, A, B);
		dfs(graph, A, B,new ArrayList<String>());
		return graph.distTo.containsKey(B) ? graph.distTo.get(B) + 1 : 0;
	}
	
	public static void main(String[] args) {
		WordLadderWorking wli = new WordLadderWorking();
		int res = wli.solve("hit", "cog", new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log")));
		System.out.println(result);
	}

}
