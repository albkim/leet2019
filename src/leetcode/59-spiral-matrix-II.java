/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:
Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

 */

package leetcode;

class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }

        int[][] result = new int[n][n];

        int y = 0;
        int x = 0;
        int xDir = 1;
        int yDir = 0;
        int leftWall = -1;
        int rightWall = n;
        int topWall = -1;
        int bottomWall = n;
        int number = 1;
        while(true) {
            result[y][x] = number;
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
            number++;
        }

        return result;
    }
}
