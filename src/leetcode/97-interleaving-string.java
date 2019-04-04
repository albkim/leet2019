/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true


Example 2:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false


See if the current char of s3 matches current char of either s1/s2. Fork and backtrack if either is true
 */

package leetcode;

class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (((s1 == null) || (s1.length() == 0)) && ((s2 == null) || s2.length() == 0) && ((s3 == null) || s3.length() == 0)) {
            return true;
        }

        if ((s1 == null) || (s1.length() == 0)) {
            return s2.equals(s3);
        }
        if ((s2 == null) || (s2.length() == 0)) {
            return s1.equals(s3);
        }

        return isInterleave(s1, s2, s3, 0, 0, 0);
    }

    private boolean isInterleave(String s1, String s2, String s3, int i1, int i2, int i3) {
        if ((s1.length() == i1) && (s2.length() == i2) && (s3.length() == i3)) {
            return true;
        }

        if ((i1 < s1.length()) && (i3 < s3.length()) && (s1.charAt(i1) == s3.charAt(i3))) {
            if (isInterleave(s1, s2, s3, i1 + 1, i2, i3 + 1)) {
                return true;
            }
        }

        if ((i2 < s2.length()) && (i3 < s3.length()) && (s2.charAt(i2) == s3.charAt(i3))) {
            if (isInterleave(s1, s2, s3, i1, i2 + 1, i3 + 1)) {
                return true;
            }
        }

        return false;
    }
}
