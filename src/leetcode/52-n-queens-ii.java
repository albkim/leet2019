/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:
Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]


 */

package leetcode;

class NQueensII {

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }

        return solveNQueens(new boolean[n], 0, new boolean[n][n], 0);
    }

    private int solveNQueens(boolean[] horizontalUsed, int vertical, boolean[][] board, int result) {
        if (vertical == horizontalUsed.length) {
            return 1;
        }

        int total = 0;
        for (int column = 0; column < horizontalUsed.length; column++) {
            if (horizontalUsed[column]) {
                continue;
            }

            // so far we guarantee that we don't align horizontally nor vertically, so all we need
            // to do is to align diagonally
            int horizontalOffset = 1;
            boolean valid = true;
            for (int row = vertical - 1; row >= 0; row--) {
                if ((column - horizontalOffset) >= 0) {
                    if (board[row][column - horizontalOffset]) {
                        valid = false;
                        break;
                    }
                }
                if ((column + horizontalOffset) < horizontalUsed.length) {
                    if (board[row][column + horizontalOffset]) {
                        valid = false;
                        break;
                    }
                }
                horizontalOffset++;
            }

            if (!valid) {
                continue;
            }

            horizontalUsed[column] = true;
            board[vertical][column] = true;

            total += solveNQueens(horizontalUsed, vertical + 1, board, result);

            board[vertical][column] = false;
            horizontalUsed[column] = false;
        }

        return total;
    }
}
