/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1


as we scan right to left, we want the number to be increasing. Find the first decreasing number. Then we want
to swap it with the lowest number which is greater than itself (so increase is smaller),
then we need to resort the ones afterward.
If all numbers are increasing, then we just need to rotate it.
 */

package leetcode;

class NextPermutation {
    public void nextPermutation(int[] nums) {
        Integer lastNumber = null;

        Integer decreasingIndex = null;
        for (int index = nums.length - 1; index >= 0; index--) {
            if (lastNumber == null) {
                lastNumber = nums[index];
                continue;
            }

            if (lastNumber > nums[index]) {
                decreasingIndex = index;
                break;
            }

            lastNumber = nums[index];
        }

        if (decreasingIndex == null) {
            // all increasing
            java.util.Arrays.sort(nums);
        } else {
            // need to swap;
            int minValue = Integer.MAX_VALUE;
            Integer minIndex = null;
            for (int index = decreasingIndex + 1; index < nums.length; index++) {
                if (nums[index] > nums[decreasingIndex]) {
                    if ((minIndex == null) || (minValue >= nums[index])) {
                        minIndex = index;
                        minValue = nums[index];
                    }
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[decreasingIndex];
            nums[decreasingIndex] = temp;

            java.util.Arrays.sort(nums, decreasingIndex + 1, nums.length);
        }
    }
}
