/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:
•Each child must have at least one candy.
•Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?

Example 1:
Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.


Example 2:
Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.



Seems like if we find a local minima, we can give 0 there and then expand from there...when we meet, we just need
to give one more than the neighbor
 */

package leetcode;

class Candy {
    public int candy(int[] ratings) {
        if ((ratings == null) || (ratings.length == 0)) {
            return 0;
        }

        int[] dp = new int[ratings.length];
        for (int index = 0; index < ratings.length; index++) {
            int left = (index == 0) ? Integer.MAX_VALUE : ratings[index - 1];
            int right = (index == (ratings.length - 1)) ? Integer.MAX_VALUE : ratings[index + 1];

            boolean isMinima = (left >= ratings[index]) && (right > ratings[index]);
            if (isMinima) {
                dp[index] = 1;
            }
        }

        for (int index = 0; index < ratings.length; index++) {
            if (dp[index] == 1) {
                traverse(dp, ratings, index);
            }
        }

        int total = 0;
        for (int index = 0; index < ratings.length; index++) {
            total += dp[index];
        }
        return total;
    }

    private void traverse(int[] dp, int[] ratings, int currentIndex) {
        // traverse left till maxima...and perform maxima logic
        for (int index = currentIndex - 1; index >= 0; index--) {
            int current = ratings[index];
            int left = (index == 0) ? Integer.MAX_VALUE : ratings[index - 1];
            int right = (index == (ratings.length - 1)) ? Integer.MAX_VALUE : ratings[index + 1];

            boolean maxima = (left < current) && (right <= current);
            if(dp[index] > 0) {
                break;
            }
            if (maxima) {
                if ((right == current) && (left == current)) {
                    dp[index] = 1;
                } else if ((left < current) && (right < current)) {
                    dp[index] = Math.max(dp[index - 1], dp[index + 1]) + 1;
                } else if (left == current) {
                    dp[index] = dp[index + 1] + 1;
                } else if (right == current) {
                    dp[index] = dp[index - 1] + 1;
                }
                break;
            }

            if (right < current) {
                dp[index] = dp[index + 1] + 1;
            } else {
                dp[index] = 1;
            }
        }

        // traverse right till maxima
        for (int index = currentIndex + 1; index < ratings.length; index++) {
            int current = ratings[index];
            int left = (index == 0) ? Integer.MAX_VALUE : ratings[index - 1];
            int right = (index == (ratings.length - 1)) ? Integer.MAX_VALUE : ratings[index + 1];

            boolean maxima = (left < current) && (right <= current);
            if ((maxima) || (dp[index] > 0)) {
                break;
            }

            if (left < current) {
                dp[index] = dp[index - 1] + 1;
            } else {
                dp[index] = 1;
            }
        }
    }
}
