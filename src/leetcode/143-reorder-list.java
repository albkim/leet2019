/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:
Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.


 */

package leetcode;

import leetcode.models.ListNode;

class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode turtle = head;
        ListNode hare = head;

        while((turtle != null) && (hare != null)) {
            turtle = turtle.next;
            hare = hare.next;
            if (hare != null) {
                hare = hare.next;
            }

            if ((hare != null) && (hare.next == null)) {
                break;
            }
        }

        if (turtle == null) {
            // we didn't get to go anywhere (1 node)
            return;
        }

        // cut link and reverse
        ListNode reversed = reverse(turtle.next);
        turtle.next = null;

        // stitch them together.
        ListNode current = head;
        while((current != null) && (reversed != null)) {
            ListNode next = current.next;
            ListNode reversedNext = reversed.next;
            current.next = reversed;
            reversed.next = next;

            current = next;
            reversed = reversedNext;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode newHead = reverse(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}
