package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ValidPath {

	static public class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
		int[][] mat = new int[A + 1][B + 1];
		boolean[][] visited = new boolean[A + 1][B + 1];
		for (int i = 0; i <= A; i++) {
			for (int j = 0; j <= B; j++) {
				visited[i][j] = false;
				for (int k = 0; k < E.size(); k++) {
					double dist = Math.sqrt(Math.pow(i - E.get(k), 2) + Math.pow(j - F.get(k), 2));
					if (dist <= D)
						mat[i][j] = -1;
				}
			}
		}
		
		int[] xMoves = {-1,-1,-1,0,0,1,1,1};
		int[] yMoves = {-1,0,1,-1,1,-1,0,1};
		Queue<Pair> q = new LinkedList<Pair>();
		Pair startPair = new Pair(0, 0);
		q.add(startPair);
		if(mat[0][0]==-1)
			return "NO";
		
		while(!q.isEmpty()) {
			
			Pair pair = q.poll();			
			for(int i=0;i<xMoves.length;i++) {
				int nextI = pair.x + xMoves[i];
				int nextJ = pair.y + yMoves[i];				
				if(isValid(A,B,nextI,nextJ,mat,visited)) {
					q.add(new Pair(nextI,nextJ));
					visited[nextI][nextJ] = true;
				}
			}
			
		}
		return visited[A][B] ? "YES":"NO";
	}

	private boolean isValid(int a, int b, int nextI, int nextJ, int[][] mat, boolean[][] visited) {
		// TODO Auto-generated method stub
		if(nextI>=0 && nextI<=a && nextJ>=0 && nextJ<=b && !visited[nextI][nextJ] && mat[nextI][nextJ]!=-1)
			return true;		
		return false;
	}
	public static void main(String[] args) {
		ValidPath vp = new ValidPath();
		System.out.println(vp.solve(14, 3, 9, 0, new ArrayList<Integer>(Arrays.asList(3, 3, 0, 11, 8, 11, 14, 8, 4)),new ArrayList<Integer>(Arrays.asList(1, 0, 2, 2, 0, 2, 3, 2, 1))));
	}

}
