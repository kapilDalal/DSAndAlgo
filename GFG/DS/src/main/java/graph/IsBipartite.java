package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class IsBipartite {
	
	static class Graph {
		
		
		LinkedList<Integer>[] adjList;
		private int numberOfVertices;
			
		public Graph(int numOfNodes) {
			this.numberOfVertices = numOfNodes;
			adjList = new LinkedList[numOfNodes];
			for(int i=0;i<numOfNodes;i++)
				adjList[i] = new LinkedList<Integer>();

		}
		
		
		
		public void addEdge(int v1,int v2){
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
		
		
		public int numberOfVertices(){
			return numberOfVertices;
		}

	}
	
	static boolean isBipartite(Graph g,boolean[] visited,int i,Integer[] color,int c){
		
		visited[i] = true;
		color[i] = c;
		Iterator<Integer> iterator = g.adjList[i].iterator();
		
		while(iterator.hasNext()){
			int next = iterator.next();
			
			if(visited[next] && color[next]==c)
				return false;
			
			else if(!visited[next])
				return isBipartite(g, visited, next, color, c^1);
		}
		
		return true;
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		//g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		
		Integer[] color = new Integer[4];
		boolean[] visited = new boolean[4];
		
		for(int i=0;i<4;i++)
			color[i]=-1;
		
		System.out.println(isBipartite(g, visited, 0, color, 0));
	}
	
}
