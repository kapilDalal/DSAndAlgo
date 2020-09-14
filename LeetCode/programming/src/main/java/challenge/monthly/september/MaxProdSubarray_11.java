package challenge.monthly.september;

public class MaxProdSubarray_11 {


    public int maxProduct(int[] A) {
        int min = A[0];
        int max = A[0];
        int res = A[0];
        for(int i=1;i<A.length;i++) {
            if(A[i]<0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(A[i],A[i]*max);
            min = Math.min(A[i],A[i]*min);
            res = Math.max(max,res);

        }
        return res;
    }

    public static void main(String[] args) {
        MaxProdSubarray_11 mp = new MaxProdSubarray_11();
        System.out.println(mp.maxProduct(new int[]{2,-5,-2,-4,3}));
    }

}
