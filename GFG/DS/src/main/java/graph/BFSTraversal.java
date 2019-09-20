package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {

	static void bfs(Graph g, int start) {
		int vertices = g.numberOfVertices();
		Queue<Integer> que = new LinkedList<Integer>();
		boolean[] visited = new boolean[vertices];
		que.add(start);
		while (!que.isEmpty()) {
			int element = que.poll();
			if (!visited[element]) {
				visited[element] = true;
				System.out.print(element + "\t");
				Iterator<Integer> iterator = g.adjList[element].iterator();
				while (iterator.hasNext()) {
					que.add(iterator.next());
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		bfs(g, 2);
		System.out.println();
	}

}
