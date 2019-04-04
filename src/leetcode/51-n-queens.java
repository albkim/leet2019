/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
both indicate a queen and an empty space respectively.

Example:
Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.


 */

package leetcode;

class NQueens {
    public java.util.List<java.util.List<String>> solveNQueens(int n) {
        java.util.List<java.util.List<String>> result = new java.util.ArrayList<>();
        if (n <= 0) {
            return result;
        }

        solveNQueens(new boolean[n], 0, new boolean[n][n], result);

        return result;
    }

    private void solveNQueens(boolean[] horizontalUsed, int vertical, boolean[][] board, java.util.List<java.util.List<String>> result) {
        if (vertical == horizontalUsed.length) {
            java.util.List<String> valid = new java.util.ArrayList<>();
            for (int row = 0; row < board.length; row++) {
                StringBuilder sRow = new StringBuilder();
                for (int column = 0; column < board[0].length; column++) {
                    if (!board[row][column]) {
                        sRow.append(".");
                    } else {
                        sRow.append("Q");
                    }
                }
                valid.add(sRow.toString());
            }
            result.add(valid);
        }

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

            solveNQueens(horizontalUsed, vertical + 1, board, result);

            board[vertical][column] = false;
            horizontalUsed[column] = false;
        }
    }
}
