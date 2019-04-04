/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: ["flower","flow","flight"]
Output: "fl"


Example 2:
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Note:

All given inputs are in lowercase letters a-z.

 */

package leetcode.easy;

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();

        int index = 0;
        boolean loop = true;
        while(loop) {
            Character chr = null;
            for (int strIndex = 0; strIndex < strs.length; strIndex++) {
                if (index >= strs[strIndex].length()) {
                    loop = false;
                    break;
                }
                if (strIndex == 0) {
                    chr = strs[strIndex].charAt(index);
                } else {
                    if (chr != strs[strIndex].charAt(index)) {
                        loop = false;
                        break;
                    }
                }
            }
            if (loop) {
                result.append(chr);
                index++;
            }
        }

        return result.toString();
    }
}
