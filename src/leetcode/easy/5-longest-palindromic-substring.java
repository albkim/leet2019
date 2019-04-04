/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.


Example 2:
Input: "cbbd"
Output: "bb"

 */

package leetcode.easy;

class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;

        if ((s == null) || (s.length() == 0)) {
            return "";
        }
        char[] chrs = s.toCharArray();
        for (int index = 0; index < chrs.length - 1; index++) {
            int length = palindromeLength(chrs, index, index);
            if (length > maxLength) {
                maxLength = length;
                int half = length / 2;
                left = index - half;
                right = index + half;
            }
            if (chrs[index] == chrs[index + 1]) {
                length = palindromeLength(chrs, index, index + 1);
                if (length > maxLength) {
                    maxLength = length;
                    int half = length / 2;
                    left = index - (half - 1);
                    right = index + half;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public int palindromeLength(char[] chrs, int left, int right) {
        int length = 1;
        while(left >= 0 && right < chrs.length) {
            if (chrs[left] == chrs[right]) {
                length = right - left + 1;
                left--;
                right++;
            } else {
                break;
            }
        }
        return length;
    }
}
