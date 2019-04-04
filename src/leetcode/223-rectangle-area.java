/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area

Example:
Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
Output: 45

Note:

Assume that the total area is never beyond the maximum possible value of int.


 It's total area (area of two - overlap)
 */


package leetcode;

class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int area = 0;

        area += (C - A) * (D - B);
        area += (G - E) * (H - F);

        // check if they overlap
        if ((((A <= E) && (E <= C)) || ((A <= G) && (G <= C) || ((E <= A) && (A <= G)) || ((E <= C) && (C <= G))))
                && (((B <= H) && (H <= D)) || ((B <= F) && (F <= D)) || ((F <= B) && (B <= H)) || ((F <= D) && (D <= H)))) {
            // overlap x would be max(left) - min(right)
            // overlap y would be max(bottom) - min(top)

            int left = Math.max(A, E);
            int right = Math.min(C, G);
            int top = Math.min(D, H);
            int bottom = Math.max(B, F);

            area -= (right - left) * (top - bottom);
        }

        return area;
    }
}
