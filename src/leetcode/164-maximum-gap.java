/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:
Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.

Example 2:
Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.

Note:
•You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
•Try to solve it in linear time/space.




Bucket sort...where we have n bucket, we will make the search linear
 */

package leetcode;

class MaximumGap {
    public int maximumGap(int[] nums) {
        if ((nums == null) || (nums.length < 2)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int index = 0; index < nums.length; index++) {
            min = Math.min(min, nums[index]);
            max = Math.max(max, nums[index]);
        }

        Object[] buckets = new Object[nums.length + 1];
        int bucketSize = (int)Math.ceil((max - min) / (1d * nums.length));

        if (bucketSize == 0) {
            // all numbers are same, no gap
            return 0;
        }

        for (int num : nums) {
            int bucketIndex = (num - min) / bucketSize;
            if (buckets[bucketIndex] == null) {
                buckets[bucketIndex] = new int[] {num, num};
            } else {
                int bucketMin = Math.min(((int[])buckets[bucketIndex])[0], num);
                int bucketMax = Math.max(((int[])buckets[bucketIndex])[1], num);
                buckets[bucketIndex] = new int[] {bucketMin, bucketMax};
            }
        }

        int maxGap = Integer.MIN_VALUE;
        Integer previous = null;
        for (Object bucket : buckets) {
            if (bucket == null) {
                continue;
            }

            int[] minMax = (int[])bucket;
            maxGap = Math.max(maxGap, minMax[1] - minMax[0]);
            if (previous != null) {
                maxGap = Math.max(maxGap, minMax[0] - previous);
            }
            previous = minMax[1];
        }

        return maxGap;
    }
}
