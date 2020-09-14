package searchingandsorting;

import java.util.Arrays;

public class PeaksAndValleys {

    public void generate(int[] a){
        Arrays.sort(a);
        int start = 0;
        int end = a.length-1;
        int[] res = new int[a.length];
        int i=0;
        while(start<=end){
            res[i++] = a[start];
            if(i<a.length)
            res[i++] = a[end];
            start++;
            end--;
        }
        i=0;
        for(;i<a.length;i++)
            a[i]=res[i];
    }

    public static void main(String[] args) {
        PeaksAndValleys pv = new PeaksAndValleys();
        int[] a = {7,7,5,4,3,2,1};
        pv.generate(a);
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+"\t");
    }

}
