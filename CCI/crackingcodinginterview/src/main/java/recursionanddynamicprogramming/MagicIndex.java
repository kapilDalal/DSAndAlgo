package recursionanddynamicprogramming;

public class MagicIndex {

    public int magicIndexBF(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==i)
                return i;
        }
        return -1;
    }

    public int magicIndexOptimised(int[] arr){
        int mi = -1;
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==mid){
                mi = mid;
                break;
            }
            else if(arr[mid]>mid){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return mi;
    }

    public static void main(String[] args) {
        MagicIndex mi = new MagicIndex();
        System.out.println(mi.magicIndexBF(new int[]{1,2,3,4,5,6}));
        System.out.println(mi.magicIndexOptimised(new int[]{-1,1,3,4,5,6}));
    }
}
