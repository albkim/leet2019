/*
Remove all elements from a linked list of integers that have value val.

Example:
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5

 */

package leetcode;

import leetcode.models.ListNode;

class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode anchor = new ListNode(-1);
        ListNode good = anchor;
        anchor.next = head;
        while (head != null) {
            if (head.val != val) {
                good.next = head;
                good = head;
            } else {
                good.next = null;
            }
            head = head.next;
        }

        return anchor.next;
    }
}
