/*
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:
Input: 123
Output: "One Hundred Twenty Three"


Example 2:
Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:
Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"


Example 4:
Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"


 */

package leetcode;

class IntegerToEnglishWords {
    private String[] underTwenty = new String[] {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private String[] tens = new String[] {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    private String[] thousands = new String[] {
            "", " Thousand", " Million", " Billion"
    };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int thousand = 0;
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            String partial = numberToWordsThousand(num % 1000);
            if (partial.length() > 0) {
                if (result.length() > 0) {
                    result.insert(0, " ");
                }
                result.insert(0, thousands[thousand]);
            }
            result.insert(0, partial);
            num /= 1000;
            thousand++;
        }
        return result.toString();
    }

    public String numberToWordsThousand(int num) {
        if (num < 20) {
            return underTwenty[num];
        }
        if (num < 100) {
            String result = tens[num / 10];
            if ((num % 10) > 0) {
                result += " " + underTwenty[num % 10];
            }
            return result;
        }
        String result = underTwenty[num / 100] + " Hundred";
        if ((num % 100) > 0) {
            result += " " + numberToWordsThousand(num % 100);
        }
        return result;
    }
}
