/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.


Example 1:
Input: nums = [1,2,3,1], k = 3, t = 0
Output: true



Example 2:
Input: nums = [1,0,1,1], k = 1, t = 2
Output: true



Example 3:
Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false


tree map to search for interval
 */

package leetcode;

import java.util.TreeMap;

class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if ((nums == null) || (nums.length == 0)) {
            return false;
        }

        TreeMap<Long, Integer> map = new TreeMap<>();
        for (int index = 0; index < nums.length; index++) {
            long num = nums[index];
            int lookback = index - k - 1;
            if (lookback >= 0) {
                long lookbackNumber = nums[lookback];
                if (map.containsKey(lookbackNumber)) {
                    if ((map.get(lookbackNumber) == 1)) {
                        map.remove(lookbackNumber);
                    } else {
                        map.put(lookbackNumber, map.get(lookbackNumber) - 1);
                    }
                }
            }

            if (!map.isEmpty()) {
                Long closestFloor = map.floorKey(num);
                Long closestCeiling = map.ceilingKey(num);
                if (((closestFloor != null) && (Math.abs(closestFloor - num) <= t)) || ((closestCeiling != null) && (Math.abs(closestCeiling - num) <= t))) {
                    return true;
                }
            }

            map.put(num, 1);
        }
        return false;
    }
}
