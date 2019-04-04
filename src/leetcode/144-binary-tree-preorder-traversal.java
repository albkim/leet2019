/*
Given a binary tree, return the preorder traversal of its nodes' values.

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]


Follow up: Recursive solution is trivial, could you do it iteratively?

 */

package leetcode;

import leetcode.models.TreeNode;

class BinaryTreePreorderTraversal {
    public java.util.List<Integer> preorderTraversal(TreeNode root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (root == null) {
            return result;
        }

        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        TreeNode current = root;
        while((!stack.empty()) || (current != null)) {
            if (current != null) {
                result.add(current.val);
                stack.push(current.right);

                current = current.left;
            } else {
                current = stack.pop();
            }
        }

        return result;
    }
}
