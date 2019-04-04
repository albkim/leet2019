/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:
1.Insert a character
2.Delete a character
3.Replace a character

Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')


Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')


DP

    h o r s e
  0 1 2 3 4 5
r 1 1 2 2 3 4
o 2 2 1 2 3 4
s 3 3 2 2 2 3

 */

package leetcode;

class EditDistance {
    public int minDistance(String word1, String word2) {
        if ((word1 == null) || (word1.length() == 0)) {
            if (word2 == null) {
                return 0;
            } else {
                return word2.length();
            }
        }
        if ((word2 == null) || (word2.length() == 0)) {
            if (word1 == null) {
                return 0;
            } else {
                return word1.length();
            }
        }

        // return minDistance(word1, word2, 0, 0);
        return minDistanceDP(word1, word2);
    }

    private int minDistance(String word1, String word2, int index1, int index2) {
        if (index1 == word1.length()) {
            return word2.length() - index2;
        }
        if (index2 == word2.length()) {
            return word1.length() - index1;
        }

        int total = Integer.MAX_VALUE;

        int current = (word1.charAt(index1) == word2.charAt(index2)) ? 0 : 1;

        // replace
        total = Math.min(total, minDistance(word1, word2, index1 + 1, index2 + 1) + current);
        // insert
        total = Math.min(total, minDistance(word1, word2, index1, index2 + 1) + 1);
        // delete
        total = Math.min(total, minDistance(word1, word2, index1 + 1, index2) + 1);

        return total;
    }

    private int minDistanceDP(String word1, String word2) {
        int[][] matrix = new int[word1.length() + 1][word2.length() + 1];

        // put 0's on the outside
        for (int row = 0; row <= word1.length(); row++) {
            matrix[row][0] = row;
        }
        for (int column = 0; column <= word2.length(); column++) {
            matrix[0][column] = column;
        }

        for (int row = 1; row <= word1.length(); row++) {
            for (int column = 1; column <= word2.length(); column++) {
                int current = (word1.charAt(row - 1) == word2.charAt(column - 1)) ? 0 : 1;

                int min = Integer.MAX_VALUE;
                min = Math.min(min, matrix[row - 1][column - 1] + current);
                min = Math.min(min, matrix[row][column - 1] + 1);
                min = Math.min(min, matrix[row - 1][column] + 1);
                matrix[row][column] = min;
            }
        }

        return matrix[word1.length()][word2.length()];
    }
}
