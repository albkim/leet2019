/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
1.Open brackets must be closed by the same type of brackets.
2.Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true


Example 2:
Input: "()[]{}"
Output: true


Example 3:
Input: "(]"
Output: false


Example 4:
Input: "([)]"
Output: false


Example 5:
Input: "{[]}"
Output: true

 */

package leetcode.easy;

class ValidParentheses {
    public boolean isValid(String s) {
        java.util.Stack<Character> brackets = new java.util.Stack<>();

        for (char chr : s.toCharArray()) {
            if ((chr == ')') || (chr == '}') || (chr == ']')) {
                if (brackets.empty()) {
                    return false;
                }
                char left = brackets.peek();
                if (((chr == ')') && (left == '(')) || ((chr == ']') && (left == '[')) || ((chr == '}') && (left == '{'))) {
                    brackets.pop();
                    continue;
                }
                return false;
            } else {
                brackets.push(chr);
            }
        }

        return brackets.empty();
    }
}
