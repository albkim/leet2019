/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.



the trick is to use a map and insert the number. While doing this, look for +1 and -1 and see if neighboring
number already exist, if so, perform sum of left + 1 + right. The key trick is then to update the other boundary.
This is needed because if next neighboring number if found, it will be next to the boundary.
 */

package leetcode;

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        java.util.Map<Integer, Integer> lookup = new java.util.HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (lookup.containsKey(num)) {
                // handle dupes
                continue;
            }

            int count = 1;
            int left = (lookup.containsKey(num - 1)) ? lookup.get(num - 1) : -1;
            int right = (lookup.containsKey(num + 1)) ? lookup.get(num + 1) : -1;

            if (left > 0) {
                count += left;
            }
            if (right > 0) {
                count += right;
            }

            lookup.put(num, count);

            if (left > 0) {
                lookup.put(num - left, count);
            }

            if (right > 0) {
                lookup.put(num + right, count);
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
