/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2


Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1


Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr()
and Java's indexOf().

 */

package leetcode;

class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if ((needle == null) || (needle.length() == 0)) {
            return 0;
        }
        if ((haystack == null) || (haystack.length() == 0)) {
            return -1;
        }

        for (int index = 0; index < haystack.length(); index++) {
            if (strStr(haystack, needle, index, 0)) {
                return index;
            }
        }

        return -1;
    }

    public boolean strStr(String haystack, String needle, int haystackIndex, int needleIndex) {
        if ((haystackIndex == haystack.length()) || (needleIndex == needle.length())) {
            return false;
        }
        if (haystack.charAt(haystackIndex) == needle.charAt(needleIndex)) {
            if (needle.length() - 1 == needleIndex) {
                return true;
            }
            return strStr(haystack, needle, haystackIndex + 1, needleIndex + 1);
        }
        return false;
    }
}
