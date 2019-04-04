/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.


Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


we want to keep adding unless we go below 0, which mean there is no way anything up to that point is going
to make the sum greater
 */

package leetcode;

class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
