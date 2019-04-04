/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:
Input: 3
Output: [1,3,3,1]


Follow up:

Could you optimize your algorithm to use only O(k) extra space?

 */

package leetcode;

class PascalsTriangleII {
    public java.util.List<Integer> getRow(int rowIndex) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();

        for (int count = 0; count <= rowIndex; count++) {
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

        return result.get(rowIndex);
    }
}
