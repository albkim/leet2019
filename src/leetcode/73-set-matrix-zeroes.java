/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:
Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]


Example 2:
Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]


Follow up:
•A straight forward solution using O(mn) space is probably a bad idea.
•A simple improvement uses O(m + n) space, but still not the best solution.
•Could you devise a constant space solution?


Use the array first row and first column to mark 0's...then flip from the other end.
 */

package leetcode;

class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if ((matrix == null) || (matrix.length == 0) || (matrix[0].length == 0)) {
            return;
        }

        // (0,0) becomes tricky since we cannot tell whether it's row or column.
        boolean leftRow = false;
        boolean topRow = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] == 0) {
                    if ((row > 0) && (column == 0)) {
                        leftRow = true;
                    } else if ((column > 0) && (row == 0)) {
                        topRow = true;
                    } else {
                        matrix[row][0] = 0;
                        matrix[0][column] = 0;
                    }
                }
            }
        }
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int column = matrix[0].length - 1; column >= 0; column--) {
                if (((row == 0) && topRow) || ((column == 0) && (leftRow)) || ((matrix[0][column] == 0) || (matrix[row][0] == 0))) {
                    matrix[row][column] = 0;
                }
            }
        }
    }
}
