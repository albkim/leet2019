/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].


Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

 */

package leetcode;

import leetcode.data_structures.IntervalMinHeap;
import leetcode.models.Interval;

class MergeIntervals {
    public java.util.List<Interval> merge(java.util.List<Interval> intervals) {
        java.util.List<Interval> result = new java.util.ArrayList<>();

        if ((intervals == null) || (intervals.size() == 0)) {
            return result;
        }

        IntervalMinHeap minHeap = new IntervalMinHeap(intervals.size());
        for (Interval interval : intervals) {
            minHeap.insert(interval);
        }

        while (minHeap.size() > 0) {
            Interval interval = minHeap.pop();
            if (result.size() == 0) {
                result.add(interval);
            } else {
                Interval tail = result.get(result.size() - 1);
                if (tail.end >= interval.start) {
                    // merge
                    tail.end = Math.max(tail.end, interval.end);
                } else {
                    result.add(interval);
                }
            }
        }

        return result;
    }
}
