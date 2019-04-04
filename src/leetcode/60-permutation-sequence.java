/*
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
1."123"
2."132"
3."213"
4."231"
5."312"
6."321"

Given n and k, return the kth permutation sequence.

Note:
•Given n will be between 1 and 9 inclusive.
•Given k will be between 1 and n! inclusive.

Example 1:
Input: n = 3, k = 3
Output: "213"


Example 2:
Input: n = 4, k = 9
Output: "2314"


 */

package leetcode;

class PermutationSequence {
    public String getPermutation(int n, int k) {
        if (n == 0) {
            return "";
        }

        java.util.List<String> result = new java.util.ArrayList<>();

        char[] chars = new char[n];
        for (int count = 0; count < n; count++) {
            chars[count] = Character.forDigit(count + 1, 10);
        }

        permutate(chars, new boolean[n], new StringBuilder(), result);

        return result.get(k - 1);
    }

    private void permutate(char[] nums, boolean[] used, StringBuilder sequence, java.util.List<String> result) {
        if (sequence.length() == nums.length) {
            result.add(sequence.toString());
        }

        for (int index = 0; index < nums.length; index++) {
            if (used[index]) {
                continue;
            }
            sequence.append(nums[index]);
            used[index] = true;
            permutate(nums, used, sequence, result);
            used[index] = false;
            sequence.deleteCharAt(sequence.length() - 1);
        }
    }
}
