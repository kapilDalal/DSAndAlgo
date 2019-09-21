package graph;

import java.util.Iterator;

public class IsCyclicUndirectedDFS {

	private static void isCyclicUtil(int src, int current, int parent, boolean[] visited, boolean[] cyclic,
			UndirectedGraph g) {

		visited[current] = true;

		Iterator<Integer> iterator = g.adjList[current].iterator();

		while (iterator.hasNext()) {
			int next = iterator.next();

			if (src == next && src != parent) {
				cyclic[0] = true;
				return;
			}

			if (!visited[next] && !cyclic[0])
				isCyclicUtil(src, next, current, visited, cyclic, g);

		}

	}

	static boolean isCyclic(UndirectedGraph g) {

		int numOfVertices = g.numberOfVertices();
		for (int i = 0; i < numOfVertices; i++) {
			boolean[] visited = new boolean[numOfVertices];
			boolean[] cyclic = new boolean[1];
			isCyclicUtil(i, i, -1, visited, cyclic, g);
			if (cyclic[0])
				return true;
		}
		return false;
	}

	public static void main(String[] args) {

		UndirectedGraph g = new UndirectedGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(2, 3);
		// g.addEdge(3, 3);
		g.addEdge(2, 0);
		// g.addEdge(3, 1);
		if (isCyclic(g))
			System.out.println("cyclic");

	}

}
