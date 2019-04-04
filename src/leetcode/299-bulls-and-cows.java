/*
You are playing the following Bulls and Cows game with your friend: You write down a number and ask your
friend to guess what the number is. Each time your friend makes a guess, you provide a hint that
indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls")
and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will
use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the
bulls and B to indicate the cows.

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:
Input: secret = "1807", guess = "7810"

Output: "1A3B"

Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.

Example 2:
Input: secret = "1123", guess = "0111"

Output: "1A1B"

Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.

Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.

 */

package leetcode;

import java.util.*;

class BullsAndCows {
    public String getHint(String secret, String guess) {
        if (((secret == null) && (guess == null)) || ((secret.length() == 0) && (guess.length() == 0))) {
            return null;
        }

        Map<Character, Set<Integer>> lookup = new HashMap<>();
        for (int index = 0; index < secret.length(); index++) {
            char chr = secret.charAt(index);
            if (lookup.containsKey(chr)) {
                lookup.get(chr).add(index);
            } else {
                Set<Integer> indexes = new HashSet<>();
                indexes.add(index);
                lookup.put(chr, indexes);
            }
        }

        // count bulls
        int bulls = 0;
        for (int index = 0; index < secret.length(); index++) {
            char left = secret.charAt(index);
            char right = guess.charAt(index);

            if (left == right) {
                bulls++;
                lookup.get(left).remove(index);
                if (lookup.get(left).size() == 0) {
                    lookup.remove(left);
                }
            }
        }

        // count cows
        int cows = 0;
        for (int index = 0; index < secret.length(); index++) {
            char left = secret.charAt(index);
            char right = guess.charAt(index);

            if (left != right) {
                if (lookup.containsKey(right)) {
                    cows++;
                    lookup.get(right).remove(lookup.get(right).iterator().next());
                    if (lookup.get(right).size() == 0) {
                        lookup.remove(right);
                    }
                }
            }
        }

        return String.format("%dA%dB", bulls, cows);
    }
}
