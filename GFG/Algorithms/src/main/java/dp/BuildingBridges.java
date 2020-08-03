package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BuildingBridges {
	
	static public class BridgePair implements Comparable<BridgePair>{
		int north;
		int south;
		
		public BridgePair(int n,int s) {
			this.north = n;
			this.south = s;
		}

		@Override
		public int compareTo(BridgePair o) {
			// TODO Auto-generated method stub
			if(this.south==o.south)
				return this.north - o.north;
			return this.south-o.south;
		}
	}
	
	static int maxBridges(int[] northBridges,int[] southBridges) {
		ArrayList<BridgePair> bridges = new ArrayList<>();		
		for(int i=0;i<northBridges.length;i++) {
			BridgePair b = new BridgePair(northBridges[i], southBridges[i]);
			bridges.add(b);
		}
		Collections.sort(bridges);
		
		int max = -1;
		int[] lis = new int[northBridges.length];
		Arrays.fill(lis, 1);
		for(int i=1;i<bridges.size();i++) {
			for(int j=0;j<i;j++) {
				if(bridges.get(j).north<=bridges.get(i).north && lis[i]<1+lis[j]) {
					lis[i] = 1 + lis[j];
				}
			}
			max = Math.max(max, lis[i]);
		}
		
		return max;
	}
	public static void main(String[] args) {
		int[] northBridges = {8,1,4,3,5,2,6,7};
		int[] southBridges = {1,2,3,4,5,6,7,8};
		System.out.println(maxBridges(northBridges, southBridges));
	}

}
