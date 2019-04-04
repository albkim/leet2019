/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:
Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.

Note:

You can assume that you can always reach the last index.

DP, what if I backtrack from the back. Mark all the ones I can reach, then take the closest one and keep doing it.

    2 3 1 1 4
1   F T F T T
2   T T


 */

package leetcode;

class JumpGameII {
    public int jump(int[] nums) {
        if ((nums == null) || (nums.length <= 1)) {
            return 0;
        }

        // return jump(nums, 0, 0);
        return jumpDP(nums);
    }

    private int jump(int[] nums, int index, int current) {
        if (index >= (nums.length - 1)) {
            //we reached it
            return current;
        }

        int min = Integer.MAX_VALUE;
        for (int jumpIndex = 1; jumpIndex <= nums[index]; jumpIndex++) {
            min = Math.min(min, jump(nums, index + jumpIndex, current + 1));
        }
        return min;
    }

    private int jumpDP(int[] nums) {
        int target = nums.length - 1;
        int min = nums.length;

        int count = 0;
        while (target > 0) {
            for (int index = target; index >= 0; index--) {
                if (nums[index] + index >= target) {
                    min = Math.min(min, index);
                }
            }
            target = min;
            count++;
        }

        return count;
    }
}
