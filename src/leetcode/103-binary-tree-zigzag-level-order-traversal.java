/*
Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).

For example:
 Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7



return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]



Note that the children has to be added in certain in reverse order of popping, so stack is the right one to use
 */

package leetcode;

import leetcode.models.TreeNode;

class BinaryTreeZigzagLevelOrderTraversal {
    public java.util.List<java.util.List<Integer>> zigzagLevelOrder(TreeNode root) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        if (root == null) {
            return result;
        }

        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        java.util.Stack<TreeNode> next = new java.util.Stack<>();
        stack.push(root);

        boolean leftToRight = true;
        java.util.List<Integer> currentRow = new java.util.ArrayList<>();
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            currentRow.add(current.val);
            if (leftToRight) {
                if (current.left != null) {
                    next.push(current.left);
                }
                if (current.right != null) {
                    next.push(current.right);
                }
            } else {
                if (current.right != null) {
                    next.push(current.right);
                }
                if (current.left != null) {
                    next.push(current.left);
                }
            }
            if (stack.empty()) {
                result.add(currentRow);
                currentRow = new java.util.ArrayList<>();
                leftToRight = !leftToRight;

                stack = next;
                next = new java.util.Stack<>();
            }
        }

        return result;
    }
}
