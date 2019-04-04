/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.


The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water
(blue section) the container can contain is 49.


Example:
Input: [1,8,6,2,5,4,8,3,7]
Output: 49

Do a left and right pointer and calculate the area until n < 2.
Move the smaller of the two into the middle by 1
 */

package leetcode.easy;

class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;

        while (left != right) {
            area = Math.max(area, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return area;
    }
}
