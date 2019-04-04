/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
A gray code sequence must begin with 0.

Example 1:
Input: 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2

For a given n, a gray code sequence may not be uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence.

00 - 0
10 - 2
11 - 3
01 - 1


Example 2:
Input: 0
Output: [0]
Explanation: We define the gray code sequence to begin with 0.
             A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
             Therefore, for n = 0 the gray code sequence is [0].



Gray code is where each sequence differ by 1. Similar to hamiltonian distance of 1. Used
in things like error correction and binary encoding. It is represented as a reflection.
Reflect the previous sequence and then append 0 to the original and 1 to the reflected in the most
significant position

n = 1         n = 2       n = 3
0             0  0       0  0  0
1             0  1       0  0  1
              1  1       0  1  1
              1  0       0  1  0
                         1  1  0
                         1  1  1
                         1  0  1
                         1  0  0

 */

package leetcode;


class GrayCode {
    public java.util.List<Integer> grayCode(int n) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (n == 0) {
            result.add(0);
            return result;
        }

        java.util.List<java.util.List<Boolean>> bits = new java.util.ArrayList<>();
        bits.add(new java.util.ArrayList<Boolean>(){{add(false);}});
        bits.add(new java.util.ArrayList<Boolean>(){{add(true);}});
        for (int count = 1; count < n; count++) {
            java.util.List<java.util.List<Boolean>> newBits = new java.util.ArrayList<>();
            for (int index = 0; index < bits.size(); index++) {
                java.util.List<Boolean> original = new java.util.ArrayList<>();
                original.add(false);
                for (boolean bit : bits.get(index)) {
                    original.add(bit);
                }
                newBits.add(original);
            }
            for (int index = bits.size() - 1; index >= 0; index--) {
                java.util.List<Boolean> reflected = new java.util.ArrayList<>();
                reflected.add(true);
                for (boolean bit : bits.get(index)) {
                    reflected.add(bit);
                }
                newBits.add(reflected);
            }
            bits = newBits;
        }

        for (int index = 0; index < bits.size(); index++) {
            result.add(bitsToNum(bits.get(index)));
        }
        return result;
    }

    private int bitsToNum(java.util.List<Boolean> bits) {
        int number = 0;
        int power = 0;
        for (int index = bits.size() - 1; index >= 0; index--) {
            number += (bits.get(index)) ? Math.pow(2, power) : 0;
            power++;
        }
        return number;
    }
}
