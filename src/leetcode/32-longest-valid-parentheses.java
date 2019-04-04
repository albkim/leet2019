/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"


Example 2:
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"


 */

package leetcode;

class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int longest = 0;
        for (int index = 0; index < s.length(); index++) {
            java.util.Stack<Character> stack = new java.util.Stack<>();
            int length = longestParentheses(s, index, 0, stack) - index;
            longest = Math.max(longest, length);
        }
        return longest;
    }

    private int longestParentheses(String s, int index, int candidate, java.util.Stack<Character> stack) {
        if (index >= s.length()) {
            if (stack.empty()) {
                return index;
            }
            return candidate;
        }

        if (s.charAt(index) == '(') {
            if (stack.empty()) {
                candidate = index;
            }
            stack.push('(');
        } else {
            if (stack.empty()) {
                return index;
            }
            if (stack.peek() == '(') {
                stack.pop();
            } else {
                return candidate;
            }
        }

        return longestParentheses(s, index + 1, candidate, stack);
    }
}
