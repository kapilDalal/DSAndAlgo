package graph;

import java.util.Iterator;

public class DFSTraversal {

	static void dfs(Graph g, int start, boolean[] visited) {
		
		visited[start] = true;
		
		System.out.print(start+"\t");
		
		Iterator<Integer> iterator = g.adjList[start].iterator();
		
		while(iterator.hasNext()){
			int next = iterator.next(); 
			
			if(!visited[next])
				dfs(g,next,visited);
			
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
		
		boolean[] visited = new boolean[g.numberOfVertices()];
		
		for(int i=0;i<visited.length;i++)
			visited[i]=false;
		
		dfs(g,2,visited);
	}

}
