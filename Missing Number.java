/*
    Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

    Link: https://leetcode.com/problems/missing-number/

    Example: For example, Given nums = [0, 1, 3] return 2.

    Solution: None
    
    Source: None
*/

public class Solution {
    public int missingNumber(int[] nums) {
        int missing_num = 0;
        // perform xor operation to find mising value
        for (int num = 0; num <= nums.length; num++) {
            missing_num ^= num;
        }
        // then, we perform xor again to delete repeat number
        for (int num : nums) {
            missing_num ^= num;
        }
        return missing_num;
    }
}