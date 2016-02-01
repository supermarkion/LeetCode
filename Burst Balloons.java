/*
    Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. 
    You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] 
    coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
    Find the maximum coins you can collect by bursting the balloons wisely.

    Link: https://leetcode.com/problems/burst-balloons/

    Example: Given [3, 1, 5, 8] Return 167
        nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
        coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

    Solution: None
		    
    Source: https://leetcode.com/discuss/72216/share-some-analysis-and-explanations
*/

public class Solution {
    public int maxCoins(int[] nums) {
        int[] iNums = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) {
            if (x > 0) {
                iNums[n++] = x;
            }
        }
        iNums[0] = iNums[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right], 
                    iNums[left] * iNums[i] * iNums[right] + dp[left][i] + dp[i][right]);
            }
    
        return dp[0][n - 1];
    }
}