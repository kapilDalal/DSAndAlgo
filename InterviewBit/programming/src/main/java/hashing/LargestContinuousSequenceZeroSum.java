package hashing;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestContinuousSequenceZeroSum {
	
	static public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        int max = 0;
        int start=0,end=0;
        for(int i=0;i<A.size();i++){
            for(int j=i;j<=A.size();j++){
                 ArrayList<Integer> l = new ArrayList<Integer>(A.subList(i,j));
                 if(sum(l)==0){
                     if(max<j-i){
                        max = j-i;
                        start = i;
                        end = j;
                     }
                 }
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=start;i<end;i++)
            res.add(A.get(i));
        return res;
        
    }
    static public int sum(ArrayList<Integer> l){
        int sum = 0;
        for(int i=0;i<l.size();i++)
            sum += l.get(i);
        return sum;
    }
    public static void main(String[] args) {
		System.out.println(lszero(new ArrayList<Integer>(Arrays.asList(-19,19))));
	}

}
