package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestPrimeSequence {

	public ArrayList<Integer> solve(int A, int B, int C, int D) {
		ArrayList<Integer> res = new ArrayList<>();
		Queue<Integer> q = new PriorityQueue<Integer>();
		q.add(A);
		q.add(B);
		q.add(C);

		while (res.size() != D && !q.isEmpty()) {

			int poll = q.poll();
			if (!res.contains(poll))
				res.add(poll);
			if (!q.contains(poll * A))
				q.add(poll * A);
			if (!q.contains(poll * B))
				q.add(poll * B);
			if (!q.contains(poll * C))
				q.add(poll * C);

		}
		return res;
	}

	public static void main(String[] args) {
		SmallestPrimeSequence sps = new SmallestPrimeSequence();
		System.out.println(sps.solve(2, 3, 5, 5));
	}
}
