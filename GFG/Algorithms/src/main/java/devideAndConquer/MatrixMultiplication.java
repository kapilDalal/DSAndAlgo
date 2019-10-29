package devideAndConquer;

public class MatrixMultiplication {
	
	static int[][] mul(int[][] a,int[][] b){
		int c[][] = new int[a.length][a.length];
		
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){
				c[i][j] = 0;
				for(int k=0;k<a.length;k++){
					c[i][j] += a[i][k]*b[k][j];
				}			
			}
		}				
		return c;
	}
	
	/**
	 * Creates a new matrix based off of part of another matrix
	 * 
	 * @param initialMatrix
	 *            the initial matrix
	 * @param newMatrix
	 *            the new matrix created from the initial matrix
	 * @param a
	 *            the initial row position of initialMatrix used when creating
	 *            newMatrix
	 * @param b
	 *            the initial column position of initialMatrix used when
	 *            creating newMatrix
	 */
	private static void deconstructMatrix(int[][] initialMatrix,
			int[][] newMatrix, int a, int b) {

		int y = b;
		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix.length; j++) {
				newMatrix[i][j] = initialMatrix[a][y++];
			}
			y = b;
			a++;
		}
	}
	/**
	 * Adds two matrices together
	 * 
	 * @param A
	 *            One matrix to be added
	 * @param B
	 *            Another matrix to be added
	 * @param n
	 *            the size of the matrix
	 * @return a new array C which is the result of the matrix addition
	 */
	private static int[][] addMatrix(int[][] A, int[][] B, int n) {

		int[][] C = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		return C;
	}
	
	/**
	 * Creates a new matrix based off of part of another matrix
	 * 
	 * @param initialMatrix
	 *            the initial matrix
	 * @param newMatrix
	 *            the new matrix created from the initial matrix
	 * @param a
	 *            the initial row position of initialMatrix used when creating
	 *            newMatrix
	 * @param b
	 *            the initial column position of initialMatrix used when
	 *            creating newMatrix
	 */
	private static void constructMatrix(int[][] initialMatrix,
			int[][] newMatrix, int a, int b) {

		int y = b;

		for (int i = 0; i < initialMatrix.length; i++) {
			for (int j = 0; j < initialMatrix.length; j++) {
				newMatrix[a][y++] = initialMatrix[i][j];
			}
			y = b;
			a++;
		}
	}

	
	public static int[][] divideAndConquerMM(int[][] A, int[][] B, int n) {
		int[][] C = new int[n][n];

		if (n == 1) {
			C[0][0] = A[0][0] * B[0][0];
			return C;
		} else {
			int[][] A11 = new int[n / 2][n / 2];
			int[][] A12 = new int[n / 2][n / 2];
			int[][] A21 = new int[n / 2][n / 2];
			int[][] A22 = new int[n / 2][n / 2];
			int[][] B11 = new int[n / 2][n / 2];
			int[][] B12 = new int[n / 2][n / 2];
			int[][] B21 = new int[n / 2][n / 2];
			int[][] B22 = new int[n / 2][n / 2];

			deconstructMatrix(A, A11, 0, 0);
			deconstructMatrix(A, A12, 0, n / 2);
			deconstructMatrix(A, A21, n / 2, 0);
			deconstructMatrix(A, A22, n / 2, n / 2);
			deconstructMatrix(B, B11, 0, 0);
			deconstructMatrix(B, B12, 0, n / 2);
			deconstructMatrix(B, B21, n / 2, 0);
			deconstructMatrix(B, B22, n / 2, n / 2);

			int[][] C11 = addMatrix(divideAndConquerMM(A11, B11, n / 2),
					divideAndConquerMM(A12, B21, n / 2), n / 2);
			int[][] C12 = addMatrix(divideAndConquerMM(A11, B12, n / 2),
					divideAndConquerMM(A12, B22, n / 2), n / 2);
			int[][] C21 = addMatrix(divideAndConquerMM(A21, B11, n / 2),
					divideAndConquerMM(A22, B21, n / 2), n / 2);
			int[][] C22 = addMatrix(divideAndConquerMM(A21, B12, n / 2),
					divideAndConquerMM(A22, B22, n / 2), n / 2);

			constructMatrix(C11, C, 0, 0);
			constructMatrix(C12, C, 0, n / 2);
			constructMatrix(C21, C, n / 2, 0);
			constructMatrix(C22, C, n / 2, n / 2);
		}

		return C;
	}
	
	public static void main(String[] args) {
		int[][] a = {{1,2},
					 {3,4}};
		int[][] b = {{3,1},
				     {2,4}};
		int[][] c = mul(a, b);
		for(int i=0;i<c.length;i++){
			for(int j=0;j<c.length;j++){
				System.out.print(c[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
