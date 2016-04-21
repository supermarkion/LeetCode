/*
    Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. 
    Return the maximum product you can get. 

    Link: https://leetcode.com/problems/integer-break/

    Example: 
	    For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4)
	
    Solution: None

    Source: None
*/

public class Solution {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int mod = n % 3;
        
        if (mod == 0) {
            return (int) Math.pow(3, n / 3);
        } else if (mod == 1) {
            return 4 * (int) Math.pow(3, (n - 4) / 3);
        }
        return 2 * (int) Math.pow(3, n / 3);
    }
}