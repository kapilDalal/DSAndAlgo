package searchingandsorting;

public class RadixSort {

    public void sort(int[] a){
        int max = getMax(a);

        for(int exp=1;exp<max;exp=exp*10){
            cSort(a,exp);
        }
    }

    public void cSort(int[] a,int exp){
        int maxBit = getMaxBit(a,exp);
        int[] count = new int[maxBit+1];
        int[] output = new int[a.length];

        for(int i=0;i<a.length;i++)
            count[(a[i]/exp)%10]++;

        for(int i=1;i<count.length;i++){
            count[i] += count[i-1];
        }

        for(int i=a.length-1;i>=0;i--){
            output[count[(a[i]/exp)%10]-1] = a[i];
            count[(a[i]/exp)%10]--;
        }
        for(int i=0;i<a.length;i++)
            a[i] = output[i];

    }

    private int getMaxBit(int[] a, int exp) {
        int max = 0;

        for(int i=0;i<a.length;i++){
            max = Math.max(max,(a[i]/exp)%10);
        }
        return max;
    }

    private int getMax(int[] a) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            max = Math.max(a[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        RadixSort rs = new RadixSort();
        int[] a = {66,75,802,2,90,24,75,45};
        rs.sort(a);
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+"\t");
    }

}
