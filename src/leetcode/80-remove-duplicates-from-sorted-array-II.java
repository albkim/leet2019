/*
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.

Example 2:
Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

It doesn't matter what values are set beyond the returned length.


Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:
// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}


 */

package leetcode;

class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        Integer last = null;
        int lastCount = 0;
        int leftIndex = 0;
        for (int index = 0; index < nums.length; index++) {
            if (last == null) {
                last = nums[index];
                lastCount = 1;
                leftIndex++;
                continue;
            }

            if (last == nums[index]) {
                if (lastCount == 1) {
                    // we now have 2 dupes
                    swap(nums, leftIndex, index);
                    leftIndex++;
                    lastCount++;
                }
                continue;
            }

            last = nums[index];
            lastCount = 1;
            swap(nums, leftIndex, index);
            leftIndex++;
        }

        return leftIndex;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
