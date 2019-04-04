/*
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function
to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at
least h citations each, and the other N − h papers have no more than h citations each."

Example:
Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
             received 3, 0, 6, 1, 5 citations respectively.
             Since the researcher has 3 papers with at least 3 citations each and the remaining
             two with no more than 3 citations each, her h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.


 Seems like a bucket sort idea. Create an array of buckets (citations and as we can increment up to current citation
 Then it's just a better of finding the first number where # of publication is greater from the max
 */

package leetcode;

class HIndex {
    public int hIndex(int[] citations) {
        if ((citations == null) || (citations.length == 0)) {
            return 0;
        }

        // no need to do more than # of publications
        int[] h = new int[citations.length + 1];

        int maxCitation = Integer.MIN_VALUE;
        for (int citation : citations) {
            for (int number = 0; number <= Math.min(citations.length, citation); number++) {
                h[number]++;
            }
            maxCitation = Math.max(maxCitation, citation);
        }

        for (int number = Math.min(citations.length, maxCitation); number > 0; number--) {
            if (number <= h[number]) {
                return number;
            }
        }

        return 0;
    }
}
