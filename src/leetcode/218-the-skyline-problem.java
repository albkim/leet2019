/*
A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed
from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape
photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).


The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri
are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height.
It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are
perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ]
that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last
key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always
has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:
•The number of buildings in any input list is guaranteed to be in the range [0, 10000].
•The input list is already sorted in ascending order by the left x position Li.
•The output list must be sorted by the x position.
•There must be no consecutive horizontal lines of equal height in the output skyline. For instance,
[...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged
into one in the final output as such: [...[2 3], [4 5], [12 7], ...]

 */

package leetcode;

import java.util.*;

class TheSkylineProblem {

    private class Building {
        public int left;
        public int right;
        public int height;
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();

        if ((buildings == null) || (buildings.length == 0)) {
            return result;
        }

        Set<Integer> uniqueCriticalPoints = new HashSet<>();
        Map<Integer, List<Building>> toAdd = new HashMap<>();
        Map<Integer, List<Building>> toRemove = new HashMap<>();

        for (int[] building : buildings) {
            Building bo = new Building();
            bo.left = building[0];
            bo.right = building[1];
            bo.height = building[2];
            uniqueCriticalPoints.add(bo.left);
            uniqueCriticalPoints.add(bo.right);
            if (!toAdd.containsKey(bo.left)) {
                toAdd.put(bo.left, new ArrayList<>());
            }
            toAdd.get(bo.left).add(bo);
            if (!toRemove.containsKey(bo.right)) {
                toRemove.put(bo.right, new ArrayList<>());
            }
            toRemove.get(bo.right).add(bo);
        }

        List<Integer> criticalPoints = new ArrayList<>();
        for (int point : uniqueCriticalPoints) {
            criticalPoints.add(point);
        }
        Collections.sort(criticalPoints);

        PriorityQueue<Building> max = new PriorityQueue<>(buildings.length, (o1, o2) -> o2.height - o1.height);
        Integer lastHeight = null;
        for (int point : criticalPoints) {
            if (toAdd.containsKey(point)) {
                for (Building building : toAdd.get(point)) {
                    max.add(building);
                }
            }
            if (toRemove.containsKey(point)) {
                for (Building building : toRemove.get(point)) {
                    max.remove(building);
                }
            }

            int maxHeight = (max.isEmpty()) ? 0 : max.peek().height;
            if ((lastHeight == null) || (maxHeight != lastHeight)) {
                result.add(new int[] {point, maxHeight});
            }

            lastHeight = maxHeight;
        }

        return result;
    }
}
