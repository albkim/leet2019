/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
find the duplicate one.

Example 1:
Input: [1,3,4,2,2]
Output: 2


Example 2:
Input: [3,1,3,4,2]
Output: 3

Note:
1.You must not modify the array (assume the array is read only).
2.You must use only constant, O(1) extra space.
3.Your runtime complexity should be less than O(n2).
4.There is only one duplicate number in the array, but it could be repeated more than once.


If we use the value of the array as the index and form a linked list...
0, 1, 2, 3, 4, 5, 6, 7
2, 7, 4, 5, 1, 6, 4, 3

2->4(2)->1(4)->7(1)->3(7)->5(3)->6(5)->4(6)->1(4)

We can see that circular dependency begins at index 4 with value 1. Then this is just finding that starting point.

1, 3, 4, 2, 2
1->3->2->4->2
 */

package leetcode;

class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
