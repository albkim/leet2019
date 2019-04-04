/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":
    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t


To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t


We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a


We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

Example 1:
Input: s1 = "great", s2 = "rgeat"
Output: true


Example 2:
Input: s1 = "abcde", s2 = "caebd"
Output: false


We can recursively check the following
L | R == L | R
OR L | R == R || L


DP
    g r e a t

r     T
g   T
t           T
a         T
e       T

 */

package leetcode;

import com.sun.org.apache.xpath.internal.operations.Bool;

class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if ((s1 == null) && (s2 == null)) {
            return true;
        } else if ((s1 == null) || (s2 == null)) {
            return false;
        }

        // return isScramble(s1, s2, 0, s1.length() - 1, 0, s2.length() - 1);
        Boolean[][][][] dp = new Boolean[s1.length()][s1.length()][s2.length()][s2.length()];
        return isScrambleMemoize(s1, s2, 0, s1.length() - 1, 0, s2.length() - 1, dp);
    }

    private boolean isScramble(String s1, String s2, int s1Start, int s1End, int s2Start, int s2End) {
        if ((s1Start == s1End) && (s2Start == s2End)) {
            return s1.charAt(s1Start) == s2.charAt(s2Start);
        }

        // find the pivot point and see if leafs are scrambled.
        for (int index = 0; index < (s1End - s1Start); index++) {
            // non scramble
            boolean left = isScramble(s1, s2, s1Start, s1Start + index, s2Start, s2Start + index);
            boolean right = isScramble(s1, s2, s1Start + index + 1, s1End, s2Start + index + 1, s2End);
            if (left && right) {
                return true;
            }

            // scrambled
            left = isScramble(s1, s2, s1Start, s1Start + index, s2End - index, s2End);
            right = isScramble(s1, s2, s1Start + index + 1, s1End, s2Start, s2End - index - 1);
            if (left && right) {
                return true;
            }
        }

        return false;
    }

    private boolean isScrambleMemoize(String s1, String s2, int s1Start, int s1End, int s2Start, int s2End, Boolean[][][][] dp) {
        if (dp[s1Start][s1End][s2Start][s2End] != null) {
            return dp[s1Start][s1End][s2Start][s2End];
        }

        if ((s1Start == s1End) && (s2Start == s2End)) {
            boolean singleEqual = s1.charAt(s1Start) == s2.charAt(s2Start);
            dp[s1Start][s1End][s2Start][s2End] = singleEqual;
            return singleEqual;
        }

        // find the pivot point and see if leafs are scrambled.
        for (int index = 0; index < (s1End - s1Start); index++) {
            // non scramble
            boolean left = isScrambleMemoize(s1, s2, s1Start, s1Start + index, s2Start, s2Start + index, dp);
            boolean right = isScrambleMemoize(s1, s2, s1Start + index + 1, s1End, s2Start + index + 1, s2End, dp);
            if (left && right) {
                dp[s1Start][s1End][s2Start][s2End] = true;
                return true;
            }

            // scrambled
            left = isScrambleMemoize(s1, s2, s1Start, s1Start + index, s2End - index, s2End, dp);
            right = isScrambleMemoize(s1, s2, s1Start + index + 1, s1End, s2Start, s2End - index - 1, dp);
            if (left && right) {
                dp[s1Start][s1End][s2Start][s2End] = true;
                return true;
            }
        }

        dp[s1Start][s1End][s2Start][s2End] = false;
        return false;
    }
}
