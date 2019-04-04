/*
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:
Input: [10,2]
Output: "210"

Example 2:
Input: [3,30,34,5,9]
Output: "9534330"


 */

package leetcode;

import java.util.Arrays;
import java.util.Comparator;

class LargestNumber {
    public String largestNumber(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return "";
        }

        String[] ss = new String[nums.length];
        for (int index = 0; index < nums.length; index++) {
            ss[index] = String.valueOf(nums[index]);
        }

        Arrays.parallelSort(ss, 0, ss.length, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String left = o1 + o2;
                String right = o2 + o1;
                return left.compareTo(right);
            }
        });

        StringBuilder result = new StringBuilder();
        for (int index = ss.length - 1; index >= 0; index--) {
            result.append(ss[index]);
        }
        if ((result.charAt(0) == '0') && (result.length() > 1)) {
            return "0";
        }
        return result.toString();
    }
}
