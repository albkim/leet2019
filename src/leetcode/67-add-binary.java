/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"

 */

package leetcode;

class AddBinary {
    public String addBinary(String a, String b) {
        if ((a == null) || (a.length() == 0)) {
            return b;
        }
        if ((b == null) || (b.length() == 0)) {
            return a;
        }

        StringBuilder aChars = new StringBuilder(a);
        StringBuilder bChars = new StringBuilder(b);
        aChars.reverse();
        bChars.reverse();

        int carry = 0;
        int max = Math.max(aChars.length(), bChars.length());
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < max; index++) {
            int left = (index < aChars.length()) ? Character.getNumericValue(aChars.charAt(index)) : 0;
            int right = (index < bChars.length()) ? Character.getNumericValue(bChars.charAt(index)) : 0;

            int current = left + right + carry;
            carry = current / 2;
            result.append(current % 2);
        }

        if (carry > 0) {
            result.append(carry);
        }

        result.reverse();

        return result.toString();
    }
}
