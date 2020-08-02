package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxLengthChainPairs {
	
	static public class Pair implements Comparable<Pair>{
		int x;
		int y;
		public Pair(int x,int y) {
			this.x = x;
			this.y = y;
		}		
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.x - o.x;
		}
	}
	
	static int maxChainLength(ArrayList<Pair> pairs) 
    {
		Collections.sort(pairs);		
		int[] lis = new int[pairs.size()];
		lis[0] = 1;
		int max = Integer.MIN_VALUE;
		for(int i=1;i<pairs.size();i++) {
			lis[i] = 1;
			for(int j=0;j<i;j++) {
				if(pairs.get(i).x>pairs.get(j).y &&   lis[j] + 1>lis[i]) {
					lis[i] = lis[j] + 1;
					
				}
			}
			max = Math.max(lis[i],max);
		}		
		return max;		
    }
	public static void main(String[] args) {
		ArrayList<Pair> pairs = new ArrayList<>(Arrays.asList(new Pair(5,24),new Pair(39,60),
															  new Pair(15,28),new Pair(27,40),
															  new Pair(50,90)));
		System.out.println(maxChainLength(pairs));
	}

}
