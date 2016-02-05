/*
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
    the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and 
    it will automatically contact the police if two adjacent houses were broken into on the same night.

    Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of 
    money you can rob tonight without alerting the police.

    Link: https://leetcode.com/problems/house-robber/

    Example: None

    Solution: When we meet a house, we have to decision on robber its previous two or three houses to achieve maximum values.
    
    Source: https://leetcode.com/discuss/76684/ac-solution-code
*/

public class Solution {
    public int rob(int[] nums) {
        //prevNo : we don't rob the previous house
        //prevYes: we rob the previous house
        int prevYes = 0, prevNo = 0; 
        for (int i : nums) { 
            int tmp = prevYes;
            prevYes = prevNo + i;
            prevNo = Math.max(tmp, prevNo);
        }           
        return Math.max(prevNo, prevYes);
    }
}