package graph;

import java.util.Iterator;
import java.util.LinkedList;

import graph.ShortestPathDirectedAcyclic.Graph.Node;

public class ShortestPathDirectedAcyclic {
	
	static class Graph{
		
		class Node{
			int data;
			int weight;
			
			public Node(int data,int weight){
				this.data = data;
				this.weight = weight;
			}
		}
		
		LinkedList<Node>[] adjList;
		int numberOfVertices;
		
		public Graph(int v){
			adjList = new LinkedList[v];
			numberOfVertices = v;
			for(int i=0;i<numberOfVertices;i++){
				adjList[i] = new LinkedList<Node>();
			}
		}
		
		public void addEdge(int src,int dest,int weight){
			Node node = new Node(dest,weight);
			adjList[src].add(node);
		}
		
	}
	
	static int minDistIndex(Integer[] dist,boolean[] sptSet){
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i=0;i<dist.length;i++){
			if(!sptSet[i] && dist[i]<min){
				min = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	static void shortestPath(Graph g,int src){
		
		int numberOfVertices = g.numberOfVertices;
		Integer[] dist = new Integer[numberOfVertices];
		Integer[] parent = new Integer[numberOfVertices];
		boolean[] sptSet = new boolean[numberOfVertices];
		
		for(int i=0;i<numberOfVertices;i++)
			dist[i] = Integer.MAX_VALUE;
		
		for(int i=0;i<numberOfVertices;i++)
			parent[i] = -1;
		
		dist[src] = 0;
		
		for(int i=0;i<numberOfVertices;i++){
			
			int u = minDistIndex(dist, sptSet);
			
			if(u==-1)
				continue;
			
			sptSet[u] = true;
			
			Iterator<Node> iterator = g.adjList[u].iterator();	
			
			while(iterator.hasNext()){
				Node node = iterator.next();
				int v = node.data;
				int distance = node.weight;
				if(distance+dist[u]<dist[v]){
					dist[v] = distance+dist[u];
					parent[v] = u;
				}
			}
			
			
		}
		
		for(int i=0;i<dist.length;i++)
			System.out.print(dist[i]+"\t");
		System.out.println("\n\nc\tp\n");
		for(int i=0;i<dist.length;i++)
			System.out.println(i+"\t"+parent[i]);
		
		
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(6); 
        g.addEdge(0, 1, 5); 
        g.addEdge(0, 2, 3); 
        g.addEdge(1, 3, 6); 
        g.addEdge(1, 2, 2); 
        g.addEdge(2, 4, 4); 
        g.addEdge(2, 5, 2); 
        g.addEdge(2, 3, 7); 
        g.addEdge(3, 4, -1); 
        g.addEdge(4, 5, -2); 
        
        shortestPath(g, 0);
        
	}

}
