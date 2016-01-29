/*
    Say you have an array for which the ith element is the price of a given stock on day i.
    
    Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

    Example: None

    Solution: None
    
    Source: None
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        int curPriceMin = Integer.MAX_VALUE;
        for (int price : prices) {
            profit = Math.max(profit, price - curPriceMin);
            curPriceMin = Math.min(curPriceMin, price);
        }
        return profit;
    }
}