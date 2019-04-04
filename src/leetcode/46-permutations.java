/*
Given a collection of distinct integers, return all possible permutations.

Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

 */

package leetcode;

class Permutations {
    public java.util.List<java.util.List<Integer>> permute(int[] nums) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        if ((nums == null) || (nums.length == 0)) {
            return result;
        }

        permutate(nums, new java.util.HashSet<>(), new java.util.ArrayList<>(), result);

        return result;
    }

    private void permutate(int[] nums, java.util.Set<Integer> used, java.util.List<Integer> sequence, java.util.List<java.util.List<Integer>> result) {
        if (sequence.size() == nums.length) {
            java.util.List<Integer> newSequence = new java.util.ArrayList<>();
            for (int num : sequence) {
                newSequence.add(num);
            }
            result.add(newSequence);
        }

        for (int num : nums) {
            if (used.contains(num)) {
                continue;
            }
            sequence.add(num);
            used.add(num);
            permutate(nums, used, sequence, result);
            used.remove(num);
            sequence.remove(sequence.size() - 1);
        }
    }
}
