package backtracking;

import java.util.ArrayList;

public class NQueen {
	
	//this solution is not giving all the possibilities because of line number 32-36

	ArrayList<ArrayList<String>> res = new ArrayList<>();

	public ArrayList<ArrayList<String>> solveNQueens(int a) {
		ArrayList<Integer> positions = new ArrayList<>();
		int numOfQueens = a;
		int firstQueenPosition = 0;
		while (firstQueenPosition < numOfQueens) {
			if (solveUtil(numOfQueens, 0, positions)) {
				//System.out.println(positions);
				ArrayList<String> sol = new ArrayList<>();				
				for(int i=0;i<positions.size();i++){
					String str = "";
					for(int j=0;j<positions.size();j++){
						if(positions.get(i)==j)
							str = str + "Q";
						else
							str = str + ".";
					}
					sol.add(str);
				}
				res.add(sol);
				
			}
			while(positions.size()>=2)
				positions.remove(1);
			positions.set(0, positions.get(0) + 1);
			firstQueenPosition = positions.get(0);
		}
		return res;
	}

	private boolean solveUtil(int numOfQueens, int queen, ArrayList<Integer> positions) {
		if (positions.size() >= numOfQueens)
			return true;

		for (int i = 0; i < numOfQueens; i++) {
			if (isValid(numOfQueens, i, positions)) {
				positions.add(i);
				if (solveUtil(numOfQueens, i + 1, positions))
					return true;
				positions.remove(positions.size() - 1);
			}

		}

		return false;
	}

	private boolean isValid(int numOfQueens, int queenPosition, ArrayList<Integer> positions) {
		for (int i = 0; i < positions.size(); i++) {
			if (positions.get(i) == queenPosition)
				return false;
		}
		int i = queenPosition - 1;
		int j = queenPosition + 1;
		for (int k = positions.size() - 1; k >= 0; k--) {
			if (positions.get(k) == i || positions.get(k) == j) {
				return false;
			}
			i--;
			j++;
		}

		return true;
	}

	public static void main(String[] args) {
		NQueen nq = new NQueen();		
		System.out.println(nq.solveNQueens(3));
	}

}
