/*
    Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
    
    Link: https://leetcode.com/problems/maximum-subarray/

    Example: given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.

    Solution: None
    
    Source: None
*/

public class Solution {
    public int maxSubArray(int[] nums) {
        int maxHere = nums[0];
        int maxEnd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxHere = Math.max(nums[i], maxHere + nums[i]);
            maxEnd = Math.max(maxHere, maxEnd);
        }
        return maxEnd;
    }
}