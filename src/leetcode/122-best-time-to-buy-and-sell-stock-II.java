/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like
(i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:
Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.


Example 2:
Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.


Example 3:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

 */

package leetcode;

class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if ((prices == null) || (prices.length == 0)) {
            return 0;
        }

        int profit = 0;
        Integer purchase = null;

        for (int index = 0; index < prices.length; index++) {
            int price = prices[index];
            if (index == (prices.length - 1)) {
                if (purchase != null) {
                    // sell, no choice
                    profit += (price - purchase);
                }
            } else {
                int future = prices[index + 1];
                if (future >= price) {
                    // if price is going up, then buy if haven't bought or don't do anything if bought
                    if (purchase == null) {
                        purchase = price;
                    }
                } else {
                    // if price is going down, sell if bought, don't go anything if haven't bought
                    if (purchase != null) {
                        profit += (price - purchase);
                        purchase = null;
                    }
                }
            }
        }

        return profit;
    }
}
