/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
1.Each row must contain the digits 1-9 without repetition.
2.Each column must contain the digits 1-9 without repetition.
3.Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.


A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:
Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true


Example 2:
Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.


Note:
•A Sudoku board (partially filled) could be valid but is not necessarily solvable.
•Only the filled cells need to be validated according to the mentioned rules.
•The given board contain only digits 1-9 and the character '.'.
•The given board size is always 9x9.

 */

package leetcode;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        java.util.Map<Integer, Integer> valid = new java.util.HashMap<Integer, Integer>() {{
           put(1, 0);
           put(2, 0);
           put(3, 0);
           put(4, 0);
           put(5, 0);
           put(6, 0);
           put(7, 0);
           put(8, 0);
           put(9, 0);
        }};

        // row
        for (int row = 0; row < board.length; row++) {
            for (int key : valid.keySet()) {
                valid.put(key, 0);
            }
            for (int column = 0; column < board[0].length; column++) {
                char numberC = board[row][column];
                if (numberC == '.') {
                    continue;
                }
                int number = Character.getNumericValue(numberC);
                if ((!valid.containsKey(number)) || (valid.get(number) == 1)) {
                    return false;
                }
                valid.put(number, 1);
            }
        }

        // column
        for (int column = 0; column < board[0].length; column++) {
            for (int key : valid.keySet()) {
                valid.put(key, 0);
            }
            for (int row = 0; row < board.length; row++) {
                char numberC = board[row][column];
                if (numberC == '.') {
                    continue;
                }
                int number = Character.getNumericValue(numberC);
                if ((!valid.containsKey(number)) || (valid.get(number) == 1)) {
                    return false;
                }
                valid.put(number, 1);
            }
        }

        // 3x3
        for (int row = 0; row < board[0].length; row += 3) {
            for (int column = 0; column < board.length; column += 3) {
                for (int key : valid.keySet()) {
                    valid.put(key, 0);
                }
                for (int rowS = row; rowS < row + 3; rowS++) {
                    for (int columnS = column; columnS < column + 3; columnS++) {
                        char numberC = board[rowS][columnS];
                        if (numberC == '.') {
                            continue;
                        }
                        int number = Character.getNumericValue(numberC);
                        if ((!valid.containsKey(number)) || (valid.get(number) == 1)) {
                            return false;
                        }
                        valid.put(number, 1);
                    }
                }
            }
        }

        return true;
    }
}
