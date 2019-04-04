/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:
Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Example 2:
Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

 */

package leetcode;

import leetcode.models.TreeNode;

class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, new java.util.ArrayList<>());
    }

    private int sumNumbers(TreeNode root, java.util.List<Character> characters) {
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            // i am at the leaf
            StringBuilder str = new StringBuilder();
            for (char chr : characters) {
                str.append(chr);
            }
            str.append(root.val);
            return Integer.parseInt(str.toString());
        }

        characters.add(Character.forDigit(root.val, 10));
        int total = sumNumbers(root.left, characters);
        total += sumNumbers(root.right, characters);
        characters.remove(characters.size() - 1);
        return total;
    }
}
