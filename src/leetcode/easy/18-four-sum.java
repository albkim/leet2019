/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:
Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

Same as 3 sum
 */

package leetcode.easy;

class FourSum {
    public java.util.List<java.util.List<Integer>> fourSum(int[] nums, int target) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();

        java.util.Arrays.sort(nums);

        Integer last = null;
        for (int index = 0; index < (nums.length - 3); index++) {
            if ((last != null) && (last == nums[index])) {
                // this ensures 1 number is used once, so we can eliminate the duplicates
                continue;
            }

            Integer secondLast = null;
            for (int secondIndex = index + 1; secondIndex < (nums.length - 2); secondIndex++) {
                if ((secondLast != null) && (secondLast == nums[secondIndex])) {
                    // this ensures 1 number is used once, so we can eliminate the duplicates
                    continue;
                }

                int twoSum = target - nums[index] - nums[secondIndex];

                int left = secondIndex + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == twoSum) {
                        java.util.List<Integer> resultSet = new java.util.ArrayList<>();
                        resultSet.add(nums[index]);
                        resultSet.add(nums[secondIndex]);
                        resultSet.add(nums[left]);
                        resultSet.add(nums[right]);
                        result.add(resultSet);
                    }
                    if (sum < twoSum) {
                        // move right until we see a different number.
                        int lastLeft = nums[left];
                        while ((left < (nums.length - 1)) && (lastLeft == nums[left])) {
                            left++;
                        }
                    } else {
                        int lastRight = nums[right];
                        while ((right > (secondIndex + 1)) && (lastRight == nums[right])) {
                            right--;
                        }
                    }
                }

                secondLast = nums[secondIndex];
            }

            last = nums[index];
        }

        return result;
    }
}
