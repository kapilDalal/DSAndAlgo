package challenge.weekly.Septmember27;

public class CentennialWheel {

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int cw = 0;
        int maxProfit = 0;
        int maxProfitIndex = -1;
        int i=0;
        int pb = 0;
        for(;i< customers.length;i++){

            cw = cw + customers[i];
            if(cw>=4){
                cw = cw-4;
                int p = (pb+4)*boardingCost - (i+1)*runningCost;
                if(p>maxProfit){
                    maxProfit = p;
                    maxProfitIndex = i+1;
                }
                pb+=4;
            }else{
                int p = (cw+pb)*boardingCost - (i+1)*runningCost;
                if(p>maxProfit){
                    maxProfit = p;
                    maxProfitIndex = i+1;
                }
                pb+=cw;
                cw = 0;

            }
        }
        while(cw>0){
            if(cw>=4){
                cw = cw-4;
                int p = (pb+4)*boardingCost - (i+1)*runningCost;
                if(p>maxProfit){
                    maxProfit = p;
                    maxProfitIndex = i+1;
                }
                pb+=4;
            }else{
                int p = (cw+pb)*boardingCost - (i+1)*runningCost;
                if(p>maxProfit){
                    maxProfit = p;
                    maxProfitIndex = i+1;
                }
                pb+=cw;
                cw = 0;

            }

            i++;
        }

        return maxProfit<=0?-1:maxProfitIndex;
    }

    public static void main(String[] args) {
        CentennialWheel cw = new CentennialWheel();
        System.out.println(cw.minOperationsMaxProfit(new int[]{2,6},3,8));
    }

}
