/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.



Example:


BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false




Note:
•next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
•You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.

 */

package leetcode;

import leetcode.models.TreeNode;

import java.util.Stack;

class BSTIterator {

    private Stack<TreeNode> stack;
    private TreeNode current;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        this.current = root;
        this.traverse();
    }

    /** @return the next smallest number */
    public int next() {
        this.current = this.stack.pop();
        int val = this.current.val;
        this.current = this.current.right;
        this.traverse();
        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.stack.empty();
    }

    private void traverse() {
        while (this.current != null) {
            this.stack.push(this.current);
            this.current = this.current.left;
        }
    }
}
