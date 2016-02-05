/*
    Given an array of integers, every element appears twice except for one. Find that single one.

    Link: https://leetcode.com/problems/single-number/

    Example: None

    Solution: XOR them.
    
    Source: None
*/

public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            n = n ^ nums[i];
        }
        return n;
    }
}