package recursionanddynamicprogramming;

public class EightQueens {

    static int solutions = 0;
    private static void placeQueensUtil(int[] queens,int n,int queen){
        if(queen==n) {
            for(int i=0;i<n;i++){
                System.out.print(queens[i]+"\t");
                //System.out.println();

            }
            solutions++;
            System.out.println();
            return;
        }
        for(int j=0;j<n;j++){
            if(isSafe(queen,j,queens)){
                queens[queen] = j;
                placeQueensUtil(queens,n,queen+1);
            }
        }

    }

    public static void placeAllQueens(int n){
        int[][] board = new int[n][n];
        int[] queens = new int[n];
        placeQueensUtil(queens,n,0);
    }

    private static boolean isSafe(int i, int j, int[] queens) {
        for(int k=0;k<i;k++){
            if(queens[k]==j)
                return false;
        }
        int cnt = 1;
        for(int k=i-1;k>=0;k--){
            if(queens[k]==j-cnt || queens[k]==j+cnt)
                return false;
            cnt++;
        }

        return true;
    }

    public static void main(String[] args) {
        placeAllQueens(8);
        System.out.println(solutions);
    }

}
