/*
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary
operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:
Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"]


Example 2:
Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]

Example 3:
Input: num = "105", target = 5
Output: ["1*0+5","10-5"]

Example 4:
Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]


Example 5:
Input: num = "3456237490", target = 9191
Output: []


 */

package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        if ((num == null) || (num.length() == 0)) {
            return result;
        }

        backtrack(result, new StringBuilder(), num, target, 0, 0, 0);

        return result;
    }

    private static void backtrack(List<String> result, StringBuilder expression, String num, int target, long answer, long previous, int start) {
        if (start == num.length()) {
            if (target == answer) {
                // we got an answer
                result.add(expression.toString());
            }
            return;
        }

        // we need to consider 2 cases
        //  concatenation of numbers
        //  operators (+, -, *)
        for (int index = start; index < num.length(); index++) {
            String numberString = num.substring(start, index + 1);
            long number = Long.parseLong(num.substring(start, index + 1));

            // we don't want to allow numbers starting with 0;
            if ((num.charAt(start) == '0') && (index > start)) {
                return;
            }

            if (start == 0) {
                // starting the expression no operators at this point
                expression.append(number);
                backtrack(result, expression, num, target, number, number, index + 1);
                expression.delete(start, index + 1);
            }
            else {
                int previousIndex = expression.length();
                // +
                expression.append('+');
                expression.append(number);
                backtrack(result, expression, num, target, answer + number, number, index + 1);
                expression.delete(previousIndex, previousIndex + numberString.length() + 1);

                // -
                expression.append('-');
                expression.append(number);
                backtrack(result, expression, num, target, answer - number, -1 * number, index + 1);
                expression.delete(previousIndex, previousIndex + numberString.length() + 1);

                // *
                // some special handling since * has to be evaluated first. subtract previous from answer and then
                // multiply
                expression.append('*');
                expression.append(number);
                backtrack(result, expression, num, target, answer - previous + (previous * number), previous * number, index + 1);
                expression.delete(previousIndex, previousIndex + numberString.length() + 1);
            }
        }
    }
}
