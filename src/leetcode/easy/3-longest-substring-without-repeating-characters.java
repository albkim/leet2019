/*
Given a string, find the length of the longest substring without repeating characters.

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */

package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lookup = new HashMap<>();
        int maxLength = 0;
        int currentLeft = 0;
        for (int index = 0; index < s.length(); index++) {
            char chr = s.charAt(index);
            if (lookup.containsKey(chr)) {
                // we've seen this before. Therefore we need to start a new substring from the right of the last
                // seen location.
                // One thing to watch out for is that, we could have been the char which is left of the current left.
                // In that case, no need to go backward.
                currentLeft = Math.max(currentLeft, lookup.get(chr) + 1);
            }
            lookup.put(chr, index);
            maxLength = Math.max(maxLength, index - currentLeft + 1);
        }
        return maxLength;
    }
}

/*
Success
Details
Runtime: 47 ms, faster than 36.61% of Java online submissions for Longest Substring Without Repeating Characters.
 */