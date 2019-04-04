/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]


Example 2:
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


 */

package leetcode;

class SpiralMatrix {
    public java.util.List<Integer> spiralOrder(int[][] matrix) {
        java.util.List<Integer> result = new java.util.ArrayList<>();

        if ((matrix == null) || (matrix.length == 0)) {
            return result;
        }

        int y = 0;
        int x = 0;
        int xDir = 1;
        int yDir = 0;
        int leftWall = -1;
        int rightWall = matrix[0].length;
        int topWall = -1;
        int bottomWall = matrix.length;
        while(true) {
            result.add(matrix[y][x]);
            boolean canGoLeft = (x - 1) > leftWall;
            boolean canGoRight = (x + 1) < rightWall;
            boolean canGoDown = (y + 1) < bottomWall;
            boolean canGoUp = (y - 1) > topWall;

            if ((xDir == 1) && (yDir == 0) && (!canGoRight)) {
                if (!canGoDown) {
                    break;
                }
                topWall++;
                xDir = 0;
                yDir = 1;
            } else if ((xDir == 0) && (yDir == 1) && (!canGoDown)) {
                if (!canGoLeft) {
                    break;
                }
                rightWall--;
                xDir = -1;
                yDir = 0;
            } else if ((xDir == -1) && (yDir == 0) && (!canGoLeft)) {
                if (!canGoUp) {
                    break;
                }
                bottomWall--;
                xDir = 0;
                yDir = -1;
            } else if ((xDir == 0) && (yDir == -1) && (!canGoUp)) {
                if (!canGoRight) {
                    break;
                }
                leftWall++;
                xDir = 1;
                yDir = 0;
            }

            x += xDir;
            y += yDir;
        }

        return result;
    }
}
