/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

We need to combine min heap with the linked list and perform remove & insert
 */

package leetcode.easy;

import leetcode.data_structures.ListNodeMinHeap;
import leetcode.models.ListNode;

class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode anchor = new ListNode(0);

        ListNodeMinHeap minHeap = new ListNodeMinHeap(lists.length);
        for(ListNode node : lists) {
            if (node != null) {
                minHeap.insert(node);
            }
        }

        ListNode current = anchor;
        while(minHeap.getCurrentSize() > 0) {
            ListNode min = minHeap.popMin();
            current.next = min;
            if (min.next != null) {
                minHeap.insert(min.next);
            }
            current = current.next;
        }

        return anchor.next;
    }

}
