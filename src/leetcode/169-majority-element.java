/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:
Input: [3,2,3]
Output: 3

Example 2:
Input: [2,2,1,1,1,2,2]
Output: 2


 */

package leetcode;

class MajorityElement {
    public int majorityElement(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        int majority = nums[0];
        int majorityCount = 1;
        for (int index = 1; index < nums.length; index++) {
            int num = nums[index];
            if (majority == num) {
                majorityCount++;
            } else {
                majorityCount--;
                if (majorityCount == -1) {
                    majority = num;
                    majorityCount = 1;
                }
            }
        }

        return majority;
    }
}
