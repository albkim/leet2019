/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values.
(ie, from left to right, level by level from leaf to root).

For example:
 Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7



return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]


 */

package leetcode;

import leetcode.models.TreeNode;

class BinaryTreeLevelOrderTraversalII {
    public java.util.List<java.util.List<Integer>> levelOrderBottom(TreeNode root) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeNode sentinel =  new TreeNode(-1);
        java.util.Queue<TreeNode> queue = new java.util.ArrayDeque<>();
        queue.add(root);
        queue.add(sentinel);

        java.util.List<Integer> currentRow = new java.util.ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.equals(sentinel)) {
                result.add(0, currentRow);
                currentRow = new java.util.ArrayList<>();
                if (queue.size() > 0) {
                    queue.add(sentinel);
                }
            } else {
                currentRow.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return result;
    }
}
