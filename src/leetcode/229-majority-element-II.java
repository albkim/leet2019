/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:
Input: [3,2,3]
Output: [3]

Example 2:
Input: [1,1,1,3,3,2,2,2]
Output: [1,2]

 */

package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        return majorityElementGeneric(nums, 2);
    }

    public static List<Integer> majorityElementGeneric(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> duplicateCheck = new HashSet<>();

        if (nums.length <= k) {
            for (int num : nums) {
                if (!duplicateCheck.contains(num)) {
                    result.add(num);
                }
                duplicateCheck.add(num);
            }
            return result;
        }

        int[] candidates = new int[k];
        int[] counts = new int[k];

        for (int num : nums) {
            boolean found = false;
            for (int index = 0; index < k; index++) {
                if (num == candidates[index]) {
                    counts[index]++;
                    found = true;
                    break;
                }
            }
            if (found) {
                continue;
            }
            for (int index = 0; index < k; index++) {
                if (counts[index] == 0) {
                    candidates[index] = num;
                    counts[index]++;
                    found = true;
                    break;
                }
            }
            if (found) {
                continue;
            }
            for (int index = 0; index < k; index++) {
                counts[index]--;
            }
        }

        duplicateCheck.clear();
        for (int candidate : candidates) {
            int count = 0;
            for (int num : nums) {
                if (candidate == num) {
                    count++;
                }
            }

            if ((count > (nums.length / (k + 1))) && (!duplicateCheck.contains(candidate))) {
                result.add(candidate);
            }
            duplicateCheck.add(candidate);
        }

        return result;
    }
}
