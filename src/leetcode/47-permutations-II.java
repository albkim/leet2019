/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]


 */

package leetcode;

class PermutationsII {
    public java.util.List<java.util.List<Integer>> permuteUnique(int[] nums) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        if ((nums == null) || (nums.length == 0)) {
            return result;
        }

        java.util.Arrays.sort(nums);
        permutate(nums, new boolean[nums.length], new java.util.ArrayList<>(), result);

        return result;
    }

    private void permutate(int[] nums, boolean[] used, java.util.List<Integer> sequence, java.util.List<java.util.List<Integer>> result) {
        if (sequence.size() == nums.length) {
            java.util.List<Integer> newSequence = new java.util.ArrayList<>();
            for (int num : sequence) {
                newSequence.add(num);
            }
            result.add(newSequence);
        }

        Integer last = null;
        for (int index = 0; index < nums.length; index++) {
            if (used[index]) {
                continue;
            }
            int num = nums[index];
            if ((last != null) && (num == last)) {
                continue;
            }

            sequence.add(num);
            used[index] = true;
            permutate(nums, used, sequence, result);
            used[index] = false;
            sequence.remove(sequence.size() - 1);
            last = num;
        }
    }
}
