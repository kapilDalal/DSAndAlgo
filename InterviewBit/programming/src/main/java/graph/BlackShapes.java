package graph;

public class BlackShapes {

	static public int black(String[] A) {
		int islands = 0;
		StringBuilder[] s = new StringBuilder[A.length];
		for (int i = 0; i < A.length; i++) {
			s[i] = new StringBuilder(A[i]);
		}
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length(); j++) {
				if (s[i].charAt(j) == 'X') {
					s[i].setCharAt(j, 'O');
					islands++;
					destroyisland(i, j, s);
				}
			}
		}

		return islands;
	}

	static int[] x = { 1, -1, 0, 0 };
	static int[] y = { 0, 0, 1, -1 };

	private static void destroyisland(int i, int j, StringBuilder[] s) {
		// TODO Auto-generated method stub
		for (int k = 0; k < x.length; k++) {
			int nextI = i + x[k];
			int nextJ = j + y[k];
			if (isValid(nextI, nextJ, s) && s[nextI].charAt(nextJ) == 'X') {
				s[nextI].setCharAt(nextJ, 'O');
				destroyisland(nextI, nextJ, s);
			}
		}
	}

	private static boolean isValid(int i, int j, StringBuilder[] s) {
		// TODO Auto-generated method stub
		if (i < 0 || i >= s.length || j < 0 || j >= s[0].length())
			return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(black(new String[]{"OOOXOOO","OOXXOXO","OOXOOXO"}));
	}

}
