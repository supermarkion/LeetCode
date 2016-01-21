/*
    Say you have an array for which the ith element is the price of a given stock on day i.
	Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
	(ie, buy one and sell one share of the stock multiple times) with the following restrictions:
		You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
		After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

    Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

    Example: 
    	prices = [1, 2, 3, 0, 2]
		maxProfit = 3
		transactions = [buy, sell, cooldown, buy, sell]

    Solution: None

    Source: https://leetcode.com/discuss/79767/java-easy-version-to-understand
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[] sell = new int[len];
        int[] coolDown = new int[len];
        sell[0] = 0;
        coolDown[0] = 0;
        for (int i = 1; i < len; i++) {
            sell[i] = Integer.max(sell[i - 1] + prices[i] - prices[i - 1], coolDown[i - 1]);
            coolDown[i] = Integer.max(sell[i - 1], coolDown[i - 1]);
        }
        return Integer.max(sell[len - 1], coolDown[len - 1]);
    }
}