/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:
Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]


 */

package leetcode;

import java.util.List;

class SubsetsII {
    public java.util.List<java.util.List<Integer>> subsetsWithDup(int[] nums) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        if (nums == null) {
            return result;
        }

        java.util.Arrays.sort(nums);

        subsetsWithDup(result, nums, 0, new java.util.ArrayList<>());

        return result;
    }

    private void subsetsWithDup(List<List<Integer>> result, int[] nums, int index, java.util.List<Integer> sequence) {
        java.util.List<Integer> newSequence = new java.util.ArrayList<>();
        for (int num : sequence) {
            newSequence.add(num);
        }
        result.add(newSequence);

        if (index == nums.length) {
            return;
        }

        Integer lastNum = null;
        for (int current = index; current < nums.length; current++) {
            int num = nums[current];
            if ((lastNum != null) && (lastNum == num)) {
                continue;
            }

            sequence.add(num);

            subsetsWithDup(result, nums, current + 1, sequence);

            sequence.remove(sequence.size() - 1);

            lastNum = num;
        }
    }
}
