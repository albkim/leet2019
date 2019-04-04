/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]


Example 2:
Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

clockwise -> swap up & down and swap symmetry (i->j)
counter-clockwise -> swap left & right and swap symmetry

 */

package leetcode;

class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        for (int yi = 0; yi < matrix.length / 2; yi++) {
            int ye = matrix.length - yi - 1;
            for (int x = 0; x < matrix[0].length; x++) {
                swap(matrix, x, yi, x, ye);
            }
        }

        for (int y = 0; y < matrix.length; y++) {
            for (int x = y; x < matrix[0].length; x++) {
                swap(matrix, x, y, y, x);
            }
        }
    }

    private void swap(int[][] matrix, int xi, int yi, int xe, int ye) {
        int temp = matrix[yi][xi];
        matrix[yi][xi] = matrix[ye][xe];
        matrix[ye][xe] = temp;
    }
}
