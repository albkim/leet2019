/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the
product of all the elements of nums except nums[i].

Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]


Note: Please solve it without division and in O(n).

Follow up:
 Could you solve it with constant space complexity? (The output array does not count as extra space for the
 purpose of space complexity analysis.)

 */

package leetcode;

class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return new int[] {};
        }

        int[] result = new int[nums.length];
        for (int index = nums.length - 1; index > 0; index--) {
            if (index == (nums.length - 1)) {
                result[index] = nums[index];
            } else {
                result[index] = result[index + 1] * nums[index];
            }
        }

        int productLeft = 1;
        for (int index = 0; index < nums.length; index++) {
            if (index == (nums.length - 1)) {
                result[index] = productLeft;
            } else {
                result[index] = result[index + 1] * productLeft;
            }
            productLeft *= nums[index];
        }

        return result;
    }
}
