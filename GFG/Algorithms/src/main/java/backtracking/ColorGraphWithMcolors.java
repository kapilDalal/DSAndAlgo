package backtracking;

public class ColorGraphWithMcolors {
	
	static int V = 4;
	
	
	static void colorTheNode(int[][] graph,int m){
		
		int[] color = new int[V];
		for(int i=0;i<V;i++)
			color[i] = 0;
		
		if(!colorTheNodesUtil(graph,m,color,0)){
			System.out.println("can not be colored");
			return;
		}
		
		for(int i=0;i<V;i++)
			System.out.println(i+"\t"+color[i]);
		
	}


	private static boolean colorTheNodesUtil(int[][] graph, int m, int[] color, int v) {
		
		if(v==V)
			return true;
		
		for(int i=1;i<=m;i++){
			
			if(isSafe(graph,color,v,i)){
				
				color[v] = i;
				
				if(colorTheNodesUtil(graph, m, color, v+1))
					return true;
				
				color[v] = 0;
				
			}
			
			
		}
		
		
		return false;
	}


	private static boolean isSafe(int[][] graph, int[] color, int v, int c) {
		
		for(int i=0;i<V;i++){
			if(graph[v][i]==1 && color[i]==c)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int graph[][] = {{0, 1, 1, 1}, 
	            		 {1, 0, 1, 0}, 
	            		 {1, 1, 0, 1}, 
	            		 {1, 0, 1, 0}}; 
	    int m = 3;
	    colorTheNode(graph, m);
	}

}
