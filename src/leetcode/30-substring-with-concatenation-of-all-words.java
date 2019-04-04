/*
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of
substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:
Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.


Example 2:
Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []

Lookback with trie
 */

package leetcode;

import leetcode.data_structures.Trie;

class SubstringWithConcatenationOfAllWords {
    public java.util.List<Integer> findSubstring(String s, String[] words) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if ((s == null) || (words == null) || (words.length == 0) || (s.length() < (words.length * words[0].length()))) {
            return result;
        }

        java.util.Map<String, Integer> count = new java.util.HashMap<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
            if (count.containsKey(word)) {
                count.put(word, count.get(word) + 1);
            } else {
                count.put(word, 1);
            }
        }

        int increment = words[0].length();
        for (int index = 0; index < s.length(); index++) {
            if (isValid(s, index, increment, trie, count)) {
                result.add(index);
            }
        }

        return result;
    }

    private boolean isValid(String s, int index, int increment, Trie trie, java.util.Map<String, Integer> count) {
        if (count.size() == 0) {
            return true;
        }
        if ((index + increment) > s.length()) {
            return false;
        }

        String word = s.substring(index, (index + increment));
        if (trie.contains(word)) {
            return false;
        }

        if (count.containsKey(word)) {
            int newCount = count.get(word) - 1;
            if (newCount == 0) {
                count.remove(word);
            } else {
                count.put(word, newCount);
            }

            boolean isValid = isValid(s, index + increment, increment, trie, count);

            if (newCount == 0) {
                count.put(word, 1);
            } else {
                count.put(word, count.get(word) + 1);
            }

            if (isValid) {
                return true;
            }
        }

        return false;
    }
}
