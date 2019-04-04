/*
Given an integer, write a function to determine if it is a power of two.

Example 1:
Input: 1
Output: true
Explanation: 2^0 = 1


Example 2:
Input: 16
Output: true
Explanation: 2^4 = 16

Example 3:
Input: 218
Output: false

 */

package leetcode;

class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        for (int power = 0; power < 32; power++) {
            long result = (long)Math.pow(2, power);
            if (n == result) {
                return true;
            }
            if (result > n) {
                break;
            }
        }
        return false;
    }
}
