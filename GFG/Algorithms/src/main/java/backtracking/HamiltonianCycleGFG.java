package backtracking;

public class HamiltonianCycleGFG {
	
	static int V = 5;
	static int path[]; 
	static boolean htCycleUtil(int[][] graph,int[] path,int pos){
		if(pos==V){
			
			if(graph[path[pos-1]][path[0]]==1)
				return true;
			
			return false;
			
		}
		for(int n=1;n<V;n++){
			if(isSafe(graph,n,pos,path)){
				path[pos] = n;
				if(htCycleUtil(graph,path, pos+1))
					return true;
				path[pos] = -1;
			}
			
			
		}
		
		
		return false;
	}
	private static boolean isSafe(int[][] graph, int n, int pos, int[] path) {
		
		if(graph[path[pos-1]][n]==0)
			return false;
		
		for(int i=0;i<pos;i++)
			if(path[i]==n)
				return false;
		
		return true;
	}
	static int hamCycle(int graph[][]) 
    { 
        path = new int[V]; 
        for (int i = 0; i < V; i++) 
            path[i] = -1; 
  
        /* Let us put vertex 0 as the first vertex in the path. 
           If there is a Hamiltonian Cycle, then the path can be 
           started from any point of the cycle as the graph is 
           undirected */
        path[0] = 0; 
        if (htCycleUtil(graph, path, 1) == false) 
        { 
            System.out.println("\nSolution does not exist"); 
            return 0; 
        } 
  
        printSolution(path); 
        return 1; 
    } 
	static void printSolution(int path[]) 
    { 
        System.out.println("Solution Exists: Following" + 
                           " is one Hamiltonian Cycle"); 
        for (int i = 0; i < V; i++) 
            System.out.print(" " + path[i] + " "); 
  
        // Let us print the first vertex again to show the 
        // complete cycle 
        System.out.println(" " + path[0] + " "); 
    } 
	public static void main(String[] args) {
		int graph1[][] = {{0, 1, 0, 1, 0}, 
	            {1, 0, 1, 1, 1}, 
	            {0, 1, 0, 0, 1}, 
	            {1, 1, 0, 0, 1}, 
	            {0, 1, 1, 1, 0}, 
	        };
		hamCycle(graph1);
		int graph2[][] = {{0, 1, 0, 1, 0}, 
	            {1, 0, 1, 1, 1}, 
	            {0, 1, 0, 0, 1}, 
	            {1, 1, 0, 0, 0}, 
	            {0, 1, 1, 0, 0}, 
	        };
		hamCycle(graph2);
	}

}
