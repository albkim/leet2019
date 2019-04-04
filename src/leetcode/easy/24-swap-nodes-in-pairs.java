/*
Given a linked list, swap every two adjacent nodes and return its head.

Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.

Note:
•Your algorithm should use only constant extra space.
•You may not modify the values in the list's nodes, only nodes itself may be changed.

 */

package leetcode.easy;

import leetcode.models.ListNode;

class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        return swapPairsInternal(head);
    }

    private ListNode swapPairsInternal(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return null;
        }

        ListNode nextTwo = swapPairs(head.next.next);
        ListNode next = head.next;
        head.next = nextTwo;
        next.next = head;

        return next;
    }
}
