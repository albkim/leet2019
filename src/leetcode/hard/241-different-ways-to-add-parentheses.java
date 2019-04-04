/*
Given a string of numbers and operators, return all possible results from computing all the different possible
ways to group numbers and operators. The valid operators are +, - and *.

Example 1:
Input: "2-1-1"
Output: [0, 2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2

Example 2:
Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10


 */

package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<String> expression = parseExpression(input);

        return recurse(expression, 0, expression.size() - 1);
    }

    private static List<Integer> recurse(List<String> expression, int left, int right) {
        if (left == right) {
            // we got it down to single expression, just return the numeric version
            return Arrays.asList(Integer.parseInt(expression.get(left)));
        }

        List<Integer> result = new ArrayList<>();
        for (int index = left + 2; index <= right; index += 2) {
            String operator = expression.get(index - 1);
            List<Integer> leftSide = recurse(expression, left, index - 2);
            List<Integer> rightSide = recurse(expression, index, right);

            for (int leftNumber : leftSide) {
                for (int rightNumber : rightSide) {
                    switch (operator) {
                        case "+":
                            result.add(leftNumber + rightNumber);
                            break;
                        case "-":
                            result.add(leftNumber - rightNumber);
                            break;
                        case "*":
                            result.add(leftNumber * rightNumber);
                            break;
                        case "/":
                            result.add(leftNumber / rightNumber);
                            break;
                    }
                }
            }
        }
        return result;
    }

    private static List<String> parseExpression(String input) {
        List<String> expression = new ArrayList<>();

        int beginIndex = 0;
        char[] string = input.toCharArray();
        for (int index = 0; index < string.length; index++) {
            if ((string[index] == '+') || (string[index] == '-') || (string[index] == '*') || (string[index] == '/')) {
                expression.add(input.substring(beginIndex, index));
                expression.add(String.valueOf(string[index]));
                beginIndex = index + 1;
            }
        }

        // last bit
        expression.add(input.substring(beginIndex, string.length));

        return expression;
    }
}
