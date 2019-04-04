/*
Given an integer n, return the number of trailing zeroes in n!.

Example 1:
Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.

Example 2:
Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.

Note: Your solution should be in logarithmic time complexity.


 1 x 2 = 2
 2 x 3 = 6
 6 x 4 = 24
 24 x 5 = 120
 120 x 6 = 720
 720 x 7 = 4320
 4320 x 8 = 43560

 looks like we get additional trailing 0 when we get 5, 10, 15 and etc

 The problem comes if we hit power of 5 like 25...

 */

package leetcode;

class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;

        while (n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }
}
