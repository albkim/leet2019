/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:
Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Sort, do 3 sum and do min diff from final target
 */

package leetcode.easy;

class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;

        java.util.Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        Integer last = null;
        for (int index = 0; index < (nums.length - 2); index++) {
            if ((last != null) && (last == nums[index])) {
                // this ensures 1 number is used once, so we can eliminate the duplicates
                continue;
            }

            int twoSum = target - nums[index];
            int left = index + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[left] + nums[right];
                if (sum == twoSum) {
                    return target;
                } else {
                    int candidate = nums[index] + sum;
                    int diff = Math.abs(target - candidate);
                    if (diff < minDiff) {
                        result = candidate;
                        minDiff = diff;
                    }
                }
                if (sum < twoSum) {
                    // move right until we see a different number.
                    int lastLeft = nums[left];
                    while((left < (nums.length - 1)) && (lastLeft == nums[left])) {
                        left++;
                    }
                } else {
                    int lastRight = nums[right];
                    while((right > (index + 1)) && (lastRight == nums[right])) {
                        right--;
                    }
                }
            }

            last = nums[index];
        }

        return result;
    }
}
