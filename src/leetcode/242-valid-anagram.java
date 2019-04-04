/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true


Example 2:
Input: s = "rat", t = "car"
Output: false


Note:
 You may assume the string contains only lowercase alphabets.

Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?

 */

package leetcode;

import java.util.Arrays;

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if ((s == null) && (t == null)) {
            return true;
        }
        if ((s == null) || (t == null)) {
            return false;
        }

        char[] charS = s.toCharArray();
        Arrays.sort(charS);
        String sSorted = new String(charS);

        char[] charT = t.toCharArray();
        Arrays.sort(charT);
        String tSorted = new String(charT);

        return sSorted.equals(tSorted);
    }
}
