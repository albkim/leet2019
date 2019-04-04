/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:
Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]


 */

package leetcode;

class PalindromePartitioning {
    public java.util.List<java.util.List<String>> partition(String s) {
        java.util.List<java.util.List<String>> result = new java.util.ArrayList<>();

        if ((s == null) || (s.length() == 0)) {
            return result;
        }

        partition(result, s, 0, new java.util.ArrayList<>());

        return result;
    }

    private void partition(java.util.List<java.util.List<String>> result, String s, int index, java.util.List<String> partitions) {
        if (index == s.length()) {
            // we reached a successful partition
            java.util.List<String> newPartitions = new java.util.ArrayList<>();
            for (String partition : partitions) {
                newPartitions.add(partition);
            }
            result.add(newPartitions);
        }

        for (int sIndex = index; sIndex < s.length(); sIndex++) {
            if (palindrome(s, index, sIndex)) {
                partitions.add(s.substring(index, sIndex + 1));
                partition(result, s, sIndex + 1, partitions);
                partitions.remove(partitions.size() - 1);
            }
        }
    }

    private boolean palindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
