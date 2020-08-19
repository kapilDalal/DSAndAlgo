package treesandgraphs;

import java.util.Iterator;
import java.util.Stack;

public class BuildOrder {
	
	public boolean isCyclic(Graph g) 
	{
		int n = g.size();
		boolean[] visited = new boolean[n];
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				boolean[] itemsInStack = new boolean[n];
				if(isCyclicUtil(g, i, visited, itemsInStack))
					return true;
			}
		}
		return false;
	}

	private boolean isCyclicUtil(Graph g, int i,boolean[] visited,boolean[] itemsInStack) {
		// TODO Auto-generated method stub
		if(itemsInStack[i])
			return true;		
		if(visited[i])
			return false;				
		visited[i] = true;
		itemsInStack[i] = true;
		
		Iterator<Integer> iterator = g.adjList[i].iterator();
		while(iterator.hasNext()) {
			int next = iterator.next();
			if(isCyclicUtil(g, next, visited, itemsInStack))
				return true;			
		}
		
		itemsInStack[i] = false;
		
		return false;
	}
	
	public void buildOrder(Graph g) {
		if(isCyclic(g))
		{
			System.out.println("cann't be built");
			return;
		}
		Stack<Integer> s = new Stack<>();
		boolean[] visited = new boolean[g.size()];
		
		for(int i=0;i<g.size();i++) {
			if(!visited[i])
				buildOrderUtil(g,i,s,visited);
		}
		System.out.println("order is");
		while(!s.isEmpty())
			System.out.print(s.pop()+"\t");
	}
	
	private void buildOrderUtil(Graph g,int i, Stack<Integer> s, boolean[] visited) {
		// TODO Auto-generated method stub
		if(visited[i])
			return;
		visited[i] = true;
		
		Iterator<Integer> iterator = g.adjList[i].iterator();
		
		while(iterator.hasNext())
			buildOrderUtil(g, iterator.next(), s, visited);
		
		s.push(i);
	}

	public static void main(String[] args) {
		BuildOrder order = new BuildOrder();
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(4, 5);
		//g.addEdge(5, 1);
		order.buildOrder(g);
	}

	

}
