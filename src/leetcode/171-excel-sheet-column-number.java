/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...


Example 1:
Input: "A"
Output: 1


Example 2:
Input: "AB"
Output: 28


Example 3:
Input: "ZY"
Output: 701


 */

package leetcode;

class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if ((s == null) || (s.length() == 0)) {
            return 0;
        }

        int number = 0;
        for (int index = 0; index < s.length(); index++) {
            char chr = s.charAt(s.length() - index - 1);
            if (index == 0) {
                number += (chr - 'A' + 1);
            } else {
                number += (chr - 'A' + 1) * (Math.pow(26, index));
            }
        }
        return number;
    }
}
