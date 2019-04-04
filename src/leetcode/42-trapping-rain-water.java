/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
 compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6

 */

package leetcode;

class TrappingRainWater {
    public int trap(int[] height) {
        if ((height == null) || (height.length <= 2)) {
            return 0;
        }

        int total = 0;
        int left = 0;
        int right = height.length - 1;

        int leftLast = 0;
        int rightLast = 0;
        java.util.List<Integer> temp = new java.util.ArrayList<>();
        while(left <= right) {
            temp.clear();
            if (leftLast < rightLast) {
                while ((left <= right) && (height[left] < leftLast)) {
                    temp.add(height[left]);
                    left++;
                }
                int min = Math.min(height[left], leftLast);
                for (int num : temp) {
                    total += (min - num);
                }
                leftLast = height[left];
                left++;
            } else {
                while ((left <= right) && (height[right] < rightLast)) {
                    temp.add(height[right]);
                    right--;
                }
                int min = Math.min(height[right], rightLast);
                for (int num : temp) {
                    total += (min - num);
                }
                rightLast = height[right];
                right--;
            }
        }
        return total;
    }
}
