/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

/*
Things to watch out for

Make sure next nodes are checked for null ref before setting
[1,8],[0] would cause null ref without 38 & 41
Make sure carry can be a condition which could advance the iteration
[5],[5] => [0,1] not [0]
 */

package leetcode.easy;

import leetcode.models.ListNode;

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // non-empty so no need for validation
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0: l2.val) + carry;
            current.next = new ListNode(sum % 10);

            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            current = current.next;
        }
        return result.next;
    }
}

/*
Success
Details
Runtime: 38 ms, faster than 35.85% of Java online submissions for Add Two Numbers.
*/