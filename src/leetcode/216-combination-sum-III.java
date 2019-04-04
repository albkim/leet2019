/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be
used and each combination should be a unique set of numbers.

Note:
•All numbers will be positive integers.
•The solution set must not contain duplicate combinations.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]


Example 2:
Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]


 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0) {
            return result;
        }

        combinationSum3(result, new ArrayList<>(), k, n, 0, 1);

        return result;
    }

    private void combinationSum3(List<List<Integer>> result, List<Integer> sequence, int k, int n, int total, int start) {
        if (k == 0) {
            if (n == total) {
                List<Integer> newSequence = new ArrayList<>();
                for (int num : sequence) {
                    newSequence.add(num);
                }
                result.add(newSequence);
            }
            return;
        }

        for (int num = start; num < 10; num++) {
            sequence.add(num);

            combinationSum3(result, sequence, k - 1, n, total + num, num + 1);

            sequence.remove(sequence.size() - 1);
        }
    }
}
