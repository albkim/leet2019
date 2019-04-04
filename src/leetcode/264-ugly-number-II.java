/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:
Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note:
1.1 is typically treated as an ugly number.
2.n does not exceed 1690.

 */

package leetcode;

class UglyNumberII {
    public int nthUglyNumber(int n) {
        if(n <= 0) {
            return 0;
        }
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int curMin = 1;
        for(int i = 1; i < n; ++i) {
            curMin = Math.min(factor2, Math.min(factor3, factor5));
            ugly[i] = curMin;
            if(factor2 == curMin){
                factor2 = 2*ugly[++index2];
            }
            if(factor3 == curMin){
                factor3 = 3*ugly[++index3];
            }
            if(factor5 == curMin){
                factor5 = 5*ugly[++index5];
            }
        }
        return ugly[n-1];
    }
}
