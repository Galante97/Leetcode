/*
 * 121. Best Time to Buy and Sell Stock
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 */
class Solution {
    // time complexity : O(n). Only a single pass is needed.
    // pace complexity : O(1). Only three variables are used.

    public int maxProfit(int[] prices) {

        // buy at bottom
        int maxProfit = 0;
        int buyPoint = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyPoint) {
                buyPoint = prices[i];
            } else if (prices[i] > buyPoint) {
                maxProfit = Math.max(maxProfit, prices[i] - buyPoint);
            }
        }

        return maxProfit;

    }
}