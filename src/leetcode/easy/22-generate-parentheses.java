/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

Do some accounting with backtracking variation. +1 when we open, -1 when we close. As long as we don't go negative,
it's possible that we could make it.

 */

package leetcode.easy;

class GenerateParentheses {
    public java.util.List<String> generateParenthesis(int n) {
        java.util.List<String> result = new java.util.ArrayList<>();
        if (n <= 0) {
            return result;
        }

        generateParenthesis(result, "(", n, 1, 1, 0);
        return result;
    }

    private void generateParenthesis(java.util.List<String> result, String current, int target, int allowance, int open, int close) {
        if ((target == open) && (target == close)) {
            if (allowance == 0) {
                result.add(current);
            }
            return;
        }

        if (allowance < 0) {
            return;
        }

        if (open < target) {
            generateParenthesis(result, current + "(", target, allowance + 1, open + 1, close);
        }

        if (close < target) {
            generateParenthesis(result, current + ")", target, allowance - 1, open, close + 1);
        }
    }
}
