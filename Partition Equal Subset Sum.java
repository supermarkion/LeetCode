/*
    Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets 
    such that the sum of elements in both subsets is equal.
    
    Note:
        Both the array size and each of the array element will not exceed 100.

    Link: https://leetcode.com/problems/partition-equal-subset-sum/

    Example: 
        Example 1:
            Input: [1, 5, 11, 5]
            Output: true
            Explanation: The array can be partitioned as [1, 5, 5] and [11].
        
        Example 2:
            Input: [1, 2, 3, 5]
            Output: false
            Explanation: The array cannot be partitioned into equal sum subsets.

    Solution: None

    Source: https://discuss.leetcode.com/topic/62913/38ms-dp-java-solution
*/

public class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n == 0)  {
            return true;
        }
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
            
        Arrays.sort(nums);
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] == target) {
                return true;
            }
                
            if (nums[i - 1] > target) {
                return false;
            }
                
            System.arraycopy(dp[i - 1], 0, dp[i], 0, Math.min(target + 1, nums[i - 1]));
            for (int j = nums[i - 1]; j <= target; j++) {
                dp[i][j] = dp[i - 1][j - nums[i - 1]];
            }
            if (dp[i][target]) {
                return true;
            }
                
        }
        return false;
    }
}