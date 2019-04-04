/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to
construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:
•The same word in the dictionary may be reused multiple times in the segmentation.
•You may assume the dictionary does not contain duplicate words.

Example 1:
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]


Example 2:
Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.


Example 3:
Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]

 */

package leetcode;

class WordBreakII {
    public java.util.List<String> wordBreak(String s, java.util.List<String> wordDict) {
        java.util.List<String> result = new java.util.ArrayList<>();
        if ((s == null) || (s.length() == 0)) {
            return result;
        }

        if ((wordDict == null) || (wordDict.size() == 0)) {
            return result;
        }

        java.util.Set<String> dict = new java.util.HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
        }

        java.util.Map<Integer, java.util.List<String>> memoize = new java.util.HashMap<>();
        return wordBreak(s, 0, dict, memoize);
    }

    private java.util.List<String> wordBreak(String s, int index, java.util.Set<String> dict, java.util.Map<Integer, java.util.List<String>> memoize) {
        java.util.List<String> result = new java.util.ArrayList<>();
        if (index == s.length()) {
            // this would ensure that this counts as a result
            result.add("");
            return result;
        }

        if (memoize.containsKey(index)) {
            return memoize.get(index);
        }

        for (int current = index; current < s.length(); current++) {
            String word = s.substring(index, current + 1);
            if (dict.contains(word)) {
                java.util.List<String> subResult = wordBreak(s, current + 1, dict, memoize);
                for (String str : subResult) {
                    StringBuilder sentence = new StringBuilder(word);
                    if (str.length() > 0) {
                        sentence.append(" ");
                    }
                    sentence.append(str);
                    result.add(sentence.toString());
                }
            }
        }

        memoize.put(index, result);
        return result;
    }
}
