/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26


Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:
Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).


Example 2:
Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

 */

package leetcode;

class DecodeWays {
    public int numDecodings(String s) {
        if ((s == null) || (s.length() == 0)) {
            return 0;
        }

        return numDecodings(s, 0);
    }

    private int numDecodings(String s, int index) {
        if (index == s.length()) {
            return 1;
        }

        int total = 0;

        // if we have 10, we can't count 0
        if (s.charAt(index) == '0') {
            return 0;
        }

        total += numDecodings(s, index + 1);

        if (index < (s.length() - 1)) {
            int doubleDigit = Integer.parseInt(s.substring(index, index + 2));
            if (doubleDigit <= 26) {
                total += numDecodings(s, index + 2);
            }
        }

        return total;
    }
}
