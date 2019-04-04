/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:
Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps


Example 2:
Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


 */

package leetcode;

class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }

        // return climbStairs(n, 0);
        return climbStairsDP(n);
    }

    private int climbStairs(int n, int current) {
        if (n == current) {
            return 1;
        } else if (current > n) {
            return 0;
        }

        int total = 0;
        total += climbStairs(n, current + 1);
        total += climbStairs(n, current + 2);
        return total;
    }

    private int climbStairsDP(int n) {
        int[] steps = new int[n + 1];

        steps[n] = 1;
        for (int index = n - 1; index >= 0; index--) {
            int total = (index == (n - 1)) ? 0 : steps[index + 2];
            total += steps[index + 1];
            steps[index] = total;
        }

        return steps[0];
    }
}
