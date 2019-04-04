/*
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
So the median is the mean of the two middle value.
For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:
•void addNum(int num) - Add a integer number from the data stream to the data structure.
•double findMedian() - Return the median of all elements so far.



Example:
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2




Follow up:
1.If all integer numbers from the stream are between 0 and 100, how would you optimize it?
2.If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?

 */

package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class FindMedianFromDataStream {

    private Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    private Queue<Integer> minHeap = new PriorityQueue<>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        // if both heap doesn't have a root, keep adding to minHeap and let it rebalance
        if ((minHeap.size() > 0) && (maxHeap.size() > 0)) {
            // compare against the root to pick the right one
            if (num < maxHeap.peek()) {
                maxHeap.add(num);
            }
            else if (num > minHeap.peek()) {
                minHeap.add(num);
            }
            else {
                // this means it's in the middle...put it into smaller one, favoring minheap if same
                if (minHeap.size() <= maxHeap.size()) {
                    minHeap.add(num);
                }
                else {
                    maxHeap.add(num);
                }
            }
        }
        else {
            minHeap.add(num);
        }

        // consider if we need to rebalance
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
        else if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            if (maxHeap.size() == 0) {
                return 0;
            }
            return ((minHeap.peek() + maxHeap.peek()) / 2d);
        }
        else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        else {
            return minHeap.peek();
        }
    }
}
