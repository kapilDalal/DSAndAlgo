package backtracking;

public class Sudoku {

	static int boardSize = 9;
	static int row = 9;
	static int col = 9;

	static boolean fillUpTheBoardUtil(int[][] board) {

		
		boolean isEmpty = false; 
		int row = -1;
		int col = -1;
		
		for (int i=0; i < Sudoku.row; i++) {
			
			for (int j=0; j < Sudoku.col; j++) {
				
				if(board[i][j]==0){
					row=i;
					col=j;
					isEmpty = true;
					break;
				}
			}
			if(isEmpty)
				break;
			
		}
		
		if(!isEmpty)
			return true;
		

		for (int k = 1; k <= boardSize; k++) {

			if ( isSafe(row, col, k, board)) {
				
				board[row][col]=k;
				
				if(fillUpTheBoardUtil(board))
					return true;
				else
					board[row][col]=0;

			}

		}
				
			
		return false;
	}

	private static boolean isSafe(int i, int j, int k, int[][] board) {

		for (int l = 0; l < col; l++)
			if (board[i][l] == k)
				return false;
		for (int l = 0; l < row; l++)
			if (board[l][j] == k)
				return false;
		
		int sqrt = (int) Math.sqrt(board.length); 
	    int boxRowStart = i - i % sqrt; 
	    int boxColStart = j - j % sqrt; 
	  
	    for (int r = boxRowStart; 
	             r < boxRowStart + sqrt && r<row; r++)  
	    { 
	        for (int d = boxColStart;  
	                 d < boxColStart + sqrt && d<col; d++)  
	        { 
	            if (board[r][d] == k)  
	            { 
	                return false; 
	            } 
	        } 
	    } 
		
		return true;
	}
	
	public static void main(String[] args) {
	    
	    int[][] board1 = { 
	            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
	            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
	            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
	            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
	            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
	            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
	            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
	            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
	            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
	    };
	    
	    fillUpTheBoardUtil(board1);
	    
	    for(int i=0;i<row;i++){
	    	for(int j=0;j<col;j++){
	    		System.out.print(board1[i][j]+"\t");
	    	}
	    	System.out.println();
	    }
	    
	}

}
