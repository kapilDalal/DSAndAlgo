package backtracking;

public class KnightTour {
	
	
	

	int N = 8;
		
	Integer[][] board = {{ 0,-1,-1,-1,-1,-1,-1,-1},
			 {-1,-1,-1,-1,-1,-1,-1,-1},
			 {-1,-1,-1,-1,-1,-1,-1,-1},
			 {-1,-1,-1,-1,-1,-1,-1,-1},
			 {-1,-1,-1,-1,-1,-1,-1,-1},
			 {-1,-1,-1,-1,-1,-1,-1,-1},
			 {-1,-1,-1,-1,-1,-1,-1,-1},
			 {-1,-1,-1,-1,-1,-1,-1,-1}};
	int x[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
	int y[] = {1, 2,  2,  1, -1, -2,-2,-1};
	
	// i don't know why these coordinates are not working and upper ones are need to analyze more.. 
	/*int[] x = {2, 1,-1,1,-1, 2,-2,-2};
	  int[] y = {1,-2,-2,2, 2,-1, 1,-1};*/
	

	boolean solveKTUtil(int i, int j, int movei) {
		int k, newI, newJ;
		if (movei == N * N)
			return true;
		
		for (k = 0; k < 8; k++) {
			newI = i + x[k];
			newJ = j + y[k];
			if (newI >= 0 && newI < N && newJ >= 0 && newJ < N && board[newI][newJ] == -1) {
				board[newI][newJ] = movei;
				if (solveKTUtil(newI, newJ, movei + 1))
					return true;
				else
					board[newI][newJ] = -1;
			}
		}

		return false;
	}
	
	public static void main(String[] args) {
		KnightTour tour = new KnightTour();				 
		tour.solveKTUtil(0, 0, 1);
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				System.out.print(tour.board[i][j]+"\t");
			}
			System.out.println();
		}
		
	}

}
