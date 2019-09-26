package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import graph.ShortestPathDAGUsingTopologicalSorting.Graph.Node;

public class ShortestPathDAGUsingTopologicalSorting {

	static class Graph {

		int numberOfVertices;
		LinkedList<Node>[] adjList;

		static class Node {
			int data;
			int weight;

			public Node(int data, int weight) {
				this.data = data;
				this.weight = weight;
			}
		}

		public Graph(int v) {
			this.numberOfVertices = v;
			adjList = new LinkedList[v];

			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Node>();
		}

		public void addEdge(int src, int dest, int weight) {
			Node node = new Node(dest, weight);
			adjList[src].add(node);
		}

	}

	static void topologicalSort(Graph g, Stack<Integer> s, boolean[] visited, int i) {

		visited[i] = true;

		Iterator<Node> iterator = g.adjList[i].iterator();

		while (iterator.hasNext()) {
			Node next = iterator.next();
			if (!visited[next.data])
				topologicalSort(g, s, visited, next.data);
		}

		s.push(i);

	}

	static void shortestPath(Graph g, int src) {

		int numOfVertices = g.numberOfVertices;

		Stack<Integer> s = new Stack<Integer>();
		boolean[] visited = new boolean[numOfVertices];
		Integer[] dist = new Integer[numOfVertices];

		for (int i = 0; i < numOfVertices; i++)
			dist[i] = Integer.MAX_VALUE;

		dist[src] = 0;

		for (int i = 0; i < numOfVertices; i++) {
			if (!visited[i])
				topologicalSort(g, s, visited, i);
		}

		while (!s.isEmpty()) {

			int u = s.pop();
			if (dist[u] != Integer.MAX_VALUE) {
				Iterator<Node> iterator = g.adjList[u].iterator();
				while (iterator.hasNext()) {
					Node next = iterator.next();
					int v = next.data;
					int distance = next.weight;
					if (dist[u] + distance < dist[v])
						dist[v] = dist[u] + distance;
				}
			}

		}

		for (int i = 0; i < numOfVertices; i++)
			System.out.println(i + "\t" + dist[i]);

	}

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 3, 6);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 4, 4);
		g.addEdge(2, 5, 2);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 4, -1);
		g.addEdge(4, 5, -2);

		shortestPath(g, 1);

	}

}
