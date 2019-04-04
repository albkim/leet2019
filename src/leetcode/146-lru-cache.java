/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the
following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
it should invalidate the least recently used item before inserting a new item.

Follow up:
 Could you do both operations in O(1) time complexity?

Example:
LRUCache cache = new LRUCache( 2 ); // capacity

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

*/

package leetcode;

class LRUCache {

    private int capacity;
    private long increment;
    private java.util.Map<Integer, Integer> cache;
    private java.util.Map<Integer, Long> time;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new java.util.HashMap<>(this.capacity);
        this.time = new java.util.HashMap<>(this.capacity);
        this.increment = 0;
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            this.markUsage(key);
            return this.cache.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        this.markUsage(key);
        this.cache.put(key, value);

        if (this.cache.size() > this.capacity) {
            invalidate();
        }
    }

    private void invalidate() {
        int minKey = Integer.MAX_VALUE;
        long minTime = Long.MAX_VALUE;

        for (int key : this.time.keySet()) {
            long time = this.time.get(key);

            if (time < minTime) {
                minKey = key;
                minTime = time;
            }
        }

        this.cache.remove(minKey);
        this.time.remove(minKey);
    }

    private void markUsage(int key) {
        this.increment++;
        this.time.put(key, this.increment);
    }

}
