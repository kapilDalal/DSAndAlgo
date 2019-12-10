package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateMatrix {
	
	//below solution is using O(n^2) extra space, a better approach is to transpose the matrix and then reverse all the rows
	static public void rotate(List<List<Integer>> a) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int rows = a.size();
		int cols = a.get(0).size();
		
		for(int j=0;j<cols;j++){
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=rows-1;i>=0;i--){
				list.add(a.get(i).get(j));
			}
			res.add(list);
		}
		for(int i=0;i<rows;i++){
			ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j=0;j<cols;j++){
                list.add(res.get(i).get(j));
            }
            a.set(i, list);
        }
		a = res;
		System.out.println(a);
    }
	public static void main(String[] args) {
		List<List<Integer>> a = new ArrayList<List<Integer>>();
		List<Integer> l = Arrays.asList(1,2,3);
		List<Integer> l1 = Arrays.asList(4,5,6);
		List<Integer> l2 = Arrays.asList(7,8,9);
		a.add(l);
		a.add(l1);
		a.add(l2);
		rotate(a);
	}

}
