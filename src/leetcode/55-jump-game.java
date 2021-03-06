/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.


Example 2:
Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.


from the back, populate true/false as to whether we can reach the last index...the value would be the value
of the index when we jump

 */


package leetcode;

class JumpGame {
    public boolean canJump(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return false;
        }

        boolean[] jump = new boolean[nums.length];
        jump[nums.length - 1] = true;

        for (int index = nums.length - 2; index >= 0; index--) {
            boolean canReach = false;
            for (int reachIndex = index + 1; reachIndex <= Math.min(nums.length - 1, index + nums[index]); reachIndex++) {
                if (jump[reachIndex]) {
                    canReach = true;
                    break;
                }
            }
            jump[index] = canReach;
        }

        return jump[0];
    }
}
