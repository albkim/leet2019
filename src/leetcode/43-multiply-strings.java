/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"


Note:
1.The length of both num1 and num2 is < 110.
2.Both num1 and num2 contain only digits 0-9.
3.Both num1 and num2 do not contain any leading zero, except the number 0 itself.
4.You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */

package leetcode;

class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if ((num1.equals("0")) || (num2.equals("0"))) {
            return "0";
        }

        char[] resultChar = new char[218];
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        for (int index = 0; index < resultChar.length; index++) {
            resultChar[index] = '0';
        }
        reverse(char1);
        reverse(char2);

        int resultIndex = 0;
        for (int index1 = 0; index1 < char1.length; index1++) {
            int carry = 0;
            for (int index2 = 0; index2 < char2.length; index2++) {
                resultIndex = index1 + index2;
                int total = (Character.getNumericValue(char1[index1]) * Character.getNumericValue(char2[index2])) + Character.getNumericValue(resultChar[resultIndex]) + carry;
                carry = total / 10;
                resultChar[resultIndex] = Character.forDigit(total % 10, 10);
            }

            if (carry > 0) {
                resultIndex++;
                resultChar[resultIndex] = Character.forDigit(carry, 10);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int index = resultIndex; index >= 0; index--) {
            result.append(resultChar[index]);
        }
        return result.toString();
    }

    private void reverse(char[] chars) {
        int left = 0;
        int right = chars.length - 1;
        while(left <= right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
