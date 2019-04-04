/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:
Input: 121
Output: true


Example 2:
Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.


Example 3:
Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Follow up:

Could you solve it without converting the integer to a string?

 */

package leetcode.easy;

class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        return x == reverse(x);
    }

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
