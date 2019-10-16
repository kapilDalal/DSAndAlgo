package backtracking;

public class NQueen {
	
	boolean isValid(int cuurentQueen,int cuurentQueenPos,Integer[] pos){
		for(int queen=0;queen<cuurentQueen;queen++){
			if(pos[queen]==cuurentQueenPos || Math.abs(queen-cuurentQueen)==Math.abs(pos[queen]-cuurentQueenPos))
				return false;		
		}
		return true;
	}
	
	
	int next(int q,Integer[] posQueens){
	
		int pos = -1;
		if(posQueens[q]==-1)
			 pos = 0;
		else
			pos = posQueens[q];					
		
		while(!isValid(q,pos,posQueens) && pos<posQueens.length){
			pos = pos+1;
		}
		if(pos == posQueens.length){
			pos = -1;
		}
		return pos;
	
	}
	
	void setQueensOnBoard(int sizeOfBoard){
		int queen = 0;
		Integer[] pos = new Integer[sizeOfBoard];
		for(int i=0;i<sizeOfBoard;i++){
			pos[i] = -1;
		}
		while(queen<pos.length){
			int position = next(queen,pos);
			if(position==-1){				
				pos[queen-1] = pos[queen-1]+1;
				pos[queen] = -1;
				queen = queen-1;
			}
			else{
				pos[queen]=position;
				queen = queen+1;
			}
		}
		for(int i=0;i<sizeOfBoard;i++){
			for(int j=0;j<sizeOfBoard;j++){
				if(j==pos[i])
					System.out.print(1+"\t");
				else
					System.out.print(0+"\t");
			}
			System.out.println();
		}
			
	}
	
	public static void main(String[] args) {
		NQueen nq = new NQueen();
		nq.setQueensOnBoard(4);
	}

}
