package backtracking;

import java.util.Date;

public class NQueen {
	
	boolean isValid(int cuurentQueen,int cuurentQueenPos,Integer[] pos){
		for(int queen=0;queen<cuurentQueen;queen++){
			if(pos[queen]==cuurentQueenPos || Math.abs(queen-cuurentQueen)==Math.abs(pos[queen]-cuurentQueenPos))
				return false;		
		}
		return true;
	}
	
	
	int nextSafe(int q,Integer[] posQueens){
	
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
			int position = nextSafe(queen,pos);
			if(position==-1){				
				pos[queen-1] = pos[queen-1]+1;
				pos[queen] = -1;
				queen = queen-1;
			}
			else{
				pos[queen]=position;
				queen = queen+1;
			}
			if(queen<0){
				System.out.println("no solution");
				return;
			}
		}
		for(int i=0;i<sizeOfBoard;i++){
			for(int j=0;j<sizeOfBoard;j++){
				if(j==pos[i])
					System.out.print("Q\t");
				else
					System.out.print("-\t");
			}
			System.out.println();
		}
			
	}
	
	static void permutationOfString(String soFar,String remaining){
		if(remaining.length()==0)
			System.out.println(soFar);
		else{
			for(int i=0;i<remaining.length();i++){				
				permutationOfString(soFar+remaining.charAt(i), remaining.substring(0,i)+remaining.substring(i+1,remaining.length()));
			}
		}
	}
	
	public static void main(String[] args) {
		/*NQueen nq = new NQueen();
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		System.out.println(date);
		nq.setQueensOnBoard(40);
		System.out.println();
		long millis1 = System.currentTimeMillis();
		Date date1 = new Date(millis1);
		System.out.println(date1);*/
		permutationOfString("", "abcd");
	}

}
