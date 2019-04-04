/*
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:
Input: 4
Output: 2


Example 2:
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.


 */

package leetcode;

class SqrtX {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        }

        long left = 1;
        long right = x / 2;
        while(left <= right) {
            long mid = left + ((right - left) >> 1);
            long sqr = mid * mid;
            if (sqr == x) {
                return (int)mid;
            } else if (sqr < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int)Math.min(left, right);
    }
}
