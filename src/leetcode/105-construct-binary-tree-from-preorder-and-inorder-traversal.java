/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
 You may assume that duplicates do not exist in the tree.

For example, given
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]

Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7


start with pre order, first element is root. now search this in the in order, any other ones prior to this is
the left sub tree. We can now see if there is a left subtree and next element in pre order is left subtree root
After that many items in the pre-order would be root of right sub tree. repeat
 */

package leetcode;

import leetcode.models.TreeNode;

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (((preorder == null) && (inorder == null)) || ((preorder.length == 0) && (inorder.length == 0))) {
            return null;
        }

        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preIndex, int inStart, int inEnd) {
        if ((preIndex >= preorder.length) || (inStart < 0) || (inEnd >= inorder.length)) {
            return null;
        }

        int rootVal = preorder[preIndex];
        TreeNode root = new TreeNode(rootVal);

        int inFound = search(inorder, inStart, inEnd, rootVal);

        if (inStart < inFound) {
            // we have left sub tree
            root.left = buildTree(preorder, inorder, preIndex + 1, inStart, inFound - 1);
        }
        if (inFound < inEnd) {
            // we have right sub tree
            root.right = buildTree(preorder, inorder, preIndex + (inFound - inStart) + 1, inFound + 1, inEnd);
        }

        return root;
    }

    private int search(int[] array, int left, int right, int val) {
        for (int index = left; index <= right; index++) {
            if (array[index] == val) {
                return index;
            }
        }

        return -1;
    }
}
