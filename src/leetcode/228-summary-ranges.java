/*
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:
Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.


Example 2:
Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.


 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if ((nums == null) || (nums.length == 0)) {
            return result;
        }

        List<int[]> ranges = new ArrayList<>();
        for (int num : nums) {
            if (ranges.size() == 0) {
                ranges.add(new int[] {num, num});
            } else {
                int[] lastRange = ranges.get(ranges.size() - 1);
                if (lastRange[1] == (num - 1)) {
                    lastRange[1] = num;
                } else {
                    ranges.add(new int[] {num, num});
                }
            }
        }

        for (int[] range : ranges) {
            if (range[0] == range[1]) {
                result.add(String.valueOf(range[0]));
            } else {
                result.add(String.format("%d->%d", range[0], range[1]));
            }
        }

        return result;
    }
}
