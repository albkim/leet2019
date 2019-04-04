/*
Given a non-empty array of integers, every element appears three times except for one,
which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
Input: [2,2,3,2]
Output: 3


Example 2:
Input: [0,1,0,1,0,1,99]
Output: 99



It seems like if we count bits from each number, each should occur multiples of 3 times, except the missing number
 */

package leetcode;

class SingleNumberII {
    public int singleNumber(int[] nums) {
        int n = 3;

        int number = 0;

        for (int bit = 0; bit < 32; bit++) {
            int count = 0;
            for (int num : nums) {
                int bitAt = num >> bit;
                if ((bitAt & 1) == 1) {
                    count++;
                }
            }

            if ((count % n) > 0) {
                number |= (1 << bit);
            }
        }

        return number;
    }
}
