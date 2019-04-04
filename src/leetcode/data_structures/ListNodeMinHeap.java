package leetcode.data_structures;

import leetcode.models.ListNode;

public class ListNodeMinHeap {

    private ListNode[] storage;
    private int currentSize = 0;

    public ListNodeMinHeap(int size) {
        // always start from index 1;
        this.storage = new ListNode[size + 1];
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public void insert(ListNode node) {
        currentSize++;
        this.storage[currentSize] = node;
        this.bubbleUp(currentSize);
    }

    public ListNode popMin() {
        if (currentSize > 0) {
            ListNode min = this.storage[1];

            this.storage[1] = this.storage[currentSize];
            this.storage[currentSize] = null;
            currentSize--;

            this.bubbleDown(1);

            return min;
        }
        return null;
    }

    private void bubbleUp(int index) {
        if (index <= 1) {
            return;
        }

        int parentIndex = this.getParentIndex(index);
        ListNode parent = this.storage[parentIndex];

        if (parent.val > this.storage[index].val) {
            // swap parent with current
            this.storage[parentIndex] = this.storage[index];
            this.storage[index] = parent;

            // continue to check
            this.bubbleUp(parentIndex);
        }
    }

    private void bubbleDown(int index) {
        if (index >= currentSize) {
            return;
        }

        int leftIndex = this.getLeftChildIndex(index);
        int rightIndex = this.getRightChildIndex(index);

        // note we may not always have the children...
        int leftVal = (leftIndex <= currentSize) ? this.storage[leftIndex].val : Integer.MAX_VALUE;
        int rightVal = (rightIndex <= currentSize) ? this.storage[rightIndex].val : Integer.MAX_VALUE;

        if ((this.storage[index].val > leftVal) || (this.storage[index].val > rightVal)) {
            // swap with a smaller one
            if (leftVal < rightVal) {
                ListNode left = this.storage[leftIndex];
                this.storage[leftIndex] = this.storage[index];
                this.storage[index] = left;
                bubbleDown(leftIndex);
            } else {
                ListNode right = this.storage[rightIndex];
                this.storage[rightIndex] = this.storage[index];
                this.storage[index] = right;
                bubbleDown(rightIndex);
            }
        }
    }

    private int getLeftChildIndex(int index) {
        return index * 2;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getParentIndex(int index) {
        return index / 2;
    }
}
