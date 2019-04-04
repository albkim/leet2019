/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1


Return:
[
   [5,4,11,2],
   [5,8,4,5]
]


 */

package leetcode;

import leetcode.models.TreeNode;

class PathSumII {
    public java.util.List<java.util.List<Integer>> pathSum(TreeNode root, int sum) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        if (root == null) {
            return result;
        }

        pathSum(root, result, new java.util.ArrayList<>(), sum, 0);

        return result;
    }

    private void pathSum(TreeNode root, java.util.List<java.util.List<Integer>> result, java.util.List<Integer> sequence, int sum, int val) {
        if ((root.left == null) && (root.right == null) && ((root.val + val) == sum)) {
            java.util.List<Integer> newSequence = new java.util.ArrayList<>();
            for (int num : sequence) {
                newSequence.add(num);
            }
            newSequence.add(root.val);
            result.add(newSequence);
        }

        sequence.add(root.val);
        if (root.left != null) {
            pathSum(root.left, result, sequence, sum, val + root.val);
        }

        if (root.right != null) {
            pathSum(root.right, result, sequence, sum, val + root.val);
        }
        sequence.remove(sequence.size() - 1);

        return;
    }
}
