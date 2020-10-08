package challenge.monthly.september;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class SubarrayProductLessThanK_28 {

    int getCount(long n){
        return (int) ((int) n * (n+1)/2);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        int p = 1;
        for(int i=0;i<nums.length;i++){
            p = p*nums[i];

            if(p>=k){
                cnt += getCount(q.size());

                while(p>=k && q.size()>0 ){
                    int num = q.poll();
                    p = p/num;
                }
                if(q.size()>=1){
                    cnt -= getCount(q.size());
                }
            }
            if(nums[i]<k)
            q.add(nums[i]);

        }
        cnt += getCount(q.size());

        return cnt;
    }
    public static void main(String[] args) {
        SubarrayProductLessThanK_28 sa = new SubarrayProductLessThanK_28();

        //System.out.println(sa.numSubarrayProductLessThanK(new int[]{1,1,1,1,1,1},100));
    }

}
