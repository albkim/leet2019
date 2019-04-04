/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:
X X X X
X O O X
X X O X
X O X X


After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X


Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not
flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be
flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.


find and mark regions connected to the O's on the border, flip the rest.
 */

package leetcode;

class SurroundedRegions {
    public void solve(char[][] board) {
        if ((board == null) || (board.length == 0) || (board[0].length == 0)) {
            return;
        }

        for (int row = 0; row < board.length; row++) {
            dfs(board, row, 0);
            dfs(board, row, board[0].length - 1);
        }

        for (int column = 1; column < (board[0].length - 1); column++) {
            dfs(board, 0, column);
            dfs(board, board.length - 1, column);
        }

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == 'O') {
                    // flip O's
                    board[row][column] = 'X';
                } else if (board[row][column] == 'T') {
                    // restore marked O's
                    board[row][column] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int y, int x) {
        if ((y < 0) || (x < 0) || (y >= board.length) || (x >= board[0].length)) {
            return;
        }

        if (board[y][x] != 'O') {
            return;
        }

        // flip first...so we can use this to track visited
        board[y][x] = 'T';
        dfs(board, y + 1, x);
        dfs(board, y - 1, x);
        dfs(board, y, x + 1);
        dfs(board, y, x - 1);
    }
}
