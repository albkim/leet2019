/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
•The number of elements initialized in nums1 and nums2 are m and n respectively.
•You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

Example:
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]


 */

package leetcode;

class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // move all m by n
        for (int index = m - 1; index >= 0; index--) {
            nums1[index + n] = nums1[index];
        }

        int first = n;
        int second = 0;
        int sorted = 0;
        while(sorted < (m + n)) {
            int num1 = (first == (m + n)) ? Integer.MAX_VALUE : nums1[first];
            int num2 = (second == n) ? Integer.MAX_VALUE : nums2[second];
            if (num1 < num2) {
                nums1[sorted] = nums1[first];
                sorted++;
                first++;
            } else {
                nums1[sorted] = nums2[second];
                sorted++;
                second++;
            }
        }
    }

}
