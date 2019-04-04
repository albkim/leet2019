/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:
•Only constant extra memory is allowed.
•You may not alter the values in the list's nodes, only nodes itself may be changed.

 */

package leetcode;

import leetcode.models.ListNode;

class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // handle cases where we have left overs which returns the head. Also since k >= length, we cannot have
        // list shorter than k, so we don't need to do this check
        ListNode current = head;
        for(int count = 0; count < (k - 1); count++) {
            if (current == null) {
                return head;
            }
            current = current.next;
        }

        if (current == null) {
            return head;
        }

        ListNode nextNext = reverseKGroup(current.next, k);

        current = reverse(head, k);

        head.next = nextNext;

        return current;
    }

    private ListNode reverse(ListNode head, int k) {
        if (k == 0) {
            return null;
        }
        if (k == 1) {
            return head;
        }

        ListNode next = head.next;
        ListNode newHead = reverse(next, k - 1);
        next.next = head;
        return newHead;
    }
}
