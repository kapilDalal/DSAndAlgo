package challenge.monthly.september;

/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint
stopping you from robbing each of them is that adjacent houses have
security system connected and it will automatically contact the police
if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
* */

public class HouseRobber_14 {

    /*
        First we handle base conditions:

        Zero houses - zero money
        One house - only money in that house
        When there are 2 or more houses,
        let's take an example nums = [2,1,1,2] and it goes like this:

        Pick Max money till 1st or 2nd house [Max of 2 and 1 = 2]
        When we are in 3rd house, we pick Max of money till 1st house + 3rd house || money till 2nd house. [Max of 1 + 2 and 1 = 3]
        When we are in 4th house, we pick Max of money till 2nd + 4th || 3rd house alone. [Max of 2 + 2 and 3 = 4]
        Now the final answer array looks like [2, 2, 3, 4]. Thus the max amount we get is 4.
    */

    public int rob(int[] nums) {
        int N = nums.length;
        if (N == 0)
            return 0;
        if (N == 1)
            return nums[0];

        int[] ans = new int[N];
        ans[0] = nums[0];
        ans[1] = Math.max(ans[0], nums[1]);

        for (int i = 2; i < N; i++) {
            ans[i] = Math.max(nums[i] + ans[i - 2], ans[i - 1]);
        }
        return ans[N - 1];
    }

}
