/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton
devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with
its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above
Wikipedia article):
1.Any live cell with fewer than two live neighbors dies, as if caused by under-population.
2.Any live cell with two or three live neighbors lives on to the next generation.
3.Any live cell with more than three live neighbors dies, as if by over-population..
4.Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state.
The next state is created by applying the above rules simultaneously to every cell in the current state,
where births and deaths occur simultaneously.

Example:
Input:
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output:
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]


Follow up:
1.Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update
some cells first and then use their updated values to update other cells.
2.In this question, we represent the board using a 2D array. In principle, the board is infinite, which would
cause problems when the active area encroaches the border of the array. How would you address these problems?

 */


package leetcode;

class GameOfLife {

    private static int[][] directions = new int[][] {
            new int[] {1,0},
            new int[] {-1,0},
            new int[] {0,1},
            new int[] {0,-1},
            new int[] {1,1},
            new int[] {-1,-1},
            new int[] {-1,1},
            new int[] {1,-1}
    };

    public void gameOfLife(int[][] board) {
        if ((board == null) || (board.length == 0) || (board[0].length == 0)) {
            return;
        }

        // 3 - dead
        // 4 - relive
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                int count = countNeighbors(board, row, column);
                if (board[row][column] == 1) {
                    if ((count < 2) || (count > 3)) {
                        board[row][column] = 3;
                    }
                }
                else {
                    if (count == 3) {
                        board[row][column] = 4;
                    }
                }
            }
        }
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == 3) {
                    board[row][column] = 0;
                }
                else if (board[row][column] == 4) {
                    board[row][column] = 1;
                }
            }
        }
    }

    private static int countNeighbors(int[][] board, int row, int column) {
        int count = 0;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newColumn = column + direction[1];

            if ((newRow < 0) || (newRow >= board.length) || (newColumn < 0) || (newColumn >= board[0].length)) {
                continue;
            }

            // should include 3 since it could have been transitioned in this round and was alive before
            if ((board[newRow][newColumn] == 1) || (board[newRow][newColumn] == 3)) {
                count++;
            }
        }
        return count;
    }
}
