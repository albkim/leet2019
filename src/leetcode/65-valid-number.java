/*
Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before
implementing one. However, here is a list of characters that can be in a valid decimal number:
•Numbers 0-9
•Exponent - "e"
•Positive/negative sign - "+"/"-"
•Decimal point - "."

Of course, the context of these characters also matters in the input.

 */

package leetcode;

class ValidNumber {

    private java.util.Set<Character> numbers = new java.util.HashSet<Character>() {{
        add('0');
        add('1');
        add('2');
        add('3');
        add('4');
        add('5');
        add('6');
        add('7');
        add('8');
        add('9');
    }};

    public boolean isNumber(String s) {
        // trim space as we convert to char array
        if ((s == null) || (s.length() == 0)) {
            return false;
        }

        int left = 0;
        while ((left < s.length()) && (s.charAt(left) == ' ')) {
            left++;
        }

        int right = s.length() - 1;
        while ((right >= 0) && (s.charAt(right) == ' ')) {
            right--;
        }

        if ((right - left) < 0) {
            return false;
        }

        char[] chars = new char[right - left + 1];
        for (int index = left; index <= right; index++) {
            chars[index - left] = s.charAt(index);
        }

        if ((chars.length == 1) && ((chars[0] == 'e') || (chars[0] == '.') || (chars[0] == '+') || (chars[0] == '-'))) {
            return false;
        }

        return isNumber(chars, 0, false, false, false, false, false);
    }

    private boolean isNumber(char[] chars, int index, boolean zero, boolean number, boolean sign, boolean exponent, boolean decimal) {
        if (index == chars.length) {
            return true;
        }

        char chr = chars[index];

        if (chr == ' ') {
            return false;
        }

        boolean last = index == (chars.length - 1);

        if (chr == 'e') {
            if ((exponent) || (!number) || (last)) {
                return false;
            } else {
                exponent = true;
                decimal = true;
                sign = false;
                number = false;
            }
        } else if (chr == '.') {
            if (decimal) {
                // we should allow .6/3. but not . apparently...this is stupid...only to make this more tricky
                return false;
            } else if (((index == 0) || (!numbers.contains(chars[index - 1]))) && ((index == (chars.length - 1)) || (!numbers.contains(chars[index + 1])))) {
                // we then now need to handle .. or -.
                return false;
            } else {
                decimal = true;
                zero = false;
            }
        } else if ((chr == '-') || (chr == '+')) {
            if (((index != 0) && (chars[index - 1] != 'e')) || (last) || (sign)) {
                return false;
            } else {
                sign = true;
            }
        }
        // how the fuck is 00 a valid number...
        /*
        else if (chr == '0') {
            if (index == 0) {
                zero = true;
            } else if (zero) {
                return false;
            } else {

            }
        }
        */
        else if (numbers.contains(chr)) {
            number = true;
        } else {
            return false;
        }

        return isNumber(chars, index + 1, zero, number, sign, exponent, decimal);
    }
}
