package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class DiameterOfGraph {

	static class Graph {
		int numOfVertices;
		LinkedList<Integer>[] adjList;

		public Graph(int v) {
			this.numOfVertices = v;
			this.adjList = new LinkedList[v];
			for (int i = 0; i < v; i++)
				this.adjList[i] = new LinkedList<Integer>();
		}

		public void addEdge(int i, int j) {
			this.adjList[i].add(j);
			this.adjList[j].add(i);
		}
	}
	static int maxDist=0;
	static int x;
	static void dfs(Graph g,boolean[] visited,int i,int cnt){
		visited[i] = true;
		Iterator<Integer> iterator = g.adjList[i].iterator();
		cnt++;
		while(iterator.hasNext()){
			Integer next = iterator.next();
			if(!visited[next]){
				
				if(cnt>maxDist){
					maxDist = cnt;
					x = next;
				}
				dfs(g, visited, next, cnt);
			}
			
		}
		
	}
	static public int solve(ArrayList<Integer> A) {
		System.out.println(A.size());
		Graph g = new Graph(A.size());
		int src = 0;
		for(int i=0;i<A.size();i++){
			if(A.get(i)!=-1)
				g.addEdge(i, A.get(i));
			else
				src = i;
		}
		boolean[] visited = new boolean[A.size()];
		Arrays.fill(visited, false);
		dfs(g, visited, src, 0);
		Arrays.fill(visited, false);
		dfs(g, visited, x, 0);
		return maxDist;
	}
	public static void main(String[] args) {
		solve(new ArrayList<Integer>(Arrays.asList(-1, 0, 1, 2, 0, 4, 4, 6, 1, 5, 6, 0, 2, 4, 0, 7, 2, 8, 13, 8, 7, 20, 3, 22, 16, 1, 7, 26, 23, 7, 27, 7, 11, 28, 30, 34, 9, 14, 16, 1, 36, 13, 0, 20, 37, 5, 44, 34, 25, 27, 13, 19, 26, 46, 43, 26, 53, 16, 40, 40, 11, 25, 61, 60, 63, 16, 50, 5, 11, 20, 10, 10, 40, 70, 43, 21, 70, 62, 54, 12, 33, 14, 67, 28, 45, 30, 13, 55, 78, 41, 22, 43, 66, 42, 27, 86, 67, 57, 51, 87)));
		System.out.println(maxDist);
	}

}
