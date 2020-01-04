package bitwise;

import java.util.ArrayList;
import java.util.Collections;

public class MinXor {

	public int findMinXor(ArrayList<Integer> A) {
		int min = Integer.MAX_VALUE;
		Collections.sort(A);
		for (int i = 0; i < A.size() - 1; i++)
			min = Math.min(min, (A.get(i) ^ A.get(i + 1)));
		return min;
	}

}
