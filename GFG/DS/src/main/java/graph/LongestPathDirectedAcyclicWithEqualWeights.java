package graph;

import java.util.Iterator;

public class LongestPathDirectedAcyclicWithEqualWeights {
	
	
	
	static int maxLength = 0;
	
	static void longestPath(Graph g,int i,int length){
		if(length>maxLength)
			maxLength = length;
		
		Iterator<Integer> iterator = g.adjList[i].iterator();
		
		while(iterator.hasNext()){
			int next = iterator.next();
			longestPath(g, next, length+1);
		}
			
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(10);
		g.addEdge(1, 2);
		g.addEdge(1, 8);
		g.addEdge(8, 9);
		g.addEdge(9, 5);
		g.addEdge(2, 5);
		g.addEdge(2, 3);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		g.addEdge(7, 0);
		g.addEdge(3, 7);
		g.addEdge(3, 4);
		
		longestPath(g, 2, 0);
		System.out.println(maxLength);
	}

}
