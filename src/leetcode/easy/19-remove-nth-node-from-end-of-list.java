/*
Given a linked list, remove the n-th node from the end of list and return its head.

Example:
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.


Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?

 */

package leetcode.easy;

import leetcode.models.ListNode;

class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode anchor = new ListNode(0);
        anchor.next = head;

        removeNthFromEnd(head, anchor, n);

        return anchor.next;
    }

    private int removeNthFromEnd(ListNode current, ListNode anchor, int n) {
        if (current == null) {
            return 1;
        }

        int order = removeNthFromEnd(current.next, current, n);

        if (order == n) {
            anchor.next = current.next;
        }

        return order + 1;
    }
}
