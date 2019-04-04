/*
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:
•All numbers (including target) will be positive integers.
•The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]


Example 2:
Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]


 */

package leetcode;

import java.util.Arrays;

class CombinationSumII {
    public java.util.List<java.util.List<Integer>> combinationSum2(int[] candidates, int target) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();

        Arrays.sort(candidates);
        findPermuation(candidates, 0, 0, target, new java.util.ArrayList<>(), result);

        return result;
    }

    private void findPermuation(int[] candidates, int index, int sum, int target, java.util.List<Integer> sequence, java.util.List<java.util.List<Integer>> result) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            java.util.List<Integer> newSequence = new java.util.ArrayList<>();
            for (int num: sequence) {
                newSequence.add(num);
            }
            result.add(newSequence);
        }
        if (index == candidates.length) {
            return;
        }

        Integer lastNumber = null;
        for (int newIndex = index; newIndex < candidates.length; newIndex++) {
            if ((lastNumber != null) && (lastNumber == candidates[newIndex])) {
                continue;
            }
            sequence.add(candidates[newIndex]);
            findPermuation(candidates, newIndex + 1, sum + candidates[newIndex], target, sequence, result);
            sequence.remove(sequence.size() - 1);
            lastNumber = candidates[newIndex];
        }
    }
}
