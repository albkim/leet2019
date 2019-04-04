/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true


Example 2:
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false

Follow up:
•This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
•Would this affect the run-time complexity? How and why?

 */

package leetcode;

class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if ((nums == null) || (nums.length == 0)) {
            return false;
        }

        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return true;
            } else {
                // try to determine if this is the worst case.....1113111
                if ((nums[left] == nums[right]) && (nums[left] != target)) {
                    // hmm
                    left++;
                    right--;
                }
                else if (target < nums[mid]) {
                    // i should go left, unless there is a right rotation and numbers are above target
                    boolean rightRotation = nums[left] <= nums[mid] && nums[left] > nums[right];
                    if ((rightRotation) && (target <= nums[right])) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    // i should go right, unless there is a left rotation and numbers are less than target
                    boolean leftRotation = nums[right] >= nums[mid] && nums[left] > nums[right];
                    if ((leftRotation) && (nums[left] <= target)) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }

        return false;
    }
}
