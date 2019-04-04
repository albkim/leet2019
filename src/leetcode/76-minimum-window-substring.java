/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"


Note:
•If there is no such window in S that covers all characters in T, return the empty string "".
•If there is such window, you are guaranteed that there will always be only one unique minimum window in S.


Could be done similar to continuous sequence sum using windowing.
 */

package leetcode;

import java.util.List;
import java.util.Map;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if ((s == null) || (s.length() == 0)) {
            if ((t == null) || (t.length() == 0)) {
                return "";
            }
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        int minLeft = Integer.MIN_VALUE;
        int minRight = Integer.MAX_VALUE;
        int left = Integer.MIN_VALUE;

        java.util.Set<Character> check = new java.util.HashSet<>();
        java.util.Map<Character, Integer> counter = new java.util.HashMap<>();
        for (char chr : t.toCharArray()) {
            check.add(chr);
            if (counter.containsKey(chr)) {
                counter.put(chr, counter.get(chr) + 1);
            } else {
                counter.put(chr, 1);
            }
        }

        java.util.Map<Character, java.util.List<Integer>> current = new java.util.HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            char chr = s.charAt(index);
            if (check.contains(chr)) {
                if (current.containsKey(chr)) {
                    current.get(chr).add(index);
                } else {
                    java.util.List<Integer> indexes = new java.util.ArrayList<>();
                    indexes.add(index);
                    current.put(chr, indexes);
                }

                if (left == Integer.MIN_VALUE) {
                    left = index;
                }

                // if condition is satisfied, set right and do min eval
                if (isWindowSatisfied(counter, current)) {
                    int length = index - left + 1;
                    if (length < minLength) {
                        minLength = length;
                        minLeft = left;
                        minRight = index;
                    }

                    // if there are more than needed, see if left can be moved, continuously
                    while (current.get(s.charAt(left)).size() > counter.get(s.charAt(left))) {
                        current.get(s.charAt(left)).remove(0);
                        left = getNextMin(current);
                        length = index - left + 1;
                        if (length < minLength) {
                            minLength = length;
                            minLeft = left;
                            minRight = index;
                        }
                    }
                }
            }
        }

        if ((minLeft != Integer.MIN_VALUE) && (minRight != Integer.MAX_VALUE)) {
            return s.substring(minLeft, minRight + 1);
        }
        return "";
    }

    private int getNextMin(Map<Character, List<Integer>> current) {
        int minIndex = Integer.MAX_VALUE;
        for (char chr : current.keySet()) {
            minIndex = Math.min(minIndex, current.get(chr).get(0));
        }
        return minIndex;
    }

    private boolean isWindowSatisfied(Map<Character, Integer> counter, Map<Character, java.util.List<Integer>> current) {
        for (char chr : counter.keySet()) {
            if (!current.containsKey(chr)) {
                return false;
            }
            if (current.get(chr).size() < counter.get(chr)) {
                return false;
            }
        }

        return true;
    }
}
