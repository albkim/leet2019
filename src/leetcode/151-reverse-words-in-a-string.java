/*
Given an input string, reverse the string word by word.



Example 1:
Input: "the sky is blue"
Output: "blue is sky the"


Example 2:
Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.


Example 3:
Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.




Note:
•A word is defined as a sequence of non-space characters.
•Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
•You need to reduce multiple spaces between two words to a single space in the reversed string.



Follow up:

For C programmers, try to solve it in-place in O(1) extra space.


reverse whole thing and then reverse words
 */

package leetcode;

class ReverseWordsInAString {
    public String reverseWords(String s) {
        if ((s == null) || (s.length() == 0)) {
            return "";
        }

        Integer lastIndex = null;
        StringBuilder newWords = new StringBuilder();
        for (int index = s.length() - 1; index >= 0; index--) {
            if (s.charAt(index) == ' ') {
                if (lastIndex != null) {
                    if (newWords.length() > 0) {
                        newWords.append(' ');
                    }
                    newWords.append(s.substring(index + 1, lastIndex + 1));
                    lastIndex = null;
                }
            } else {
                if (lastIndex == null) {
                    lastIndex = index;
                }
            }
        }
        if ((s.charAt(0) != ' ') && (lastIndex != null)) {
            if (newWords.length() > 0) {
                newWords.append(' ');
            }
            newWords.append(s.substring(0, lastIndex + 1));
        }
        return newWords.toString();
    }
}
