package graph;

import java.util.LinkedList;

public class UndirectedGraph {
	
	
	LinkedList<Integer>[] adjList;
	private int numberOfVertices;
		
	public UndirectedGraph(int numOfNodes) {
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
