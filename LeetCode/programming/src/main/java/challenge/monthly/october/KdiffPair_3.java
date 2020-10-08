package challenge.monthly.october;

import java.util.HashSet;

public class KdiffPair_3 {
    public int findPairs(int[] nums, int k) {
        if(nums.length<=1)
            return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(nums[0]);
        HashSet<String> res = new HashSet<>();
        int count = 0;
        for(int i=1;i<nums.length;i++)
        {
            if(set.contains(k+nums[i])){

                String a = ""+nums[i];
                String b = ""+(k+nums[i]);

                if(res.contains(a+"_"+b)|| res.contains(b+"_"+a)){

                }
                else {
                    count++;
                    res.add(a + "_" + b);

                    res.add(b + "_" + a);
                }

            }
            if(set.contains(nums[i]-k)){
                String a = ""+nums[i];

                String c = ""+(nums[i]-k);
                if(res.contains(a+"_"+c) || res.contains(c+"_"+a)){

                }
                else{
                    count++;

                res.add(a+"_"+c);
                res.add(c+"_"+a);
                }

            }
            set.add(nums[i]);

        }
        return count;

    }

    public static void main(String[] args) {
        KdiffPair_3 kd = new KdiffPair_3();

        System.out.println(kd.findPairs(new int[]{6,3,5,7,2,3,3,8,2,4},2));
    }
}
