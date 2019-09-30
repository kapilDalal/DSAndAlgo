package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import graph.MinimiseCashFlowWrong.Graph.Node;

public class MinimiseCashFlowWrong {

	static class Graph {

		int numOfVertices;
		LinkedList<Node>[] adjList;

		static class Node {
			int v, amount;

			public Node(int v, int a) {
				this.v = v;
				this.amount = a;
			}
		}

		public Graph(int v) {
			this.numOfVertices = v;
			adjList = new LinkedList[v];
			for (int i = 0; i < v; i++)
				adjList[i] = new LinkedList<Node>();
		}

		public void addEdge(int i, int j, int amount) {
			Node node = new Node(j, amount);
			adjList[i].add(node);
		}
	}

	public static int findParent(Integer[] parent, int i) {
		if (parent[i] == -1)
			return i;
		return findParent(parent, parent[i]);
	}

	public static void union(Integer[] parent, int i, int j) {
		int parentI = findParent(parent, i);
		int parentJ = findParent(parent, j);

		parent[parentI] = parentJ;
	}

	static void minimiseCFUtil(Graph g, Integer[] parent, int i) {

		Iterator<Node> iterator = g.adjList[i].iterator();

		while (iterator.hasNext()) {
			Node next = iterator.next();

			int parentI = findParent(parent, i);
			int parentNext = findParent(parent, next.v);
			if (parentI != parentNext) {
				union(parent, i, next.v);
				minimiseCFUtil(g, parent, next.v);
			} else {
				int amount = next.amount;
				g.adjList[i].remove(next);
				int reach = i;
				while (reach != next.v) {
					int currParent = parent[reach];
					Iterator<Node> iterator2 = g.adjList[reach].iterator();
					while (iterator2.hasNext()) {
						Node next1 = iterator2.next();
						if (next1.v == currParent) {
							next1.amount = next1.amount + amount;
							reach = currParent;
							break;
						}
					}
				}

			}
		}

	}

	static void bfs(Graph g, int src) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(src);
		boolean[] visited = new boolean[g.numOfVertices];
		while (!que.isEmpty()) {
			int popped = que.poll();
			for (Node node : g.adjList[popped]) {
				System.out.println(popped + "-->" + node.v + "\t" + node.amount);
				if (!visited[node.v]) {
					visited[node.v] = true;
					que.add(node.v);
				}
			}
		}
	}

	static void minimiseCF(Graph g) {
		int v = g.numOfVertices;
		Integer[] parent = new Integer[v];		
		for (int i = 0; i < v; i++)
			parent[i] = -1;

		minimiseCFUtil(g, parent, 0);

	}

	public static void main(String[] args) {
		Graph g = new Graph(3);
		g.addEdge(0, 1, 1000);
		g.addEdge(0, 2, 2000);
		g.addEdge(2, 0, 5000);
		bfs(g, 0);
		minimiseCF(g);
		System.out.println();
		bfs(g, 0);
	}

}
