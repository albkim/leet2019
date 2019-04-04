/*
Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
Find and return the shortest palindrome you can find by performing this transformation.

Example 1:
Input: "aacecaaa"
Output: "aaacecaaa"


Example 2:
Input: "abcd"
Output: "dcbabcd"

 */

package leetcode;

class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if ((s == null) || (s.length() == 0)) {
            return "";
        }

        StringBuilder result = new StringBuilder(s);
        int right = longestPalindrome(s) + 1;
        for (int index = right; index < s.length(); index++) {
            result.insert(0, s.charAt(index));
        }
        return result.toString();
    }

    private int longestPalindrome(String s) {
        int max = 0;
        for (int index = 0; index < s.length(); index++) {
            if (isPalindrome(s, 0, index)) {
                max = index;
            }
        }
        return max;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
