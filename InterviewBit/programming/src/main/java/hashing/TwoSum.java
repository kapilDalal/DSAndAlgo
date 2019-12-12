package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class TwoSum {
	
	static public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
		ArrayList<Integer> res = new ArrayList<>();
		HashSet<Integer> set = new HashSet<Integer>();
		int index1=0,index2=0;
		for(int i=0;i<A.size();i++){
			if(!set.isEmpty() && set.contains(B-A.get(i))){
				Iterator<Integer> iterator = set.iterator();
				int place=0;
				/*while(iterator.hasNext()){
					int ele = iterator.next();
					if(ele==B-A.get(i))
						break;
					place++;
				}*/
				for(int j=0;j<i;j++){
					int ele = A.get(j);
					if(ele==B-A.get(i))
						break;
					place++;
				}
				//System.out.println(i+"\t"+place);
				if(i<place){
					res.add(i+1);
					res.add(place+1);
					
					
				}
				else{
					res.add(place+1);
					res.add(i+1);
					
				}
				break;
			}
			set.add(A.get(i));
		}
		
		return res;
    }
	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8 );
		
		System.out.println(twoSum(A, -3));
	}

}
