/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.



nums1 = [1, 3]
nums2 = [2]

The median is 2.0

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

Think of this as a two decks of cards. We want to cut the deck such that
L1 (highest number on the left side of the first deck) < R2 (lowest number on the right side of the second deck)
&& L2 < R1 and numL1 + numL2 = numR1 and numR2

[...L1]/[R1...] & [...L2]/[R2...]

Another thing to notice is that which deck to start matters, if one of the deck is smaller, there is no way that we can
cut one end of the large deck and make sure above is true.

Now if we decide to pick a position to cut on one of the deck, we should be able to pick the right position to cut on the
second. Since the count should be equal.

median = (max(L1, L2) + min(R1, R2)) / 2

The other thing to consider is that if we have odd number (total) of numbers, we should pick a number to cut.
If the total number is even, we need to cut between numbers
 */

package leetcode.hard;

class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int numSmall = nums1.length;
        int numLarge = nums2.length;

        if (numSmall > numLarge) return findMedianSortedArrays(nums2, nums1);

        int left = -1;
        int right = numSmall;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int L1 = (mid < 0) ? Integer.MIN_VALUE : nums1[mid];
            int R1 = (mid + 1) >= nums1.length ? Integer.MAX_VALUE : nums1[mid + 1];

            /*
                mid + 1 + L2i + 1 = nums1.length - mid - 1 + nums2.length - L2i - 1
                2L2i = nums1.length - mid + nums2.length - mid - 4
                L2i = (nums1.length + nums2.length) / 2  - mid - 2
             */
            int L2i = (nums1.length + nums2.length) / 2  - mid - 2;
            int R2i = L2i + 1;

            int L2 = (L2i < 0) ? Integer.MIN_VALUE : nums2[L2i];
            int R2 = R2i >= nums2.length ? Integer.MAX_VALUE : nums2[R2i];

            if ((L1 <= R2) && (L2 <= R1)) {
                // we found it, now need to see if it's odd or even
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (Integer.max(L1, L2) + Integer.min(R1, R2)) / 2d;
                }
                // in the odd case, we need to take the bigger part
                if ((mid + L2i + 2) > (nums1.length + nums2.length - mid - L2i - 2)) {
                    return Integer.max(L1, L2);
                } else {
                    return Integer.min(R1, R2);
                }
            }
            if (L1 > R2) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 0;
    }
}
