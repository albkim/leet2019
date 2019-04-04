/*
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:
Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^


Example 2:
Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^


 */


package leetcode;

class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if ((s == null) && (t == null)) {
            return 0;
        }
        if ((s == null) || (t == null)) {
            return 1;
        }

        Integer[][] cache = new Integer[s.length() + 1][t.length() + 1];
        return numDistinct(s, t, 0, 0, cache);
    }

    private int numDistinct(String s, String t, int sIndex, int tIndex, Integer[][] cache) {
        if (cache[sIndex][tIndex] != null) {
            return cache[sIndex][tIndex];
        }
        if (tIndex == t.length()) {
            return 1;
        }
        if (sIndex == s.length()) {
            return 0;
        }

        int total = 0;
        if (s.charAt(sIndex) == t.charAt(tIndex)) {
            total += numDistinct(s, t, sIndex + 1, tIndex + 1, cache);
        }
        total += numDistinct(s, t, sIndex + 1, tIndex, cache);

        cache[sIndex][tIndex] = total;
        return total;
    }
}
