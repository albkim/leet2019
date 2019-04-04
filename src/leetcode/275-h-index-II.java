/*
Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher,
write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least
h citations each, and the other N − h papers have no more than h citations each."

Example:
Input: citations = [0,1,3,5,6]
Output: 3
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
             received 0, 1, 3, 5, 6 citations respectively.
             Since the researcher has 3 papers with at least 3 citations each and the remaining
             two with no more than 3 citations each, her h-index is 3.

Note:

If there are several possible values for h, the maximum one is taken as the h-index.

Follow up:
•This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
•Could you solve it in logarithmic time complexity?

 */

package leetcode;

class HIndexII {
    public int hIndex(int[] citations) {
        if ((citations == null) || (citations.length == 0)) {
            return 0;
        }

        // no need to do more than # of publications
        int[] h = new int[citations[citations.length - 1] + 1];

        for (int citation : citations) {
            h[citation]++;
        }

        Integer previous = null;
        for (int number = citations[citations.length - 1]; number > 0; number--) {
            int publication = h[number];
            if (previous != null) {
                publication += previous.intValue();
            }
            if (number <= publication) {
                return number;
            }
            previous = publication;
        }

        return 0;
    }
}
