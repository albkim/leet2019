/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).


The matching should cover the entire input string (not partial).

Note:
•s could be empty and contains only lowercase letters a-z.
•p could be empty and contains only lowercase letters a-z, and characters like ? or *.

Example 1:
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".


Example 2:
Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.


Example 3:
Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.


Example 4:
Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".


Example 5:
Input:
s = "acdcb"
p = "a*c?b"
Output: false

DP Solution
    a
  T F
a F T
a F F

    *
  T T
a F T
a F T

    ? a
  T F F
c F T F
b F F F

    * a * b
  T T F F F
a F T T T F
d F T F T F
c F T F T F
e F T F T F
b F T F T T

    a * c ? b
  T F F F F F
a F T T F F F
c F F T T F F
d F F T F T F
c F F T T F F
b F F T F T F
 */

package leetcode;

class WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean sEmpty = (s == null) || (s.length() == 0);
        boolean pEmpty = (p == null) || (p.length() == 0);
        if ((sEmpty) && (pEmpty)) {
            return true;
        }
        if (pEmpty) {
            // to handle cases like "", "*"
            return false;
        }

        // return isMatch(s, p, 0, 0);
        return isMatchDP(s, p);
    }

    private boolean isMatch(String s, String p, int sIndex, int pIndex) {
        boolean sDone = sIndex >= s.length();
        boolean pDone = pIndex >= p.length();
        if (sDone && pDone) {
            return true;
        }
        if (pDone || (sDone && p.charAt(pIndex) != '*')) {
            return false;
        }

        if (p.charAt(pIndex) == '*') {
            // wild card pattern

            // try empty and multiple occurrence
            int sMultiIndex = sIndex;
            while (sMultiIndex <= s.length()) {
                if (isMatch(s, p, sMultiIndex, pIndex + 1)) {
                    return true;
                }
                sMultiIndex++;
            }
        } else if ((s.charAt(sIndex) == p.charAt(pIndex)) || (p.charAt(pIndex) == '?')){
            return isMatch(s, p, sIndex + 1, pIndex + 1);
        }

        return false;
    }

    private boolean isMatchDP(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        // horizontally, we have exp, and 0 length string. If we have a series of "*" this row
        // would be true, until we hit a non wildcard
        for (int pIndex = 1; pIndex <= p.length(); pIndex++) {
            if (p.charAt(pIndex - 1) != '*') {
                break;
            }
            dp[0][pIndex] = true;
        }

        // vertically, we have string and 0 length exp. This should always be false;
        // dp[sIndex][0] = false;

        // now do this for each cell
        for (int sIndex = 1; sIndex <= s.length(); sIndex++) {
            for (int pIndex = 1; pIndex <= p.length(); pIndex++) {
                char sChar = s.charAt(sIndex - 1);
                char pChar = p.charAt(pIndex - 1);

                if (pChar == '*') {
                    // this case, we consider 0 (result at previous pattern) and multiple (result at previous string)
                    dp[sIndex][pIndex] = dp[sIndex][pIndex - 1] || dp[sIndex - 1][pIndex];
                } else {
                    // what was previous pattern & string + current
                    dp[sIndex][pIndex] = dp[sIndex - 1][pIndex - 1] && ((sChar == pChar) || (pChar == '?'));
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
