/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.


 */

package leetcode;

class WordSearch {
    public boolean exist(char[][] board, String word) {
        if ((board == null) || (board.length == 0) || (board[0].length == 0)) {
            if ((word == null) || (word.length() == 0)) {
                return true;
            }
            return false;
        }

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (exist(board, word, column, row, 0, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, String word, int x, int y, int index, boolean[][] used) {
        if (index == word.length()) {
            return true;
        }

        if ((x < 0) || (y < 0) || (x == board[0].length) || (y == board.length)) {
            return false;
        }
        if (used[y][x]) {
            return false;
        }
        if (board[y][x] != word.charAt(index)) {
            return false;
        }

        used[y][x] = true;

        if (exist(board, word, x, y - 1, index + 1, used)) {
            return true;
        }
        if (exist(board, word, x, y + 1, index + 1, used)) {
            return true;
        }
        if (exist(board, word, x - 1, y, index + 1, used)) {
            return true;
        }
        if (exist(board, word, x + 1, y, index + 1, used)) {
            return true;
        }

        used[y][x] = false;

        return false;
    }
}
