/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R


And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"


Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

for first row it's always step of (n-1) * 2
    3 - 1, 5, 9...
    4 - 1, 7, 13...
for last row it's always step of (n-1) * 2 from n
    3 - 3, 7, 11...
    4 - 4, 10, 16
for others, there are 2 numbers (on left and on right) with same step for left
    3 - 2, 6, 10...
    4 - 2, 8, 14...
for others, on the right, we need to do internal step where it's (n - row) * 2
    3 - 4, 8, 12...
    4 - 6, 12, 18...
And so on


make sure edge cases are handled...
    if the length == row return string itself...
    if row == 1 return string itself
 */

package leetcode.weird;

class ZigZagConversion {
    public String convert(String s, int numRows) {
        if ((numRows == 1) || (s.length() == numRows)) return s;
        StringBuilder result = new StringBuilder();
        int step = (numRows - 1) * 2;
        for (int row = 1; row <= numRows; row++) {
            for (int index = row - 1; index < s.length(); index += step) {
                result.append(s.charAt(index));
                if ((row > 1) && (row < numRows)) {
                    int innerStep = (numRows - row) * 2;
                    if ((index + innerStep) < s.length()) {
                        result.append(s.charAt(index + innerStep));
                    }
                }
            }
        }
        return result.toString();
    }
}

/*

Success
Details
Runtime: 41 ms
 */