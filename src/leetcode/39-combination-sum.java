/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:
•All numbers (including target) will be positive integers.
•The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]


Example 2:
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]


 */

package leetcode;

class CombinationSum {
    public java.util.List<java.util.List<Integer>> combinationSum(int[] candidates, int target) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();

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

        for (int newIndex = index; newIndex < candidates.length; newIndex++) {
            sequence.add(candidates[newIndex]);
            findPermuation(candidates, newIndex, sum + candidates[newIndex], target, sequence, result);
            sequence.remove(sequence.size() - 1);
        }
    }
}
