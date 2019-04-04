/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:
Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5


 */

package leetcode;

import leetcode.models.ListNode;

class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode leftAnchor = new ListNode(-1);
        ListNode rightAnchor = new ListNode(-1);

        ListNode currentLeft = leftAnchor;
        ListNode currentRight = rightAnchor;

        while(head != null) {
            if (head.val < x) {
                currentLeft.next = head;
                currentLeft = head;
            } else {
                currentRight.next = head;
                currentRight = head;
            }
            head = head.next;
        }

        currentRight.next = null;
        currentLeft.next = rightAnchor.next;

        return leftAnchor.next;
    }
}
