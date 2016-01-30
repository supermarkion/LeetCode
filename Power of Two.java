/*
    Given an integer, write a function to determine if it is a power of two.
    
    Link: https://leetcode.com/problems/power-of-two/

    Example: None

    Solution: None
    
    Source: None
*/

public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}