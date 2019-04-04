/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example:
Input: [2,1,5,6,2,3]
Output: 10


Use a stack, as long as the current one is greater than the top, push in the height & index.
When we see a smaller one, we can start poping larger ones and calculate rect...Then push the current one in with
the smallest index...

1 2 3 4 5
we see 3, now there is 5x1, 4x2
If we see the same one, we can just proceed
Another case is if we se one smaller
1, 2, 4, 5
we want to insert the current one with the lowest index. (so now shorter rect can be calculated including
the ones we popped off

 */

package leetcode;

class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if ((heights == null) || (heights.length == 0)) {
            return 0;
        }

        int max = 0;
        java.util.Stack<int[]> stack = new java.util.Stack<>();

        for (int index = 0; index <= heights.length; index++) {
            int height = (index == heights.length) ? 0 : heights[index];
            if ((stack.empty()) || (stack.peek()[0] < height)) {
                stack.push(new int[] {height, index});
            } else {
                int lastIndex = index;
                while((!stack.empty()) && (stack.peek()[0] > height)) {
                    int[] pair = stack.pop();
                    lastIndex = pair[1];
                    int area = pair[0] * (index - lastIndex);
                    max = Math.max(max, area);
                }
                if ((!stack.empty()) && (stack.peek()[0] == height)) {
                    continue;
                } else {
                    stack.push(new int[] {height, lastIndex});
                }
            }
        }

        return max;
    }
}
