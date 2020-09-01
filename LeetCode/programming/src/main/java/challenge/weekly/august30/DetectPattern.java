package challenge.weekly.august30;

import java.util.ArrayList;

public class DetectPattern {

    //O((n^2)*m)
    public boolean containsPattern(int[] arr, int m, int k) {
        for(int i=0;i<arr.length;i++){
            ArrayList<Integer> last = new ArrayList<>();
            int cnt = 0;
            for(int j=i;j<arr.length;j=j+m){
                ArrayList<Integer> curr = new ArrayList<>();
                for(int p = j;p<j+m && p<arr.length;p++){
                    curr.add(arr[p]);
                }
                if(curr.size()>0 && curr.equals(last))
                    cnt++;
                else{
                    cnt = 1;
                }
                if(cnt>=k)
                    return true;
                last = curr;
            }
        }
        return false;
    }

    //O(n) - works on the fact that length of the sub-array with given condition will be k-1 * m
    public boolean containsPatternOptimised(int[] arr, int m, int k) {
        int ans=0;
        for(int i=0;i+m < arr.length; i++)
        {
            if(arr[i]!=arr[i+m])
                ans=0;
            if(arr[i] == arr[i+m])
                ans++;;
            if(ans== (k-1)*m)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DetectPattern dp = new DetectPattern();
        System.out.println(dp.containsPatternOptimised(new int[]{4,5,4,3,4,4},2,2));
    }
}
