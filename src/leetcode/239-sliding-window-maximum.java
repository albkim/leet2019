/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the
very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.

Example:
Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Explanation:

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7


Note:
 You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
 Could you solve it in linear time?

 */

package leetcode;

import java.util.*;

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if ((nums == null) || (nums.length == 0)) {
            return new int[] {};
        }
        if (nums.length < k) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return new int[] {max};
        }

        PriorityQueue<Integer> window = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int count = 0; count < k; count++) {
            window.add(nums[count]);
        }

        List<Integer> result = new ArrayList<>();
        result.add(window.peek());

        int left = 0;
        for (int index = k; index < nums.length; index++) {
            int old = nums[left];
            window.remove(old);
            window.add(nums[index]);
            result.add(window.peek());
            left++;
        }

        int[] intResult = new int[result.size()];
        for (int index = 0; index < result.size(); index++) {
            intResult[index] = result.get(index);
        }
        return intResult;
    }
}
