/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear
exactly twice. Find the two elements that appear only once.

Example:
Input:  [1,2,1,3,2,5]
Output: [3,5]

Note:
1.The order of the result is not important. So in the above example, [5, 3] is also correct.
2.Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?



 This is cute. If we XOR (similar to I) all numbers, we get XOR of two numbers. Then if we can find  any 1 bit this is
 distinct to only one of the numbers. Now if we separate the numbers into two groups which has this bit and which does not.
 The problem degrades to I performed on two groups
 */

package leetcode;

class SingleNumberIII {
    public int[] singleNumber(int[] nums) {

        long xor = 0;
        for (int num : nums) {
            xor ^= (long)num;
        }

        // find a bit
        int shift = 0;
        while(xor != 0) {
            if (((xor >> shift) & 1) == 1) {
                break;
            }
            shift++;
        }

        long xor1 = 0;
        long xor2 = 0;
        for (int num : nums) {
            if ((((long)num >> shift) & 1) == 1) {
                xor1 ^= (long)num;
            }
            else {
                xor2 ^= (long)num;
            }
        }

        return new int[] {(int)xor1, (int)xor2};
    }
}
