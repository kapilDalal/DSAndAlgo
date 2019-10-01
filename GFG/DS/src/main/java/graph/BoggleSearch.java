package graph;

public class BoggleSearch {
	
	static String[] dictionary = { "GEEKS", "FOR", "QUIZ", "GUQ", "EE" };
	
	private static boolean isPresent(String str) {
		for(int i=0;i<dictionary.length;i++)
			if(dictionary[i].equals(str))
				return true;
		return false;
	}
	
	static void searchWordUtil(char[][] boggle,int numOfRows,int numOfCols,String str,int i,int j,boolean visited[][]){
		
		Integer[] rowDir = {+1,-1,-1,+1,0,0,-1,+1};
		Integer[] colDir = {+1,-1,+1,-1,+1,-1,0,0};
		visited[i][j] = true;
		char c = boggle[i][j];
		str = str+c;
		if(isPresent(str))
			System.out.println(str+" present");
		for(int k=0;k<rowDir.length;k++){
			int newI = i+rowDir[k];
			int newJ = j+colDir[k];
			if((newI>=0 && newI<numOfRows)&&(newJ>=0 && newJ<numOfCols)){							
				if(!visited[newI][newJ])
					searchWordUtil(boggle,numOfRows,numOfCols,str,newI,newJ,visited);			
			
			}	        
		}	
		//str = ""+str.charAt(str.length() - 1); 
		visited[i][j] = false;
	}
	static void searchWord(char[][] boggle){
		String str = "";
		boolean visited[][] = new boolean[3][3];
		//searchWordUtil(boggle, 3, 3, str, 0, 0,visited);
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				//boolean visited[][] = new boolean[3][3];
				searchWordUtil(boggle, 3, 3, str, i, j,visited);
			}
		}
		
	}
	
	public static void main(String[] args) {
		char boggle[][] = { { 'G', 'I', 'Z' }, 
						    { 'U', 'E', 'K' }, 
						    { 'Q', 'S', 'E' } };
		
		searchWord(boggle);
	}



	
	
	
	
	
	

}
