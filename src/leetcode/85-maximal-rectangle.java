/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:
Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6


if we add up all the connected column for each for, this is same as largest rect in a histogram for each row

 */

package leetcode;

class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if ((matrix == null) || (matrix.length == 0) || (matrix[0].length == 0)) {
            return 0;
        }

        int[][] heights = new int[matrix.length][matrix[0].length];

        int max = 0;
        for (int row = 0; row < matrix.length; row++) {
            java.util.Stack<int[]> stack = new java.util.Stack<>();
            for (int column = 0; column <= matrix[0].length; column++) {
                if (column < matrix[0].length) {
                    int previous = ((row == 0) || (column == matrix[0].length)) ? 0 : heights[row - 1][column];
                    int current = matrix[row][column] == '1' ? 1 : 0;
                    heights[row][column] = (current > 0) ? (previous + current) : 0;
                }
                int num = (column == matrix[0].length) ? 0 : heights[row][column];
                if ((stack.empty()) || (stack.peek()[0] < num)) {
                    stack.push(new int[] { num, column });
                } else {
                    int lastIndex = column;
                    while((!stack.empty()) && (stack.peek()[0] > num)) {
                        int[] lastPair = stack.pop();
                        int lastNum = lastPair[0];
                        lastIndex = lastPair[1];
                        int area = (column - lastIndex) * lastNum;
                        max = Math.max(max, area);
                    }

                    if ((stack.empty()) || (stack.peek()[0] < num)) {
                        stack.push(new int[] { num, lastIndex });
                    }
                }
            }
        }

        return max;
    }
}
