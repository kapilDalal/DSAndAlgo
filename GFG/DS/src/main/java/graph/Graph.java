package graph;

import java.util.LinkedList;

public class Graph {

	LinkedList<Integer>[] adjList;
	private int numberOfVertices;
	
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Graph(int numOfNodes) {
		this.numberOfVertices = numOfNodes;
		adjList = new LinkedList[numOfNodes];
		for(int i=0;i<numOfNodes;i++)
			adjList[i] = new LinkedList<Integer>();

	}
	
	
	
	public void addEdge(int v1,int v2){
		adjList[v1].add(v2);
	}
	
	
	public int numberOfVertices(){
		return numberOfVertices;
	}
	
	
}
