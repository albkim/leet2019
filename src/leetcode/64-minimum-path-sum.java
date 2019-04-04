/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.


 */

package leetcode;

class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if ((grid == null) || (grid.length == 0) || (grid[0].length == 0)) {
            return 0;
        }

        return traverseDP(grid);
    }

    private int traverseDP(int[][] grid) {
        int[][] matrix = new int[grid.length][grid[0].length];

        for (int row = grid.length - 1; row >= 0; row--) {
            for (int column = grid[0].length - 1; column >= 0; column--) {
                if ((row == (grid.length - 1)) && (column == (grid[0].length - 1))) {
                    matrix[row][column] = grid[row][column];
                } else {
                    int min = Integer.MAX_VALUE;
                    if ((row + 1) < grid.length) {
                        min = Math.min(min, matrix[row + 1][column]);
                    }
                    if ((column + 1) < grid[0].length) {
                        min = Math.min(min, matrix[row][column + 1]);
                    }
                    matrix[row][column] = grid[row][column] + min;
                }
            }
        }

        return matrix[0][0];
    }
}
