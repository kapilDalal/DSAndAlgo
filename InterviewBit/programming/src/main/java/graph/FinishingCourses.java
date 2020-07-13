package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class FinishingCourses {

	static public class Graph{
		int numberOfNodes;
		LinkedList<Integer>[] adjList;
		public Graph(int numOfNodes) {
			// TODO Auto-generated constructor stub
			this.numberOfNodes = numOfNodes;
			adjList = new LinkedList[numOfNodes];
			for(int i=0;i<numberOfNodes;i++)
				adjList[i] = new LinkedList<Integer>();
		}
		public void addNode(int i,int j) {
			adjList[i].add(j);
		}
	}

	public boolean isCyclic(Graph g,int node,boolean[] recStack,boolean[] visited) {
		if(recStack[node])
			return true;
		if(visited[node])
			return false;
		
		recStack[node] = true;
		visited[node] = true;
		
		Iterator<Integer> iterator = g.adjList[node].iterator();
		
		while(iterator.hasNext()) {
			int next = iterator.next();
			if(isCyclic(g, next, recStack, visited))
				return true;
		}
		recStack[node] = false;	
		
		return false;
	}
	
	public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
		Graph g = new Graph(A+1);
		for(int i=0;i<B.size();i++) {
			g.addNode(B.get(i), C.get(i));
		}
		boolean[] recStack = new boolean[A+1];
		boolean[] visited = new boolean[A+1];
		for(int i=0;i<B.size();i++) {			
			if(isCyclic(g, B.get(i), recStack, visited))
				return 0;
		}
		
		return 1;
	}
	public static void main(String[] args) {	
		FinishingCourses fc = new FinishingCourses();
		int res = fc.solve(3, new ArrayList<Integer>(Arrays.asList(1,2)), 
				new ArrayList<Integer>(Arrays.asList(2,3)));
		System.out.println(res);
	}

}
