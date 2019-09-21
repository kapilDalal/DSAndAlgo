package graph;

public class IsCyclicUndirectedUsingUnionFind {

	static class Graph {

		Edge[] edge;
		int numOfVertices;

		static class Edge {
			int src, dest;
		}

		public Graph(int v, int numberOfEdges) {
			edge = new Edge[numberOfEdges];
			numOfVertices = v;
			for (int i = 0; i < numberOfEdges; i++)
				edge[i] = new Edge();
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

	static boolean isCyclic(Graph g) {
		Integer[] parent = new Integer[g.numOfVertices];
		for (int i = 0; i < parent.length; i++)
			parent[i] = -1;

		for (int i = 0; i < g.edge.length; i++) {

			int src = g.edge[i].src;
			int dest = g.edge[i].dest;

			int parentSrc = findParent(parent, src);
			int parentDest = findParent(parent, dest);

			if (parentSrc == parentDest)
				return true;

			union(parent, src, dest);
		}
		return false;
	}
	
	public static void main(String[] args) {
			int V = 3, E = 2; 
	        Graph graph = new Graph(V, E); 
	  
	        // add edge 0-1 
	        graph.edge[0].src = 0; 
	        graph.edge[0].dest = 1; 
	  
	        // add edge 1-2 
	        graph.edge[1].src = 1; 
	        graph.edge[1].dest = 2; 
	  
	        // add edge 0-2 
	        /*graph.edge[2].src = 0; 
	        graph.edge[2].dest = 2; */
	        if (isCyclic(graph)) 
	            System.out.println( "graph contains cycle" ); 
	        else
	            System.out.println( "graph doesn't contain cycle" ); 
	}

}
