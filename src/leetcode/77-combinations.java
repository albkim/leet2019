/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]


 */

package leetcode;

class Combinations {
    public java.util.List<java.util.List<Integer>> combine(int n, int k) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();

        if ((n < 1) || (k == 0)) {
            return result;
        }

        combine(n, k, 1, new java.util.ArrayList<>(), result);

        return result;
    }

    private void combine(int n, int k, int skip, java.util.List<Integer> sequence, java.util.List<java.util.List<Integer>> result) {
        if (sequence.size() == k) {
            java.util.List<Integer> newSequence = new java.util.ArrayList<>();
            for (int num : sequence) {
                newSequence.add(num);
            }
            result.add(newSequence);
        }

        for (int num = skip; num <= n; num++) {
            sequence.add(num);
            combine(n, k, num + 1, sequence, result);
            sequence.remove(sequence.size() - 1);
        }
    }
}
