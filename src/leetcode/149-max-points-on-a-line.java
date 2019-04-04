package leetcode;

import leetcode.models.Point;

class MaxPointsOnALine {
    private class Line {
        public double slope;
        public boolean vertical;
        public boolean horizontal;
        public double origin; // x coordinate at y = 0

        public Line(int x1, int y1, int x2, int y2) {
            if (x2 == x1) {
                // need to special case this
                this.vertical = true;
                this.origin = x2;
                return;
            }
            else if (y2 == y1) {
                this.horizontal = true;
                this.origin = y2; // we never hit y == 0
                return;
            }
            this.slope = (y2 - y1) * 1d / (x2 - x1);
            this.origin = x2 - (y2 / this.slope);
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Line)) {
                return false;
            }

            return ((Line)other).vertical == this.vertical && ((Line)other).horizontal == this.horizontal
                    && ((Line)other).slope == this.slope && ((Line)other).origin == this.origin;
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(this.horizontal, this.vertical, this.slope, this.origin);
        }
    }

    public int maxPoints(Point[] points) {
        if ((points == null) || (points.length == 0)) {
            return 0;
        }

        // this requires at least 2 points
        if (points.length == 1) {
            return 1;
        }

        java.util.Map<Line, java.util.Set<Integer>> counts = new java.util.HashMap<>();
        for (int left = 0; left < points.length; left++) {
            for (int right = left + 1; right < points.length; right++) {
                Line line = new Line(points[left].x, points[left].y, points[right].x, points[right].y);

                // since we could add points multiple times (we add 1 & 2 and 1 & 3..but when we do 2 & 3, we add them again
                // we should use a set to only add unique points
                if (counts.containsKey(line)) {
                    counts.get(line).add(left);
                    counts.get(line).add(right);
                }
                else {
                    java.util.Set<Integer> set = new java.util.HashSet<>();
                    set.add(left);
                    set.add(right);
                    counts.put(line, set);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (java.util.Set<Integer> x : counts.values()) {
            max = Math.max(max, x.size());
        }
        return max;
    }
}
