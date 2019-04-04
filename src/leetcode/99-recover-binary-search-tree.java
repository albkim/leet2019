/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:
Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2


Example 2:
Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3


Follow up:
•A solution using O(n) space is pretty straight forward.
•Could you devise a constant space solution?


As i do in order traversal, I should be able to detect places where it's wrong. (current is lower than last)
when there are 2 it's obvious that it's those two
when there are 3 it's the two ends
 */

package leetcode;

import leetcode.models.TreeNode;

import java.util.Set;

class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        java.util.List<TreeNode> candidates = new java.util.ArrayList<>();
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        TreeNode current = root;
        TreeNode previous = null;
        while((!stack.empty()) || (current != null)) {
            if (current != null) {
                stack.push(current);

                current = current.left;
            } else {
                current = stack.pop();

                if ((previous != null) && (previous.val > current.val)) {
                    if ((candidates.size() == 0) || (candidates.get(candidates.size() - 1).val != previous.val)) {
                        candidates.add(previous);
                    }
                    candidates.add(current);
                }

                previous = current;

                current = current.right;
            }
        }

        TreeNode smallest = null;
        TreeNode largest = null;
        for (TreeNode candidate : candidates) {
            if ((smallest == null) || (smallest.val > candidate.val)) {
                smallest = candidate;
            }
            if ((largest == null) || (largest.val < candidate.val)) {
                largest = candidate;
            }
        }

        int tmp = smallest.val;
        smallest.val = largest.val;
        largest.val = tmp;
    }
}
