/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]


The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.


build up the number from index and index + 1 from the row below. and take the min each time.
 */

package leetcode;

class Triangle {
    public int minimumTotal(java.util.List<java.util.List<Integer>> triangle) {
        if ((triangle == null) || (triangle.size() == 0)) {
            return 0;
        }

        int[] storage = new int[triangle.size()];
        for (int index = 0; index < triangle.get(triangle.size() - 1).size(); index++) {
            storage[index] = triangle.get(triangle.size() - 1).get(index);
        }

        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int index = 0; index < triangle.get(row).size(); index++) {
                int min = Math.min(storage[index], storage[index + 1]);
                storage[index] = triangle.get(row).get(index) + min;
            }
        }

        return storage[0];
    }
}
