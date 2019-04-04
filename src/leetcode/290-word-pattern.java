/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:
Input: pattern = "abba", str = "dog cat cat dog"
Output: true

Example 2:
Input:pattern = "abba", str = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false

Example 4:
Input: pattern = "abba", str = "dog dog dog dog"
Output: false

Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a
 single space.

 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> patternToString = new HashMap<>();
        Map<String, Character> stringToCharacter = new HashMap<>();

        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        for (int index = 0; index < pattern.length(); index++) {
            char chr = pattern.charAt(index);
            String word = words[index];

            if (patternToString.containsKey(chr)) {
                if (!stringToCharacter.containsKey(word)) {
                    return false;
                }
                if (stringToCharacter.get(word) != chr) {
                    return false;
                }
            } else {
                if (stringToCharacter.containsKey(word)) {
                    return false;
                }

                patternToString.put(chr, word);
                stringToCharacter.put(word, chr);
            }
        }

        return true;
    }
}
