/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]


 */

package leetcode;

class PascalsTriangle {

    public java.util.List<java.util.List<Integer>> generate(int numRows) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();

        if (numRows == 0) {
            return result;
        }

        for (int count = 0; count < numRows; count++) {
            java.util.List<Integer> line = new java.util.ArrayList<>();
            for (int inner = 0; inner <= count; inner++) {
                int val = 0;
                if ((inner == 0) || (inner == count)) {
                    val = 1;
                } else {
                    val = result.get(count - 1).get(inner - 1) + result.get(count - 1).get(inner);
                }
                line.add(val);
            }
            result.add(line);
        }

        return result;
    }
}
