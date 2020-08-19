package treesandgraphs;

import java.util.Iterator;

public class RouteBetweenNodes {
	
	//can handle the self loop case by calling this method in other method.
	public boolean routePresent(Graph g,int u,int v,boolean[] visited) {
		if(visited[u])
			return false;
		if(u==v)
			return true;
		visited[u] = true;
		Iterator<Integer> iterator = g.adjList[u].iterator();
		while(iterator.hasNext()) {
			if(routePresent(g, iterator.next(), v, visited))
				return true;
		}
		return false;		
	}
	
	public static void main(String[] args) {		
		Graph g = Graph.getDirectedGraph();
		RouteBetweenNodes rbn = new RouteBetweenNodes();
		System.out.println(rbn.routePresent(g, 2, 1, new boolean[g.adjList.length]));
	}

}
