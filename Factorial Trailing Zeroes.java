/*
    Given an integer n, return the number of trailing zeroes in n!.

    Link: https://leetcode.com/problems/factorial-trailing-zeroes/

    Example: None

    Solution: Count 2 and 5, and consider of that 5 repeat smaller than 2, we should only consider of
    the number of 5.
    
    Source: None
*/

public class Solution {
    public int trailingZeroes(int n) {
    	int sum = 0;
        while (n >= 5){
            sum += n / 5;
            n = n / 5;
        }
        return sum;
    }
}