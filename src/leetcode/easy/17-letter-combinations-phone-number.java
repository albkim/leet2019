/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.


Seems like recursive solution...maybe dp solution since it's recursive

 */

package leetcode.easy;

class LetterCombinationsPhoneNumber {
    public java.util.List<String> letterCombinations(String digits) {
        java.util.Map<Character, java.util.List<Character>> lookup = new java.util.HashMap<Character, java.util.List<Character>>() {{
            put('2', new java.util.ArrayList<Character>(){{add('a'); add('b'); add('c'); }});
            put('3', new java.util.ArrayList<Character>(){{add('d'); add('e'); add('f'); }});
            put('4', new java.util.ArrayList<Character>(){{add('g'); add('h'); add('i'); }});
            put('5', new java.util.ArrayList<Character>(){{add('j'); add('k'); add('l'); }});
            put('6', new java.util.ArrayList<Character>(){{add('m'); add('n'); add('o'); }});
            put('7', new java.util.ArrayList<Character>(){{add('p'); add('q'); add('r'); add('s'); }});
            put('8', new java.util.ArrayList<Character>(){{add('t'); add('u'); add('v'); }});
            put('9', new java.util.ArrayList<Character>(){{add('w'); add('x'); add('y'); add('z'); }});
        }};

        java.util.List<String> result = new java.util.ArrayList<>();
        java.util.List<String> result1;
        for (int index = 0; index < digits.length(); index++) {
            char chr = digits.charAt(index);
            result1 = new java.util.ArrayList<>();
            for(char possible : lookup.get(chr)) {
                if (index == 0) {
                    result1.add(String.valueOf(possible));
                } else {
                    for (String str : result) {
                        result1.add(str + String.valueOf(possible));
                    }
                }
            }
            result = result1;
        }

        return result;
    }
}
