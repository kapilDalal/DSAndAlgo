package graph;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadderProblem {

	// not a good solution
	static void diceRollCount(Integer[] moves, int src) {
		int rolls = 0;
		boolean ladderFound = false;
		boolean reached = false;
		while (!reached) {
			for (int i = src; i < src + 6; i++) {
				if (i < moves.length && moves[i] > src + 6) {
					src = moves[i];
					ladderFound = true;
					if (i != src)
						rolls++;
					break;
				}
			}
			if (!ladderFound) {
				int cnt = 6;
				while (src + cnt < moves.length - 1 && (src + cnt > moves[src + cnt]))
					cnt--;
				src = src + cnt;
				rolls++;
			}
			ladderFound = false;
			if (src >= moves.length - 1)
				reached = true;
		}
		System.out.println(rolls);
	}

	static class Node {
		int vertex;
		int dist;

		public Node(int v, int d) {
			vertex = v;
			dist = d;
		}
	}

	static int diceCountGFG(Integer[] moves, int src) {
		boolean[] visited = new boolean[moves.length];
		Queue<Node> que = new LinkedList<Node>();

		visited[src] = true;

		Node node = new Node(src, 0);

		que.add(node);

		while (!que.isEmpty()) {
			node = que.poll();

			int v = node.vertex;

			if (v >= moves.length - 1)
				return node.dist;

			for (int i = v; i <= v + 6 && i < moves.length; i++) {
				if(!visited[i]){
					
					visited[i] = true;
					
					Node temp = new Node(i,node.dist+1);
					
					if(moves[i]!=-1)
						temp.vertex = moves[i];
					
					que.add(temp);
				}
			}

		}
		return node.dist;
	}

	public static void main(String[] args) {
		/*int n = 30;

		Integer[] moves = new Integer[n];
		for (int i = 0; i < n; i++)
			moves[i] = i;

		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;*/
		int N = 30; 
		Integer moves[] = new Integer[N]; 
		for (int i = 0; i < N; i++) 
			moves[i] = -1; 

		// Ladders 
		moves[2] = 21; 
		moves[4] = 7; 
		moves[10] = 25; 
		moves[19] = 28; 
        //moves[8] = 30;

		// Snakes 
		moves[26] = 0; 
		moves[20] = 8; 
		moves[16] = 3; 
		moves[18] = 6; 

		
		System.out.println(diceCountGFG(moves, 0));

	}

}
