/*
    Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly 
    twice. Find the two elements that appear only once.

    Link: https://leetcode.com/problems/single-number-iii/

    Example: Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

    Solution: Applying XOR operation.

    Source: https://leetcode.com/discuss/76099/a-summary-of-java-solutions
*/

public class Solution {
    public int[] singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result ^= nums[i];
        }
        // notice that 6^5 = 3, 6^3 = 5
        // now how to find 3 and 5 from 6
        int[] r = new int[2];
        // find the lowest bit of the result
        // let's say 6 (0110), -6 = 1010  0110 & 1010 = 0010
        int lowbit = result & -result;
        // since this bit from the result is 1, we can be sure that 
        // a & lowbit and b & lowbit have different result
        for(int n : nums){
            if((n & lowbit) == 0) {
                r[0] ^= n;
            } else {
                r[1] ^=n;
            }
        }
        return r;
    }
}