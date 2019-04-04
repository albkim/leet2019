/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

 */

package leetcode.easy;

import leetcode.models.ListNode;

class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode anchor = new ListNode(0);

        mergeTwoLists(anchor, l1, l2);

        return anchor.next;
    }

    private void mergeTwoLists(ListNode anchor, ListNode l1, ListNode l2) {
        if ((l1 == null) && (l2 == null)) {
            anchor.next = null;
            return;
        }

        if (l1 == null) {
            anchor.next = l2;
            mergeTwoLists(anchor.next, l1, l2.next);
        } else if (l2 == null) {
            anchor.next = l1;
            mergeTwoLists(anchor.next, l1.next, l2);
        } else {
            if (l1.val < l2.val) {
                anchor.next = l1;
                mergeTwoLists(anchor.next, l1.next, l2);
            } else {
                anchor.next = l2;
                mergeTwoLists(anchor.next, l1, l2.next);
            }
        }
    }
}
