/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321


Example 2:
Input: -123
Output: -321


Example 3:
Input: 120
Output: 21


Note:
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 */

package leetcode.easy;

class ReverseInteger {
    public int reverse(int x) {
        long result = 0;
        int sign = (x < 0) ? -1 : 1;
        if (x < 0) {
            x *= -1;
        }
        while (x > 0) {
            if (result > 0) {
                result *= 10;
            }
            int remainder = x % 10;
            result += remainder;
            x /= 10;
        }
        result *= sign;
        if ((result > Integer.MAX_VALUE) || (result < Integer.MIN_VALUE)) {
            return 0;
        }
        return (int)result;
    }
}
