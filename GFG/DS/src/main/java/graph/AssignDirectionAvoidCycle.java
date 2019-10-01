package graph;

import java.util.Iterator;
import java.util.Stack;

public class AssignDirectionAvoidCycle {

	static void topologicalSortUtil(Graph g, int i, Stack<Integer> s, boolean[] visited) {
		visited[i] = true;
		Iterator<Integer> iterator = g.adjList[i].iterator();

		while (iterator.hasNext()) {
			int next = iterator.next();

			if (!visited[next])
				topologicalSortUtil(g, next, s, visited);
		}
		s.add(i);
	}

	static Integer[] topologicalSort(Graph g) {
		boolean[] visited = new boolean[g.numberOfVertices()];
		Stack<Integer> s = new Stack<Integer>();
		Integer[] result = new Integer[g.numberOfVertices()];
		for (int i = 0; i < g.numberOfVertices(); i++) {
			if (!visited[i])
				topologicalSortUtil(g, i, s, visited);
		}
		int i = 0;
		while (!s.isEmpty())
			result[i++] = s.pop();
		return result;
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(0, 2); 
		g.addEdge(0, 5); 
		g.addEdge(4, 5); 
		g.addEdge(4, 1); 
		g.addEdge(2, 3); 
		g.addEdge(3, 1); 
		Integer[] res = topologicalSort(g);
		for(int i=0;i<res.length;i++)
			System.out.print(res[i]+"\t");
	}

}
