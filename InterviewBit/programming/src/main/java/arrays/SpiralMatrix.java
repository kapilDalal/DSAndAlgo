package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {

		int left, right, top, bottom, dir;
		bottom = A.size() - 1;
		right = A.get(0).size() - 1;
		left = top = dir = 0;

		ArrayList<Integer> a = new ArrayList<Integer>();
		while (left <= right && top <= bottom) {

			if (dir == 0)
				for (int i = left; i <= right; i++) {
					// System.out.print(A.get(top).get(i)+"\t");
					a.add(A.get(top).get(i));
					top++;
				}

			else if (dir == 1)
				for (int i = top; i <= bottom; i++) {
					// System.out.print(A.get(i).get(right)+"\t");
					a.add(A.get(i).get(right));
					right--;
				}

			else if (dir == 2)
				for (int i = right; i >= left; i--) {
					// System.out.print(A.get(bottom).get(i)+"\t");
					a.add(A.get(bottom).get(i));
					bottom--;
				}

			else if (dir == 3)
				for (int i = bottom; i >= top; i--) {
					// System.out.print(A.get(i).get(left)+"\t");
					a.add(A.get(i).get(left));
					left++;
				}
			dir = (dir + 1) % 4;

		}

		return a;
	}
}
