package backtracking;

public class RatMazeForwardAndBackMoves {
	
	int[] xMoves = {0,1};
	int[] yMoves = {1,0};
	
	int row = 4;
	int col = 4;
	
	int[][] maze = {{1, 0, 0, 0},
					{1, 1, 0, 1},
					{0, 1, 0, 0},
					{1, 1, 1, 1}};
	
	
	boolean reachedDestination(int i,int j){
		
		if(i==row-1 && j==col-1)
			return true;
		
		for(int pos = 0; pos<xMoves.length; pos++){
			int newI = i + xMoves[pos];
			int newJ = j + yMoves[pos];
			
			if(newI>=0 && newI<row && newJ>=0 && newJ<col && maze[newI][newJ]!=0){
				
				if(reachedDestination(newI, newJ))
					return true;
				
			}
			
			
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		RatMazeForwardAndBackMoves maze = new RatMazeForwardAndBackMoves();
		//maze.reachedDestination(0, 0);
		System.out.println(maze.reachedDestination(0, 0));
	}
	

}
