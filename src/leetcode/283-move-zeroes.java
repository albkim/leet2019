/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative
order of the non-zero elements.

Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

Note:
1.You must do this in-place without making a copy of the array.
2.Minimize the total number of operations.

 */

package leetcode;

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return;
        }

        int left = 0;
        int right = 0;

        while((left < nums.length) && (right < nums.length)) {
            // initialize
            while((left < nums.length) && (nums[left] != 0)) {
                left++;
            }
            right = left;
            while((right < nums.length) && (nums[right] == 0)) {
                right++;
            }

            if ((left < nums.length) && (right < nums.length)) {
                // swap left with right
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
    }
}
