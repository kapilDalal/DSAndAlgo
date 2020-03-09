package greedy;

public class SeatsAllocation {

	static public int seats(String A) {
		int res = Integer.MAX_VALUE;
		if (!A.contains("x"))
			return 0;
		int[] arr = new int[A.length()];

		for (int i = 0; i < arr.length; i++) {
			if (A.charAt(i) == '.')
				arr[i] = -1;
			else
				arr[i] = 1;
		}
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == 'x') {
				int leftMoves = numberOfMoves(A, i, true);
				int rightMoves = numberOfMoves(A, i, false);
				if (leftMoves + rightMoves < res)
					res = leftMoves + rightMoves;
			}
		}		
		return res;
	}

	static private int numberOfMoves(String a, int i, boolean leftMovement) {
		// TODO Auto-generated method stub
		StringBuffer temp = new StringBuffer(a);
		int moves = 0;
		int vacantSeatPointer;
		if (leftMovement) {

			vacantSeatPointer = i - 1;
			while (vacantSeatPointer >= 0 && temp.charAt(vacantSeatPointer) != '.')
				vacantSeatPointer--;

			if (vacantSeatPointer <= 0)
				return moves;

			for (int j = vacantSeatPointer - 1; j >= 0; j--) {
				if (temp.charAt(j) == 'x') {
					temp.setCharAt(j, '.');
					moves = moves + (vacantSeatPointer - j);
					vacantSeatPointer--;
				}
			}

		} else {

			vacantSeatPointer = i + 1;

			while (vacantSeatPointer < temp.length() && temp.charAt(vacantSeatPointer) != '.')
				vacantSeatPointer++;

			if (vacantSeatPointer == temp.length() - 1)
				return moves;
			for (int j = vacantSeatPointer; j < temp.length(); j++) {
				if (temp.charAt(j) == 'x') {
					temp.setCharAt(j, '.');
					moves = moves + (j - vacantSeatPointer);
					vacantSeatPointer++;
				}
			}

		}
		return moves;
	}
	
	//optimised
	private static final long MOD = 10000003;
    
    private static final char OCCUPIED = 'x';
    
	static public int seatsOpt(String a) {
	    int numLeft = 0;
	    int numRight = 0;
	    for (int i = 0; i < a.length(); ++i) {
	        if (a.charAt(i) == OCCUPIED) {
	            ++numRight;
	        }
	    }
	    
	    long moves = 0;
	    for (int i = 0; i < a.length(); ++i) {
	        if (numRight == 0) {
	            break;
	        } else if (a.charAt(i) == OCCUPIED) {
                ++numLeft;
                --numRight;
	        } else {
	            moves += Math.min(numLeft, numRight);
	        }
	    }
	    return (int) (moves % MOD);
	}

	public static void main(String[] args) {
		System.out.println(seatsOpt(".x.x.x..x"));
		
	}

}
