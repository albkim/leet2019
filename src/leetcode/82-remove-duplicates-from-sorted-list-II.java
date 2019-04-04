/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:
Input: 1->2->3->3->4->4->5
Output: 1->2->5


Example 2:
Input: 1->1->1->2->3
Output: 2->3


 */

package leetcode;

import leetcode.models.ListNode;

class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode anchor = new ListNode(-1);
        ListNode lastAnchor = null;
        while(head != null) {
            ListNode last = getLast(head);
            if (last == head) {
                if (anchor.next == null) {
                    anchor.next = last;
                } else {
                    lastAnchor.next = last;
                }
                lastAnchor = last;
            }
            head = last.next;
        }
        if (lastAnchor != null) {
            lastAnchor.next = null;
        }

        return anchor.next;
    }

    private ListNode getLast(ListNode head) {
        int val = head.val;
        ListNode last = null;
        while ((head != null) && (head.val == val)) {
            last = head;
            head = head.next;
        }
        return last;
    }
}
