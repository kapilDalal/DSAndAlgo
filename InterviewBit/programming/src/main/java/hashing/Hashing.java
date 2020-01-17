package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hashing {
	
	static public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        Collections.sort(A);
        
        for(int i=0;i<A.size();i++){
            for(int j=i+1;j<A.size();j++){
                int sum = B-(A.get(i)+ A.get(j));
                int start = j+1;
                int end = A.size()-1;
                while(start<end){
                    if(A.get(start)+A.get(end)==sum){
                        ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(A.get(i),A.get(j),A.get(start),A.get(end)));
                        if(!res.contains(l))
                            res.add(l);
                        start++;
                        end--;
                    }
                    else if(A.get(start)+A.get(end)<sum)
                        start++;
                    else 
                        end--;
                }
            }
        }
       // Collections.sort(res);
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(fourSum(new ArrayList<Integer>(Arrays.asList(9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10, -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1, -2, 5, -2)), 0));
	}

}
