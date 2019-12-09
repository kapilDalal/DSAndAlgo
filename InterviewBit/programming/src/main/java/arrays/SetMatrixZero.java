package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SetMatrixZero {

	static public void setZeroes(List<List<Integer>> a) {
		HashSet<Integer> rows = new HashSet<Integer>();
		HashSet<Integer> cols = new HashSet<Integer>();
		//int numOfRows = a.size();
		int colSize = a.get(0).size();
		for (int i = 0; i < a.size(); i++) {
			List<Integer> list = a.get(i);
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		if (rows.size() > 0) {
			Iterator<Integer> rowItr = rows.iterator();
			while (rowItr.hasNext()) {
				int row = rowItr.next();
				//System.out.println(row);
				for (int j = 0; j < colSize; j++)
					a.get(row).set(j, 0);
			}
		}
		if (cols.size() > 0) {
			Iterator<Integer> colItr = cols.iterator();
			while (colItr.hasNext()) {
				int col = colItr.next();
				for (int i = 0; i < a.size(); i++)
					a.get(i).set(col, 0);
			}
		}
		//System.out.println(a);

	}

	public static void main(String[] args) {
		List<List<Integer>> a = new ArrayList<>();
		List<Integer> l = Arrays.asList(1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0);
		List<Integer> l1 = Arrays.asList(1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		List<Integer> l2 = Arrays.asList(0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0);
		List<Integer> l3 = Arrays.asList(0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1);
		List<Integer> l4 = Arrays.asList(0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1);
		List<Integer> l5 = Arrays.asList(1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0);
		List<Integer> l6 = Arrays.asList(0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0);
		List<Integer> l7 = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1);
		List<Integer> l8 = Arrays.asList(0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1);
		List<Integer> l9 = Arrays.asList(1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1);
		List<Integer> l10 = Arrays.asList(0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1);
		List<Integer> l11 = Arrays.asList(1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0);
		List<Integer> l12 = Arrays.asList(1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1);
		List<Integer> l13 = Arrays.asList(0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1);
		List<Integer> l14 = Arrays.asList(1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1);
		List<Integer> l15 = Arrays.asList(0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0);
		List<Integer> l16 = Arrays.asList(0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0);
		List<Integer> l17 = Arrays.asList(1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0);
		List<Integer> l18 = Arrays.asList(1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1);
		List<Integer> l19 = Arrays.asList(0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0);
		List<Integer> l20 = Arrays.asList(1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0);
		List<Integer> l21 = Arrays.asList(1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1);
		List<Integer> l22 = Arrays.asList(1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0);
		List<Integer> l23 = Arrays.asList(1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1);
		List<Integer> l24 = Arrays.asList(1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0);
		List<Integer> l25 = Arrays.asList(0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1);
		
		a.add(l);
		a.add(l1);
		a.add(l2);
		a.add(l3);
		a.add(l4);
		a.add(l5);
		a.add(l6);
		a.add(l7);
		a.add(l8);
		a.add(l9);
		a.add(l10);
		a.add(l11);
		a.add(l12);
		a.add(l13);
		a.add(l14);
		a.add(l15);
		a.add(l16);
		a.add(l17);
		a.add(l18);
		a.add(l19);
		a.add(l20);
		a.add(l21);
		a.add(l22);
		a.add(l23);
		a.add(l24);
		a.add(l25);
		
		setZeroes(a);
		System.out.println(a);
	}

}
