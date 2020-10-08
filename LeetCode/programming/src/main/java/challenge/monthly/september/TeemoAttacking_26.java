package challenge.monthly.september;

import java.util.Arrays;

public class TeemoAttacking_26 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length==0)
            return 0;
        boolean[] poisoned = new boolean[timeSeries[timeSeries.length-1]+duration];
        //int i=0;
        int cnt = 0;
        int prev = -1;

        for(int i=0;i<timeSeries.length;i++){
            int num = timeSeries[i];
            if(prev==-1){
                cnt = cnt+duration;
                prev = num+duration-1;
            }
            else{
                if(num<prev){

                }else{
                    if(prev==num){
                        cnt = cnt+duration-1;
                        prev = num+duration-1;
                    }else{
                        cnt = cnt+duration;
                        prev = num+duration-1;
                    }
                }
            }

        }
        return cnt;

    }

    public static void main(String[] args) {
        TeemoAttacking_26 ta = new TeemoAttacking_26();
        System.out.println(ta.findPoisonedDuration(new int[]{1,4},
                2));
    }
}
