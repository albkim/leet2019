/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
which has the largest product.

Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.


Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


handle 0 and negative numbers in a special way.
 */

package leetcode;

class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        long finalMax = nums[0];
        long max = nums[0];
        long min = nums[0];

        for (int index = 1; index < nums.length; index++) {
            int num = nums[index];
            long temp = max;
            max = Math.max(Math.max(max * num, min * num), num);
            min = Math.min(Math.min(temp * num, min * num), num);
            finalMax = Math.max(finalMax, max);
        }

        return (int)finalMax;
    }
}
