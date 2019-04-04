/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
'.' Matches any single character.
'*' Matches zero or more of the preceding element.


The matching should cover the entire input string (not partial).

Note:
•s could be empty and contains only lowercase letters a-z.
•p could be empty and contains only lowercase letters a-z, and characters like . or *.

Example 1:
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".


Example 2:
Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".


Example 3:
Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".


Example 4:
Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".


Example 5:
Input:
s = "mississippi"
p = "mis*is*p*."
Output: false


 */

package leetcode.hard;

class RegularExpressionMatching {
    public boolean isMatch(String s, String p) throws Exception {
        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    public boolean isMatch(char[] s, char[] p, int sIndex, int pIndex) throws Exception {
        // handle 0 length on both
        if ((sIndex >= s.length) && (pIndex >= p.length)) {
            return true;
        }
        // handle zero length pattern...meaning we have more string than pattern available
        if (pIndex >= p.length) {
            return false;
        }

        // handle "*" or "**"
        if ((p[pIndex] == '*') && ((pIndex == 0) || (p[pIndex - 1] == '*'))) {
            throw new Exception("Invalid pattern");
        }

        // handle current + *
        if ((pIndex < (p.length - 1)) && (p[pIndex + 1] == '*')) {
            if (isMatch(s, p, sIndex, pIndex + 2)) {
                return true;
            }
            int sNewIndex = sIndex;
            while ((sNewIndex < s.length) && ((s[sNewIndex] == p[pIndex]) || (p[pIndex] == '.'))) {
                sNewIndex++;
                if (isMatch(s, p, sNewIndex, pIndex)) {
                    return true;
                }
            }
        }

        // now we should check length of s, if length is 0, we have extra pattern
        if (sIndex >= s.length) {
            return false;
        }

        if ((s[sIndex] == p[pIndex]) || (p[pIndex] == '.')) {
            return isMatch(s, p, sIndex + 1, pIndex + 1);
        }

        return false;
    }
}
