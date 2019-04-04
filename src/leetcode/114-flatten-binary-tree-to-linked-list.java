/*
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:
    1
   / \
  2   5
 / \   \
3   4   6


The flattened tree should look like:
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6


has to be in place...try to do a pre order traversal with some pointer trick?


 */

package leetcode;

import leetcode.models.TreeNode;

class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flattenRecursive(root);
    }

    private TreeNode[] flattenRecursive(TreeNode root) {
        if ((root.left == null) && (root.right == null)) {
            return new TreeNode[] {root, root};
        }

        TreeNode[] leftSub = (root.left == null) ? null : flattenRecursive(root.left);
        TreeNode[] rightSub = (root.right == null) ? null : flattenRecursive(root.right);

        root.left = null;
        TreeNode end = root;
        if (leftSub != null) {
            root.right = leftSub[0];
            end = leftSub[1];
            end.right = null;
        }
        if (rightSub != null) {
            end.right = rightSub[0];
            end = rightSub[1];
            end.right = null;
        }
        return new TreeNode[] {root, end};
    }
}
