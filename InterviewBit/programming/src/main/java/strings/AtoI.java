package strings;

public class AtoI {

	public int atoi(final String A) {
		int res = 0;
		boolean neg = false;
		int j = 0;
		while (j < A.length() && A.charAt(j) == ' ') {
			j++;
		}
		if(A.length()==j)
			return res;
		for (int i = j; i < A.length(); i++) {
			char ch = A.charAt(i);
			if (ch == '+' && i == 0)
				continue;
			if (ch == '-' && i == 0) {
				neg = true;
				continue;
			}
			if ((ch - '0' >= 0 && ch - '0' <= 9)) {
				if (neg && ((1L * res * 10 + ch - '0') > Integer.MAX_VALUE))
					return Integer.MIN_VALUE;
				else if (neg == false && ((1L * res * 10 + ch - '0') > Integer.MAX_VALUE))
					return Integer.MAX_VALUE;
				res = (res * 10 + ch - '0');

			} else
				break;
		}

		if (neg)
			res = -1 * res;

		return res;
	}

	
	public static void main(String[] args) {
			
	}

}
