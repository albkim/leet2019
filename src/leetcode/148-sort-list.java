/*
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:
Input: 4->2->1->3
Output: 1->2->3->4


Example 2:
Input: -1->5->3->4->0
Output: -1->0->3->4->5

 */

package leetcode;

import leetcode.models.ListNode;

class SortList {
    public ListNode sortList(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // at least two elements
        // cut the list in half...this this a lot
        ListNode previous = null;
        ListNode slow = head;
        ListNode fast = head;
        while((slow != null) && (fast != null)) {
            previous = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        // now head holds one copy and slow holds another, cut it!
        previous.next = null;

        // sort eash side
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        // merge
        ListNode anchor = new ListNode(-1);
        ListNode newHead = anchor;
        while ((left != null) || (right != null)) {
            // 3 case, either one of them is null or both are not null and i should compare
            if ((left != null) && (right != null)) {
                if (left.val < right.val) {
                    newHead.next = left;
                    left = left.next;
                }
                else {
                    newHead.next = right;
                    right = right.next;
                }
            }
            else if (left == null) {
                newHead.next = right;
                right = right.next;
            }
            else {
                newHead.next = left;
                left = left.next;
            }

            newHead = newHead.next;
        }

        return anchor.next;
    }
}
