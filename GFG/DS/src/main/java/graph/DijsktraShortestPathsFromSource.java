package graph;

public class DijsktraShortestPathsFromSource {
	
	static int minDist(boolean[] sptSet,int[] dist,int numOfVertices){
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		
		for(int i=0;i<numOfVertices;i++){
			if(!sptSet[i] && dist[i] < min){
				min = dist[i];
				minIndex = i;
			}
		}
		
		
		return minIndex;
	}
	
	
	static void shortestDistanceFromSource(int[][] graph,int source,int numOfVertices){
		
		boolean[] sptSet = new boolean[numOfVertices];
		
		int[] dist = new int[numOfVertices];
		
		for(int i=0;i<numOfVertices;i++)
			dist[i] = Integer.MAX_VALUE;
		
		dist[0] = 0;
		
		for(int i=0;i<numOfVertices;i++){
			
			int u = minDist(sptSet, dist, numOfVertices);
			
			sptSet[u] = true;
			
			for(int v=0;v<numOfVertices;v++){
				if(!sptSet[v] && graph[u][v]!=0 /*&& dist[v]!=Integer.MAX_VALUE*/ && dist[u]+graph[u][v]<dist[v])
					dist[v] = dist[u]+graph[u][v];
			}
			
		}
		
		for(int i=0;i<numOfVertices;i++)
			System.out.println(i+"\t"+dist[i]);
		
	}
	
	public static void main(String[] args) {
	   int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
						             { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
						             { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
						             { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
						             { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
						             { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
						             { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
						             { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
						             { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		shortestDistanceFromSource(graph, 0, 9);				             
	}
	

}
