package backtracking;

public class HamiltonianCycle {

	static int V = 5;
	static int[] hp = new int[V];

	static boolean htCycleUtil(int[][] graph, int start, int v, boolean[] visited, int index) {

		visited[v] = true;
		for (int i = 0; i < V; i++) {
			if (isSafe(graph, v, i, visited)) {
				hp[index] = i;
				if (htCycleUtil(graph, start, i, visited, index + 1))
					return true;
				/*
				 * visited[v] = false; hp[index] = -1;
				 */
			}
		}
		if (allVisited(visited) && isNextStart(graph, v, start))
			return true;
		visited[v] = false;
		return false;

	}

	private static boolean isNextStart(int[][] graph, int v, int start) {
		// TODO Auto-generated method stub

		if (graph[v][start] == 1)
			return true;

		return false;
	}

	private static boolean allVisited(boolean[] visited) {
		// TODO Auto-generated method stub
		for (int i = 0; i < visited.length; i++)
			if (visited[i] == false)
				return false;
		return true;
	}

	private static boolean isSafe(int[][] graph, int v, int i, boolean[] visited) {

		if (graph[v][i] == 1 && !visited[i])
			return true;

		return false;
	}

	static void htCycle(int[][] graph) {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++)
			hp[i] = -1;
		htCycleUtil(graph, 1, 1, visited, 0);
		for (int i = 0; i < V; i++)
			System.out.println(hp[i]);
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 1, 0, 1, 0 },
						{ 1, 0, 1, 1, 1 },
						{ 0, 1, 0, 1, 1 },
						{ 1, 1, 1, 0, 0 },
						{ 0, 1, 1, 0, 0 } };
		htCycle(graph);
	}

}
