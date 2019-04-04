/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:
Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3


 */

package leetcode;

import leetcode.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        binaryTreePaths(result, new ArrayList<>(), root);
        return result;
    }

    private void binaryTreePaths(List<String> result, ArrayList<Integer> current, TreeNode root) {
        if (root == null) {
            return;
        }

        current.add(root.val);
        if ((root.left == null) && (root.right == null)) {
            StringBuilder path = new StringBuilder();
            for (int num : current) {
                if (path.length() > 0) {
                    path.append("->");
                }
                path.append(String.valueOf(num));
            }
            result.add(path.toString());
        }

        binaryTreePaths(result, current, root.left);
        binaryTreePaths(result, current, root.right);
        current.remove(current.size() - 1);
    }
}
