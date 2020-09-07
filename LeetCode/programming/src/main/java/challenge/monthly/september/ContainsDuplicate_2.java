package challenge.monthly.september;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate_2 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<=i+k && j<nums.length;j++){
                if(Math.abs(nums[i]-nums[j])<=t)
                    return true;
            }
        }
        return false;
    }
    public boolean containsNearbyAlmostDuplicateOptimised(int[] nums, int k, int t) {
        if (nums == null || k < 0 || t < 0) return false;
        Map<Integer, Integer> buckets = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int bucket = (int) Math.floorDiv(nums[i], (long) t + 1);
            if (buckets.containsKey(bucket)) return true;
            else {
                buckets.put(bucket, nums[i]);
                // Cast to long as it overflows if 2147483647 - (-1) => -2147483648
                if (buckets.containsKey(bucket - 1) && nums[i] - (long) buckets.get(bucket - 1) <= t)
                    return true;
                if (buckets.containsKey(bucket + 1) && buckets.get(bucket + 1) - (long) nums[i] <= t)
                    return true;
                if (buckets.size() > k) {
                    buckets.remove((int) Math.floorDiv(nums[i - k], (long) t + 1));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate_2 d = new ContainsDuplicate_2();
        System.out.println(d.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9},2,3));
    }


}
