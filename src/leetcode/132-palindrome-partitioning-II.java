/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:
Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.



greedily find longest palindrome in each iteration and use the dp to update the min cut

   a  a  b
0  1  1  2
 */

package leetcode;

class PalindromePartitioningII {
    public int minCut(String s) {
        if ((s == null) || (s.length() == 0)) {
            return 0;
        }

        // leave for -1 which would be boundary
        int[] dp = new int[s.length() + 1];
        for (int index = 1; index <= s.length(); index++) {
            dp[index] = Integer.MAX_VALUE;
        }
        for (int index = 0; index < s.length(); index++) {
            // for every palindrome, set set min cut on right edge, using dp from left edge.
            whilePalindrome(dp, s, index, index);
            if (index < (s.length() - 1)) {
                whilePalindrome(dp, s, index, index + 1);
            }
        }

        return dp[s.length()] - 1;
    }

    private void whilePalindrome(int[] dp, String s, int left, int right) {
        while ((left >= 0) && (right < s.length()) && (s.charAt(left) == s.charAt(right))) {
            dp[right + 1] = Math.min(dp[right + 1], dp[left] + 1);
            left--;
            right++;
        }
    }
}
