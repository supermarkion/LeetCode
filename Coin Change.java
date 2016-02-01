/*
    You are given coins of different denominations and a total amount of money amount. Write a function to compute the 
    fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any 
    combination of the coins, return -1.

    Link: https://leetcode.com/problems/coin-change/

    Example: 
        Example 1:
        coins = [1, 2, 5], amount = 11
        return 3 (11 = 5 + 5 + 1)

        Example 2:
        coins = [2], amount = 3
        return -1.

    Solution: None
		    
    Source: https://leetcode.com/discuss/79446/java-easy-version-to-understand
*/

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }
            
        int[] minNumber = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            minNumber[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE) {
                    minNumber[i] = Integer.min(minNumber[i], 1 + minNumber[i - coins[j]]);
                }
            }
        }
        if (minNumber[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minNumber[amount];
        }
    }
}