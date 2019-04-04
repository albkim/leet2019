/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

 */

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PerfectSquares {
    public int numSquares(int n) {
        Map<Integer, Integer> cache = new HashMap<>();

        return numSquares(n, getSquares(n), 0, cache);
    }

    private int numSquares(int n, List<Integer> squares, int count, Map<Integer, Integer> cache) {
        if (n == 0) {
            return count;
        }

        if (cache.containsKey(n)) {
            return cache.get(n) + count;
        }

        int minCount = Integer.MAX_VALUE;
        for (int index = squares.size() - 1; index >= 0; index--) {
            int number = squares.get(index);
            if (number > n) {
                continue;
            }
            minCount = Math.min(minCount, numSquares(n - number, squares, count + 1, cache));
        }

        cache.put(n, minCount - count);

        return minCount;
    }

    private List<Integer> getSquares(int n) {
        List<Integer> squares = new ArrayList<>();

        for (int num = 1; num * num <= n; num++) {
            squares.add(num * num);
        }

        return squares;
    }
}
