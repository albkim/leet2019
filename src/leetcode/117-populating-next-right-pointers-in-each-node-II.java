/*
Given a binary tree
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}


Populate each next pointer to point to its next right node. If there is no next right node,
the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.



Example:


Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}

Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.




Note:
•You may only use constant extra space.
•Recursive approach is fine, implicit stack space does not count as extra space for this problem.

 */

package leetcode;

import leetcode.models.Node;

class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node level = root;
        Node levelNext = null;
        Node current = root;
        Node last = null;

        while(level != null) {
            while(current != null) {
                // no leaf node
                if ((current.left != null) || (current.right != null)) {
                    if (current.left != null) {
                        if (last != null) {
                            last.next = current.left;
                        } else {
                            levelNext = current.left;
                        }
                        last = current.left;
                    }
                    if (current.right != null) {
                        if (last != null) {
                            last.next = current.right;
                        } else {
                            levelNext = current.right;
                        }
                        last = current.right;
                    }
                }
                current = current.next;
            }
            level = levelNext;
            current = level;
            last = null;
            levelNext = null;
        }

        return root;
    }
}
