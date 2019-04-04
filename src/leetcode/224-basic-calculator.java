/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:
Input: "1 + 1"
Output: 2


Example 2:
Input: " 2-1 + 2 "
Output: 3

Example 3:
Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note: •You may assume that the given expression is always valid.
•Do not use the eval built-in library function.

 */


package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BasicCalculator {
    public int calculate(String s) {
        if ((s == null) || (s.length() == 0)) {
            return 0;
        }

        StringBuilder str = new StringBuilder();
        Stack<String> expression = new Stack<>();
        for (char chr : s.toCharArray()) {
            if (chr == '(') {
                expression.add("(");
            } else if (chr == ')') {
                processStr(expression, str);
                expression.add(String.valueOf(evaluate(getExpression(expression))));
            } else if ((chr == '+') || (chr == '-')) {
                processStr(expression, str);
                expression.add(String.valueOf(chr));
            } else if (chr == ' ') {
                processStr(expression, str);
            } else {
                str.append(chr);
            }
        }
        processStr(expression, str);

        return evaluate(getExpression(expression));
    }

    private int evaluate(List<String> expression) {
        long current = Integer.parseInt(expression.get(0));

        for (int index = 2; index < expression.size(); index += 2) {
            int now = Integer.parseInt(expression.get(index));
            String operation = expression.get(index - 1);
            if (operation.equals("+")) {
                current += now;
            } else {
                current -= now;
            }
        }

        return (int)current;
    }

    private void processStr(Stack<String> expression, StringBuilder str) {
        if (str.length() > 0) {
            expression.add(str.toString());
        }
        str.replace(0, str.length(), "");
    }

    private List<String> getExpression(Stack<String> expression) {
        List<String> subExpression = new ArrayList<>();

        while(!expression.empty()) {
            String current = expression.pop();
            if (current.equals("(")) {
                break;
            }
            subExpression.add(0, current);
        }

        return subExpression;
    }
}
