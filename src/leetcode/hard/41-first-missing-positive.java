/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:
Input: [1,2,0]
Output: 3


Example 2:
Input: [3,4,-1,1]
Output: 2


Example 3:
Input: [7,8,9,11,12]
Output: 1


Note:

Your algorithm should run in O(n) time and uses constant extra space.


The key here is that, it has to start from 1, meaning if we fill the same array, it has to start from 1...
that also means we can ignore any numbers greater than the size of the array (since it implies, we have
something lower that's missing)
 */

package leetcode.hard;

class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        int index = 0;
        while(index < nums.length) {
            int num = nums[index];
            int newIndex = num - 1;
            if (newIndex == index) {
                index++;
            } else if ((newIndex < nums.length) && (num > 0)) {
                int temp = nums[newIndex];
                // detect duplicate
                if (temp == num) {
                    index++;
                    continue;
                }
                nums[newIndex] = num;
                nums[index] = temp;
            } else {
                // either 0, negative or greater than size of array
                nums[index] = 0;
                index++;
            }
        }

        for (int missingIndex = 0; missingIndex < nums.length; missingIndex++) {
            if (nums[missingIndex] == 0) {
                return missingIndex + 1;
            }
        }

        return nums.length + 1;
    }
}
