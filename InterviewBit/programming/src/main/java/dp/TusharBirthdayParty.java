package dp;

import java.util.Arrays;
import java.util.List;

public class TusharBirthdayParty {
	
	int priceForOneFriend = Integer.MAX_VALUE;
	
	public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
		int totalPrice = 0;
		
		for(int i=0;i<A.size();i++) {
			calPrice(B,C,A.get(i),0);
			totalPrice += priceForOneFriend; 
			priceForOneFriend = Integer.MAX_VALUE;
		}
		
		return totalPrice;
    }

	private void calPrice(List<Integer> wt, List<Integer> val, Integer w, int p) {
		// TODO Auto-generated method stub
		if(w<0)
			return;
		if(w==0) {
			priceForOneFriend = Math.min(p, priceForOneFriend);
			return;
		}
		for(int i=0;i<wt.size();i++) {
			calPrice(wt, val, w-wt.get(i), p+val.get(i));
		}
	}
	
	public int solveUsingDP(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int totSum = 0;
        
        int a = 0;
        
        for(Integer b : A){
            if(b>a){
                a = b;
            }
        }
        
        int [] v = new int[a+1];
        for(int i = 1;i<=a;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j<B.size();j++){
                if(B.get(j)>i){
                    continue;
                }
                int value = v[i-B.get(j)] + C.get(j);
                if(value<min){
                    min = value;
                }
            }
            v[i] = min;
        }
        for(int i=0;i<v.length;i++)
        	System.out.print(v[i]+"\t");
        for(Integer b : A){        	
            totSum += v[b];
        }
           
        return totSum;
    }
	
	public static void main(String[] args) {
		TusharBirthdayParty tbp = new TusharBirthdayParty();
		System.out.println(tbp.solveUsingDP(Arrays.asList(4,6), Arrays.asList(1,3), Arrays.asList(5,3)));
	}

}
