package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku {

	public void solveSudoku(ArrayList<ArrayList<Character>> a) {

		
		solve(a, a.size(), a.get(0).size());
		System.out.println(a);

	}

	private boolean solve(ArrayList<ArrayList<Character>> a,int nr, int nc) {
		// TODO Auto-generated method stub

		int rn = 0, cn = 0;
		boolean found = false;
		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				if (a.get(i).get(j) == '.') {
					rn = i;
					cn = j;
					found = true;
					break;
				}
			}
			if (found)
				break;
		}
		if(!found)
			return true;
		for (int i = 1; i <= 9; i++) {
			if (isSafe(a, rn, cn, String.valueOf(i).charAt(0))) {
				a.get(rn).set(cn, String.valueOf(i).charAt(0));

				if (solve(a,nr, nc))
					return true;
				a.get(rn).set(cn, '.');
			}
		}
		return false;
	}

	private boolean isSafe(ArrayList<ArrayList<Character>> a, int rn, int cn, char k) {
		// TODO Auto-generated method stub

		for (int j = 0; j < a.get(0).size(); j++) {
			if (a.get(rn).get(j) == k)
				return false;
		}
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).get(cn) == k)
				return false;
		}

		int sqrt = (int) Math.sqrt(a.size());
		int boxRowStart = rn - rn % sqrt;
		int boxColStart = cn - cn % sqrt;

		for (int r = boxRowStart; r < boxRowStart + sqrt && r < a.size(); r++) {
			for (int d = boxColStart; d < boxColStart + sqrt && d < a.get(0).size(); d++) {
				if (a.get(r).get(d) == k) {
					return false;
				}
			}
		}

		return true;
	}
	public static void main(String[] args) {
		ArrayList<ArrayList<Character>> a = new ArrayList<>();
		ArrayList<Character> l1 = new ArrayList<>(Arrays.asList('5','3','.','.','7','.','.','.','.'));
		ArrayList<Character> l2 = new ArrayList<>(Arrays.asList('6','.','.','1','9','5','.','.','.'));
		ArrayList<Character> l3 = new ArrayList<>(Arrays.asList('.','9','8','.','.','.','.','6','.'));
		ArrayList<Character> l4 = new ArrayList<>(Arrays.asList('8','.','.','.','6','.','.','.','3'));
		ArrayList<Character> l5 = new ArrayList<>(Arrays.asList('4','.','.','8','.','3','.','.','1'));
		ArrayList<Character> l6 = new ArrayList<>(Arrays.asList('7','.','.','.','2','.','.','.','6'));
		ArrayList<Character> l7 = new ArrayList<>(Arrays.asList('.','6','.','.','.','.','2','8','.'));
		ArrayList<Character> l8 = new ArrayList<>(Arrays.asList('.','.','.','4','1','9','.','.','5'));
		ArrayList<Character> l9 = new ArrayList<>(Arrays.asList('.','.','.','.','8','.','.','7','9'));
		a.add(l1);
		a.add(l2);
		a.add(l3);
		a.add(l4);
		a.add(l5);
		a.add(l6);
		a.add(l7);
		a.add(l8);
		a.add(l9);
		Sudoku s = new Sudoku();
		s.solveSudoku(a);
	}

}
