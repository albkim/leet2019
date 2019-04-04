/*
You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one
of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take
the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you
can win the game given the number of stones in the heap.

Example:
Input: 4
Output: false
Explanation: If there are 4 stones in the heap, then you will never win the game;
             No matter 1, 2, or 3 stones you remove, the last stone will always be
             removed by your friend.

 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

class NimGame {
    public boolean canWinNim(int n) {
        Map<Integer, Boolean> cache = new HashMap<>();
        return canWinNim(n, true, cache);
    }

    private boolean canWinNim(int n, boolean myTurn,  Map<Integer, Boolean> cache) {
        if (n <= 3) {
            return myTurn;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        for (int stone = 1; stone <= 3; stone++) {
            if (canWinNim(n - stone, !myTurn, cache)) {
                cache.put(n, true);
                return true;
            }
        }

        cache.put(n, false);
        return false;
    }
}
