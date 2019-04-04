/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character but a character may map to itself.

Example 1:
Input: s = "egg", t = "add"
Output: true


Example 2:
Input: s = "foo", t = "bar"
Output: false

Example 3:
Input: s = "paper", t = "title"
Output: true

Note:
 You may assume both s and t have the same length.

 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (((s == null) && (t == null)) || ((s.length() == 0) && (t.length() == 0))) {
            return true;
        }

        Map<Character, Character> mapLeft = new HashMap<>();
        Map<Character, Character> mapRight = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            char sChar = s.charAt(index);
            char tChar = t.charAt(index);
            if (mapLeft.containsKey(sChar) || mapRight.containsKey(tChar)) {
                if ((!mapLeft.containsKey(sChar)) || (!mapRight.containsKey(tChar)) || (mapLeft.get(sChar) != tChar) || (mapRight.get(tChar) != sChar)){
                    return false;
                } else {
                    continue;
                }
            } else {
                mapLeft.put(sChar, tChar);
                mapRight.put(tChar, sChar);
            }
        }

        return true;
    }
}
