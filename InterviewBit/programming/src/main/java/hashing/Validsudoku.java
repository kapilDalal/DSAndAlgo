package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Validsudoku {
	
	public boolean isValid(ArrayList<ArrayList<Integer>> mat){
		if(!rowsValid(mat))
			return false;
		if(!colsValid(mat))
			return false;
		
		return true;
		
	}

	private boolean colsValid(ArrayList<ArrayList<Integer>> mat) {
		
		int colLength = mat.get(0).size();
		
		for(int j=0;j<colLength;j++){
			
			HashSet<Integer> set = new HashSet<Integer>();
			
			for(int i=0;i<mat.size();i++){
				if(set.contains(mat.get(i).get(j)))
					return false;
				set.add(mat.get(i).get(j));
				
			}
		}
		
		return true;
	}

	private boolean rowsValid(ArrayList<ArrayList<Integer>> mat) {
		
		int rowLength = mat.size();
		
		for(int i=0;i<rowLength;i++){
			HashSet<Integer> set = new HashSet<Integer>();
			for(int j=0;j<mat.get(0).size();){
				if(set.contains(mat.get(i).get(j)))
					return false;
				set.add(mat.get(i).get(j));
			}
			
		}
		
		return true;
	}
	private static boolean isSafe(int i, int j, char k, List<String> A) {

		for (int l = 0; l < A.get(0).length(); l++)
			if (A.get(i).charAt(l) == k)
				return false;
		for (int l = 0; l < A.size(); l++)
			if (A.get(l).charAt(l) == k)
				return false;
		
		int sqrt = (int) Math.sqrt(A.size()); 
	    int boxRowStart = i - i % sqrt; 
	    int boxColStart = j - j % sqrt; 
	  
	    for (int r = boxRowStart; 
	             r < boxRowStart + sqrt && r<A.size(); r++)  
	    { 
	        for (int d = boxColStart;  
	                 d < boxColStart + sqrt && d<A.get(0).length(); d++)  
	        { 
	            if (A.get(r).charAt(d) == k)  
	            { 
	                return false; 
	            } 
	        } 
	    } 
		
		return true;
	}
	
	public int isValidSudoku(final List<String> A) {
		
		for(int i=0;i<A.size();i++){
			HashSet<Character> rowSet = new HashSet<>();
			HashSet<Character> colSet = new HashSet<>();
			for(int j=0;j<A.get(0).length();j++){
				char chRow = A.get(i).charAt(j);
				char chCol = A.get(j).charAt(i);
				if(chRow !='.'){
					if(rowSet.contains(chRow))
						return 0;
					rowSet.add(chRow);
				}
				if(chCol!='.'){
					if(colSet.contains(chCol))
						return 0;
					colSet.add(chCol);
				}
			}
		}
		
		int rowSetter = 0;
		int colSetter = 0;
		
		while(rowSetter<=6 && colSetter<=6){
			HashSet<Character> set = new HashSet<>();
			for(int i=rowSetter;i<=rowSetter+2;i++){
				
				
				for(int j=colSetter;j<=colSetter+2;j++){
					
					char ch = A.get(i).charAt(j);
					if(ch!='.'){
						if(set.contains(ch))
							return 0;
						set.add(ch);
					}
					
				}
				
			}
			
			if(colSetter==6){
				rowSetter += 3;
			}
			
			colSetter += 3;
			
			
		}
		
		
		
		return 1;
    }
	
	public static void main(String[] args) {
		Validsudoku vs = new Validsudoku();
		System.out.println(vs.isValidSudoku(Arrays.asList("....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......")));
	}
	
	
	

}
