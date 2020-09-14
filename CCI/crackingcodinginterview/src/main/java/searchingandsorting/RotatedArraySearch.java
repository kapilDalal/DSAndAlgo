package searchingandsorting;

public class RotatedArraySearch {

    public int search(int[] arr,int target){
        int pivot = getPivot(arr);
        if(target<arr[0]){
            return bs(arr,pivot,arr.length,target);
        }
        return bs(arr,0,pivot,target);

    }
    private int bs(int[] arr,int start,int end,int target){
        int index = -1;
        while(start<=end){
            int mid = (start+end)/2;
            if(mid>=arr.length)
                return -1;
            if(arr[mid]==target)
                return mid;
            else if(target>arr[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return index;
    }
    private int getPivot(int[] arr) {
        int pivot = -1;
        int start = 0;
        int end = arr.length-1;
        while(start<end){

            if(arr[start]<=arr[end]){
                pivot = start;
                break;
            }
            int mid = (start+end)/2;

            if(mid-1>=0 && arr[mid]<=arr[mid-1]){
                while(mid>0 && arr[mid]==arr[mid-1])
                    mid--;
                pivot = mid;
                break;
            }
            else if(arr[mid]>arr[start]){
                if(mid+1<=end && arr[mid+1]<arr[mid]){
                    pivot = mid;
                    break;
                }
                start = mid+1;
            }else{
                if(mid+1<=end && arr[mid+1]<arr[mid]){
                    pivot = mid;
                    break;
                }
                end = mid-1;
            }

        }
        return pivot;
    }

    public static void main(String[] args) {
        RotatedArraySearch rs = new RotatedArraySearch();
        System.out.println(rs.search(new int[]{8,1,2,3,4,5},8));
    }

}
