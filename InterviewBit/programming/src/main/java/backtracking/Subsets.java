package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Subsets {
	static class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {

		  @Override
		  public int compare(List<T> o1, List<T> o2) {
		    for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
		      int c = o1.get(i).compareTo(o2.get(i));
		      if (c != 0) {
		        return c;
		      }
		    }
		    return Integer.compare(o1.size(), o2.size());
		  }

	}
	static public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		int n = A.size();
		String str = "";
		for(int i=0;i<A.size();i++)
			str = str + A.get(i);
		for(int i=0;i<Math.pow(2,n);i++){
			ArrayList<Integer> list = new ArrayList<>();
			for(int j=0;j<n;j++){
				if(((i>>j)&1)==1){
					list.add(A.get(j));
				}
			}
			if(!res.contains(list)) //for removing duplicate subsets in case of duplicate elements
				res.add(list);
		}
		//Collections.sort(res);
		Collections.sort(res, new ListComparator<>());
		System.out.println(res);
		return res;
    }
	
	static public void subset(){
		String str = "abc";
		ArrayList<String> l = new ArrayList<>();
		int n = str.length();
		for(int i=0;i<Math.pow(2, n);i++){
			String res = "";
			for(int j=0;j<n;j++){
				if(((i>>j)&1)==1){
					res = res + str.charAt(j);
				}
				
			}
			//if(res.length()>0)
				l.add(res);
			//System.out.println(res);
		}
		Collections.sort(l);
		System.out.println(l);
	}
	
	static public ArrayList<ArrayList<Integer>> subsetsUsingBacktracking(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		output.add(new ArrayList<Integer>());
		if (a.size() == 0)
			return output;
		Collections.sort(a);
		generate(a, output, new ArrayList<Integer>(), 0);
		return output;
	}
	
	static public void generate(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> output, ArrayList<Integer> temp, int index)
	{
		for (int i = index; i < a.size(); i++)
		{
			temp.add(a.get(i));
			output.add(new ArrayList<Integer>(temp));
			generate(a, output, temp, i+1);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		//subsets(new ArrayList<Integer>(Arrays.asList(1,2,3)));		
		System.out.println(subsetsUsingBacktracking(new ArrayList<Integer>(Arrays.asList(1,2,3))));
	}

}
