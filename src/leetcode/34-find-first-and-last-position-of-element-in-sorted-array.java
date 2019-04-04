/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

 */

package leetcode;

class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if ((nums == null) || (nums.length == 0)) {
            return new int[] {-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                int foundLeft = mid;
                while(foundLeft > 0) {
                    if (nums[foundLeft - 1] == nums[mid]) {
                        foundLeft--;
                    } else {
                        break;
                    }
                }
                int foundRight = mid;
                while(foundRight < (nums.length - 1)) {
                    if (nums[foundRight + 1] == nums[mid]) {
                        foundRight++;
                    } else {
                        break;
                    }
                }
                return new int[] {foundLeft, foundRight};
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[] {-1, -1};
    }
}
