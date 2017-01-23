/*
    You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
    Now you have 2 symbols + and -. For each integer, you should choose one from + 
    and - as its new symbol.

    Find out how many ways to assign symbols to make sum of integers equal to target S.

    Link: https://leetcode.com/problems/target-sum/

    Example: 

        Input: nums is [1, 1, 1, 1, 1], S is 3. 
        Output: 5
        Explanation: 

        -1+1+1+1+1 = 3
        +1-1+1+1+1 = 3
        +1+1-1+1+1 = 3
        +1+1+1-1+1 = 3
        +1+1+1+1-1 = 3

        There are 5 ways to assign symbols to make the sum of nums be target 3.

    Solution: None

    Source: https://discuss.leetcode.com/topic/76265/18ms-java-solution/2
*/

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] *= 2;
        }
        if (Math.abs(sum) < Math.abs(S)) {
           return 0; 
        }
        int target = S + sum;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i]) dp[j] += dp[j - nums[i]];
            } 
        }
        return dp[target];
    }
}