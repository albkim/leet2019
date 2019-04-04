/*
Given a binary tree, return the postorder traversal of its nodes' values.

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]


Follow up: Recursive solution is trivial, could you do it iteratively?

 */

package leetcode;

import leetcode.models.TreeNode;

class BinaryTreePostorderTraversal {
    public java.util.List<Integer> postorderTraversal(TreeNode root) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (root == null) {
            return result;
        }

        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        TreeNode current = root;
        while((!stack.empty()) || (current != null)) {
            if (current != null) {
                stack.push(current);

                current = current.left;
            } else {
                current = stack.pop();

                if (current.right != null) {
                    if ((!stack.empty()) && (current.right.equals(stack.peek()))) {
                        // we are coming back up.
                        stack.pop();
                        result.add(current.val);
                        current = null;
                    } else {
                        stack.push(current.right);
                        stack.push(current);
                        current = current.right;
                    }
                } else {
                    result.add(current.val);
                    current = null;
                }
            }
        }

        return result;
    }
}
