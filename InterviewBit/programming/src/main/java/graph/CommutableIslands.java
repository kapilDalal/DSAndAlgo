package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CommutableIslands {
	static class Island implements Comparable<Island> {
		int src;
		int dest;
		int weight;

		public Island(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public int compareTo(Island o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}

	public static int findParent(Integer[] parent, int i) {
		if (parent[i] == -1)
			return i;
		return findParent(parent, parent[i]);
	}

	public static void union(Integer[] parent, int i, int j) {
		int parentI = findParent(parent, i);
		int parentJ = findParent(parent, j);

		parent[parentI] = parentJ;
	}
	
	public int solve(int A, ArrayList<ArrayList<Integer>> B) {
		int res = 0;
		ArrayList<Island> islands = new ArrayList<Island>();
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < B.size(); i++) {
			ArrayList<Integer> islandInfo = B.get(i);
			int src = islandInfo.get(0);
			int dest = islandInfo.get(1);
			int weight = islandInfo.get(2);
			Island island = new Island(src, dest, weight);
			islands.add(island);
		}
		Collections.sort(islands);

		Integer[] parent = new Integer[A];
		for (int i = 0; i < parent.length; i++)
			parent[i] = -1;
		
		for (int i = 0; i < islands.size(); i++) {
			Island island = islands.get(i);
			int parentSrc = findParent(parent, island.src);
			int parentDest = findParent(parent, island.dest);
			if(parentSrc!=parentDest) {
				res += island.weight;
				union(parent, island.src, island.dest);
			}
		}
		return res;
	}

}
