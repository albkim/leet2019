/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:
Input: [5,7]
Output: 4


Example 2:
Input: [0,1]
Output: 0

 */

package leetcode;

class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if ((m == 0) || (m == n)) {
            return m;
        }

        int leftShift = 1;
        while(m != n) {
            m >>= 1;
            n >>= 1;
            leftShift <<= 1;
        }
        return m * leftShift;
    }
}
