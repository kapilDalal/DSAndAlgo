package graph;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {
	
	static void sortUtil(Graph g,boolean[] visited,Stack<Integer> s,int i){
		
		visited[i] = true;
		
		Iterator<Integer> iterator = g.adjList[i].iterator();
		
		while(iterator.hasNext()){
			int next = iterator.next();
			if(!visited[next])
				sortUtil(g, visited, s, next);
		}
		
		s.push(i);
		
	}
	
	static void sort(Graph g){
		
		int numOfVertices = g.numberOfVertices();
		boolean[] visited = new boolean[numOfVertices];
		Stack<Integer> s = new Stack<Integer>();
		for(int i=0;i<numOfVertices;i++){
			if(!visited[i])
				sortUtil(g, visited, s, i);
			
		}
		while(!s.isEmpty())
			System.out.print(s.pop()+"\t");
		
	}
	
	
	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(0, 2); 
		g.addEdge(0, 5); 
		g.addEdge(4, 5); 
		g.addEdge(4, 1); 
		g.addEdge(2, 3); 
		g.addEdge(3, 1); 
		sort(g);
	}

}
