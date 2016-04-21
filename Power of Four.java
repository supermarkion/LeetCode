/*
    Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

    Link: https://leetcode.com/problems/power-of-four/

    Example: 
	    Given num = 16, return true. Given num = 5, return false.
	
    Solution: None

    Source: None
*/

public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) !=0;
    }
}