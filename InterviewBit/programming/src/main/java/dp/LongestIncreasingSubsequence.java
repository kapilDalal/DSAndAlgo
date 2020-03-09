package dp;

import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
	static public int lis(final List<Integer> A) {
		if(A.size()==0)
			return 0;
		int max=1;
		int[] lis = new int[A.size()];
		Arrays.fill(lis, 1);
		for(int i=1;i<A.size();i++){
			for(int j=0;j<i;j++){
				if(A.get(i)>A.get(j))
					lis[i] = Math.max(lis[j]+1, lis[i]);
			}
		}
		for(int i=0;i<lis.length;i++)
			max = Math.max(max, lis[i]);
		return max;
    }
	
	
	public static void main(String[] args) {
		System.out.println(lis(Arrays.asList(1, 2, 1, 5)));			
	}

}
