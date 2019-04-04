/*
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:
Input: dividend = 10, divisor = 3
Output: 3

Example 2:
Input: dividend = 7, divisor = -3
Output: -2

Note:
•Both dividend and divisor will be 32-bit signed integers.
•The divisor will never be 0.
•Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.


Binary search based on multiple of divisor
 */

package leetcode;

class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = (((divisor < 0) && (dividend < 0)) || ((divisor > 0) && (dividend > 0))) ? 1 : -1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int left = 1;
        int right = dividend;

        if ((dividend == 0) || (dividend < divisor)) {
            return 0;
        }

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long multiple = multiply(divisor, mid);
            if (multiple == dividend) {
                return (sign < 0) ? (0 - mid) : mid;
            } else if (multiple > dividend) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int lower = Math.min(left, right);
        return (sign < 0) ? (0 - lower) : lower;
    }

    private long multiply(int base, int number) {
        long sum = 0;
        for (long count = 0; count < number; count++) {
            sum += base;
        }
        return sum;
    }
}
