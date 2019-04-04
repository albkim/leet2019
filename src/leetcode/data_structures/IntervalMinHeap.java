package leetcode.data_structures;

import leetcode.models.Interval;

public class IntervalMinHeap {

    private Interval[] intervals;
    private int currentIndex = 1;

    public IntervalMinHeap(int size) {
        this.intervals = new Interval[size + 1];
    }

    public void insert(Interval interval) {
        this.intervals[currentIndex] = interval;
        this.bubbleUp();
        this.currentIndex++;
    }

    public Interval pop() {
        Interval min = this.intervals[1];
        this.currentIndex--;
        this.intervals[1] = this.intervals[currentIndex];
        this.bubbleDown();
        return min;
    }

    public int size() {
        return this.currentIndex - 1;
    }

    private int getParentIndex(int index) {
        return index / 2;
    }

    private int getLeftChildIndex(int index) {
        return index * 2;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 1;
    }

    private void bubbleDown() {
        int index = 1;
        while(index < this.currentIndex) {
            int value = this.intervals[index].start;
            int leftChildIndex = this.getLeftChildIndex(index);
            int leftChildValue = (leftChildIndex < this.currentIndex) ? this.intervals[leftChildIndex].start : Integer.MAX_VALUE;
            int rightChildIndex = this.getRightChildIndex(index);
            int rightChildValue = (rightChildIndex < this.currentIndex) ? this.intervals[rightChildIndex].start : Integer.MAX_VALUE;
            if (leftChildValue < rightChildValue) {
                if (value > leftChildValue) {
                    swap(index, leftChildIndex);
                    index = leftChildIndex;
                } else {
                    break;
                }
            } else {
                if (value > rightChildValue) {
                    swap(index, rightChildIndex);
                    index = rightChildIndex;
                } else {
                    break;
                }
            }
        }
    }

    private void bubbleUp() {
        int index = this.currentIndex;
        while(index > 1) {
            int parentIndex = this.getParentIndex(index);
            if (this.intervals[parentIndex].start < this.intervals[index].start) {
                break;
            }
            this.swap(parentIndex, index);
            index = parentIndex;
        }
    }

    private void swap(int index1, int index2) {
        Interval temp = this.intervals[index1];
        this.intervals[index1] = this.intervals[index2];
        this.intervals[index2] = temp;
    }

}
