/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:
Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4


 */

package leetcode;

class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if ((matrix == null) || (matrix.length == 0) || (matrix[0].length == 0)) {
            return 0;
        }

        long maxArea = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if ((visited[row][column]) || (matrix[row][column] == '0')) {
                    continue;
                }

                maxArea = Math.max(maxArea, maximalSquare(matrix, visited, row, column, 1));
            }
        }

        return (int)Math.pow(maxArea, 2);
    }

    private long maximalSquare(char[][] matrix, boolean[][] visited, int row, int column, int size) {
        boolean isSquare = true;

        squareCheck:
        for (int ver = row; ver < (row + size); ver++) {
            for (int hor = column; hor < (column + size); hor++) {
                if ((ver == matrix.length) || (hor == matrix[0].length) || (visited[ver][hor]) || (matrix[ver][hor] == '0')) {
                    isSquare = false;
                    break squareCheck;
                }
            }
        }

        if (isSquare) {
            return maximalSquare(matrix, visited, row, column, size + 1);
        }

        for (int ver = row; ver < (row + size); ver++) {
            for (int hor = column; hor < (column + size); hor++) {
                visited[row][column] = true;
            }
        }

        return size - 1;
    }
}
