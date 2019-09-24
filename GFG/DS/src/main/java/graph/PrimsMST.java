package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class PrimsMST {
	static class Edge{
		int src,dest,weight;

		@Override
		public String toString() {
			return "Edge [src=" + src + ", dest=" + dest + ", weight=" + weight + "]";
		}
	}
	
	static int minKey(boolean[] mstSet,Integer[] key,int numOfVertices){
		Integer min = Integer.MAX_VALUE; 
		int minIndex=-1;
		for(int i=0;i<numOfVertices;i++){			
			if(mstSet[i]==false && min>key[i]){
				minIndex = i;
				min = key[i];
			}
		}
		return minIndex;
	}
	
	static void primMstGFG(int[][] graph,int numberOfVertices){
		boolean[] mstSet = new boolean[numberOfVertices];
		Integer[] key = new Integer[numberOfVertices];
		Integer[] parent = new Integer[numberOfVertices];
		
		for(int i=0;i<numberOfVertices;i++)
			key[i] = Integer.MAX_VALUE;
		
		key[0] = 0;
		parent[0] = -1;
		
		
		
		for(int i=0;i<numberOfVertices;i++){
			
			int u = minKey(mstSet, key, numberOfVertices);
			
			mstSet[u] = true;
			
			for(int v=0;v<numberOfVertices;v++){
				
				if(graph[u][v]!=0 && !mstSet[v] && key[v]>graph[u][v]){
					parent[v] = u;
					key[v] = graph[u][v];
				}
				
			}
		}
		System.out.println("------------------------");
		System.out.println("s--d\t|\tw\t|");
		System.out.println("------------------------");
		for(int i=1;i<numberOfVertices;i++){
			System.out.println(parent[i]+"--"+i+"\t|\t"+key[i]+"\t|");
		}
		
		
	}
	
	
	
	static void primsMST(int[][] mat,int numOfCol){
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Edge> listOfEdges = new ArrayList<Edge>();
		list1.add(0);
		for(int i=1;i<numOfCol;i++)
			list2.add(i);
		
		while(list2.size()>0){
			int min = Integer.MAX_VALUE;
			Integer minSrc,minDest;
			minSrc=minDest = -1;
			for(int i=0;i<list1.size();i++){	
				for(int j=0;j<list2.size();j++){
						if(mat[list1.get(i)][list2.get(j)]!=0 && mat[list1.get(i)][list2.get(j)]<min){
							minSrc = list1.get(i);
							minDest = list2.get(j);
							min = mat[list1.get(i)][list2.get(j)];
						}	

				}
			}
			if(!list1.contains(minDest))
				list1.add(minDest);
			
			Iterator<Integer> iterator = list2.iterator();
			while(iterator.hasNext()){
				int next = iterator.next();
				if(next==minDest)
					iterator.remove();
			}
			
			
			Edge edge = new Edge();
			edge.src = minSrc;
			edge.dest = minDest;
			edge.weight = mat[minSrc][minDest];
			listOfEdges.add(edge);
		}
		System.out.println(listOfEdges);
		
	}
	
	
	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, 
						              { 2, 0, 3, 8, 5 }, 
						              { 0, 3, 0, 0, 7 }, 
						              { 6, 8, 0, 0, 9 }, 
						              { 0, 5, 7, 9, 0 } };
						          
		primsMST(graph, 5);
		System.out.println();
		primMstGFG(graph, 5);
	}

}
