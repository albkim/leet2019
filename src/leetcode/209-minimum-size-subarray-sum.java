/*
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous
subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:
Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.

Follow up:

If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).


Only positive integers...do windows solution with min size
 */

package leetcode;

class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;
        while(right <= nums.length) {
            if (sum >= s) {
                while ((left < right) && (sum >= s)) {
                    minSize = Math.min(minSize, right - left);
                    sum -= nums[left];
                    left++;
                }
            } else {
                if (right < nums.length) {
                    sum += nums[right];
                }
                right++;
            }
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
