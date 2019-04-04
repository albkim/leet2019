/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:
•The same word in the dictionary may be reused multiple times in the segmentation.
•You may assume the dictionary does not contain duplicate words.

Example 1:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".


Example 2:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.


Example 3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false


 */

package leetcode;

class WordBreak {
    public boolean wordBreak(String s, java.util.List<String> wordDict) {
        if ((s == null) || (s.length() == 0)) {
            return true;
        }

        if ((wordDict == null) || (wordDict.size() == 0)) {
            return false;
        }

        java.util.Set<String> dict = new java.util.HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
        }

        Boolean[] memoize = new Boolean[s.length()];
        return wordBreak(s, 0, dict, memoize);
    }

    private boolean wordBreak(String s, int index, java.util.Set<String> dict, Boolean[] memoize) {
        if (index == s.length()) {
            return true;
        }

        if (memoize[index] != null) {
            return memoize[index];
        }

        for (int current = index; current < s.length(); current++) {
            if (dict.contains(s.substring(index, current + 1))) {
                if (wordBreak(s, current + 1, dict, memoize)) {
                    memoize[index] = true;
                    return true;
                }
            }
        }

        memoize[index] = false;
        return false;
    }
}
