package dp;

import java.util.Arrays;

public class LengthOfLongestSubsequence {
	
	public int longestSubsequenceLength(final int[] A) {
    
		int max = 1;
		int[] lis = new int[A.length];
		Arrays.fill(lis, 1);
		int[] lisRev = new int[A.length];
		Arrays.fill(lisRev, 1);
		
		for(int i=1;i<A.length;i++) {
			for(int j=0;j<i;j++) {
				if(A[i]>A[j]) {
					lis[i] = Math.max(lis[j]+1, lis[i]);
				}
			}
		}
		for(int i=A.length-2;i>=0;i--) {
			for(int j=A.length-1;j>i;j--) {
				if(A[i]>A[j]) {
					lisRev[i] = Math.max(lisRev[j]+1, lisRev[i]);
				}
			}
		}
		for(int i=0;i<lis.length;i++)
			max = Math.max(lis[i], max);
		for(int i=0;i<lis.length;i++) {
			for(int j=lisRev.length-1;j>i;j--) {
				if((lis[i]>1 || lisRev[j]>1) && A[i]!=A[j])
				max = Math.max(lis[i]+lisRev[j], max);
			}
		}
		
		
		return max;
	
	}
	public static void main(String[] args) {
		LengthOfLongestSubsequence lls = new LengthOfLongestSubsequence();
		System.out.println(lls.longestSubsequenceLength(new int[] {2, 1, 3 }));
	}

}
