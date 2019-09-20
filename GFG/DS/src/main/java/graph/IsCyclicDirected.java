package graph;

import java.util.Iterator;

public class IsCyclicDirected {

	private static boolean isCyclicUtil(Graph g, boolean[] recStack, boolean[] visited, int i) {

		if (recStack[i])
			return true;
		if (visited[i])
			return false;

		visited[i] = true;
		recStack[i] = true;

		Iterator<Integer> iterator = g.adjList[i].iterator();

		while (iterator.hasNext()) {
			int next = iterator.next();

			if (isCyclicUtil(g, recStack, visited, next))
				return true;
		}
		recStack[i] = false;

		return false;
	}

	static boolean isCyclic(Graph g) {

		int numOfVertices = g.numberOfVertices();
		boolean[] visited = new boolean[numOfVertices];
		boolean[] recStack = new boolean[numOfVertices];
		for (int i = 0; i < numOfVertices; i++) {
			for (int j = 0; j < numOfVertices; j++) {
				visited[i] = false;
				recStack[i] = false;
			}

			if (isCyclicUtil(g, recStack, visited, i))
				return true;

		}

		return false;
	}

	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		// graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		if (isCyclic(graph))
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't " + "contain cycle");
	}

}
