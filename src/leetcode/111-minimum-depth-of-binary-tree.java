/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

return its minimum depth = 2.

 */

package leetcode;

import leetcode.models.TreeNode;

class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        int depth = 1;
        if ((left == 0) && (right == 0)) {
            return depth;
        } else if ((left > 0) && (right > 0)) {
            return depth + Math.min(left, right);
        }

        return depth + Math.max(left, right);
    }
}
