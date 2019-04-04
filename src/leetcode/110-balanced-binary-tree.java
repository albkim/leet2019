/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:


a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:
    3
   / \
  9  20
    /  \
   15   7

Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4


Return false.


evaluate max depth at every level.

 */

package leetcode;

import leetcode.models.TreeNode;

class BalancedBinaryTree {

    private class BalancedResult {
        public boolean valid;
        public int depth;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        BalancedResult result = isBalancedRecursive(root);
        return result.valid;
    }

    private BalancedResult isBalancedRecursive(TreeNode root) {
        BalancedResult result = new BalancedResult();
        if (root == null) {
            result.valid = true;
            result.depth = 0;
            return result;
        }

        BalancedResult left = isBalancedRecursive(root.left);
        BalancedResult right = isBalancedRecursive(root.right);

        result.depth = Math.max(left.depth, right.depth) + 1;
        result.valid = left.valid && right.valid && (Math.abs(left.depth - right.depth) <= 1);
        return result;
    }
}
