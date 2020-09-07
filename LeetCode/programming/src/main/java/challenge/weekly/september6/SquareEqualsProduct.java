package challenge.weekly.september6;

import java.util.HashMap;

public class SquareEqualsProduct {

    private int waysUtil(int[] nums1,int[] nums2){

        int count = 0;

        for(int i=0;i< nums1.length;i++){

            for(int j=0;j<nums2.length-1;j++){

                for(int k=j+1;k<nums2.length;k++){
                    if(1L*nums1[i]*nums1[i] == 1L*nums2[j]*nums2[k])
                        count++;

                }

            }
        }

        return count;
    }

    private int waysUtilOptimized(int[] nums1,int[] nums2){
        int count = 0;

        for(int i=0;i<nums1.length;i++){

            int start = 0;
            int end = nums2.length-1;
            while(start<end){
                if(1L*nums1[i]*nums1[i] == 1L*nums2[start]*nums2[end]){
                    count++;
                    if(start+1!=end && 1L*nums1[i]*nums1[i] == 1L*nums2[start+1]*nums2[end])
                        count++;
                    if(end-1!=start && 1L*nums1[i]*nums1[i] == 1L*nums2[start]*nums2[end-1])
                        count++;
                    start++;
                    end--;
                }
                else if(1L*nums1[i]*nums1[i] < 1L*nums2[start]*nums2[end])
                    start++;
                else
                    end--;

            }

        }

        return count;
    }

    public int numTripletsOptimized(int[] nums1, int[] nums2) {
        int count =0;
        HashMap<Long,Long> map = new HashMap<>();

        for(int i=0;i<nums2.length-1;i++){
            for(int j=i+1;j<nums2.length;j++){
                map.put(1L*nums2[i]*nums2[j],map.getOrDefault(1L*nums2[i]*nums2[j],0L)+1);
            }
        }
        for(int i=0;i<nums1.length;i++){
            count += map.getOrDefault(1L*nums1[i]*nums1[i],0L);
        }
        map.clear();
        for(int i=0;i<nums1.length-1;i++){
            for(int j=i+1;j<nums1.length;j++){
                map.put(1L*nums1[i]*nums1[j],map.getOrDefault(1L*nums1[i]*nums1[j],0L)+1);
            }
        }
        for(int i=0;i<nums2.length;i++){
            count += map.getOrDefault(1L*nums2[i]*nums2[i],0L);
        }

        /*Arrays.sort(nums1);
        Arrays.sort(nums2);
        count += waysUtilOptimized(nums1,nums2);
        System.out.println("count1="+count);
        count += waysUtilOptimized(nums2,nums1);*/
        return count;
    }

    public static void main(String[] args) {
        SquareEqualsProduct sp = new SquareEqualsProduct();
        System.out.println(sp.numTriplets(new int[]{7,7,8,3},new int[]{1,2,9,7}));
        System.out.println(sp.numTripletsOptimized(new int[]{43024,99908},new int[]{1864}));
    }

    private int numTriplets(int[] nums1, int[] nums2) {
        int count =0;
        count += waysUtil(nums1,nums2);
        count += waysUtil(nums2,nums1);
        return count;
    }

}
