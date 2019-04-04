/*
Count the number of prime numbers less than a non-negative number, n.

Example:
Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.


 We only need to look at 1 - n^1/2 since n/2 is the minimum division...even further, there is always counter set

 for 12
 2x6 == 6x2
 3x4 == 4x3

 So...now we can even do better. Once we find a prime number, it can be used to eliminate more numbers

 2 -> 4, 6, 8, 10
 3 -> 6, 9, 12, 15
 5 -> 10, 15, 20, 25

 and so on. So we can kinda do dp like operation by trying to divide all prime numbers found thus far

 */

package leetcode;

class CountPrimes {
    public int countPrimes(int n) {

        if (n <= 1) {
            return 0;
        }

        int count = 0;
        boolean[] nonPrimes = new boolean[n];
        for (int num = 2; num < n; num++) {
            if (nonPrimes[num]) {
                continue;
            }
            // if we are here, we are already on a prime number because following will mark all
            // non-prime numbers below
            for (int mult = num; mult < n; mult += num) {
                nonPrimes[mult] = true;
            }
            count++;
        }

        return count;
    }
}
