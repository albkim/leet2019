/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
money you can rob tonight without alerting the police.

Example 1:
Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.


 */

package leetcode;

class HouseRobber {
    public int rob(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        int[] dp = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            // if we decide to steal this, it will be max of index - 2 + index
            // if we don't decide to steal this, it will be max of index - 1
            int twoLeft = (index < 2) ? 0 : dp[index - 2];
            int oneLeft = (index < 1) ? 0 : dp[index - 1];
            int current = nums[index];

            dp[index] = Math.max(twoLeft + current, oneLeft);
        }

        return dp[nums.length - 1];
    }
}
