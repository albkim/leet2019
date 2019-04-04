/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
you can see ordered from top to bottom.

Example:
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---


 */

package leetcode;

import leetcode.models.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeNode sentinel = new TreeNode(-1);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        queue.add(sentinel);

        TreeNode current = null;
        while(!queue.isEmpty()) {
            if (queue.peek().equals(sentinel)) {
                result.add(current.val);
            }
            current = queue.poll();
            if (current.equals(sentinel)) {
                if (!queue.isEmpty()) {
                    queue.add(sentinel);
                }
            } else {
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
