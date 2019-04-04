/*
Given a singly linked list, determine if it is a palindrome.

Example 1:
Input: 1->2
Output: false

Example 2:
Input: 1->2->2->1
Output: true

Follow up:
 Could you do it in O(n) time and O(1) space?

 */

package leetcode;

import leetcode.models.ListNode;

class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return true;
        }

        ListNode previous = null;
        ListNode slow = head;
        ListNode fast = head;

        while ((slow != null) && (fast != null)) {
            previous = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        ListNode rightHead = previous.next;
        ListNode current = slow;
        // now slow would be at middle node or right side of half. If we reverse from slow (and hold on to previous)
        // we will have the other half lined up. (mid could be last element but we don't care)
        previous = null;
        while(current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        ListNode left = head;
        ListNode right = previous;
        while ((left != null) && (right != null) && (left != rightHead)) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}
