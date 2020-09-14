package challenge.monthly.september;

import java.util.HashMap;

public class ImageOverlap_6 {

    boolean isSafe(int i,int j,int[][] a,boolean[][] v){
        if(i>=0 && i<a.length && j>=0 && j<a[0].length && a[i][j]==1 && !v[i][j])
            return true;
        return false;
    }

    public int largestOverlap(int[][] A, int[][] B) {
        int max = 0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){

                if(A[i][j]==1){

                    for(int k=0;k<B.length;k++){
                        for(int l=0;l<B[0].length;l++){

                            if(B[k][l]==1){
                                boolean[][] v1 = new boolean[A.length][A[0].length];
                                boolean[][] v2 = new boolean[A.length][A[0].length];
                                int currMax = getMax(A,B,v1,v2,i,j,k,l);
                                max = Math.max(currMax,max);
                            }

                        }

                    }

                }

            }
        }
        return max;
    }
    int[] xMoves = {1,-1,0,0};
    int[] yMoves = {0,0,1,-1};
    private int getMax(int[][] a, int[][] b,boolean[][] v1,boolean[][] v2, int i, int j, int k, int l) {

        if((i==a.length-1 && j==a[0].length-1) || (k==b.length-1 && l==b[0].length-1)){
            if(a[i][j]==1 && b[k][l]==1)
                return 1;
            return 0;
        }
        v1[i][j] = true;
        v2[k][l] = true;
        for(int m = 0;m< xMoves.length;m++){
            if(isSafe(i+xMoves[m],j+yMoves[m],a,v1) && isSafe(k+xMoves[m],l+yMoves[m],b,v2)) {
                return 1 + getMax(a, b, v1,v2, i + xMoves[m], j + yMoves[m], k + xMoves[m], l + yMoves[m]);
            }
        }
        return 1;
    }

    public int numJewelsInStones(String J, String s) {
        int cnt = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        for(int i=0;i<J.length();i++)
            if(map.containsKey(J.charAt(i)))
                cnt += map.get(J.charAt(i));
        return cnt;
    }

    public static void main(String[] args) {
        ImageOverlap_6 io = new ImageOverlap_6();
        int[][] a = {{0,1},
                     {1,1}};
        int[][] b = {{0,1},
                     {1,0}};
       // System.out.println(io.largestOverlap(a,b));
        System.out.println(io.numJewelsInStones("aA","aAAbbbb"));
    }

}
