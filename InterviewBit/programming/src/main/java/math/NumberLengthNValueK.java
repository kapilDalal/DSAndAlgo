package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberLengthNValueK {

	public int solve(List<Integer> A, int B, int C) {
		int res = 0;
		
		if(B==1){			
			for(int i=0;i<A.size();i++)
				if(A.get(i)<C)
					res++;
			return res;
		}
		int[][] mat = null;
		ArrayList<Integer> dd = new ArrayList<Integer>();
		if(B>=2){
			mat = new int[A.size()][A.size()];		
			fillMat(mat,A,A);
			if(B==2){
				for(int i=1;i<mat.length;i++){
					for(int j=0;j<mat[0].length;j++){
						if(mat[i][j]<C)
							res++;
						else
							return res;
					}
				}
			}
			else{
				for(int i=1;i<mat.length;i++){
					for(int j=0;j<mat[0].length;j++){
						dd.add(mat[i][j]);
					}
				}				
			}
		}
		int[][] mat2 = new int[dd.size()][A.size()];
		ArrayList<Integer> td = new ArrayList<Integer>();
		if(B>=3){
			fillMat(mat2,dd,A);
			if(B==3){
				return findCount(mat2,dd.size(),A.size(),C);				
			}
			else{
				addElementsToList(mat2,dd.size(),A.size(),td);
			}
		}
		int[][] mat3 = new int[td.size()][A.size()];
		ArrayList<Integer> fd = new ArrayList<Integer>();
		if(B>=4){
			fillMat(mat3, td, A);
			if(B==4){
				return findCount(mat3, td.size(), A.size(), C);
			}
			else
				addElementsToList(mat3, td.size(), A.size(), fd);
		}
		
		
		
		int[][] mat4 = new int[fd.size()][A.size()];
		ArrayList<Integer> fivd = new ArrayList<Integer>();
		if(B>=4){
			fillMat(mat4, fd, A);
			if(B==4){
				return findCount(mat4, fd.size(), A.size(), C);
			}
			else
				addElementsToList(mat4, fd.size(), A.size(), fivd);
		}
		
		int[][] mat5 = new int[fivd.size()][A.size()];
		ArrayList<Integer> sixd = new ArrayList<Integer>();
		if(B>=5){
			fillMat(mat5, fivd, A);
			if(B==5){
				return findCount(mat5, fivd.size(), A.size(), C);
			}
			else
				addElementsToList(mat5, fivd.size(), A.size(), sixd);
		}
		
		int[][] mat6 = new int[sixd.size()][A.size()];
		ArrayList<Integer> sevd = new ArrayList<Integer>();
		if(B>=6){
			fillMat(mat6, sixd, A);
			if(B==6){
				return findCount(mat6, sixd.size(), A.size(), C);
			}
			else
				addElementsToList(mat6, sixd.size(), A.size(), sevd);
		}
		int[][] mat7 = new int[sevd.size()][A.size()];
		ArrayList<Integer> eigd = new ArrayList<Integer>();
		if(B>=7){
			fillMat(mat7, sevd, A);
			if(B==7){
				return findCount(mat7, sevd.size(), A.size(), C);
			}
			else
				addElementsToList(mat7, sevd.size(), A.size(), eigd);
		}
		int[][] mat8 = new int[eigd.size()][A.size()];
		ArrayList<Integer> nind = new ArrayList<Integer>();
		if(B>=8){
			fillMat(mat8, eigd, A);
			if(B==8){
				return findCount(mat8, eigd.size(), A.size(), C);
			}
			else
				addElementsToList(mat8, eigd.size(), A.size(), nind);
		}

		if (B == 9) {
			for (int i = 0; i < nind.size(); i++)
				if (nind.get(i) < C)
					res++;
			return res;
		}

		return res;
    }

	private void addElementsToList(int[][] mat, int row, int col, ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				list.add(mat[i][j]);
			}
		}
		
	}

	private int findCount(int[][] mat,int row,int col, int c) {
		// TODO Auto-generated method stub
		int res = 0;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(mat[i][j]<c)
					res++;
				else
					return res;
			}
		}
		return res;
	}

	private void fillMat(int[][] mat, List<Integer> rows, List<Integer> cols) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<rows.size();i++){
			for(int j=0;j<cols.size();j++){
				int a1 = rows.get(i);
				int a2 = cols.get(j);
				String str = String.valueOf(a1) + String.valueOf(a2);
				int parseInt = Integer.parseInt(str);
				mat[i][j] = parseInt;
			}
		}
		
	}
	
	public static void main(String[] args) {
		NumberLengthNValueK l = new NumberLengthNValueK();
		//l.solve(Arrays.asList(0,1,2,5), 1, 3);
		System.out.println(l.solve(Arrays.asList(0, 2, 3, 4, 5, 7, 8, 9), 5, 86587));
	}
	
}
