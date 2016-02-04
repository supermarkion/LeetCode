/*
    Reverse digits of an integer.

    Link: https://leetcode.com/problems/reverse-integer/

    Example: 
        Example1: x = 123, return 321
        Example2: x = -123, return -321

    Solution: In this problem, we should consider of that the result is over range of given data structure.
    
    Source: None
*/

public class Solution {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = x % 10 + 10 * result;
            x /= 10;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)result;
    }
}