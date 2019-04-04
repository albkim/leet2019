/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:
1.Each of the digits 1-9 must occur exactly once in each row.
2.Each of the digits 1-9 must occur exactly once in each column.
3.Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.

Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:
•The given board contain only digits 1-9 and the character '.'.
•You may assume that the given Sudoku puzzle will have a single unique solution.
•The given board size is always 9x9.

 */

package leetcode;

class SudokuSolver {
    public void solveSudoku(char[][] board) {
        java.util.List<java.util.Map<Integer, Integer>> rowValids = new java.util.ArrayList<>();
        java.util.List<java.util.Map<Integer, Integer>> columnValids = new java.util.ArrayList<>();
        java.util.List<java.util.Map<Integer, Integer>> subValids = new java.util.ArrayList<>();

        for (int row = 0; row < board.length; row++) {
            rowValids.add(new java.util.HashMap<>());
            for (int column = 0; column < board[0].length; column++) {
                if (row == 0) {
                    columnValids.add(new java.util.HashMap<>());
                }
                if (((row % 3) == 0) && ((column % 3) == 0)) {
                    subValids.add(new java.util.HashMap<>());
                }
                char numberC = board[row][column];
                if (numberC == '.') {
                    continue;
                }
                int number = Character.getNumericValue(numberC);
                rowValids.get(row).put(number, 1);
                columnValids.get(column).put(number, 1);

                int subIndex = (row / 3) * 3 + (column / 3);
                subValids.get(subIndex).put(number, 1);
            }
        }

        tryFill(board, 0, 0, rowValids, columnValids, subValids);
    }

    private boolean tryFill(
            char[][] board,
            int row,
            int column,
            java.util.List<java.util.Map<Integer, Integer>> rowValids,
            java.util.List<java.util.Map<Integer, Integer>> columnValids,
            java.util.List<java.util.Map<Integer, Integer>> subValids) {
        if ((row == board.length) && (column == 0)) {
            return true;
        }

        int nextColumn = column + 1;
        int nextRow = row;
        if (nextColumn >= board[0].length) {
            nextRow++;
            nextColumn = 0;
        }

        char numberC = board[row][column];
        if (numberC == '.') {
            for (int number = 1; number <= 9; number++) {
                if ((rowValids.get(row).containsKey(number)) && (rowValids.get(row).get(number) == 1)) {
                    continue;
                }
                if  ((columnValids.get(column).containsKey(number)) && (columnValids.get(column).get(number) == 1)) {
                    continue;
                }
                int subIndex = (row / 3) * 3 + (column / 3);
                if ((subValids.get(subIndex).containsKey(number)) && (subValids.get(subIndex).get(number) == 1)) {
                    continue;
                }

                rowValids.get(row).put(number, 1);
                columnValids.get(column).put(number, 1);
                subValids.get(subIndex).put(number, 1);
                board[row][column] = Character.forDigit(number, 10);

                if (tryFill(board, nextRow, nextColumn, rowValids, columnValids, subValids)) {
                    return true;
                }

                board[row][column] = '.';
                rowValids.get(row).put(number, 0);
                columnValids.get(column).put(number, 0);
                subValids.get(subIndex).put(number, 0);
            }
        } else {
            if (tryFill(board, nextRow, nextColumn, rowValids, columnValids, subValids)) {
                return true;
            }
        }

        return false;
    }
}
