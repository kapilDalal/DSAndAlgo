package backtracking;

public class KnightTourGFG {
	
	int n=8;
	
	private boolean isValid(int x,int y,int[][] sol){
		return (x>=0 && x<n && y>=0 && y<n && sol[x][y]==-1 );
	}
	
	private boolean traverseTheBoardUtil(int x,int y,int step,int[][] sol,int[] xMove,int[] yMove){
		if(step==n*n)
			return true;
		
		for(int k=0;k<8;k++){
			int new_x = x + xMove[k];
			int new_y = y + yMove[k];
			if(isValid(new_x,new_y,sol)){	
				sol[new_x][new_y] = step;
				if(traverseTheBoardUtil(new_x, new_y, step+1, sol, xMove, yMove))
					return true;
				else
					sol[new_x][new_y] = -1;
			}
		}
		return false;
	}
	
	public void traveTheBoard(){
		int x[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
		int y[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
		int[][] board = {{ 0,-1,-1,-1,-1,-1,-1,-1},
				 {-1,-1,-1,-1,-1,-1,-1,-1},
				 {-1,-1,-1,-1,-1,-1,-1,-1},
				 {-1,-1,-1,-1,-1,-1,-1,-1},
				 {-1,-1,-1,-1,-1,-1,-1,-1},
				 {-1,-1,-1,-1,-1,-1,-1,-1},
				 {-1,-1,-1,-1,-1,-1,-1,-1},
				 {-1,-1,-1,-1,-1,-1,-1,-1}};
		
		traverseTheBoardUtil(0, 0, 1, board, x, y);
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				System.out.print(board[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		KnightTourGFG kt = new KnightTourGFG();
		kt.traveTheBoard();
	}

}
