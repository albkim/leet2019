/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two
  adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
of money you can rob tonight without alerting the police.

Example 1:
Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.


Example 2:
Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.


 Since it wraps there are two cases:

   If first house is robbed we cannot rob the last house, so the dp has to stop at n - 1
   If first house is not robbed (we start from index 1) then we can do all the way.

 Max is max of the two cases
 */

package leetcode;

class HouseRobberII {
    public int rob(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length + 1];

        // first case
        for (int index = 0; index < nums.length - 1; index++) {
            // need empty first 2 elements
            int dpIndex = index + 2;
            dp[dpIndex] = Math.max(dp[dpIndex - 1], dp[dpIndex - 2] + nums[index]);
        }

        int max1 = dp[nums.length];

        // second case
        for (int index = 1; index < nums.length; index++) {
            // need empty first 2 elements
            int dpIndex = index + 1;
            dp[dpIndex] = Math.max(dp[dpIndex - 1], dp[dpIndex - 2] + nums[index]);
        }

        int max2 = dp[nums.length];

        return Math.max(max1, max2);

    }
}
