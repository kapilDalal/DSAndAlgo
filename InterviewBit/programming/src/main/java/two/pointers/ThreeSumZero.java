package two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class ThreeSumZero {
	
	static public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();		
		Collections.sort(A);		
		int B=0;		
		for(int i=0;i<A.size()-2;i++){
			int first = A.get(i);
			int start = i+1;
			int end = A.size()-1;
			if(i-1>=0 && A.get(i)==A.get(i-1))
                continue;
			
			while(start<end){				
				if(i==start){
					start++;
					continue;
				}
				else if(i==end){
					end--;
					continue;					
				}
				int second = A.get(start);
				int third = A.get(end);
				int sum = first+second+third;
				
				if(sum==B){
					if(res.size()>0){
						ArrayList<Integer> list = res.get(res.size()-1);
						if(first==list.get(0).intValue() && second==list.get(1).intValue() && third==list.get(2).intValue());
						else{
							res.add(new ArrayList<Integer>(Arrays.asList(first,second,third)));
						}
					}else{
						res.add(new ArrayList<Integer>(Arrays.asList(first,second,third)));
					}
					start++;
					end--;
				}
				else if(sum < B)
					start++;
				else
					end--;
				
			}
		}
		//filterRes(res);
		return res;
    }
	private static void filterRes(ArrayList<ArrayList<Integer>> res) {
		// TODO Auto-generated method stub
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();		
		for(int i=0;i<res.size();i++){
			ArrayList<Integer> l = res.get(i);
			if(set.contains(l)){
				res.remove(i);
			}
			set.add(l);
		}
	}
	public static void main(String[] args) {
		System.out.println(threeSum(new ArrayList<Integer>(Arrays.asList(1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3))));
	}

}
