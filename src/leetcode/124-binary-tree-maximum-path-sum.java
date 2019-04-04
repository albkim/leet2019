/*
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree
along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:
Input: [1,2,3]

       1
      / \
     2   3

Output: 6


Example 2:
Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42


post order traversal and disregard any negatively contributing sub tree

 */

package leetcode;

import leetcode.models.TreeNode;

class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        return (int)maxPathSumRecursive(root)[0];
    }

    private long[] maxPathSumRecursive(TreeNode root) {
        if (root == null) {
            return new long[] { Integer.MIN_VALUE, 0 };
        }

        long[] leftSum = maxPathSumRecursive(root.left);
        long[] rightSum = maxPathSumRecursive(root.right);
        long current = root.val;

        // one gotcha is that if current doesn't contribute, we should either consider this as max but we cannot
        // contribute this in the upper path.

        // assume current contributes, find the larger path
        long larger = Math.max(leftSum[1] + current, rightSum[1] + current);
        if (larger < 0) {
            // if contribution is less than 0, might as well not contribute
            larger = 0;
        }

        return new long[]{
                Math.max(Math.max(Math.max(Math.max(
                        Math.max(leftSum[0], rightSum[0]),
                        current),
                        leftSum[1] + current),
                        rightSum[1] + current),
                        leftSum[1] + rightSum[1] + current
                ),
                larger
        };
    }
}
