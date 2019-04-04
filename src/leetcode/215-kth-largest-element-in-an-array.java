/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
not the kth distinct element.

Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5


Example 2:
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.

 */

package leetcode;

class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if ((nums == null) || (nums.length == 0) || (k < 0) || (k > nums.length)) {
            return -1;
        }

        return findKthLargest(nums, nums.length - k, 0, nums.length - 1);
    }

    private int findKthLargest(int[] nums, int k, int left, int right) {
        int refValue = nums[left];

        int l = left + 1;
        int r = right;
        while(l <= r) {
            int leftValue = nums[l];
            if (leftValue <= refValue) {
                l++;
            } else {
                swap(nums, l, r);
                r--;
            }
        }

        int ref = (nums[r] > refValue) ? (r - 1) : r;
        swap(nums, ref, left);

        if (ref == k) {
            return refValue;
        } else if (ref < k) {
            return findKthLargest(nums, k , ref + 1, right);
        } else {
            return findKthLargest(nums, k, left, ref - 1);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
