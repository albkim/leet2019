/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
•Integers in each row are sorted from left to right.
•The first integer of each row is greater than the last integer of the previous row.

Example 1:
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true


Example 2:
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false


this is just binary search in a long array and only tricky bit is translating index to 2d index

 */

package leetcode;

class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if ((matrix == null) || (matrix.length == 0) || (matrix[0].length == 0)) {
            return false;
        }

        int left = 0;
        int right = matrix.length * matrix[0].length - 1;

        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            int element = getElement(matrix, mid);
            if (element == target) {
                return true;
            } else if (element < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    private int getElement(int[][] matrix, int index) {
        int row = index / matrix[0].length;
        int column = index % matrix[0].length;

        return matrix[row][column];
    }
}
