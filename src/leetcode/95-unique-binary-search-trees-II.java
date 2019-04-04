/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:
Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3



One thing to note in BST is that all the sub tree to the left should be lower and all the sub tree
to the right should be higher, not just the immediate children. So this problem can be broken up
by processing left/right sub tree separately once root node is determined
*/

package leetcode;

import leetcode.models.TreeNode;

class UniqueBinarySearchTreesII {
    public java.util.List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private java.util.List<TreeNode> generateTrees(int start, int end) {
        java.util.List<TreeNode> result = new java.util.ArrayList<>();

        if ((end - start) < 0) {
            return result;
        }

        for (int val = start; val <= end; val++) {
            // get left sub tree's (all variations)(
            java.util.List<TreeNode> lefts = generateTrees(start, val - 1);
            // right
            java.util.List<TreeNode> rights = generateTrees(val + 1, end);

            // for each left, create right...for the point of the exercise, we probably don't care about sharing the
            // same object and don't need to copy the tree
            java.util.List<TreeNode> temp = new java.util.ArrayList<>();
            if (lefts.size() == 0) {
                if (temp.size() == 0) {
                    temp.add(new TreeNode(val));
                }
            } else {
                for (TreeNode leftRoot : lefts) {
                    TreeNode root = new TreeNode(val);
                    root.left = leftRoot;
                    temp.add(root);
                }
            }

            if (rights.size() == 0) {
                result.addAll(temp);
            } else {
                for (TreeNode tmp : temp) {
                    for (TreeNode rightRoot : rights) {
                        TreeNode root = new TreeNode(val);
                        root.left = tmp.left;
                        root.right = rightRoot;
                        result.add(root);
                    }
                }
            }
        }

        return result;
    }
}
