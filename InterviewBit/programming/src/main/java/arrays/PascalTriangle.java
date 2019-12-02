package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PascalTriangle {

	static public void generatePascalLayer(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		list.addAll(Arrays.asList(1));
		res.add(new ArrayList<Integer>(list));
		if (n >= 2){	
			list.clear();
			list.addAll(Arrays.asList(1, 1));
			res.add(list);
		}
		int k = 2;
		while (k < n) {
			ArrayList<Integer> newList = new ArrayList<Integer>();
			newList.add(1);
			for (int i = 0; i < list.size() - 1; i++) {
				int first = list.get(i);
				int second = list.get(i + 1);
				newList.add(first + second);
			}
			newList.add(1);
			list = newList;
			res.add(newList);
			k++;	
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		generatePascalLayer(0);
	}

}
