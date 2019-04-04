/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
 You may assume that duplicates do not exist in the tree.

For example, given
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]

Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7



last one in the post order is root. now do a search in in order and we can get left sub tree. Moving that much from left
would give you the right sub tree.
 */

package leetcode;

import leetcode.models.TreeNode;

class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (((postorder == null) && (inorder == null)) || ((postorder.length == 0) && (inorder.length == 0))) {
            return null;
        }

        return buildTree(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if ((pStart < 0) || (pEnd >= postorder.length) || (iStart < 0) || (iEnd >= inorder.length)) {
            return null;
        }

        int rootVal = postorder[pEnd];
        TreeNode root = new TreeNode(rootVal);

        int inFound = -1;
        for (int index = iStart; index <= iEnd; index++) {
            if (inorder[index] == rootVal) {
                inFound = index;
                break;
            }
        }

        if (iStart < inFound) {
            // we have left sub tree
            root.left = buildTree(postorder, inorder, pStart, pStart + (inFound - iStart - 1), iStart, inFound - 1);
        }
        if (inFound < iEnd) {
            // we have right sub tree
            root.right = buildTree(postorder, inorder, pStart + (inFound - iStart), pEnd - 1, inFound + 1, iEnd);
        }

        return root;
    }
}
