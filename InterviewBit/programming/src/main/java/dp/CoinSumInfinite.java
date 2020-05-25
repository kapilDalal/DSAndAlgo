package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CoinSumInfinite {

	
    public int coinchange2(ArrayList<Integer> A, int B) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        solve(A,new ArrayList<Integer>(),res,B);
        System.out.println(res);
        return res.size();
    }
    public void solve(ArrayList<Integer> A,ArrayList<Integer> resSublist, ArrayList<ArrayList<Integer>> res,int B){
        if(B==0){
        	Collections.sort(resSublist);
        	if(!res.contains(resSublist))
        		res.add(resSublist);        	    
            return;
        }
        for(int i=0;i<A.size();i++){
            if(B-A.get(i)>=0){
            	ArrayList<Integer> resSublist1 = new ArrayList<Integer>(resSublist);
            	resSublist1.add(A.get(i));
                solve(A,resSublist1,res,B-A.get(i));
            }
        }
    }
    public static void main(String[] args) {
		CoinSumInfinite csi = new CoinSumInfinite();
		int res = csi.coinchange2(new ArrayList<Integer>(Arrays.asList(2,5,3,6)), 10);
		System.out.println(res);
	}
	
}
