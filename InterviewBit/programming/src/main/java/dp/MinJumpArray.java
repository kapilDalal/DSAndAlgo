package dp;

public class MinJumpArray {

	//copied from Tushar Roy
	public int minJump(int arr[], int result[]) {

		int[] jump = new int[arr.length];
		jump[0] = 0;
		for (int i = 1; i < arr.length; i++) {
			jump[i] = Integer.MAX_VALUE - 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] + j >= i) {
					if (jump[i] > jump[j] + 1) {
						result[i] = j;
						jump[i] = jump[j] + 1;
					}
				}
			}
		}

		return jump[jump.length - 1];
	}

	// wrong
	static public int jump(int[] A) {
		int jump = A[0];
		int jumpCount = 0;
		for (int i = 0; i < A.length;) {
			int maxJump = Integer.MIN_VALUE;
			int index = i + 1;
			for (int j = i + 1; j <= i + jump; j++) {
				if (A[i] > maxJump) {
					index = j;
					maxJump = A[i];
				}
			}
			jumpCount++;
			i = index;
			jump = maxJump;
			if (i + jump >= A.length - 1) {
				jumpCount++;
				break;
			}
		}
		return jumpCount;
	}

	public static void main(String[] args) {
		System.out.println();
	}

}
