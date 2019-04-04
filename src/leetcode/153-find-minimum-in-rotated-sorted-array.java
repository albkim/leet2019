/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2]
Output: 1


Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0


binary search to find the rotation point
 */

package leetcode;

class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            int midVal = nums[mid];
            int leftVal = nums[left];
            int rightVal = nums[right];

            // check if there is no rotation
            if ((leftVal <= midVal) && (midVal <= rightVal)) {
                min = Math.min(min, leftVal);
                break;
            }

            if ((leftVal > midVal) && (midVal < rightVal)) {
                // rotation on the left
                min = Math.min(min, midVal);
                right = mid - 1;
            } else {
                min = Math.min(min, leftVal);
                left = mid + 1;
            }
        }
        return min;
    }
}
