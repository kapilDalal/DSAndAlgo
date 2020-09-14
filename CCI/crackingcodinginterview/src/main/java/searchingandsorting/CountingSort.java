package searchingandsorting;

import java.util.Arrays;

public class CountingSort {

    public void sort(int[] a){

        int max = getMax(a);
        int[] count = new int[max+1];
        int[] output = new int[a.length];
        Arrays.fill(count,0);

        for(int i=0;i<a.length;i++)
            count[a[i]]++;

        for(int i=1;i<count.length;i++)
            count[i] += count[i-1];

        for(int i=a.length-1;i>=0;i--){
            output[count[a[i]]-1] = a[i];
            count[a[i]]--;
        }
        for(int i=0;i<a.length;i++)
            a[i] = output[i];

    }

    private int getMax(int[] a) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            max = Math.max(max,a[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] a = {1,3,2,5,2,1};
        CountingSort cs = new CountingSort();
        cs.sort(a);
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+"\t");
    }

}
