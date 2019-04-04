/*
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5
Explanation: Your function can return either index number 1 where the peak element is 2,
             or index number 5 where the peak element is 6.

Note:

Your solution should be in logarithmic complexity.


Do a binary search on peak condition

 */

package leetcode;

class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + ((right - left) >> 1);

            int leftVal = ((mid - 1) >= 0) ? nums[mid - 1] : Integer.MIN_VALUE;
            int rightVal = ((mid + 1) < nums.length) ? nums[mid + 1] : Integer.MIN_VALUE;
            if ((leftVal <= nums[mid]) && (nums[mid] >= rightVal)) {
                return mid;
            }

            if (leftVal > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
