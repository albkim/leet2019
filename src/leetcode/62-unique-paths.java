/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right


Example 2:
Input: m = 7, n = 3
Output: 28

 */

package leetcode;

class UniquePaths {
    public int uniquePaths(int m, int n) {
        if ((m <= 0) || (n <= 0)) {
            return 0;
        }

        // return traverse(1, 1, m, n);
        return traverseDP(m, n);
    }

    private int traverse(int x, int y, int m, int n) {
        if ((x == m) && (y == n)) {
            return 1;
        }

        int total = 0;
        if (x < m) {
            total += traverse(x + 1, y, m, n);
        }
        if (y < n) {
            total += traverse(x, y + 1, m, n);
        }

        return total;
    }

    private int traverseDP(int m, int n) {
        int[][] matrix = new int[m + 1][n + 1];
        for (int row = 0; row < m; row++) {
            matrix[row][n] = 0;
        }
        for (int column = 0; column < n; column++) {
            matrix[m][column] = 0;
        }

        // set the last cell (one below the last cell)
        matrix[m][n - 1] = 1;

        for (int row = m - 1; row >= 0; row--) {
            for (int column = n - 1; column >= 0; column--) {
                matrix[row][column] = matrix[row + 1][column] + matrix[row][column + 1];
            }
        }

        return matrix[0][0];
    }
}
