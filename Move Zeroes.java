/*
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Link: https://leetcode.com/problems/move-zeroes/

    Example: For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

    Solution: None
    
    Source: https://leetcode.com/discuss/82731/my-0ms-simple-java-solution
*/

public class Solution {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos++] = nums[i];
            }
        }
        for (int i = pos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}