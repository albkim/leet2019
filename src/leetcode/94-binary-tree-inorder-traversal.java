/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]

Follow up: Recursive solution is trivial, could you do it iteratively?

 */

package leetcode;

import leetcode.models.TreeNode;
import sun.reflect.generics.tree.Tree;

class BinaryTreeInorderTraversal {
    public java.util.List<Integer> inorderTraversal(TreeNode root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (root == null) {
            return result;
        }

        /*
        inorderTraversalRecursive(root, result);

        return result;
        */
        return inorderTraversalIterative(root);
    }

    private void inorderTraversalRecursive(TreeNode current, java.util.List<Integer> result) {
        if (current == null) {
            return;
        }

        inorderTraversalRecursive(current.left, result);
        result.add(current.val);
        inorderTraversalRecursive(current.right, result);
    }

    private java.util.List<Integer> inorderTraversalIterative(TreeNode root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();

        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        TreeNode current = root;
        while ((!stack.empty()) || (current != null)) {
            if (current != null) {
                stack.push(current);

                // move left
                current = current.left;
            } else {
                // current is null but stack has entry...now start popping off
                current = stack.pop();

                result.add(current.val);

                current = current.right;
            }
        }

        return result;
    }
}
