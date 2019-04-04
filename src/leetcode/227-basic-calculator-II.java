/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
The integer division should truncate toward zero.

Example 1:
Input: "3+2*2"
Output: 7


Example 2:
Input: " 3/2 "
Output: 1

Example 3:
Input: " 3+5 / 2 "
Output: 5


Note:
•You may assume that the given expression is always valid.
•Do not use the eval built-in library function.

 */

package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BasicCalculatorII {
    public int calculate(String s) {
        if ((s == null) || (s.length() == 0)) {
            return 0;
        }

        String operator = null;
        Stack<String> expression = new Stack();
        StringBuilder str = new StringBuilder();
        for (char chr : s.toCharArray()) {
            if ((chr == '+') || (chr == '-') || (chr == '*') || (chr == '/')) {
                processStr(operator, expression, str);
                operator = String.valueOf(chr);
                expression.add(operator);
            } else if (chr == ' ') {
                processStr(operator, expression, str);
            } else {
                str.append(chr);
            }
        }
        processStr(operator, expression, str);

        List<String> exp = new ArrayList<>();
        while(!expression.isEmpty()) {
            exp.add(0, expression.pop());
        }

        int result = Integer.parseInt(exp.get(0));
        for (int index = 2; index < exp.size(); index += 2) {
            int right = Integer.parseInt(exp.get(index));
            String op = exp.get(index - 1);
            if (op.equals("+")) {
                result += right;
            } else {
                result -= right;
            }
        }
        return result;
    }

    private int evaluate(Stack<String> expression) {
        int right = Integer.parseInt(expression.pop());
        String operator = expression.pop();
        int left = Integer.parseInt(expression.pop());

        if (operator.equals("*")) {
            return left * right;
        } else {
            return left / right;
        }
    }

    private void processStr(String operator, Stack<String> expression, StringBuilder str) {
        if (str.length() > 0) {
            expression.add(str.toString());

            if (operator != null) {
                if ((operator.equals("*")) || (operator.equals("/"))) {
                    expression.add(String.valueOf(evaluate(expression)));
                }
            }
        }
        str.replace(0, str.length(), "");
    }
}
