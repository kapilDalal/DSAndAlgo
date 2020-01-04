package bitwise;

import java.util.ArrayList;
import java.util.Arrays;

public class DifferentBitSumPairwise {
	
	public int cntBits(ArrayList<Integer> A) {
		int res = 0;
        
        for(int i=0;i<31;i++){
            int numOfOnes = 0;
            for(int j=0;j<A.size();j++){
                int ele = A.get(j);
                if((ele & 1<<i) != 0)
                    numOfOnes++;
            }
            int numOfZeros = A.size() - numOfOnes;
            res += (1L * numOfOnes * numOfZeros)% 1000000007;;
            res = res % 1000000007;
            
        }
        return 2*res;
    }
	
	public static void main(String[] args) {
		DifferentBitSumPairwise db = new DifferentBitSumPairwise();
		System.out.println(db.cntBits(new ArrayList<Integer>(Arrays.asList(1,3,5))));
	}

}
