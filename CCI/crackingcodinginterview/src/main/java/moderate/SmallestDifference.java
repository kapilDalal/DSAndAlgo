package moderate;

import java.util.Arrays;

public class SmallestDifference {

    public int getDiff(int[] arr1,int[] arr2){
        int diff = Integer.MAX_VALUE;
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int f=0;
        int s=0;
        while(f<arr1.length && s<arr2.length){
            if(arr1[f]<arr2[s]){
                diff = Math.min(diff,arr2[s]-arr1[f]);
                f++;
            }else{
                diff = Math.min(diff,arr1[f]-arr2[s]);
                s++;
            }
        }

        return diff;
    }

    public static void main(String[] args) {
        SmallestDifference sd = new SmallestDifference();
        System.out.println(sd.getDiff(new int[]{1,3,15,11,2},new int[]{23,127,235,19,8}));
    }

}
