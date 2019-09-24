package graph;

import java.util.ArrayList;
import java.util.Arrays;

import graph.KruskalMST.Graph.Edge;

public class KruskalMST {

	static class Graph {

		static class Edge implements Comparable<Edge> {
			int src, dest, weight;

			public int compareTo(Edge o) {
				return this.weight - o.weight;
			}

			@Override
			public String toString() {
				return "Edge [src=" + src + ", dest=" + dest + ", weight=" + weight + "]";
			}
		}

		Edge[] edge;
		int vertices, numOfEdges;

		public Graph(int v, int e) {
			this.vertices = v;
			this.numOfEdges = e;
			edge = new Edge[numOfEdges];
			for (int i = 0; i < numOfEdges; i++)
				edge[i] = new Edge();
		}

	}
	private static int findParent(Integer[] parent,int i) {
		
		if(parent[i]==-1)
			return i;		
		return findParent(parent, parent[i]);
	}
	
	private static void union(Integer[] parent,int i,int j){
		int parentI = findParent(parent,i);
		int parentJ = findParent(parent, j);
		
		parent[parentI] = parentJ;
		
	}
	
	static ArrayList<Edge> kruskalMst(Graph g){
		
		Arrays.sort(g.edge);
		
		ArrayList<Edge> result = new ArrayList<Edge>();
		Integer[] parent = new Integer[g.vertices];
		for(int i=0;i<parent.length;i++)
			parent[i] = -1;
		
		for(int i=0;i<g.numOfEdges;i++){
			
			int src = g.edge[i].src;
			int dest = g.edge[i].dest;
			
			int srcParent = findParent(parent, src);
			int destParent = findParent(parent, dest);
			
			if(srcParent!=destParent){
				result.add(g.edge[i]);
				union(parent,src,dest);
			}
				
			
		}
		return result;
	}

	

	public static void main(String[] args) {
		Graph graph = new Graph(9, 14);
		/*
		 * After sorting:
Weight   Src    Dest
1         7      6
2         8      2
2         6      5
4         0      1
4         2      5
6         8      6
7         2      3
7         7      8
8         0      7
8         1      2
9         3      4
10        5      4
11        1      7
14        3      5
		 * 
		 * */
		graph.edge[13].src = 7; 
        graph.edge[13].dest = 6; 
        graph.edge[13].weight = 1;
		
		graph.edge[12].src = 8; 
        graph.edge[12].dest = 2; 
        graph.edge[12].weight = 2;
		
		graph.edge[11].src = 6; 
        graph.edge[11].dest = 5; 
        graph.edge[11].weight = 2;
		
		graph.edge[10].src = 0; 
        graph.edge[10].dest = 1; 
        graph.edge[10].weight = 4;
		
		graph.edge[9].src = 2; 
        graph.edge[9].dest = 5; 
        graph.edge[9].weight = 4;
		
		graph.edge[8].src = 8; 
        graph.edge[8].dest = 6; 
        graph.edge[8].weight = 6;
		
		graph.edge[7].src = 2; 
        graph.edge[7].dest = 3; 
        graph.edge[7].weight = 7;
		
		graph.edge[6].src = 7; 
        graph.edge[6].dest = 8; 
        graph.edge[6].weight = 7;
		
		graph.edge[5].src = 0; 
        graph.edge[5].dest = 7; 
        graph.edge[5].weight = 8;
		
		// add edge 0-1
		graph.edge[0].src = 3; 
        graph.edge[0].dest = 5; 
        graph.edge[0].weight = 14; 
  
        // add edge 0-2 
        graph.edge[1].src = 1; 
        graph.edge[1].dest = 7; 
        graph.edge[1].weight = 11; 
  
        // add edge 0-3 
        graph.edge[2].src = 5; 
        graph.edge[2].dest = 4; 
        graph.edge[2].weight = 10; 
  
        // add edge 1-3 
        graph.edge[3].src = 3; 
        graph.edge[3].dest = 4; 
        graph.edge[3].weight = 9; 
  
        // add edge 2-3 
        graph.edge[4].src = 1; 
        graph.edge[4].dest = 2; 
        graph.edge[4].weight = 8; 

		/*g.edge[0].src = 0;
		g.edge[0].dest = 1;
		g.edge[0].weight = 3;

		g.edge[1].src = 0;
		g.edge[1].dest = 2;
		g.edge[1].weight = 7;

		g.edge[2].src = 0;
		g.edge[2].dest = 3;
		g.edge[2].weight = 4;

		g.edge[3].src = 1;
		g.edge[3].dest = 3;
		g.edge[3].weight = 2;

		g.edge[4].src = 2;
		g.edge[4].dest = 3;
		g.edge[4].weight = 7;*/

		/*Arrays.sort(g.edge);

		for (int i = 0; i < g.numOfEdges; i++)
			System.out.println("src->" + g.edge[i].src + "\tdest->" + g.edge[i].dest + "\tweight->" + g.edge[i].weight);
		
		System.out.println();*/
		
		ArrayList<Edge> result = kruskalMst(graph);
		
		System.out.println(result);
		
	}

}
