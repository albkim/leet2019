/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL


 */

package leetcode;

import leetcode.models.ListNode;

class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }

        ListNode anchor = new ListNode(-1);
        anchor.next = head;

        // handle m == 1
        ListNode mNodeLeft = (m == 1) ? anchor : null;
        ListNode nNode = null;

        int count = 1;
        while(nNode == null) {
            if (count == (m - 1)) {
                mNodeLeft = head;
            } else if (count == n) {
                nNode = head;
            }
            head = head.next;
            count++;
        }

        ListNode mNode = mNodeLeft.next;
        ListNode nNodeRight = nNode.next;

        reverse(mNode, nNode);

        mNodeLeft.next = nNode;
        mNode.next = nNodeRight;

        return anchor.next;
    }

    private ListNode reverse(ListNode head, ListNode nNode) {
        if (head == nNode) {
            return nNode;
        }

        ListNode next = head.next;
        ListNode newHead = reverse(next, nNode);
        next.next = head;
        return newHead;
    }
}
