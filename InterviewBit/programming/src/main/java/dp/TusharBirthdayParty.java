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
	public static void main(String[] args) {
		TusharBirthdayParty tbp = new TusharBirthdayParty();
		System.out.println(tbp.solve(Arrays.asList(4,6), Arrays.asList(1,3), Arrays.asList(5,3)));
	}

}
