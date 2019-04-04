/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

class Subsets {
    public java.util.List<java.util.List<Integer>> subsets(int[] nums) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new java.util.ArrayList<>());
            return result;
        }

        // prevents dupes
        java.util.Arrays.sort(nums);

        subsets(nums, 0, new java.util.ArrayList<>(), result);
        
        return result;
    }

    private void subsets(int[] nums, int start, java.util.List<Integer> sequence, List<List<Integer>> result) {
        java.util.List<Integer> newSequence = new java.util.ArrayList<>();
        for (int num : sequence) {
            newSequence.add(num);
        }
        result.add(newSequence);

        for (int index = start; index < nums.length; index++) {
            int num = nums[index];
            sequence.add(num);

            subsets(nums, index + 1, sequence, result);

            sequence.remove(sequence.size() - 1);
        }
    }
}
