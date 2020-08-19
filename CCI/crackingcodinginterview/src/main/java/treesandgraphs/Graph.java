package treesandgraphs;

import java.util.LinkedList;

public class Graph {
	
	LinkedList<Integer>[] adjList;
	int numberOfVertices;
	public Graph(int v) {
		this.numberOfVertices = v;
		adjList = new LinkedList[v];
		for(int i=0;i<v;i++)
			adjList[i] = new LinkedList<Integer>();
	}
	
	public void addEdge(int u,int v) {
		adjList[u].add(v);
	}
	
	public int size() {
		return this.numberOfVertices;
	}
	
	
	/*
	 *		5 		   4
	 * 	   /  \		  / \
	 * 	   |   \	 /   \
	 * 	   |	->0<-     \
	 * 	   |		       |
	 * 	   |               |
	 * 		->2		  ->1<-'
	 *        \      /
	 *         ->3-'
	 * 			 
	 * 
	 * */
	public static Graph getDirectedGraph() {
		Graph g = new Graph(6);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(5, 0);
		g.addEdge(5, 2);
		return g;
	}
	
	public static Graph getUnDirectedGraph() {
		Graph g = new Graph(6);
		
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(5, 0);
		g.addEdge(5, 2);
		
		g.addEdge(3, 2);
		g.addEdge(1, 3);
		g.addEdge(0, 4);
		g.addEdge(1, 4);
		g.addEdge(0, 5);
		g.addEdge(2, 5);
		
		return g;
	}

}
