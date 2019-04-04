/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.


Example 2:
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.


 */

package leetcode;

class PlusOne {
    public int[] plusOne(int[] digits) {
        if ((digits == null) || (digits.length == 0)) {
            return digits;
        }

        int carry = 0;
        java.util.List<Integer> result = new java.util.ArrayList<>();
        for (int index = digits.length - 1; index >= 0; index --) {
            int current = digits[index] + carry;
            if (index == (digits.length - 1)) {
                current++;
            }

            carry = current / 10;
            result.add(current % 10);
        }

        if (carry > 0) {
            result.add(carry);
        }

        int[] resultInt = new int[result.size()];
        for (int index = 0; index < result.size(); index++) {
            resultInt[result.size() - index - 1] = result.get(index);
        }

        return resultInt;
    }
}
