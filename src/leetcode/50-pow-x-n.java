/*
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:
Input: 2.00000, 10
Output: 1024.00000


Example 2:
Input: 2.10000, 3
Output: 9.26100


Example 3:
Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25


Note:
•-100.0 < x < 100.0
•n is a 32-bit signed integer, within the range [−231, 231 − 1]



 n = 2 * n/2 + n%2

 pow(x, n) = pow(x, 2 * n/2 + n%2) = pow(x, 2 * n/2) * pow(n%2) = pow(pow(x, n/2), 2) * pow(n%2)

 note the second power can only be 0 or 1 which is it's either 1 or x
 */

package leetcode;

class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            // handle overflow
            return 1 / (x * (myPow(x, -1 * (n + 1))));
        }

        double y = myPow(x, n/2);
        double z = y * y;

        return (n%2 == 0) ? z : (z * x);
    }
}
