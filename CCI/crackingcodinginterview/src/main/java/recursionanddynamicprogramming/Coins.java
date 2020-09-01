package recursionanddynamicprogramming;

public class Coins {

    public static int getNumberOfWays(int[] values,int sum){
        int[][] dp = new int[values.length][sum+1];
        for(int i=0;i< values.length;i++)
            dp[i][0] = 1;
        for(int j=1;j<=sum;j++) {
            dp[0][j] = 0;
            dp[1][j] = 1;
        }

        for(int i=1; i<values.length; i++){
            for(int j=1; j<=sum; j++){
                if(values[i]<=j){
                    dp[i][j] = Math.max(dp[i-1][j],1+dp[i][j- values[i]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[values.length-1][sum];
    }

    public static void main(String[] args) {
        System.out.println(getNumberOfWays(new int[]{1,5,10,25},60));
    }

}
