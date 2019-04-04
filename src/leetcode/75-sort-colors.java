/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color
are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:
Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Follow up:
•A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's,
then 1's and followed by 2's.
•Could you come up with a one-pass algorithm using only constant space?


two pointers. move 0's to the front, move 2's to the end. when we are done, we are done.
 */

package leetcode;

class SortColors {
    public void sortColors(int[] nums) {
        if ((nums == null) || (nums.length <= 1)) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        int current = 0;
        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                left++;

                // without this, the left pointer could pass the current if there are enough 0's
                if (left > current) {
                    current = left;
                }
            } else if (nums[current] == 2) {
                swap(nums, right, current);
                right--;
            } else {
                // this is 1...nothing i can do but proceed
                current++;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
