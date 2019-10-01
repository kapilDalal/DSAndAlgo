package graph;

public class MinCashFlowGFG {

	static void minCashFlowUtil(Integer[] amount) {

		int maxCreditor = getMaxCreditor(amount);
		int maxDebitor = getMaxDebitor(amount);

		int min = Math.min(amount[maxCreditor], -amount[maxDebitor]);

		if (amount[maxCreditor] == 0 && amount[maxDebitor] == 0)
			return;

		System.out.println("person " + maxDebitor + " pays " + min + " to person " + maxCreditor);

		amount[maxCreditor] -= min;
		amount[maxDebitor] += min;

		minCashFlowUtil(amount);

	}

	private static int getMaxDebitor(Integer[] amount) {
		int maxDebt = 0;

		for (int i = 1; i < amount.length; i++)
			if (amount[i] < amount[maxDebt])
				maxDebt = i;

		return maxDebt;
	}

	private static int getMaxCreditor(Integer[] amount) {
		int max = 0;

		for (int i = 1; i < amount.length; i++)
			if (amount[i] > amount[max])
				max = i;

		return max;
	}

	static void minCashFlow(Integer[][] graph, int numberOfVertices) {
		Integer[] amount = new Integer[numberOfVertices];
		for (int i = 0; i < numberOfVertices; i++)
			amount[i] = 0;

		for (int i = 0; i < numberOfVertices; i++) {
			for (int j = 0; j < numberOfVertices; j++)
				amount[i] = amount[i] + (graph[j][i] - graph[i][j]);
		}

		minCashFlowUtil(amount);

	}

	public static void main(String[] args) {
		Integer[][] graph = { { 0, 1000, 2000 },
							  { 0, 0,    5000 },
							  { 0, 0,    0 } };
		minCashFlow(graph, 3);
	}

}
