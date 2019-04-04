/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?



An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:
Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

 */

package leetcode;

class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if ((obstacleGrid == null) || (obstacleGrid.length == 0) || (obstacleGrid[0].length == 0)) {
            return 0;
        }

        return traverseDP(obstacleGrid);
    }

    private int traverseDP(int[][] obstacleGrid) {
        int[][] matrix = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int row = obstacleGrid.length - 1; row >= 0; row--) {
            for (int column = obstacleGrid[0].length - 1; column >= 0; column--) {
                if (obstacleGrid[row][column] == 1) {
                    continue;
                }
                if ((row == (obstacleGrid.length - 1)) && (column == (obstacleGrid[0].length - 1))) {
                    matrix[row][column] = 1;
                } else {
                    int total = 0;
                    if (((row + 1) < obstacleGrid.length) && (obstacleGrid[row + 1][column] != 1)) {
                        total += matrix[row + 1][column];
                    }
                    if (((column + 1) < obstacleGrid[0].length) && (obstacleGrid[row][column + 1] != 1)) {
                        total += matrix[row][column + 1];
                    }
                    matrix[row][column] = total;
                }
            }
        }

        return matrix[0][0];
    }
}
