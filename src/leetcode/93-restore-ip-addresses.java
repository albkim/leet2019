/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:
Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]



ip should be from 0 to 255

 */

package leetcode;

import java.util.List;

class RestoreIPAddresses {
    public java.util.List<String> restoreIpAddresses(String s) {
        java.util.List<String> result = new java.util.ArrayList<>();

        if ((s == null) || (s.length() < 4)) {
            return result;
        }

        restoreIpAddresses(result, s, 0, 0, new StringBuilder());

        return result;
    }

    private void restoreIpAddresses(List<String> result, String s, int index, int count, StringBuilder sequence) {
        if ((count == 4) && (index == s.length())) {
            String ip = sequence.toString();
            result.add(ip.substring(0, ip.length() - 1));
        } else if ((count >= 4) || (index >= s.length())) {
            return;
        }

        for (int length = 1; length <= 3; length++) {
            // check for max length
            if ((index + length) > s.length()) {
                break;
            }
            String currentChar = s.substring(index, index + length);

            // .0xx is probably not valid...while .0. is
            if ((length > 1) && (currentChar.charAt(0) == '0')) {
                continue;
            }

            // anything over 255 is not valid
            int number = Integer.parseInt(currentChar);
            if (number > 255) {
                continue;
            }

            sequence.append(currentChar);
            sequence.append('.');
            restoreIpAddresses(result, s, index + length, count + 1, sequence);

            // remove last length + 1 chars
            sequence.delete(sequence.length() - length - 1, sequence.length());
        }
    }
}
