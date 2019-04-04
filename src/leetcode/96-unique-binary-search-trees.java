/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:
Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


similar to creating variation, it should be number of left * number of right sub tree's


probably can memoize or dp for better perf

 */

package leetcode;

class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        return numTrees(1, n);
    }

    private int numTrees(int start, int end) {
        if (start == end) {
            return 1;
        } else if (end < start) {
            return 0;
        }

        int total = 0;
        for (int val = start; val <= end; val++) {
            int countLeft = numTrees(start, val - 1);
            int countRight = numTrees(val + 1, end);

            if (countLeft == 0) {
                total += countRight;
            } else if (countRight == 0) {
                total += countLeft;
            } else {
                total += countLeft * countRight;
            }
        }

        return total;
    }
}
