/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:
Input: numerator = 1, denominator = 2
Output: "0.5"


Example 2:
Input: numerator = 2, denominator = 1
Output: "2"

Example 3:
Input: numerator = 2, denominator = 3
Output: "0.(6)"


Track remainder to see if it repeats....then there is a repeating pattern
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();

        long numeratori = (long)numerator;
        long denominatori = (long)denominator;

        // need to handle the sign separately...because it could mess up remainder calculation
        // we should make both parts into positive and then consider sign separately
        if (((numeratori < 0) && (denominatori > 0)) || ((numeratori > 0) && (denominatori < 0))) {
            result.append("-");
        }

        numeratori = Math.abs(numeratori);
        denominatori = Math.abs(denominatori);

        // left part
        result.append(numeratori / denominatori);

        long remainder = numeratori % denominatori;

        if (remainder > 0) {
            // need decimal
            result.append('.');
            remainder *= 10;

            // use a map to track possible remainder / start index
            // if we see the same remainder then pattern would repeat from that index to now
            Map<Long, Integer> remainders = new HashMap<>();

            while(remainder > 0) {
                if (remainders.containsKey(remainder)) {
                    // we have seen this before. Now it can only repeat!
                    result.insert(remainders.get(remainder), "(");
                    // we have seen this before. Now it can only repeat!
                    result.append(')');
                    break;
                }

                // put the lookup
                remainders.put(remainder, result.length());

                // not big enough, need to move the digits and make it bigger
                if (remainder < denominatori) {
                    result.append("0");
                    remainder *= 10;
                    continue;
                }

                // add the result
                result.append(remainder / denominatori);

                // get new remainder
                remainder %= denominatori;

                remainder *= 10;
            }
        }

        return result.toString();
    }
}
