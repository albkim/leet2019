/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

sort and do 2 sum (iterative) while iterating the array
 */

package leetcode.easy;

import java.util.HashMap;

class ThreeSum {
    public java.util.List<java.util.List<Integer>> threeSum(int[] nums) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();

        java.util.Arrays.sort(nums);

        Integer last = null;
        for (int index = 0; index < (nums.length - 2); index++) {
            if ((last != null) && (last == nums[index])) {
                // this ensures 1 number is used once, so we can eliminate the duplicates
                continue;
            }

            int twoSum = -1 * nums[index];
            int left = index + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[left] + nums[right];
                if (sum == twoSum) {
                    java.util.List<Integer> resultSet = new java.util.ArrayList<>();
                    resultSet.add(nums[index]);
                    resultSet.add(nums[left]);
                    resultSet.add(nums[right]);
                    result.add(resultSet);
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
