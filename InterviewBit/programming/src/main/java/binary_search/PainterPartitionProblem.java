package binary_search;

import java.util.Arrays;
import java.util.List;

public class PainterPartitionProblem {

	public int paint(int A, int B, List<Integer> C) {

		long low = Integer.MIN_VALUE;
		long high = 0;

		for (int i = 0; i < C.size(); i++) {
			high = high + C.get(i);
			low = Math.max(low, C.get(i));
		}
		long availablePainters = A;
		while (low < high) {
			long mid = low + (high-low) / 2;
			if (paintersForJob(mid, C) <= availablePainters) {
				high = mid;
			} else
				low = mid+1;
		}

		return (int)(low% 10000003 * B% 10000003)% 10000003;
	}

	private long paintersForJob(long mid, List<Integer> c) {
		long area = 0;
		long cnt = 1;
		for (int i = 0; i < c.size(); i++) {
			area = area + c.get(i);
			if (area > mid) {
				cnt++;
				area = c.get(i);
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		PainterPartitionProblem ppp = new PainterPartitionProblem();
		
		System.out.println(ppp.paint(1, 1000000, Arrays.asList(1000000,1000000)));
	}

}
