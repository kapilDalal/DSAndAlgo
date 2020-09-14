package searchingandsorting;

public class SortedMerge {

    /*
    * brute force can be to put b directly in a and then sort a
    * optimized is to shift a to end and then use two pointer to
    * put b in a
    * */

    public void sort(int[] a,int[] b){
        int mi = a.length-b.length-1;
        int li = a.length-1;
        while(mi>=0){
            a[li] = a[mi];
            mi--;
            li--;
        }
        int f = b.length;
        int s = 0;

        int index = 0;
        while(f!=a.length && s!=b.length){
            if(a[f]>b[s]){
                a[index] = b[s];
                s++;
            }else{
                a[index] = a[f];
                f++;
            }

            index++;
        }
        while(s!=b.length && index<a.length){
            a[index++] = b[s++];
        }

    }

    public static void main(String[] args) {
        SortedMerge sm = new SortedMerge();
        int[] a = new int[]{-1,-4,-5,-8,-11,-12,-13,14,0,0,0,0};
        int[] b = new int[]{3,5,7,9};
        sm.sort(a,b);
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+"\t");
    }

}
