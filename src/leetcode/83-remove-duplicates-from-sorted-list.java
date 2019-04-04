/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:
Input: 1->1->2
Output: 1->2


Example 2:
Input: 1->1->2->3->3
Output: 1->2->3


 */

package leetcode;

import leetcode.models.ListNode;

class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode anchor = new ListNode(-1);
        anchor.next = head;

        while (head != null) {
            ListNode next = getNext(head);
            head.next = next;
            head = next;
        }

        if (head != null) {
            head.next = null;
        }

        return anchor.next;
    }

    private ListNode getNext(ListNode head) {
        int val = head.val;
        while((head != null) && (head.val == val)) {
            head = head.next;
        }
        return head;
    }
}
