package arrays;

import java.util.ArrayList;

public class SpiralOrderMatrixII {

	static public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		int left = 0, top = 0, dir = 0, right = A - 1, bottom = A - 1;
		int[][] mat = new int[A][A];
		ArrayList<Integer> a = new ArrayList<Integer>();
		int ele = 1;
		while (left <= right && top <= bottom) {

			if (dir == 0) {
				for (int i = left; i <= right; i++) {
					// System.out.print(A.get(top).get(i)+"\t");
					mat[top][i] = ele++;
					// a.add(ele++);

				}
				top++;
			}

			else if (dir == 1) {
				for (int i = top; i <= bottom; i++) {
					// System.out.print(A.get(i).get(right)+"\t");
					// a.add(ele++);
					mat[i][right] = ele++;

				}
				right--;
			}

			else if (dir == 2) {
				for (int i = right; i >= left; i--) {
					// System.out.print(A.get(bottom).get(i)+"\t");
					// a.add(ele++);
					mat[bottom][i] = ele++;

				}
				bottom--;
			} else if (dir == 3) {
				for (int i = bottom; i >= top; i--) {
					// System.out.print(A.get(i).get(left)+"\t");
					// a.add(ele++);
					mat[i][left] = ele++;

				}
				left++;
			}
			dir = (dir + 1) % 4;

		}
		for (int i = 0; i < A; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < A; j++) {
				//System.out.print(mat[i][j] + "\t");
				list.add(mat[i][j]);
			}
			res.add(list);
			//System.out.println();
		}
		//System.out.println(res);

		return res;
	}

	public static void main(String[] args) {
		generateMatrix(3);
	}

}
